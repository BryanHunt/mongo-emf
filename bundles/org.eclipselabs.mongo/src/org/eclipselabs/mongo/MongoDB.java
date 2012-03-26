/*******************************************************************************
 * Copyright (c) 2010 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.MongoURI;
import com.mongodb.ServerAddress;

/**
 * @author bhunt
 * 
 */
public class MongoDB implements IMongoDB
{
	@Override
	public synchronized void configureMongo(MongoURI uri, List<ServerAddress> replicaSetSeeds)
	{
		mongos.put(uri.toString(), new Mongo(replicaSetSeeds));
	}

	@Override
	public synchronized void configureMongo(MongoURI uri, List<ServerAddress> replicaSetSeeds, MongoOptions options)
	{
		mongos.put(uri.toString(), new Mongo(replicaSetSeeds, options));
	}

	@Override
	public synchronized void configureMongo(MongoURI uri, ServerAddress addr)
	{
		mongos.put(uri.toString(), new Mongo(addr));
	}

	@Override
	public synchronized void configureMongo(MongoURI uri, ServerAddress addr, MongoOptions options)
	{
		mongos.put(uri.toString(), new Mongo(addr, options));
	}

	@Override
	public synchronized void configureMongo(MongoURI uri, String host) throws UnknownHostException, MongoException
	{
		mongos.put(uri.toString(), new Mongo(host));
	}

	@Override
	public synchronized void configureMongo(MongoURI uri, String host, int port) throws UnknownHostException, MongoException
	{
		mongos.put(uri.toString(), new Mongo(host, port));
	}

	@Override
	public synchronized void configureMongo(MongoURI uri, String host, MongoOptions options) throws UnknownHostException, MongoException
	{
		mongos.put(uri.toString(), new Mongo(host, options));
	}

	@Override
	public synchronized Mongo getMongo(MongoURI uri) throws MongoException, UnknownHostException
	{
		Mongo mongo = mongos.get(uri.toString());

		if (mongo == null)
		{
			mongo = new Mongo(uri);
			mongos.put(uri.toString(), mongo);
		}

		return mongo;
	}

	private final Map<String, Mongo> mongos = new HashMap<String, Mongo>();
}
