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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.query.QueryFactory;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;

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
		this.serializeDefault = false;
	}

	@Override
	public void close() throws IOException
	{
		super.close();
		DBCollection collection = MongoDBURIHandlerImpl.getCollection(mongoDB, uri, options);

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

		Boolean serializeOption = (Boolean) options.get(MongoDBURIHandlerImpl.OPTION_SERIALIZE_DEFAULT_ATTRIBUTE_VALUES);

		if (serializeOption != null)
			serializeDefault = serializeOption;

		if (resource.getContents().size() == 1)
			saveSingleObject(collection, uriHandler, id, response);
		else
			saveMultipleObjects(collection, uriHandler, response);
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

		// We have to add the URI of the class to the object so that we can
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
			if (!attribute.isTransient() && (eObject.eIsSet(attribute) || (!attribute.isUnsettable() && serializeDefault)))
			{
				Object value = eObject.eGet(attribute);

				if (FeatureMapUtil.isFeatureMap(attribute))
				{
					FeatureMap.Internal featureMap = (FeatureMap.Internal) value;
					Iterator<FeatureMap.Entry> iterator = featureMap.basicIterator();
					ArrayList<DBObject> dbFeatureMap = new ArrayList<DBObject>();

					while (iterator.hasNext())
					{
						DBObject dbEntry = new BasicDBObject();
						FeatureMap.Entry entry = iterator.next();
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
				else if (attribute.isMany())
				{
					EDataType eDataType = attribute.getEAttributeType();

					if (!MongoDBURIHandlerImpl.isNativeType(eDataType))
					{
						EList<?> rawValues = (EList<?>) value;
						ArrayList<String> values = new ArrayList<String>(rawValues.size());

						for (Object rawValue : rawValues)
							values.add(EcoreUtil.convertToString(eDataType, rawValue));

						value = values;
					}
				}
				else
					value = getDBAttributeValue(attribute, value);

				dbObject.put(attribute.getName(), value);
			}
		}

		// All references are mapped as key / value pairs with the key being the reference name.

		for (EReference reference : eClass.getEAllReferences())
		{
			if (!reference.isTransient() && eObject.eIsSet(reference))
			{
				Object value = eObject.eGet(reference, false);

				if (reference.isMany())
				{
					// One to many reference

					@SuppressWarnings("unchecked")
					List<EObject> targetObjects = ((InternalEList<EObject>) value).basicList();
					ArrayList<Object> dbReferences = new ArrayList<Object>(targetObjects.size());

					for (EObject targetObject : targetObjects)
						dbReferences.add(buildDBReference(db, reference, targetObject, uriHandler));

					value = dbReferences;
				}
				else if (value != null)
				{
					// One to one reference

					EObject targetObject = (EObject) value;

					value = buildDBReference(db, reference, targetObject, uriHandler);
				}

				dbObject.put(reference.getName(), value);
			}
		}

		return dbObject;
	}

	private Object buildDBReference(DB db, EReference eReference, EObject targetObject, XMLResource.URIHandler uriHandler) throws IOException
	{
		InternalEObject internalEObject = (InternalEObject) targetObject;
		URI eProxyURI = internalEObject.eProxyURI();

		if (eProxyURI != null)
		{
			BasicDBObject dbObject = new BasicDBObject(2);
			dbObject.put(MongoDBURIHandlerImpl.PROXY_KEY, uriHandler.deresolve(eProxyURI).toString());
			dbObject.put(MongoDBURIHandlerImpl.ECLASS_KEY, EcoreUtil.getURI(targetObject.eClass()).toString());
			return dbObject;
		}
		else if (!eReference.isContainment() || (eReference.isResolveProxies() && internalEObject.eDirectResource() != null))
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
		EDataType eDataType = attribute.getEAttributeType();
		if (!MongoDBURIHandlerImpl.isNativeType(eDataType))
			return EcoreUtil.convertToString(eDataType, rawValue);

		return rawValue;
	}

	private void saveMultipleObjects(DBCollection collection, XMLResource.URIHandler uriHandler, Map<Object, Object> response) throws IOException
	{
		EList<EObject> contents = resource.getContents();
		ArrayList<DBObject> dbObjects = new ArrayList<DBObject>(contents.size());
		long timeStamp = System.currentTimeMillis();
		response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, timeStamp);

		DB db = collection.getDB();
		Boolean useIdAttributeAsPrimaryKey = (Boolean) options.get(MongoDBURIHandlerImpl.OPTION_USE_ID_ATTRIBUTE_AS_PRIMARY_KEY);

		for (EObject eObject : contents)
		{
			DBObject dbObject = buildDBObject(db, eObject, uriHandler);
			dbObject.put(MongoDBURIHandlerImpl.TIME_STAMP_KEY, timeStamp);

			if (useIdAttributeAsPrimaryKey != null && useIdAttributeAsPrimaryKey)
			{
				EAttribute idAttribute = eObject.eClass().getEIDAttribute();

				if (idAttribute != null)
					dbObject.put("_id", eObject.eGet(idAttribute));
			}

			dbObjects.add(dbObject);
		}

		WriteConcern writeConcern = (WriteConcern) options.get(MongoDBURIHandlerImpl.OPTION_WRITE_CONCERN);

		if (writeConcern == null)
			collection.insert(dbObjects);
		else
			collection.insert(dbObjects, writeConcern);

		URI baseURI = resource.getURI().trimSegments(1);
		InternalEObject[] eObjects = contents.toArray(new InternalEObject[contents.size()]);
		Result result = QueryFactory.eINSTANCE.createResult();
		InternalEList<EObject> values = (InternalEList<EObject>) result.getValues();

		for (int i = 0; i < dbObjects.size(); i++)
		{
			InternalEObject internalEObject = eObjects[i];
			internalEObject.eSetProxyURI(baseURI.appendSegment(dbObjects.get(i).get(MongoDBURIHandlerImpl.ID_KEY).toString()).appendFragment("/"));
			internalEObject.eAdapters().clear();
			values.addUnique(internalEObject);
		}

		contents.clear();
		contents.add(result);
	}

	private void saveSingleObject(DBCollection collection, XMLResource.URIHandler uriHandler, Object id, Map<Object, Object> response) throws IOException
	{
		// Build a MongoDB object from the EMF object.

		EObject eObject = resource.getContents().get(0);
		DBObject dbObject = buildDBObject(collection.getDB(), eObject, uriHandler);

		// The timestamp needs to be persisted with the object, and set in the response

		long timeStamp = System.currentTimeMillis();
		dbObject.put(MongoDBURIHandlerImpl.TIME_STAMP_KEY, timeStamp);
		response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, timeStamp);

		if (id == null)
		{
			// The id was not specified in the URI, so we can let MongoDB generate the id or use the value
			// of the ID attribute

			Boolean useIdAttributeAsPrimaryKey = (Boolean) options.get(MongoDBURIHandlerImpl.OPTION_USE_ID_ATTRIBUTE_AS_PRIMARY_KEY);
			EAttribute idAttribute = eObject.eClass().getEIDAttribute();
			WriteConcern writeConcern = (WriteConcern) options.get(MongoDBURIHandlerImpl.OPTION_WRITE_CONCERN);

			if (useIdAttributeAsPrimaryKey != null && useIdAttributeAsPrimaryKey && idAttribute != null)
			{
				// Use the ID attribute value as the id

				id = eObject.eGet(idAttribute);
				dbObject.put("_id", id);

				if (writeConcern == null)
					collection.insert(dbObject);
				else
					collection.insert(dbObject, writeConcern);
			}
			else
			{
				// The id was not specified, so we are creating an object and letting MongoDB generate the id

				if (writeConcern == null)
					collection.insert(dbObject);
				else
					collection.insert(dbObject, writeConcern);

				id = dbObject.get(MongoDBURIHandlerImpl.ID_KEY);
			}

			// Modify the EMF Resource URI to include the id generated by MongoDB or specified in the ID attribute
			// by removing the dummy id and appending the real id.

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
	private boolean serializeDefault;
}
