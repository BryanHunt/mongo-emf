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

package org.eclipselabs.emf.mongodb.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.ext.ECollection;
import org.eclipselabs.emf.ext.ExtFactory;
import org.eclipselabs.emf.mongodb.ConverterService;
import org.eclipselabs.emf.mongodb.DBObjectBuilder;
import org.eclipselabs.emf.mongodb.DBObjectBuilderFactory;
import org.eclipselabs.emf.mongodb.Keywords;
import org.eclipselabs.emf.mongodb.MongoUtils;
import org.eclipselabs.emf.mongodb.Options;
import org.eclipselabs.emongo.MongoIdFactory;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;

/**
 * @author bhunt
 * 
 */
public class MongoOutputStream extends ByteArrayOutputStream implements URIConverter.Saveable
{
	public MongoOutputStream(ConverterService converterService, DBObjectBuilderFactory builderFactory, DBCollection collection, URI uri, Map<String, MongoIdFactory> idProviders, Map<?, ?> options, Map<Object, Object> response)
	{
		if (converterService == null)
			throw new NullPointerException("The converter service must not be null");

		if (collection == null)
			throw new NullPointerException("The database collection must not be null");

		this.converterService = converterService;
		this.collection = collection;
		this.uri = uri;
		this.idFactories = idProviders;
		this.options = options;
		this.response = response;
		this.builderFactory = builderFactory;
	}

	@Override
	public void close() throws IOException
	{
		super.close();

		// We need to set up the XMLResource.URIHandler so that proxy URIs are handled properly.

		XMLResource.URIHandler uriHandler = (XMLResource.URIHandler) options.get(XMLResource.OPTION_URI_HANDLER);

		if (uriHandler == null)
			uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

		Object id = MongoUtils.getID(uri);

		// If the id was not specified, look for an id generator

		if (id == null && idFactories != null)
		{
			MongoIdFactory mongoIdFactory = idFactories.get(uri.trimSegments(uri.segmentCount() - 2).toString());

			if (mongoIdFactory != null)
			{
				id = mongoIdFactory.getNextId();
				uri = uri.appendSegment(id.toString());
				resource.setURI(resource.getURI().trimSegments(1).appendSegment(id.toString()));
			}
		}

		// If the id was not specified, we append a dummy id to the resource URI so that all of the
		// relative proxies will be generated correctly.

		if (id == null)
			resource.setURI(resource.getURI().trimSegments(1).appendSegment("-1"));

		uriHandler.setBaseURI(resource.getURI());

		Boolean serializeOption = (Boolean) options.get(Options.OPTION_SERIALIZE_DEFAULT_ATTRIBUTE_VALUES);
		boolean serializeDefaultAttributeValues = false;

		if (serializeOption != null)
			serializeDefaultAttributeValues = serializeOption;

		builder = builderFactory.createBuilder(converterService, uriHandler, serializeDefaultAttributeValues);

		if (resource.getContents().size() > 1 || resource.getContents() instanceof ECollection)
			saveMultipleObjects();
		else
			saveSingleObject(id);
	}

	@Override
	public void saveResource(Resource resource)
	{
		this.resource = resource;
	}

	private void saveMultipleObjects() throws IOException
	{
		EList<EObject> contents = null;

		if (resource.getContents() instanceof ECollection)
			contents = ((ECollection) resource.getContents()).getValues();
		else
			contents = resource.getContents();

		ArrayList<DBObject> dbObjects = new ArrayList<DBObject>(contents.size());
		long timeStamp = System.currentTimeMillis();
		response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, timeStamp);

		Boolean useIdAttributeAsPrimaryKey = (Boolean) options.get(Options.OPTION_USE_ID_ATTRIBUTE_AS_PRIMARY_KEY);

		for (EObject eObject : contents)
		{
			DBObject dbObject = builder.buildDBObject(eObject);
			dbObject.put(Keywords.TIME_STAMP_KEY, timeStamp);

			if (useIdAttributeAsPrimaryKey != null && useIdAttributeAsPrimaryKey)
			{
				EAttribute idAttribute = eObject.eClass().getEIDAttribute();

				if (idAttribute != null)
					dbObject.put(Keywords.ID_KEY, eObject.eGet(idAttribute));
			}

			dbObjects.add(dbObject);
		}

		WriteConcern writeConcern = (WriteConcern) options.get(Options.OPTION_WRITE_CONCERN);

		if (writeConcern == null)
			collection.insert(dbObjects);
		else
			collection.insert(dbObjects, writeConcern);

		URI baseURI = resource.getURI().trimSegments(1);
		InternalEObject[] eObjects = contents.toArray(new InternalEObject[contents.size()]);
		ECollection eCollection = ExtFactory.eINSTANCE.createECollection();
		InternalEList<EObject> values = (InternalEList<EObject>) eCollection.getValues();

		for (int i = 0; i < dbObjects.size(); i++)
		{
			InternalEObject internalEObject = eObjects[i];
			internalEObject.eSetProxyURI(baseURI.appendSegment(dbObjects.get(i).get(Keywords.ID_KEY).toString()).appendFragment("/"));
			internalEObject.eAdapters().clear();
			values.addUnique(internalEObject);
		}

		contents.clear();
		contents.add(eCollection);
	}

	private void saveSingleObject(Object id) throws IOException
	{
		// Build a MongoDB object from the EMF object.

		EObject eObject = resource.getContents().get(0);
		DBObject dbObject = builder.buildDBObject(eObject);

		// The timestamp needs to be persisted with the object, and set in the response

		long timeStamp = System.currentTimeMillis();
		dbObject.put(Keywords.TIME_STAMP_KEY, timeStamp);
		response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, timeStamp);
		WriteConcern writeConcern = (WriteConcern) options.get(Options.OPTION_WRITE_CONCERN);

		if (id == null)
		{
			// The id was not specified in the URI, so we can let MongoDB generate the id or use the value
			// of the ID attribute

			Boolean useIdAttributeAsPrimaryKey = (Boolean) options.get(Options.OPTION_USE_ID_ATTRIBUTE_AS_PRIMARY_KEY);
			EAttribute idAttribute = eObject.eClass().getEIDAttribute();

			boolean idSpecifiedByClient = useIdAttributeAsPrimaryKey != null && useIdAttributeAsPrimaryKey && idAttribute != null;

			if (idSpecifiedByClient)
			{
				// Use the ID attribute value as the id
				id = eObject.eGet(idAttribute);
				dbObject.put(Keywords.ID_KEY, id);
			}

			if (writeConcern == null)
				collection.insert(dbObject);
			else
				collection.insert(dbObject, writeConcern);

			if (!idSpecifiedByClient)
			{
				// The id was not specified, so we are creating an object and letting MongoDB generate the
// id
				id = dbObject.get(Keywords.ID_KEY);
			}

			// Modify the EMF Resource URI to include the id generated by MongoDB or specified in the ID
// attribute
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

			dbObject.put(Keywords.ID_KEY, id);

			if (writeConcern == null)
				collection.save(dbObject);
			else
				collection.save(dbObject, writeConcern);
		}
	}

	private ConverterService converterService;
	private DBObjectBuilderFactory builderFactory;
	private DBCollection collection;
	private Map<?, ?> options;
	private Resource resource;
	private Map<Object, Object> response;
	private URI uri;
	private DBObjectBuilder builder;
	private Map<String, MongoIdFactory> idFactories;
}
