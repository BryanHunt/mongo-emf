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

package org.eclipselabs.mongo.emf.builders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.mongodb.ConverterService;
import org.eclipselabs.emf.mongodb.DBObjectBuilder;
import org.eclipselabs.emf.mongodb.Keywords;
import org.eclipselabs.emf.mongodb.MongoUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * This class builds a DBObject from an EMFObject. This builder is designed to be extensible,
 * but you must be aware of the assumptions made by each of the functions in the builder.
 * 
 * This class is thread safe.
 * 
 * @author bhunt
 */
public class DBObjectBuilderImpl implements DBObjectBuilder
{
	/**
	 * @param converterService the service to use when converting attribute values
	 * @param uriHandler the handler for creating proxy URIs
	 * @param serializeDefaultAttributeValues true causes default attribute values to be written to the DBObject;
	 *          false causes default attribute values to be skipped
	 */
	public DBObjectBuilderImpl(ConverterService converterService, XMLResource.URIHandler uriHandler, boolean serializeDefaultAttributeValues)
	{
		this.converterService = converterService;
		this.uriHandler = uriHandler;
		this.serializeDefaultAttributeValues = serializeDefaultAttributeValues;
	}

	/**
	 * Build a DBObject from the supplied EMF object.
	 * 
	 * @param eObject the EMF object to serialize
	 * @return the newly created DBObject
	 */
	@Override
	public DBObject buildDBObject(EObject eObject)
	{
		// Build a MongoDB object from the EMF object.

		BasicDBObject dbObject = new BasicDBObject();
		EClass eClass = eObject.eClass();

		// We have to add the URI of the class to the object so that we can
		// reconstruct the EMF object when we read it back out of MongoDB.

		dbObject.put(Keywords.ECLASS_KEY, EcoreUtil.getURI(eClass).toString());

		// Save the XML extrinsic id if necessary

		buildExtrensicID(eObject, dbObject);

		// All attributes are mapped as key / value pairs with the key being the attribute name.

		for (EAttribute attribute : eClass.getEAllAttributes())
		{
			if (!attribute.isTransient() && (eObject.eIsSet(attribute) || (!attribute.isUnsettable() && serializeDefaultAttributeValues)))
				buildAttribute(eObject, dbObject, attribute);
		}

		// All references are mapped as key / value pairs with the key being the reference name.

		for (EReference reference : eClass.getEAllReferences())
		{
			if (!reference.isTransient() && eObject.eIsSet(reference))
				buildReference(eObject, dbObject, reference);
		}

		return dbObject;
	}

	/**
	 * Serializes the attribute from the EMF object into the DBObject
	 * Feature maps are delegated to buildFeatureMap() and non-native arrays to
	 * buildAttributeArray(). The converter service is used for value conversion.
	 * Attribute values are mapped in the DBObject using the attribute
	 * name as the key.
	 * 
	 * @param eObject the EMF object to serialize
	 * @param dbObject the MongoDB object being built
	 * @param attribute the attribute to serialize from the EMF object
	 */
	protected void buildAttribute(EObject eObject, DBObject dbObject, EAttribute attribute)
	{
		Object value = eObject.eGet(attribute);

		if (FeatureMapUtil.isFeatureMap(attribute))
			buildFeatureMap(dbObject, attribute, value);
		else if (attribute.isMany())
			buildAttributeArray(dbObject, attribute, value);
		else
			buildAttributeValue(dbObject, attribute, value);
	}

	/**
	 * Serializes an attribute as a java.util.ArrayList. Each value is
	 * converted using the converter service.
	 * 
	 * @param dbObject the MongoDB object being built
	 * @param attribute the attribute to serialize from the EMF object
	 * @param values the attribute values to serialize
	 */
	protected void buildAttributeArray(DBObject dbObject, EAttribute attribute, Object values)
	{
		EDataType eDataType = attribute.getEAttributeType();

		if (!MongoUtils.isNativeType(eDataType))
		{
			EList<?> eValues = (EList<?>) values;
			ArrayList<Object> convertedValues = new ArrayList<Object>(eValues.size());

			for (Object rawValue : eValues)
				convertedValues.add(convertEMFValueToMongoDBValue(attribute.getEAttributeType(), rawValue));

			dbObject.put(attribute.getName(), convertedValues);
		}
		else
			dbObject.put(attribute.getName(), values);
	}

	/**
	 * Converts the attribute value if needed
	 * 
	 * @param dbObject the MongoDB object being built
	 * @param attribute the attribute to serialize from the EMF object
	 * @param value the value of the attribute from the EMF object
	 */
	protected void buildAttributeValue(DBObject dbObject, EAttribute attribute, Object value)
	{
		EDataType eDataType = attribute.getEAttributeType();

		if (!MongoUtils.isNativeType(eDataType))
			dbObject.put(attribute.getName(), convertEMFValueToMongoDBValue(eDataType, value));
		else
			dbObject.put(attribute.getName(), value);
	}

	/**
	 * Sets the extrensic ID if it exists and the resource is of type XMLResource. The
	 * extrensic ID is mapped to the key EXTRINSIC_ID_KEY.
	 * 
	 * @param eObject the EMF object to serialize
	 * @param dbObject the MongoDB object being built
	 */
	protected void buildExtrensicID(EObject eObject, DBObject dbObject)
	{
		Resource resource = eObject.eResource();

		if (resource instanceof XMLResource)
		{
			String id = ((XMLResource) resource).getID(eObject);

			if (id != null)
				dbObject.put(Keywords.EXTRINSIC_ID_KEY, id);
		}
	}

	/**
	 * Serializes a feature map from the attribute value. Feature maps
	 * of references are delegated to buildReferencedObject to build
	 * the referenced object.
	 * 
	 * @param dbObject the MongoDB object being built
	 * @param attribute the emf attribute being serialized
	 * @param value the feature map
	 */
	protected void buildFeatureMap(DBObject dbObject, EAttribute attribute, Object value)
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
			{
				EDataType eDataType = ((EAttribute) feature).getEAttributeType();

				if (!MongoUtils.isNativeType(eDataType))
					dbEntry.put("value", convertEMFValueToMongoDBValue(eDataType, entry.getValue()));
				else
					dbEntry.put("value", entry.getValue());
			}
			else
				dbEntry.put("value", buildReferencedObject((EReference) feature, (EObject) entry.getValue()));

			dbFeatureMap.add(dbEntry);
		}

		dbObject.put(attribute.getName(), dbFeatureMap);
	}

	/**
	 * Serializes a reference value from the EMF object. References with cardinality greater
	 * than one are stored as a java.util.ArrayList. Reference values are mapped in the
	 * DBObject using the reference name as the key. Building of the referenced object is
	 * delegated to buildReferencedObject().
	 * 
	 * @param eObject the EMF object to serialize
	 * @param dbObject the MongoDB object being built
	 * @param reference
	 */
	protected void buildReference(EObject eObject, DBObject dbObject, EReference reference)
	{
		Object value = eObject.eGet(reference, false);

		if (reference.isMany())
		{
			// One to many reference

			@SuppressWarnings("unchecked")
			List<EObject> targetObjects = ((InternalEList<EObject>) value).basicList();
			ArrayList<Object> dbReferences = new ArrayList<Object>(targetObjects.size());

			for (EObject targetObject : targetObjects)
				dbReferences.add(buildReferencedObject(reference, targetObject));

			value = dbReferences;
		}
		else if (value != null)
		{
			// One to one reference

			EObject targetObject = (EObject) value;
			value = buildReferencedObject(reference, targetObject);
		}

		dbObject.put(reference.getName(), value);
	}

	/**
	 * Serializes a reference as an embedded object or a proxy as appropriate
	 * 
	 * @param eReference the reference to serialize
	 * @param targetObject to referenced object
	 * @return the serialized object / proxy
	 */
	protected DBObject buildReferencedObject(EReference eReference, EObject targetObject)
	{
		InternalEObject internalEObject = (InternalEObject) targetObject;
		URI eProxyURI = internalEObject.eProxyURI();

		if (eProxyURI != null)
		{
			BasicDBObject dbObject = new BasicDBObject(2);
			dbObject.put(Keywords.PROXY_KEY, uriHandler.deresolve(eProxyURI).toString());
			dbObject.put(Keywords.ECLASS_KEY, EcoreUtil.getURI(targetObject.eClass()).toString());
			return dbObject;
		}
		else if (!eReference.isContainment() || (eReference.isResolveProxies() && internalEObject.eDirectResource() != null))
		{
			// Cross-document containment, or non-containment reference - build a proxy

			BasicDBObject dbObject = new BasicDBObject(2);
			dbObject.put(Keywords.PROXY_KEY, uriHandler.deresolve(EcoreUtil.getURI(targetObject)).toString());
			dbObject.put(Keywords.ECLASS_KEY, EcoreUtil.getURI(targetObject.eClass()).toString());
			return dbObject;
		}
		else
		{
			// Non cross-document containment reference - build a MongoDB embedded object

			return buildDBObject(targetObject);
		}
	}

	/**
	 * Converts the EMF value into a MongoDB value using the converter service
	 * 
	 * @param eDataType the value type
	 * @param emfValue the value
	 * @return the converted value
	 */
	protected Object convertEMFValueToMongoDBValue(EDataType eDataType, Object emfValue)
	{
		return converterService.getConverter(eDataType).convertEMFValueToMongoDBValue(eDataType, emfValue);
	}

	private ConverterService converterService;
	private XMLResource.URIHandler uriHandler;
	private boolean serializeDefaultAttributeValues;
}
