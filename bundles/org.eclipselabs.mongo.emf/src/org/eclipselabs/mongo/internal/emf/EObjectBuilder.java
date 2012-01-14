/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.internal.emf;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class EObjectBuilder
{
	public EObjectBuilder(IConverterService converterService, XMLResource.URIHandler uriHandler, boolean proxyAttributes)
	{
		this.converterService = converterService;
		this.uriHandler = uriHandler;
		this.proxyAttributes = proxyAttributes;
	}

	public EObject buildEObject(DBCollection collection, DBObject dbObject, Resource resource, boolean isProxy)
	{
		// Build an empty EMF object to hold the data from the MongodDB object
		// This function should not add the object to the resource since the
		// object may become part of a collection returned in the resource such
		// as the result of a query.

		EObject eObject = createEObject(resource.getResourceSet(), dbObject);

		// isProxy will be set to true when the object is being returned as
		// part of a collection such as the result of a query.

		if (isProxy)
		{
			URI proxyURI = URI.createURI("../" + collection.getName() + "/" + dbObject.get(MongoDBURIHandlerImpl.ID_KEY) + "#/");
			((InternalEObject) eObject).eSetProxyURI(uriHandler.resolve(proxyURI));
		}

		// Load the XML extrinsic id if necessary

		String id = (String) dbObject.get(MongoDBURIHandlerImpl.EXTRINSIC_ID_KEY);

		if (id != null && resource instanceof XMLResource)
			((XMLResource) resource).setID(eObject, id);

		// Extract all features from the database object and populate the EObject

		for (EStructuralFeature feature : eObject.eClass().getEAllStructuralFeatures())
		{
			if (feature instanceof EAttribute)
			{
				EAttribute attribute = (EAttribute) feature;

				if (!isProxy || !FeatureMapUtil.isFeatureMap(attribute))
					buildAttribute(collection, dbObject, resource, eObject, attribute);
			}
			else if (!isProxy)
				buildReference(collection, dbObject, resource, eObject, (EReference) feature);
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
	protected void buildAttribute(DBCollection collection, DBObject dbObject, Resource resource, EObject eObject, EAttribute attribute)
	{
		if (!attribute.isTransient() && dbObject.containsField(attribute.getName()))
		{
			// Attributes are mapped as key / value pairs with the key being the attribute name.

			Object value = dbObject.get(attribute.getName());

			if (FeatureMapUtil.isFeatureMap(attribute))
				buildFeatureMap(collection, resource, eObject, attribute, value);
			else if (attribute.isMany() && !MongoDBURIHandlerImpl.isNativeType(attribute.getEAttributeType()))
				buildAttributeArray(eObject, attribute, value);
			else
				eObject.eSet(attribute, converterService.convertMongoDBValueToEMFValue(attribute.getEAttributeType(), value));
		}
	}

	/**
	 * @param eObject
	 * @param attribute
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	protected void buildAttributeArray(EObject eObject, EAttribute attribute, Object value)
	{
		ArrayList<Object> values = new ArrayList<Object>();
		EDataType eDataType = attribute.getEAttributeType();

		for (Object dbValue : (ArrayList<Object>) value)
			values.add(converterService.convertMongoDBValueToEMFValue(eDataType, dbValue));

		eObject.eSet(attribute, values);
	}

	/**
	 * @param collection
	 * @param dbObject
	 * @param resource
	 * @param uriHandler
	 * @param eObject
	 * @param reference
	 */
	protected void buildReference(DBCollection collection, DBObject dbObject, Resource resource, EObject eObject, EReference reference)
	{
		// References are mapped as key / value pairs with the key being the reference name.

		String field = reference.getName();

		if (!reference.isTransient() && dbObject.containsField(field))
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
					EObject target = buildReference(collection, dbReference, resource, isResolveProxies);
					eObjects.add(target);
				}
			}
			else
			{
				DBObject dbReference = (DBObject) dbObject.get(field);
				EObject target = buildReference(collection, dbReference, resource, isResolveProxies);
				eObject.eSet(reference, target);
			}
		}
	}

	protected EObject buildReference(DBCollection collection, DBObject dbReference, Resource resource, boolean referenceResolvesProxies)
	{
		if (dbReference == null)
			return null;

		// Build an EMF reference from the data in MongoDB.

		String proxy = (String) dbReference.get(MongoDBURIHandlerImpl.PROXY_KEY);

		if (proxy == null)
			return buildEObject(collection, dbReference, resource, false);
		else
			return buildProxy(collection, dbReference, resource.getResourceSet(), referenceResolvesProxies);
	}

	/**
	 * @param collection
	 * @param resource
	 * @param eObject
	 * @param attribute
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	protected void buildFeatureMap(DBCollection collection, Resource resource, EObject eObject, EAttribute attribute, Object value)
	{
		FeatureMap.Internal featureMap = (FeatureMap.Internal) eObject.eGet(attribute);

		for (DBObject entry : (ArrayList<DBObject>) value)
		{
			EStructuralFeature feature = (EStructuralFeature) resource.getResourceSet().getEObject(URI.createURI((String) entry.get("key")), true);

			if (feature instanceof EAttribute)
				featureMap.add(feature, converterService.convertMongoDBValueToEMFValue(((EAttribute) feature).getEAttributeType(), entry.get("value")));
			else
			{
				EReference reference = (EReference) feature;
				DBObject dbReference = (DBObject) entry.get("value");
				EObject target = buildReference(collection, dbReference, resource, reference.isResolveProxies());
				featureMap.add(feature, target);
			}
		}
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
	protected EObject buildProxy(DBCollection collection, DBObject dbReference, ResourceSet resourceSet, boolean referenceResolvedProxies)
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
			eObject = createEObject(resourceSet, dbReference);

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
								buildAttribute(referenceCollection, referencedDBObject, null, eObject, attribute);
						}
					}
				}
			}
		}

		return eObject;
	}

	/**
	 * This function creates an empty EObject by extracting the EClass type from the given DBObject
	 * using the ECLASS_KEY. This function also maintains a static cache of EClass URI to EClass for
	 * improved performance.
	 * 
	 * @param resourceSet the resourceSet that will be used to locate the EClass if it is not cached
	 * @param dbObject the object read from MongoDB
	 * @return the newly created object of type as specified by the data read from MongoDB
	 */
	protected EObject createEObject(ResourceSet resourceSet, DBObject dbObject)
	{
		String eClassURI = (String) dbObject.get(MongoDBURIHandlerImpl.ECLASS_KEY);
		EClass eClass;

		synchronized (eClassCache)
		{
			eClass = eClassCache.get(eClassURI);

			if (eClass == null)
			{
				eClass = (EClass) resourceSet.getEObject(URI.createURI(eClassURI), true);
				eClassCache.put(eClassURI, eClass);
			}
		}

		return EcoreUtil.create(eClass);
	}

	private IConverterService converterService;
	private XMLResource.URIHandler uriHandler;
	private static Map<String, EClass> eClassCache = new HashMap<String, EClass>();
	private boolean proxyAttributes;
}
