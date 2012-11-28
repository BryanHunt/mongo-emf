/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt & Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt & Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.emf.mongodb.builders;

import java.util.ArrayList;
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
import org.eclipselabs.emf.mongodb.ConverterService;
import org.eclipselabs.emf.mongodb.EObjectBuilder;
import org.eclipselabs.emf.mongodb.Keywords;
import org.eclipselabs.emf.mongodb.MongoUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * This class builds EMF EObjects from a MongoDB DBObject. This builder is designed to be extensible,
 * but you must be aware of the assumptions made by each of the functions in the builder.
 * 
 * This class is thread safe.
 * 
 * @author bhunt
 */
public class EObjectBuilderImpl implements EObjectBuilder
{
	/**
	 * Constructs an object builder without an EClass cache.
	 * 
	 * @param converterService the service to use when converting attribute values
	 * @param uriHandler the handler for creating proxy URIs
	 * @param includeAttributesForProxyReferences true if you want attribute values to be set on proxy references; false otherwise
	 */
	public EObjectBuilderImpl(ConverterService converterService, XMLResource.URIHandler uriHandler, boolean includeAttributesForProxyReferences)
	{
		this(converterService, uriHandler, includeAttributesForProxyReferences, null);
	}

	/**
	 * Constructs an object builder with an optional EClass cache.
	 * 
	 * @param converterService the service to use when converting attribute values
	 * @param uriHandler the handler for creating proxy URIs
	 * @param includeAttributesForProxyReferences true if you want attribute values to be set on proxy references; false otherwise
	 * @param eClassCache the cache to use to EClass lookups when building the EObject instance - may be null
	 */
	public EObjectBuilderImpl(ConverterService converterService, XMLResource.URIHandler uriHandler, boolean includeAttributesForProxyReferences, Map<String, EClass> eClassCache)
	{
		this.converterService = converterService;
		this.uriHandler = uriHandler;
		this.includeAttributesForProxyReferences = includeAttributesForProxyReferences;
		this.eClassCache = eClassCache;
	}

	/**
	 * Build an EMF EObject from the supplied DBObject from MongoDB.
	 * 
	 * @param collection the MongoDB collection containing the DBObject
	 * @param dbObject the object read from MongoDB
	 * @param resource the resource that will contain the EMF Object
	 *          This function will not add the created to the supplied resource
	 *          to support the case where the user wishes to return a collection
	 *          of objects such as the result of a query.
	 * @param isProxy true if the object is to be built as a proxy; false otherwise
	 * @return the newly created EMF object instance
	 */
	@Override
	public EObject buildEObject(DBCollection collection, DBObject dbObject, Resource resource, boolean isProxy)
	{
		// Build an empty EMF object to hold the data from the MongodDB object
		// This function should not add the object to the resource since the
		// object may become part of a collection returned in the resource such
		// as the result of a query.

		EObject eObject = createEObject(resource.getResourceSet(), dbObject);
		EClass eClass = eObject.eClass();

		// Load the XML extrinsic id if necessary

		buildExtransicID(dbObject, resource, eObject);

		// All attributes are mapped as key / value pairs with the key being the attribute name.

		for (EAttribute attribute : eClass.getEAllAttributes())
		{
			if (!isProxy || !FeatureMapUtil.isFeatureMap(attribute))
				buildAttribute(collection, dbObject, resource, eObject, attribute);
		}

		// isProxy will be set to true when the object is being returned as
		// part of a collection such as the result of a query.

		if (isProxy)
		{
			URI proxyURI = URI.createURI("../" + collection.getName() + "/" + dbObject.get(Keywords.ID_KEY) + "#/");
			((InternalEObject) eObject).eSetProxyURI(uriHandler.resolve(proxyURI));
			return eObject;
		}

		// All references are mapped as key / value pairs with the key being the reference name.

		for (EReference reference : eClass.getEAllReferences())
			buildReference(collection, dbObject, resource, eObject, reference);

		return eObject;
	}

	@Override
	public URI buildURI(DBCollection collection, DBObject object)
	{
		URI uri = URI.createURI("../" + collection.getName() + "/" + object.get(Keywords.ID_KEY));
		return uriHandler.resolve(uri);
	}

	/**
	 * Builds an attribute value from the DBObject, converting the value if necessary.
	 * Feature maps are delegated to buildFeatureMap() and non-native arrays to
	 * buildAttributeArray(). The converter service is used for value conversion.
	 * Attribute values are expected to be mapped in the DBObject using the attribute
	 * name as the key.
	 * 
	 * @param collection the MongoDB collection containing the DBObject
	 * @param dbObject the object read from MongoDB
	 * @param resource the resource that will contain the EMF Object
	 * @param eObject the EMF object being built
	 * @param attribute the attribute to set on the EMF object
	 */
	@SuppressWarnings("unchecked")
	protected void buildAttribute(DBCollection collection, DBObject dbObject, Resource resource, EObject eObject, EAttribute attribute)
	{
		// Attributes are mapped as key / value pairs with the key being the attribute name.

		if (!attribute.isTransient() && dbObject.containsField(attribute.getName()))
		{
			Object value = dbObject.get(attribute.getName());

			if (FeatureMapUtil.isFeatureMap(attribute))
				buildFeatureMap(collection, resource, eObject, attribute, (List<DBObject>) value);
			else if (attribute.isMany())
				buildAttributeArray(eObject, attribute, value);
			else
				buildAttributeValue(eObject, attribute, value);
		}
	}

	/**
	 * Builds a multi-value attribute from a collection of values. Each value is
	 * converted using the converter service.
	 * 
	 * @param eObject the EMF object being built
	 * @param attribute the attribute to set on the EMF object
	 * @param values the raw, unconverted, collection of values of the attribute
	 */
	protected void buildAttributeArray(EObject eObject, EAttribute attribute, Object values)
	{
		if (!MongoUtils.isNativeType(attribute.getEAttributeType()))
		{
			@SuppressWarnings("unchecked")
			List<Object> eValues = (List<Object>) values;
			ArrayList<Object> convertedValues = new ArrayList<Object>(eValues.size());
			EDataType eDataType = attribute.getEAttributeType();

			for (Object dbValue : eValues)
				convertedValues.add(convertMongoDBValueToEMFValue(eDataType, dbValue));

			eObject.eSet(attribute, convertedValues);
		}
		else
			eObject.eSet(attribute, values);
	}

	/**
	 * Sets the attribute value on the EMF object after converting it using the converter service.
	 * 
	 * @param eObject the EMF object being built
	 * @param attribute the attribute to set on the EMF object
	 * @param value the value read from MongoDB
	 */
	protected void buildAttributeValue(EObject eObject, EAttribute attribute, Object value)
	{
		EDataType eDataType = attribute.getEAttributeType();
		eObject.eSet(attribute, convertMongoDBValueToEMFValue(eDataType, value));
	}

	/**
	 * Sets the extrensic ID if it exists and the resource is of type XMLResource. The
	 * extrensic ID is expected to be mapped to the key EXTRINSIC_ID_KEY.
	 * 
	 * @param dbObject the object read from MongoDB
	 * @param resource the resource that will contain the EMF Object
	 * @param eObject the EMF object being built
	 */
	protected void buildExtransicID(DBObject dbObject, Resource resource, EObject eObject)
	{
		String id = (String) dbObject.get(Keywords.EXTRINSIC_ID_KEY);

		if (id != null && resource instanceof XMLResource)
			((XMLResource) resource).setID(eObject, id);
	}

	/**
	 * Builds a feature map from the attribute value. Feature maps
	 * of references are delegated to buildReferencedObject to build
	 * the referenced object.
	 * 
	 * @param collection the MongoDB collection containing the DBObject
	 * @param resource the resource that will contain the EMF Object
	 * @param eObject the EMF object being built
	 * @param attribute the attribute to set on the EMF object
	 * @param values the values extracted from the database as a list
	 */
	protected void buildFeatureMap(DBCollection collection, Resource resource, EObject eObject, EAttribute attribute, List<DBObject> values)
	{
		FeatureMap.Internal featureMap = (FeatureMap.Internal) eObject.eGet(attribute);

		for (DBObject entry : values)
		{
			EStructuralFeature feature = (EStructuralFeature) resource.getResourceSet().getEObject(URI.createURI((String) entry.get("key")), true);

			if (feature instanceof EAttribute)
			{
				EDataType eDataType = ((EAttribute) feature).getEAttributeType();
				featureMap.add(feature, convertMongoDBValueToEMFValue(eDataType, entry.get("value")));
			}
			else
			{
				EReference reference = (EReference) feature;
				DBObject dbReference = (DBObject) entry.get("value");
				EObject target = buildReferencedObject(collection, dbReference, resource, reference.isResolveProxies());
				featureMap.add(feature, target);
			}
		}
	}

	/**
	 * Builds a reference value from the DBObject. References with cardinality greater
	 * than one are expected to be stored as a java.util.List of DBObject. References
	 * with cardinality equal to one are expected to be stored as a DBObject.
	 * Reference values are expected to be mapped in the DBObject using the reference
	 * name as the key. Building of the referenced object is delegated to
	 * buildReferencedObject().
	 * 
	 * @param collection the MongoDB collection containing the DBObject
	 * @param dbObject the object read from MongoDB
	 * @param resource the resource that will contain the EMF Object
	 * @param eObject the EMF object being built
	 * @param reference the reference to set on the EMF object
	 */
	protected void buildReference(DBCollection collection, DBObject dbObject, Resource resource, EObject eObject, EReference reference)
	{
		// References are mapped as key / value pairs with the key being the reference name.

		if (!reference.isTransient() && dbObject.containsField(reference.getName()))
		{
			boolean isResolveProxies = reference.isResolveProxies();

			if (reference.isMany())
			{
				// One to many reference

				@SuppressWarnings("unchecked")
				List<DBObject> dbReferences = (List<DBObject>) dbObject.get(reference.getName());

				@SuppressWarnings("unchecked")
				EList<EObject> eObjects = (EList<EObject>) eObject.eGet(reference);

				for (DBObject dbReference : dbReferences)
				{
					EObject target = buildReferencedObject(collection, dbReference, resource, isResolveProxies);
					eObjects.add(target);
				}
			}
			else
			{
				// One to one reference

				DBObject dbReference = (DBObject) dbObject.get(reference.getName());
				EObject target = buildReferencedObject(collection, dbReference, resource, isResolveProxies);
				eObject.eSet(reference, target);
			}
		}
	}

	/**
	 * Builds the EObject for a reference. The EObject may be a proxy. The reference
	 * value is assumed to be stored in the DBObject as { PROXY_KEY : String } where the
	 * string is an EMF proxy URI. If the proxy URI is not null, the proxy EObject is
	 * built by delegating to buildProxy(). If the proxy URI is null, the referenced
	 * object is treated as an embedded reference and is built by delegating to buildEObject().
	 * 
	 * @param collection the MongoDB collection containing the DBObject
	 * @param dbReference the DBObject containing the referenced object / proxy
	 * @param resource the resource that will contain the EMF Object
	 * @param referenceResolvesProxies true if the references resolves proxies; false otherwise
	 * @return
	 */
	protected EObject buildReferencedObject(DBCollection collection, DBObject dbReference, Resource resource, boolean referenceResolvesProxies)
	{
		if (dbReference == null)
			return null;

		// Build an EMF reference from the data in MongoDB.

		String proxy = (String) dbReference.get(Keywords.PROXY_KEY);

		if (proxy == null)
			return buildEObject(collection, dbReference, resource, false);
		else
			return buildProxy(collection, dbReference, resource.getResourceSet(), referenceResolvesProxies);
	}

	/**
	 * Builds an EMF proxy object from the reference DBObject
	 * 
	 * @param collection the collection containing the referencing object
	 * @param dbReference the MongoDB reference - must be of the form { ECLASS_KEY : eClassURI, PROXY_KEY : proxyURI }
	 * @param resourceSet the resource set to use for building the proxy
	 * @param referenceResolvesProxies true if the reference resolves proxies; false otherwise
	 * @return the proxy object when referenceResolvedProxies is true, the resolved object otherwise
	 */
	protected EObject buildProxy(DBCollection collection, DBObject dbReference, ResourceSet resourceSet, boolean referenceResolvesProxies)
	{
		EObject eObject;
		URI proxyURI = URI.createURI((String) dbReference.get(Keywords.PROXY_KEY));
		URI resolvedProxyURI = uriHandler.resolve(proxyURI);

		if (!referenceResolvesProxies)
		{
			// When referenceResolvedProxies is false, we must resolve the proxy in place and get the referenced object

			eObject = resourceSet.getEObject(resolvedProxyURI, true);
		}
		else
		{
			eObject = createEObject(resourceSet, dbReference);

			((InternalEObject) eObject).eSetProxyURI(resolvedProxyURI);

			if (includeAttributesForProxyReferences && proxyURI.isRelative() && "/".equals(proxyURI.fragment()))
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
					DBObject referenceDBObject = new BasicDBObject(Keywords.ID_KEY, new ObjectId(proxyURI.lastSegment()));
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
	 * Converts the MongoDB value into an EMF value using the converter service
	 * 
	 * @param eDataType the value type
	 * @param dbValue the value
	 * @return the converted value
	 */
	protected Object convertMongoDBValueToEMFValue(EDataType eDataType, Object dbValue)
	{
		Object convertedValue = dbValue;

		if (!MongoUtils.isNativeType(eDataType))
		{
			// Types not native to MongoDB are stored as strings and must be converted to the proper object type by EMF

			convertedValue = converterService.getConverter(eDataType).convertMongoDBValueToEMFValue(eDataType, dbValue);
		}
		else if (dbValue != null)
		{
			// If the type is a byte, float, or short, it must be converted from the native MongoDB type
			// It is valid to use == for string comparison in this case.

			String instanceClassName = eDataType.getInstanceClassName();

			if (instanceClassName == "byte" || instanceClassName == "java.lang.Byte")
				convertedValue = ((Integer) dbValue).byteValue();
			else if (instanceClassName == "float" || instanceClassName == "java.lang.Float")
				convertedValue = ((Double) dbValue).floatValue();
			else if (instanceClassName == "short" || instanceClassName == "java.lang.Short")
				convertedValue = ((Integer) dbValue).shortValue();
		}

		return convertedValue;
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
		String eClassURI = (String) dbObject.get(Keywords.ECLASS_KEY);
		EClass eClass = getEClass(resourceSet, eClassURI);
		return EcoreUtil.create(eClass);
	}

	/**
	 * Finds the EClass for the given URI
	 * 
	 * @param resourceSet the resource set used to locate the EClass if it was not
	 *          found in the cache
	 * @param eClassURI the URI of the EClass
	 * @return the EClass instance for the given URI
	 */
	protected EClass getEClass(ResourceSet resourceSet, String eClassURI)
	{
		if (eClassCache != null)
		{
			synchronized (eClassCache)
			{
				EClass eClass = eClassCache.get(eClassURI);

				if (eClass == null)
				{
					eClass = (EClass) resourceSet.getEObject(URI.createURI(eClassURI), true);
					eClassCache.put(eClassURI, eClass);
				}

				return eClass;
			}
		}

		return (EClass) resourceSet.getEObject(URI.createURI(eClassURI), true);
	}

	private ConverterService converterService;
	private XMLResource.URIHandler uriHandler;
	private Map<String, EClass> eClassCache;
	private boolean includeAttributesForProxyReferences;
}
