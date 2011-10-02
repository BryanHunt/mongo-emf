/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.junit.bundle.Activator;
import org.junit.rules.ExternalResource;
import org.osgi.util.tracker.ServiceTracker;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

/**
 * This class is intended to be used as a JUnit @Rule. It will verify that
 * the IMongoDB service exists, and it will delete all collections in the specified
 * MongoDB after each test runs.
 * 
 * Example usage:
 * 
 * @Rule
 *       public MongoDatabase database = new MongoDatabase("junit");
 * 
 * @author bhunt
 * 
 */
public class MongoDatabase extends ExternalResource
{
	public MongoDatabase(String database)
	{
		this("localhost", database);
	}

	public MongoDatabase(String hostname, String database)
	{
		this.hostname = hostname;
		this.database = database;
		mongoServiceTracker = new ServiceTracker<IMongoDB, IMongoDB>(Activator.getBundleContext(), IMongoDB.class, null);
		mongoServiceTracker.open();
	}

	public DB getMongoDB()
	{
		return db;
	}

	public IMongoDB getMongoDBService()
	{
		return mongoService;
	}

	@Override
	protected void before() throws Throwable
	{
		super.before();
		mongoService = mongoServiceTracker.waitForService(1000);
		assertThat(mongoService, is(notNullValue()));
		Mongo mongo = mongoService.getMongo(new MongoURI("mongodb://" + hostname));
		db = mongo.getDB(database);
	}

	@Override
	protected void after()
	{
		if (mongoService != null)
		{
			try
			{

				for (String collectionName : db.getCollectionNames())
				{
					if (!"system.indexes".equals(collectionName))
						db.getCollection(collectionName).drop();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		super.after();
	}

	private String hostname;
	private String database;
	private ServiceTracker<IMongoDB, IMongoDB> mongoServiceTracker;
	private IMongoDB mongoService;
	private DB db;
}
