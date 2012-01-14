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
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.query.QueryFactory;
import org.eclipselabs.emf.query.Result;
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

		if (uriHandler == null)
			uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

		if (resource.getURI().hasQuery())
			uriHandler.setBaseURI(resource.getURI().trimSegments(1).appendSegment("-1"));
		else
			uriHandler.setBaseURI(resource.getURI());

		boolean proxyAttributes = Boolean.TRUE.equals(options.get(MongoDBURIHandlerImpl.OPTION_PROXY_ATTRIBUTES));
		EObjectBuilder builder = new EObjectBuilder(handler, uriHandler, proxyAttributes);

		// If the URI contains a query string, use it to locate a collection of objects from
		// MongoDB, otherwise simply get the object from MongoDB using the id.

		DBCollection collection = MongoDBURIHandlerImpl.getCollection(handler.getMongoDB(), uri, options);
		EList<EObject> contents = resource.getContents();

		if (uri.query() != null)
		{
			Result result = QueryFactory.eINSTANCE.createResult();
			InternalEList<EObject> values = (InternalEList<EObject>) result.getValues();

			for (DBObject dbObject : collection.find(handler.getQueryEngine().buildDBObjectQuery(uri)))
				values.addUnique(builder.buildEObject(collection, dbObject, resource, true));

			contents.add(result);
		}
		else
		{
			DBObject dbObject = collection.findOne(new BasicDBObject(MongoDBURIHandlerImpl.ID_KEY, MongoDBURIHandlerImpl.getID(uri)));

			if (dbObject != null)
			{
				EObject eObject = builder.buildEObject(collection, dbObject, resource, false);

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

	private URI uri;
	private Map<?, ?> options;
	private Map<Object, Object> response;
	private MongoDBURIHandlerImpl handler;
}
