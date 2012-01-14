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

import java.io.IOException;
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
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class DBObjectBuilder
{
	/**
	 * @param converterService
	 * @param options
	 * @param resource
	 * @param serializeDefault
	 */
	public DBObjectBuilder(IConverterService converterService, XMLResource.URIHandler uriHandler, boolean serializeDefault)
	{
		this.converterService = converterService;
		this.uriHandler = uriHandler;
		this.serializeDefault = serializeDefault;
	}

	public DBObject buildDBObject(DB db, EObject eObject) throws IOException
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
							dbEntry.put("value", buildDBReference(db, (EReference) feature, (EObject) entry.getValue()));

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
						ArrayList<Object> values = new ArrayList<Object>(rawValues.size());

						for (Object rawValue : rawValues)
							values.add(converterService.convertEMFValueToMongoDBValue(eDataType, rawValue));

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
						dbReferences.add(buildDBReference(db, reference, targetObject));

					value = dbReferences;
				}
				else if (value != null)
				{
					// One to one reference

					EObject targetObject = (EObject) value;

					value = buildDBReference(db, reference, targetObject);
				}

				dbObject.put(reference.getName(), value);
			}
		}

		return dbObject;
	}

	protected Object buildDBReference(DB db, EReference eReference, EObject targetObject) throws IOException
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

			return buildDBObject(db, targetObject);
		}
	}

	protected Object getDBAttributeValue(EAttribute attribute, Object rawValue)
	{
		EDataType eDataType = attribute.getEAttributeType();

		if (!MongoDBURIHandlerImpl.isNativeType(eDataType))
			return converterService.convertEMFValueToMongoDBValue(eDataType, rawValue);

		return rawValue;
	}

	private IConverterService converterService;
	private XMLResource.URIHandler uriHandler;
	private boolean serializeDefault;
}
