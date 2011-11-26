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
import java.util.List;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.MongoURI;
import com.mongodb.ServerAddress;

/**
 * This interface provides the API for accessing a MongoDB database. It is intended to be accessed
 * as a service in an OSGi environment. The OSGi bundle containing this interface provides and
 * registers an OSGi service implementation.
 * 
 * It is intended that one of the configureMongo() functions are called prior to calling getMongo(),
 * but is not necessary. If getMongo() is called without calling configureMongo(), a new Mongo
 * instance will be created using the supplied URI.
 * 
 * Mongo instances are cached by the service implementation. Calling configureMongo() with
 * an existing URI will create a new cached instance of Mongo.
 * 
 * @author bhunt
 * 
 */
public interface IMongoDB
{
	/**
	 * Configure a Mongo for accessing a MongoDB replica set
	 * 
	 * @param uri the base URI of the MongoDB - used when calling getMongo()
	 * @param replicaSetSeeds MongoDB replica set server list
	 * @throws MongoException is there is an internal error constructing the Mongo instance
	 */
	void configureMongo(MongoURI uri, List<ServerAddress> replicaSetSeeds) throws MongoException;

	/**
	 * Configure a Mongo for accessing a MongoDB replica set
	 * 
	 * @param uri the base URI of the MongoDB - used when calling getMongo()
	 * @param replicaSetSeeds MongoDB replica set server list
	 * @param options the default query options
	 * @throws MongoException is there is an internal error constructing the Mongo instance
	 */
	void configureMongo(MongoURI uri, List<ServerAddress> replicaSetSeeds, MongoOptions options) throws MongoException;

	/**
	 * Configure a Mongo for accessing a MongoDB
	 * 
	 * @param uri the base URI of the MongoDB - used when calling getMongo()
	 * @param addr the database server address
	 * @throws MongoException is there is an internal error constructing the Mongo instance
	 */
	void configureMongo(MongoURI uri, ServerAddress addr) throws MongoException;

	/**
	 * Configure a Mongo for accessing a MongoDB
	 * 
	 * @param uri the base URI of the MongoDB - used when calling getMongo()
	 * @param addr the database server address
	 * @param options the default query options
	 * @throws MongoException is there is an internal error constructing the Mongo instance
	 */
	void configureMongo(MongoURI uri, ServerAddress addr, MongoOptions options) throws MongoException;

	/**
	 * Configure a Mongo for accessing a MongoDB
	 * 
	 * @param uri the base URI of the MongoDB - used when calling getMongo()
	 * @param host the database server hostname
	 * @throws MongoException is there is an internal error constructing the Mongo instance
	 * @throws UnknownHostException if the hostname is unknown
	 */
	void configureMongo(MongoURI uri, String host) throws UnknownHostException, MongoException;

	/**
	 * Configure a Mongo for accessing a MongoDB
	 * 
	 * @param uri the base URI of the MongoDB - used when calling getMongo()
	 * @param host the database server hostname
	 * @param port the database port number
	 * @throws MongoException is there is an internal error constructing the Mongo instance
	 * @throws UnknownHostException if the hostname is unknown
	 */
	void configureMongo(MongoURI uri, String host, int port) throws UnknownHostException, MongoException;

	/**
	 * Configure a Mongo for accessing a MongoDB
	 * 
	 * @param uri the base URI of the MongoDB - used when calling getMongo()
	 * @param host the database server hostname
	 * @param options the default query options
	 * @throws MongoException is there is an internal error constructing the Mongo instance
	 * @throws UnknownHostException if the hostname is unknown
	 */
	void configureMongo(MongoURI uri, String host, MongoOptions options) throws UnknownHostException, MongoException;

	/**
	 * This function returns a Mongo instance for accessing MongoDB.
	 * 
	 * @param uri the base URI of the MongoDB
	 * @return the Mongo instance for accessing the database
	 * @throws MongoException if there is an internal error constructing the Mongo instance
	 * @throws UnknownHostException if the host of the URI is unknown
	 */
	Mongo getMongo(MongoURI uri) throws MongoException, UnknownHostException;
}
