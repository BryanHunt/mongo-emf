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

import java.util.Map;

import org.eclipselabs.mongo.IDatabaseLocator;
import org.eclipselabs.mongo.IMongoId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class MongoId implements IMongoId
{
	private IDatabaseLocator databaseLocator;
	private DBCollection collection;
	private DBObject query;
	private DBObject update;
	private DB db;

	private static final String ID = "_id";
	private static final String LAST_ID = "lastId";

	public void configure(Map<String, Object> parameters)
	{
		String uri = (String) parameters.get(PROP_URI);
		String collectionName = uri.split("/")[4];

		db = databaseLocator.getDatabase(uri);

		if (db == null)
			throw new RuntimeException("Could not find database for URI: '" + uri + "'");

		collection = db.getCollection(collectionName);

		query = new BasicDBObject();
		query.put(ID, Long.valueOf(0));

		update = new BasicDBObject();
		update.put("$inc", new BasicDBObject(LAST_ID, Long.valueOf(1)));

		DBObject object = collection.findOne(query);

		if (object == null)
		{
			DBObject initialId = new BasicDBObject();
			initialId.put(ID, Long.valueOf(0));
			initialId.put(LAST_ID, Long.valueOf(0));
			collection.insert(initialId);

			if (!db.getLastError().ok())
				throw new RuntimeException("Could not initialize the id counter for collection: '" + collection.getName() + "'");
		}
	}

	public void bindDatabaseLocator(IDatabaseLocator databaseLocator)
	{
		this.databaseLocator = databaseLocator;
	}

	@Override
	public String getNextId()
	{
		DBObject result = collection.findAndModify(query, null, null, false, update, true, false);

		if (!db.getLastError().ok())
			throw new RuntimeException("Failed to update the id counter for collection: '" + collection.getName() + "'");

		return result.get(LAST_ID).toString();
	}
}
