/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt & Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt & Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.internal.emf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMap.Internal;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.query.QueryFactory;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class MongoDBOutputStream extends ByteArrayOutputStream implements URIConverter.Saveable
{
	public MongoDBOutputStream(IMongoDB mongoDB, URI uri, Map<?, ?> options, Map<Object, Object> response)
	{
		this.mongoDB = mongoDB;
		this.uri = uri;
		this.options = options;
		this.response = response;
	}

	@Override
	public void close() throws IOException
	{
		super.close();
		DBCollection collection = MongoDBURIHandlerImpl.getCollection(mongoDB, uri);

		// We need to set up the XMLResource.URIHandler so that proxy URIs are handled properly.

		XMLResource.URIHandler uriHandler = (XMLResource.URIHandler) options.get(XMLResource.OPTION_URI_HANDLER);

		if (uriHandler == null)
			uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

		Object id = MongoDBURIHandlerImpl.getID(uri);

		// If the id was not specified, we append a dummy id to the resource URI so that all of the
		// relative proxies will be generated correctly.

		if (id == null)
			resource.setURI(resource.getURI().trimSegments(1).appendSegment("-1"));

		uriHandler.setBaseURI(resource.getURI());

		if (resource.getContents().size() == 1)
			saveSingleObject(collection, uriHandler, id, response);
		else
			saveMultipleObjects(collection, uriHandler, id, response);
	}

	@Override
	public void saveResource(Resource resource)
	{
		this.resource = resource;
	}

	private DBObject buildDBObject(DB db, EObject eObject, XMLResource.URIHandler uriHandler) throws IOException
	{
		// Build a MongoDB object from the EMF object.

		BasicDBObject dbObject = new BasicDBObject();
		EClass eClass = eObject.eClass();

		// We have to add the package namespace URI and eclass name to the object so that we can
		// reconstruct the EMF object when we read it back out of MongoDB.

		dbObject.put(MongoDBURIHandlerImpl.ECLASS_KEY, EcoreUtil.getURI(eClass).toString());

		// Save the XML extrinsic id if necessary

		Resource resource = eObject.eResource();

		if (resource instanceof XMLResource)
		{
			String id = ((XMLResource) resource).getID(eObject);

			if (id != null)
				dbObject.put(MongoDBURIHandlerImpl.EXTRINSIC_ID_KEY, id);
		}

		// All attributes are mapped as key / value pairs with the key being the attribute name.

		for (EAttribute attribute : eClass.getEAllAttributes())
		{
			if (!attribute.isTransient() && !(attribute.isID() && attribute.isDerived()))
			{
				Object value = null;

				if (FeatureMapUtil.isFeatureMap(attribute))
				{
					FeatureMap.Internal featureMap = (Internal) eObject.eGet(attribute);
					Iterator<Entry> iterator = featureMap.iterator();
					ArrayList<DBObject> dbFeatureMap = new ArrayList<DBObject>();

					while (iterator.hasNext())
					{
						DBObject dbEntry = new BasicDBObject();
						Entry entry = iterator.next();
						EStructuralFeature feature = entry.getEStructuralFeature();
						dbEntry.put("key", EcoreUtil.getURI(feature).toString());

						if (feature instanceof EAttribute)
							dbEntry.put("value", getDBAttributeValue((EAttribute) feature, entry.getValue()));
						else
							dbEntry.put("value", buildDBReference(db, (EReference) feature, (EObject) entry.getValue(), uriHandler));

						dbFeatureMap.add(dbEntry);
					}

					value = dbFeatureMap;
				}
				else if (attribute.isMany() && !MongoDBURIHandlerImpl.isNativeType(attribute.getEAttributeType()))
				{
					@SuppressWarnings("unchecked")
					EList<Object> rawValues = (EList<Object>) eObject.eGet(attribute);
					ArrayList<String> values = new ArrayList<String>(rawValues.size());

					for (Object rawValue : rawValues)
						values.add(EcoreUtil.convertToString(attribute.getEAttributeType(), rawValue));

					value = values;
				}
				else
					value = getDBAttributeValue(attribute, eObject.eGet(attribute));

				dbObject.put(attribute.getName(), value);
			}
		}

		// All references are mapped as key / value pairs with the key being the reference name.

		for (EReference reference : eClass.getEAllReferences())
		{
			if (reference.isTransient())
				continue;

			Object value = null;

			if (reference.isMany())
			{
				// One to many reference

				@SuppressWarnings("unchecked")
				EList<EObject> targetObjects = (EList<EObject>) eObject.eGet(reference);
				ArrayList<Object> dbReferences = new ArrayList<Object>(targetObjects.size());

				for (EObject targetObject : targetObjects)
					dbReferences.add(buildDBReference(db, reference, targetObject, uriHandler));

				value = dbReferences;
			}
			else
			{
				// One to one reference

				EObject targetObject = (EObject) eObject.eGet(reference);

				if (targetObject == null)
					continue;

				value = buildDBReference(db, reference, targetObject, uriHandler);
			}

			dbObject.put(reference.getName(), value);
		}

		return dbObject;
	}

	private Object buildDBReference(DB db, EReference eReference, EObject targetObject, XMLResource.URIHandler uriHandler) throws UnknownHostException, IOException
	{
		InternalEObject internalEObject = (InternalEObject) targetObject;

		if (!eReference.isContainment() || (eReference.isResolveProxies() && internalEObject.eDirectResource() != null))
		{
			// Cross-document containment, or non-containment reference - build a proxy

			BasicDBObject dbObject = new BasicDBObject(2);
			dbObject.put(MongoDBURIHandlerImpl.PROXY_KEY, uriHandler.deresolve(EcoreUtil.getURI(targetObject)).toString());
			dbObject.put(MongoDBURIHandlerImpl.ECLASS_KEY, EcoreUtil.getURI(targetObject.eClass()).toString());
			return dbObject;
		}
		else
		{
			// Non cross-document containment reference - build a MongoDB embedded object

			return buildDBObject(db, targetObject, uriHandler);
		}
	}

	private Object getDBAttributeValue(EAttribute attribute, Object rawValue)
	{
		if (!MongoDBURIHandlerImpl.isNativeType(attribute.getEAttributeType()))
			return EcoreUtil.convertToString(attribute.getEAttributeType(), rawValue);

		return rawValue;
	}

	private void saveMultipleObjects(DBCollection collection, XMLResource.URIHandler uriHandler, Object id, Map<Object, Object> response) throws IOException
	{
		ArrayList<DBObject> dbObjects = new ArrayList<DBObject>();
		long timeStamp = System.currentTimeMillis();
		response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, timeStamp);

		for (EObject eObject : resource.getContents())
		{
			DBObject dbObject = buildDBObject(collection.getDB(), eObject, uriHandler);
			dbObject.put(MongoDBURIHandlerImpl.TIME_STAMP_KEY, timeStamp);
			dbObjects.add(dbObject);
		}

		collection.insert(dbObjects);
		URI baseURI = resource.getURI().trimSegments(1);
		ArrayList<EObject> eObjects = new ArrayList<EObject>(resource.getContents());
		Result result = QueryFactory.eINSTANCE.createResult();
		EList<EObject> values = result.getValues();

		for (int i = 0; i < dbObjects.size(); i++)
		{
			EObject eObject = eObjects.get(i);
			InternalEObject internalEObject = (InternalEObject) eObject;
			internalEObject.eSetProxyURI(baseURI.appendSegment(dbObjects.get(i).get(MongoDBURIHandlerImpl.ID_KEY).toString()).appendFragment("/"));
			internalEObject.eAdapters().clear();
			values.add(eObject);
		}

		resource.getContents().clear();
		resource.getContents().add(result);
	}

	private void saveSingleObject(DBCollection collection, XMLResource.URIHandler uriHandler, Object id, Map<Object, Object> response) throws IOException
	{
		// Build a MongoDB object from the EMF object.

		DBObject dbObject = buildDBObject(collection.getDB(), resource.getContents().get(0), uriHandler);

		long timeStamp = System.currentTimeMillis();
		dbObject.put(MongoDBURIHandlerImpl.TIME_STAMP_KEY, timeStamp);
		response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, timeStamp);

		if (id == null)
		{
			// The id was not specified in the URI, so we are creating an object for the first time.

			collection.insert(dbObject);
			id = dbObject.get(MongoDBURIHandlerImpl.ID_KEY);

			// Since MongoDB assigns an id to the inserted object, we need to modify the EMF Resource
			// URI to include the generated id by removing the dummy id and appending the id generated
			// by MongoDB.

			URI newURI = resource.getURI().trimSegments(1).appendSegment(id.toString());

			// The EMF framework will do the actual modification of the Resource URI if the new URI is
			// set in the response options.

			response.put(URIConverter.RESPONSE_URI, newURI);
		}
		else
		{
			// The object id was specified, so we are either doing an update, or inserting a new
			// object. If the object already exists, then it will be updated; otherwise it will
			// be inserted.

			dbObject.put("_id", id);
			collection.save(dbObject);
		}
	}

	private IMongoDB mongoDB;
	private Map<?, ?> options;
	private Resource resource;
	private Map<Object, Object> response;
	private URI uri;
}
