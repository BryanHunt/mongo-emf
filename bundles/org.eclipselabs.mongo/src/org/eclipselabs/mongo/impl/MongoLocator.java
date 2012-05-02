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

import com.mongodb.Mongo;

/**
 * @author bhunt
 * 
 */
public class MongoLocator implements IMongoLocator
{
	@Override
	public synchronized Mongo getMongo(String uri)
	{
		IMongoProvider provider = mongoProviders.get(uri);

		if (provider == null)
		{
			for (Entry<String, IMongoProvider> entry : mongoProviders.entrySet())
			{
				if (uri.startsWith(entry.getKey()))
				{
					provider = entry.getValue();
					break;
				}
			}
		}

		return provider != null ? provider.getMongo() : null;
	}

	public synchronized void bindMongoProvider(IMongoProvider mongoProvider, Map<String, Object> properties)
	{
		Object uriProperty = properties.get(IMongoProvider.PROP_URI);

		if (uriProperty instanceof String)
		{
			mongoProviders.put((String) uriProperty, mongoProvider);
		}
		else
		{
			for (String uri : (String[]) uriProperty)
				mongoProviders.put(uri, mongoProvider);
		}
	}

	public synchronized void unbindMongoProvider(IMongoProvider mongoProvider, Map<String, Object> properties)
	{
		Object uriProperty = properties.get(IMongoProvider.PROP_URI);

		if (uriProperty instanceof String)
		{
			mongoProviders.remove((String) uriProperty);
		}
		else
		{
			for (String uri : (String[]) uriProperty)
				mongoProviders.remove(uri);
		}
	}

	private HashMap<String, IMongoProvider> mongoProviders = new HashMap<String, IMongoProvider>();
}
