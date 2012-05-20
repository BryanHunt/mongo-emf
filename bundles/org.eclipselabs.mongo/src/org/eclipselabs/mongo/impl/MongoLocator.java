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

package org.eclipselabs.mongo.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipselabs.mongo.IMongoLocator;
import org.eclipselabs.mongo.IMongoProvider;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * @author bhunt
 * 
 */
public class MongoLocator implements IMongoLocator
{
	@Override
	public DB getDatabase(String uri)
	{
		IMongoProvider mongoProvider = getMongoProvider(uri);

		if (mongoProvider == null)
			return null;

		// The URI will be of the form: mongodb://host[:port]/db/collection/[id]
		// When the string is split on / the db will be the part at index 3

		String[] parts = uri.split("/");

		if (parts.length < 4)
			return null;

		DB db = mongoProvider.getMongo().getDB(parts[3]);
		String user = mongoProvider.getUser();

		if (user != null)
			db.authenticate(user, mongoProvider.getPassword().toCharArray());

		return db;
	}

	@Override
	public Mongo getMongo(String uri)
	{
		IMongoProvider provider = getMongoProvider(uri);
		return provider != null ? provider.getMongo() : null;
	}

	public synchronized void bindMongoProvider(IMongoProvider mongoProvider, Map<String, Object> properties)
	{
		String uri = (String) properties.get(IMongoProvider.PROP_URI);

		// The URI can be a CSV when connecting to a replica set.  In that case, we
		// register the provider using the first URI in the list

		String[] uris = uri.split(",");
		uri = uris[0].trim();

		mongoProvidersByURI.put(uri, mongoProvider);
	}

	public synchronized void unbindMongoProvider(IMongoProvider mongoProvider, Map<String, Object> properties)
	{
		String uri = (String) properties.get(IMongoProvider.PROP_URI);

		// The URI can be a CSV when connecting to a replica set.  In that case, the
		// provider was registered using the first URI in the list, so we must use
		// that first URI to unregister the provider.

		String[] uris = uri.split(",");
		uri = uris[0].trim();

		mongoProvidersByURI.remove(uri);
	}

	private synchronized IMongoProvider getMongoProvider(String uri)
	{
		IMongoProvider provider = mongoProvidersByURI.get(uri);

		if (provider != null)
			return provider;

		// Since the provider was not found, the client probably passed in a URI
		// that contains segments in the path.  In this case, we have to compare
		// each registered URI for a substring match.

		for (Entry<String, IMongoProvider> entry : mongoProvidersByURI.entrySet())
		{
			if (uri.startsWith(entry.getKey()))
				return entry.getValue();
		}

		return null;
	}

	private HashMap<String, IMongoProvider> mongoProvidersByURI = new HashMap<String, IMongoProvider>();
}
