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

package org.eclipselabs.mongo.emf;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.query.QueryFactory;
import org.eclipselabs.emf.query.Result;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class MongoInputStream extends InputStream implements URIConverter.Loadable
{
	public MongoInputStream(IConverterService converterService, IEObjectBuilderFactory builderFactory, IQueryEngine queryEngine, DBCollection collection, URI uri, Map<?, ?> options, Map<Object, Object> response) throws IOException
	{
		if (converterService == null)
			throw new NullPointerException("The converter service must not be null");

		if (collection == null)
			throw new NullPointerException("The database collection must not be null");

		this.converterService = converterService;
		this.builderFactory = builderFactory;
		this.queryEngine = queryEngine;
		this.collection = collection;
		this.uri = uri;
		this.options = options;
		this.response = response;
	}

	@Override
	public void loadResource(Resource resource) throws IOException
	{
		// We need to set up the XMLResource.URIHandler so that proxy URIs are handled properly.

		XMLResource.URIHandler uriHandler = (XMLResource.URIHandler) options.get(XMLResource.OPTION_URI_HANDLER);

		if (uriHandler == null)
			uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

		if (resource.getURI().hasQuery())
			uriHandler.setBaseURI(resource.getURI().trimSegments(1).appendSegment("-1"));
		else
			uriHandler.setBaseURI(resource.getURI());

		boolean includeAttributesForProxyReferences = Boolean.TRUE.equals(options.get(MongoURIHandlerImpl.OPTION_PROXY_ATTRIBUTES));
		EObjectBuilder builder = builderFactory.createObjectBuilder(converterService, uriHandler, includeAttributesForProxyReferences, eClassCache);

		// If the URI contains a query string, use it to locate a collection of objects from
		// MongoDB, otherwise simply get the object from MongoDB using the id.

		EList<EObject> contents = resource.getContents();

		if (uri.query() != null)
		{
			if (queryEngine == null)
				throw new IOException("The query engine was not found");

			Result result = QueryFactory.eINSTANCE.createResult();
			InternalEList<EObject> values = (InternalEList<EObject>) result.getValues();

			for (DBObject dbObject : collection.find(queryEngine.buildDBObjectQuery(uri)))
				values.addUnique(builder.buildEObject(collection, dbObject, resource, true));

			contents.add(result);
		}
		else
		{
			DBObject dbObject = collection.findOne(new BasicDBObject(MongoURIHandlerImpl.ID_KEY, MongoURIHandlerImpl.getID(uri)));

			if (dbObject != null)
			{
				EObject eObject = builder.buildEObject(collection, dbObject, resource, false);

				if (eObject != null)
					contents.add(eObject);

				response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, dbObject.get(MongoURIHandlerImpl.TIME_STAMP_KEY));
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

	private URI uri;
	private Map<?, ?> options;
	private Map<Object, Object> response;
	private IConverterService converterService;
	private IQueryEngine queryEngine;
	private DBCollection collection;
	private HashMap<String, EClass> eClassCache = new HashMap<String, EClass>();
	private IEObjectBuilderFactory builderFactory;
}
