/*******************************************************************************
 * Copyright (c) 2010 Bryan Hunt & Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt & Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.internal.emf.Activator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

public class MongoDBURIHandlerImpl extends URIHandlerImpl
{
	static final String ID_KEY = "_id";

	static final String EPACKAGE_KEY = "_ePackage";

	static final String ECLASS_KEY = "_eClass";

	static final String PROXY_KEY = "_eProxyURI";

	@Override
	public boolean canHandle(URI uri)
	{
		return "mongo".equalsIgnoreCase(uri.scheme());
	}

	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException
	{
		DBCollection collection = getCollection(uri);
		collection.findAndRemove(new BasicDBObject(ID_KEY, getID(uri)));
	}

	@Override
	public OutputStream createOutputStream(final URI uri, final Map<?, ?> options) throws IOException
	{
		return new MongoDBOutputStream()
		{
			@Override
			public void close() throws IOException
			{
				super.close();
				EObject root = resource.getContents().get(0);
				DBCollection collection = getCollection(uri);

				XMLResource.URIHandler uriHandler = (XMLResource.URIHandler) options.get(XMLResource.OPTION_URI_HANDLER);

				if (uriHandler == null)
					uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

				if (resource.getURI().hasTrailingPathSeparator())
					uriHandler.setBaseURI(resource.getURI());
				else
					uriHandler.setBaseURI(resource.getURI().appendSegment(""));

				DBObject dbObject = buildDBObject(collection.getDB(), root, uriHandler);
				ObjectId id = getID(uri);

				if (id == null)
				{
					collection.insert(dbObject);
					id = (ObjectId) dbObject.get(ID_KEY);
					Map<Object, Object> response = getResponse(options);

					URI newURI = null;

					if (resource.getURI().hasTrailingPathSeparator())
						newURI = resource.getURI().trimSegments(1).appendSegment(id.toString());
					else
						newURI = resource.getURI().appendSegment(id.toString());

					response.put(URIConverter.RESPONSE_URI, newURI);
				}
				else
				{
					dbObject.put(ID_KEY, id);
					collection.findAndModify(new BasicDBObject(ID_KEY, id), dbObject);
				}
			}
		};
	}

	public static class MongoDBOutputStream extends ByteArrayOutputStream implements URIConverter.Savable
	{
		protected Resource resource;

		@Override
		public void saveResource(Resource resource)
		{
			this.resource = resource;
		}
	}

	@Override
	public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException
	{
		return new MongoDBInputStream()
		{
			@Override
			public void loadResource(Resource resource) throws IOException
			{
				XMLResource.URIHandler uriHandler = (XMLResource.URIHandler) options.get(XMLResource.OPTION_URI_HANDLER);

				if (uriHandler == null)
					uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

				if (resource.getURI().hasTrailingPathSeparator())
					uriHandler.setBaseURI(resource.getURI());
				else
					uriHandler.setBaseURI(resource.getURI().appendSegment(""));

				DBCollection collection = getCollection(uri);
				DBObject dbObject = collection.findOne(new BasicDBObject(ID_KEY, getID(uri)));

				if (dbObject != null)
					resource.getContents().add(buildObject(collection, dbObject, resource, uriHandler));
			}
		};
	}

	public abstract static class MongoDBInputStream extends InputStream implements URIConverter.Loadable
	{
		@Override
		public int read() throws IOException
		{
			return 0;
		}
	}

	private ObjectId getID(URI uri)
	{
		if (uri.segmentCount() != 3)
			return null;

		String id = uri.segment(2);

		return id.isEmpty() ? null : new ObjectId(uri.segment(2));
	}

	private DBCollection getCollection(URI uri) throws UnknownHostException, IOException
	{
		IMongoDB mongoDB = Activator.getInstance().getMongoDB();

		if (mongoDB == null)
			throw new IOException("MongoDB service is unavailable");

		String port = uri.port();
		MongoURI mongoURI = new MongoURI("mongodb://" + uri.host() + (port != null ? ":" + port : ""));
		Mongo mongo = mongoDB.getMongo(mongoURI);

		if (mongo == null)
			throw new IOException("Could not find MongoDB host: " + mongoURI);

		DB db = mongo.getDB(uri.segment(0));

		if (db == null)
			throw new IOException("Could not find Mongo database: " + uri.segment(0));

		DBCollection collection = db.getCollection(uri.segment(1));
		return collection;
	}

	private DBObject buildDBObject(DB db, EObject eObject, XMLResource.URIHandler uriHandler) throws UnknownHostException, IOException
	{
		BasicDBObject dbObject = new BasicDBObject();
		EClass eClass = eObject.eClass();

		dbObject.put(EPACKAGE_KEY, eClass.getEPackage().getNsURI());
		dbObject.put(ECLASS_KEY, eClass.getName());

		for (EAttribute attribute : eClass.getEAllAttributes())
		{
			if (!attribute.isTransient())
			{
				dbObject.put(attribute.getName(), eObject.eGet(attribute));
			}
		}

		for (EReference reference : eClass.getEAllReferences())
		{
			if (reference.isTransient())
				continue;

			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				EList<EObject> targetObjects = (EList<EObject>) eObject.eGet(reference);

				ArrayList<Object> dbReferences = new ArrayList<Object>(targetObjects.size());

				for (EObject targetObject : targetObjects)
					dbReferences.add(buildDBReference(db, reference, targetObject, uriHandler));

				dbObject.put(reference.getName(), dbReferences);
			}
			else
			{
				EObject targetObject = (EObject) eObject.eGet(reference);

				if (targetObject == null)
					continue;

				dbObject.put(reference.getName(), buildDBReference(db, reference, targetObject, uriHandler));
			}
		}

		return dbObject;
	}

	private Object buildDBReference(DB db, EReference eReference, EObject targetObject, XMLResource.URIHandler uriHandler) throws UnknownHostException, IOException
	{
		InternalEObject internalEObject = (InternalEObject) targetObject;

		if (eReference.isResolveProxies())
		{
			// Cross-document containment, or non-containment reference - build a proxy

			Resource resource = targetObject.eResource();

			if (internalEObject.eDirectResource() == null || !canHandle(resource.getResourceSet().getURIConverter().normalize(resource.getURI())))
			{
				BasicDBObject dbObject = new BasicDBObject(2);
				dbObject.put(PROXY_KEY, uriHandler.deresolve(EcoreUtil.getURI(targetObject)).toString());
				dbObject.put(EPACKAGE_KEY, targetObject.eClass().getEPackage().getNsURI());
				dbObject.put(ECLASS_KEY, targetObject.eClass().getName());
				return dbObject;
			}
			else
			{
				URI normalizedTargetURI = resource.getResourceSet().getURIConverter().normalize(resource.getURI());
				return new DBRef(db, getCollection(normalizedTargetURI).getName(), getID(normalizedTargetURI));
			}
		}
		else
		{
			// Non cross-document containment reference - build a MongoDB embedded object
			return buildDBObject(db, targetObject, uriHandler);
		}
	}

	private EObject buildObject(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler)
	{
		EObject eObject = buildObject(dbObject);

		for (EAttribute attribute : eObject.eClass().getEAllAttributes())
		{
			if (!attribute.isTransient())
				eObject.eSet(attribute, dbObject.get(attribute.getName()));
		}

		for (EReference reference : eObject.eClass().getEAllReferences())
		{
			if (reference.isTransient())
				continue;

			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				List<Object> dbReferences = (List<Object>) dbObject.get(reference.getName());

				if (dbReferences != null)
				{
					@SuppressWarnings("unchecked")
					EList<EObject> eObjects = (EList<EObject>) eObject.eGet(reference);

					for (Object dbReference : dbReferences)
						eObjects.add(buildObjectReference(collection, dbReference, resource, uriHandler));
				}
			}
			else
				eObject.eSet(reference, buildObjectReference(collection, dbObject.get(reference.getName()), resource, uriHandler));
		}

		return eObject;
	}

	private EObject buildObjectReference(DBCollection collection, Object dbReference, Resource resource, XMLResource.URIHandler uriHandler)
	{
		if (dbReference instanceof DBRef)
			return buildProxy((DBRef) dbReference, resource, uriHandler);
		else
		{
			DBObject dbObject = (DBObject) dbReference;
			String proxy = (String) dbObject.get(PROXY_KEY);

			if (proxy == null)
				return buildObject(collection, dbObject, resource, uriHandler);
			else
				return buildProxy(dbObject, uriHandler);
		}
	}

	private EObject buildProxy(DBObject dbObject, XMLResource.URIHandler uriHandler)
	{
		EObject eObject = buildObject(dbObject);
		((InternalEObject) eObject).eSetProxyURI(uriHandler.resolve(URI.createURI((String) dbObject.get(PROXY_KEY))));
		return eObject;
	}

	private EObject buildProxy(DBRef dbReference, Resource resource, XMLResource.URIHandler uriHandler)
	{
		EObject eObject = buildObject(dbReference.fetch());
		URI proxyURI = URI.createURI("../../../" + dbReference.getDB().getName() + "/" + dbReference.getRef() + "/" + dbReference.getId() + "#/0");
		((InternalEObject) eObject).eSetProxyURI(uriHandler.resolve(proxyURI));
		return eObject;
	}

	private EObject buildObject(DBObject dbObject)
	{
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage((String) dbObject.get(EPACKAGE_KEY));
		EClass eClass = (EClass) ePackage.getEClassifier((String) dbObject.get(ECLASS_KEY));
		return EcoreUtil.create(eClass);
	}
}
