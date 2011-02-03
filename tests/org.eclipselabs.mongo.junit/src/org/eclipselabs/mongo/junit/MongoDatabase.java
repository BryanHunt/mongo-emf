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
import org.junit.rules.ExternalResource;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

public class MongoDatabase extends ExternalResource
{
	public MongoDatabase(BundleContext context, String database)
	{
		this.database = database;
		mongoServiceTracker = new ServiceTracker<IMongoDB, IMongoDB>(context, IMongoDB.class, null);
		mongoServiceTracker.open();
	}

	@Override
	protected void before() throws Throwable
	{
		super.before();
		mongoService = mongoServiceTracker.waitForService(1000);
		assertThat(mongoService, is(notNullValue()));
	}

	@Override
	protected void after()
	{
		if (mongoService != null)
		{
			try
			{
				Mongo mongo = mongoService.getMongo(new MongoURI("mongodb://localhost"));
				DB db = mongo.getDB(database);

				for (String collectionName : db.getCollectionNames())
				{
					if (!"system.indexes".equals(collectionName))
						db.getCollection(collectionName).drop();
				}
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.after();
	}

	private String database;
	private ServiceTracker<IMongoDB, IMongoDB> mongoServiceTracker;
	private IMongoDB mongoService;
}
