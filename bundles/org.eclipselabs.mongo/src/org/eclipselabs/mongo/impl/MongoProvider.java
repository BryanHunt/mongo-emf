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

import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mongo.IMongoProvider;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * @author bhunt
 * 
 */
public class MongoProvider implements IMongoProvider
{
	public MongoProvider()
	{}

	public MongoProvider(String uri) throws MongoException, UnknownHostException, URISyntaxException
	{
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put(IMongoProvider.PROP_URI, uri);
		configure(properties);
	}

	@Override
	public Mongo getMongo()
	{
		return mongo;
	}

	@Override
	public String getURI()
	{
		return uri;
	}

	public void configure(Map<String, Object> properties) throws MongoException, UnknownHostException, URISyntaxException
	{
		MongoOptions options = new MongoOptions();

		String description = (String) properties.get(PROP_DESCRIPTION);

		if (description != null)
			options.description = description;

		Integer connectionsPerHost = (Integer) properties.get(PROP_CONNECTIONS_PER_HOST);

		if (connectionsPerHost != null)
			options.connectionsPerHost = connectionsPerHost;

		Integer threadsAllowedToBlockForConnectionMultiplier = (Integer) properties.get(PROP_THREADS_ALLOWED_TO_BLOCK_FOR_CONNECTION_MULTIPLIER);

		if (threadsAllowedToBlockForConnectionMultiplier != null)
			options.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;

		Integer maxWaitTime = (Integer) properties.get(PROP_MAX_WAIT_TIME);

		if (maxWaitTime != null)
			options.maxWaitTime = maxWaitTime;

		Integer connectTimeout = (Integer) properties.get(PROP_CONNECT_TIMEOUT);

		if (connectTimeout != null)
			options.connectTimeout = connectTimeout;

		Integer socketTimeout = (Integer) properties.get(PROP_SOCKET_TIMEOUT);

		if (socketTimeout != null)
			options.socketTimeout = socketTimeout;

		Boolean socketKeepAlive = (Boolean) properties.get(PROP_SOCKET_KEEP_ALIVE);

		if (socketKeepAlive != null)
			options.socketKeepAlive = socketKeepAlive;

		Boolean autoConnectRetry = (Boolean) properties.get(PROP_AUTO_CONNECT_RETRY);

		if (autoConnectRetry != null)
			options.autoConnectRetry = autoConnectRetry;

		Long maxAutoConnectRetryTime = (Long) properties.get(PROP_MAX_AUTO_CONNECT_RETRY_TIME);

		if (maxAutoConnectRetryTime != null)
			options.maxAutoConnectRetryTime = maxAutoConnectRetryTime;

		Boolean safe = (Boolean) properties.get(PROP_SAFE);

		if (safe != null)
			options.safe = safe;

		Integer w = (Integer) properties.get(PROP_W);

		if (w != null)
			options.w = w;

		Integer wtimeout = (Integer) properties.get(PROP_WTIMEOUT);

		if (wtimeout != null)
			options.wtimeout = wtimeout;

		Boolean fsync = (Boolean) properties.get(PROP_FSYNC);

		if (fsync != null)
			options.fsync = fsync;

		Boolean j = (Boolean) properties.get(PROP_J);

		if (j != null)
			options.j = j;

		// The uriProperty is a single string containing one or more server URIs.
		// When more than one URI is specified, it denotes a replica set and the
		// URIs must be separated by a comma (CSV).

		String uriProperty = (String) properties.get(PROP_URI);

		if (uriProperty == null || uriProperty.isEmpty())
			throw new UnknownHostException("The MongoDB URI was not found in the configuration properties");

		String[] uris = uriProperty.split(",");
		uri = uris[0];

		if (uris.length == 1)
		{
			ServerAddress serverAddress = createServerAddress(uris[0].trim());
			mongo = createMongo(options, serverAddress);
		}
		else
		{
			ArrayList<ServerAddress> serverAddresses = new ArrayList<ServerAddress>(uris.length);

			for (String uri : uris)
				serverAddresses.add(createServerAddress(uri.trim()));

			mongo = createMongo(options, serverAddresses);
		}
	}

	protected Mongo createMongo(MongoOptions options, ArrayList<ServerAddress> serverAddresses)
	{
		return new Mongo(serverAddresses, options);
	}

	protected Mongo createMongo(MongoOptions options, ServerAddress serverAddress)
	{
		return new Mongo(serverAddress, options);
	}

	private ServerAddress createServerAddress(String uriProperty) throws URISyntaxException, UnknownHostException
	{
		URI uri = new URI(uriProperty);
		int port = uri.getPort();
		ServerAddress serverAddress = port == -1 ? new ServerAddress(uri.getHost()) : new ServerAddress(uri.getHost(), uri.getPort());
		return serverAddress;
	}

	private volatile String uri;
	private volatile Mongo mongo;
}
