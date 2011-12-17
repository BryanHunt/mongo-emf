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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.query.QueryFactory;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.emf.IMongoEmfConverter;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class MongoDBInputStream extends InputStream implements URIConverter.Loadable
{
	public MongoDBInputStream(MongoDBURIHandlerImpl handler, URI uri, Map<?, ?> options, Map<Object, Object> response) throws IOException
	{
		this.handler = handler;
		this.uri = uri;
		this.options = options;
		this.response = response;
	}

	@Override
	public void loadResource(Resource resource) throws IOException
	{
		// We need to set up the XMLResource.URIHandler so that proxy URIs are handled properly.

		XMLResource.URIHandler uriHandler = (XMLResource.URIHandler) options.get(XMLResource.OPTION_URI_HANDLER);

		proxyAttributes = Boolean.TRUE.equals(options.get(MongoDBURIHandlerImpl.OPTION_PROXY_ATTRIBUTES));

		if (uriHandler == null)
			uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

		if (resource.getURI().hasQuery())
			uriHandler.setBaseURI(resource.getURI().trimSegments(1).appendSegment("-1"));
		else
			uriHandler.setBaseURI(resource.getURI());

		// If the URI contains a query string, use it to locate a collection of objects from
		// MongoDB, otherwise simply get the object from MongoDB using the id.

		DBCollection collection = MongoDBURIHandlerImpl.getCollection(handler.getMongoDB(), uri, options);
		EList<EObject> contents = resource.getContents();

		if (uri.query() != null)
		{
			Result result = QueryFactory.eINSTANCE.createResult();
			InternalEList<EObject> values = (InternalEList<EObject>) result.getValues();

			for (DBObject dbObject : collection.find(handler.getQueryEngine().buildDBObjectQuery(uri)))
				values.addUnique(buildEObject(collection, dbObject, resource, uriHandler, true));

			contents.add(result);
		}
		else
		{
			DBObject dbObject = collection.findOne(new BasicDBObject(MongoDBURIHandlerImpl.ID_KEY, MongoDBURIHandlerImpl.getID(uri)));

			if (dbObject != null)
			{
				EObject eObject = buildEObject(collection, dbObject, resource, uriHandler, false);

				if (eObject != null)
					contents.add(eObject);

				response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, dbObject.get(MongoDBURIHandlerImpl.TIME_STAMP_KEY));
			}
		}
	}

	@Override
	public int read() throws IOException
	{
		// InputStream requires that we implement this function.  It will never be called since this implementation
		// implements URIConverter.Loadable. The loadResource() function will be called instead.

		return 0;
	}

	private EObject buildEObject(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler, boolean isProxy)
	{
		ResourceSet resourceSet = resource.getResourceSet();

		// Build an EMF object from the MongodDB object

		EObject eObject = createEObject(dbObject, resource.getResourceSet());

		if (isProxy)
		{
			URI proxyURI = URI.createURI("../" + collection.getName() + "/" + dbObject.get(MongoDBURIHandlerImpl.ID_KEY) + "#/");
			((InternalEObject) eObject).eSetProxyURI(uriHandler.resolve(proxyURI));
		}

		// Load the XML extrinsic id if necessary

		String id = (String) dbObject.get(MongoDBURIHandlerImpl.EXTRINSIC_ID_KEY);

		if (id != null && resource instanceof XMLResource)
			((XMLResource) resource).setID(eObject, id);

		// All features are mapped as key / value pairs with the key being the attribute name.

		for (EStructuralFeature feature : eObject.eClass().getEAllStructuralFeatures())
		{
			if (feature instanceof EAttribute)
			{
				EAttribute attribute = (EAttribute) feature;

				if (!isProxy || !FeatureMapUtil.isFeatureMap(attribute))
					buildEObjectAttribute(collection, dbObject, resource, uriHandler, resourceSet, eObject, attribute);
			}
			else if (!isProxy)
				buildEObjectReference(collection, dbObject, resource, uriHandler, eObject, (EReference) feature);
		}

		return eObject;
	}

	/**
	 * @param collection
	 * @param dbObject
	 * @param resource
	 * @param uriHandler
	 * @param resourceSet
	 * @param eObject
	 * @param attribute
	 */
	@SuppressWarnings("unchecked")
	private void buildEObjectAttribute(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler, ResourceSet resourceSet, EObject eObject, EAttribute attribute)
	{
		if (!attribute.isTransient() && dbObject.containsField(attribute.getName()))
		{
			Object value = dbObject.get(attribute.getName());

			if (FeatureMapUtil.isFeatureMap(attribute))
			{
				FeatureMap.Internal featureMap = (FeatureMap.Internal) eObject.eGet(attribute);

				for (DBObject entry : (ArrayList<DBObject>) value)
				{
					EStructuralFeature feature = (EStructuralFeature) resourceSet.getEObject(URI.createURI((String) entry.get("key")), true);

					if (feature instanceof EAttribute)
						featureMap.add(feature, convertMongoDBValueToEMFValue(((EAttribute) feature).getEAttributeType(), entry.get("value")));
					else
					{
						EReference reference = (EReference) feature;
						DBObject dbReference = (DBObject) entry.get("value");
						EObject target = buildEObjectReference(collection, dbReference, resource, uriHandler, reference.isResolveProxies());
						featureMap.add(feature, target);
					}
				}
			}
			else if (attribute.isMany() && !MongoDBURIHandlerImpl.isNativeType(attribute.getEAttributeType()))
			{
				ArrayList<Object> values = new ArrayList<Object>();
				EDataType eDataType = attribute.getEAttributeType();
				IMongoEmfConverter converter = handler.getConverter(eDataType);

				for (Object dbValue : (ArrayList<Object>) value)
					values.add(converter.convertMongoDBValueToEMFValue(eDataType, dbValue));

				eObject.eSet(attribute, values);
			}
			else
				eObject.eSet(attribute, convertMongoDBValueToEMFValue(attribute.getEAttributeType(), value));
		}
	}

	/**
	 * @param collection
	 * @param dbObject
	 * @param resource
	 * @param uriHandler
	 * @param eObject
	 * @param reference
	 */
	private void buildEObjectReference(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler, EObject eObject, EReference reference)
	{
		if (reference.isTransient())
			return;

		String field = reference.getName();

		if (dbObject.containsField(field))
		{
			boolean isResolveProxies = reference.isResolveProxies();

			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				List<DBObject> dbReferences = (List<DBObject>) dbObject.get(field);

				@SuppressWarnings("unchecked")
				EList<EObject> eObjects = (EList<EObject>) eObject.eGet(reference);

				for (DBObject dbReference : dbReferences)
				{
					EObject target = buildEObjectReference(collection, dbReference, resource, uriHandler, isResolveProxies);
					eObjects.add(target);
				}
			}
			else
			{
				DBObject dbReference = (DBObject) dbObject.get(field);
				EObject target = buildEObjectReference(collection, dbReference, resource, uriHandler, isResolveProxies);
				eObject.eSet(reference, target);
			}
		}
	}

	private EObject buildEObjectReference(DBCollection collection, DBObject dbReference, Resource resource, XMLResource.URIHandler uriHandler, boolean referenceResolvesProxies)
	{
		if (dbReference == null)
			return null;

		// Build an EMF reference from the data in MongoDB.

		String proxy = (String) dbReference.get(MongoDBURIHandlerImpl.PROXY_KEY);

		if (proxy == null)
			return buildEObject(collection, dbReference, resource, uriHandler, false);
		else
			return buildProxy(collection, dbReference, resource.getResourceSet(), uriHandler, referenceResolvesProxies);
	}

	/**
	 * This function builds an EMF proxy object from the reference DBObject
	 * 
	 * @param collection the collection containing the referencing object
	 * @param dbReference the MongoDB reference - must be of the form { ECLASS_KEY : eClassURI, PROXY_KEY : proxyURI }
	 * @param resourceSet the resource set to use for building the proxy
	 * @param uriHandler the resource URI handler used to resolve the relative proxy URI
	 * @param referenceResolvedProxies flag indicating that the reference resolves proxies
	 * @return the proxy object when referenceResolvedProxies is true, the resolved object otherwise
	 */
	private EObject buildProxy(DBCollection collection, DBObject dbReference, ResourceSet resourceSet, XMLResource.URIHandler uriHandler, boolean referenceResolvedProxies)
	{
		EObject eObject;
		URI proxyURI = URI.createURI((String) dbReference.get(MongoDBURIHandlerImpl.PROXY_KEY));
		URI resolvedProxyURI = uriHandler.resolve(proxyURI);

		if (!referenceResolvedProxies)
		{
			// When referenceResolvedProxies is false, we must resolve the proxy in place and get the referenced object

			eObject = resourceSet.getEObject(resolvedProxyURI, true);
		}
		else
		{
			eObject = createEObject(dbReference, resourceSet);

			((InternalEObject) eObject).eSetProxyURI(resolvedProxyURI);

			if (proxyAttributes && proxyURI.isRelative() && "/".equals(proxyURI.fragment()))
			{
				DBCollection referenceCollection = null;

				if (proxyURI.segmentCount() == 3 && proxyURI.segment(0).equals(".."))
				{
					referenceCollection = collection.getDB().getCollection(proxyURI.segment(1));
				}
				else if (proxyURI.segmentCount() == 1)
				{
					referenceCollection = collection;
				}

				if (referenceCollection != null)
				{
					DBObject referenceDBObject = new BasicDBObject(MongoDBURIHandlerImpl.ID_KEY, new ObjectId(proxyURI.lastSegment()));
					DBObject referencedDBObject = referenceCollection.findOne(referenceDBObject);

					if (referencedDBObject != null)
					{
						for (EAttribute attribute : eObject.eClass().getEAllAttributes())
						{
							if (!attribute.isTransient() && !FeatureMapUtil.isFeatureMap(attribute))
								buildEObjectAttribute(referenceCollection, referencedDBObject, null, uriHandler, resourceSet, eObject, attribute);
						}
					}
				}
			}
		}

		return eObject;
	}

	/**
	 * This function converts the raw value read from MongoDB into the correct type for
	 * the given datatype.
	 * 
	 * @param eDataType the EMF datatype to convert to
	 * @param value the raw MongoDB value to convert from
	 * @return the converted value
	 */
	private Object convertMongoDBValueToEMFValue(EDataType eDataType, Object value)
	{
		if (!MongoDBURIHandlerImpl.isNativeType(eDataType))
		{
			// Types not native to MongoDB are stored as strings and must be converted to the proper object type by EMF

			value = handler.getConverter(eDataType).convertMongoDBValueToEMFValue(eDataType, value);
		}
		else if (value != null)
		{
			// If the type is a byte, float, or short, it must be converted from the native MongoDB type
			// It is valid to use == for string comparison in this case.

			String instanceClassName = eDataType.getInstanceClassName();

			if (instanceClassName == "byte" || instanceClassName == "java.lang.Byte")
				value = ((Integer) value).byteValue();
			else if (instanceClassName == "float" || instanceClassName == "java.lang.Float")
				value = ((Double) value).floatValue();
			else if (instanceClassName == "short" || instanceClassName == "java.lang.Short")
				value = ((Integer) value).shortValue();
		}

		return value;
	}

	/**
	 * This function creates an empty EObject from the given DBObject. The actual instance created
	 * is determined by the EClass specified in the DBObject by the ECLASS_KEY. This function also
	 * maintains a static cache of EClass URI to EClass for improved performance.
	 * 
	 * @param dbObject the object read from MongoDB
	 * @param resourceSet the resourceSet that will be used to locate the EClass if it is not cached
	 * @return the newly created object of type as specified by the data read from MongoDB
	 */
	private EObject createEObject(DBObject dbObject, ResourceSet resourceSet)
	{
		String eClassURI = (String) dbObject.get(MongoDBURIHandlerImpl.ECLASS_KEY);
		EClass eClass = eClassCache.get(eClassURI);

		if (eClass == null)
		{
			eClass = (EClass) resourceSet.getEObject(URI.createURI(eClassURI), true);
			eClassCache.put(eClassURI, eClass);
		}

		return EcoreUtil.create(eClass);
	}

	private MongoDBURIHandlerImpl handler;
	private URI uri;
	private Map<?, ?> options;
	private Map<Object, Object> response;
	private static Map<String, EClass> eClassCache = new HashMap<String, EClass>();
	private boolean proxyAttributes;
}
