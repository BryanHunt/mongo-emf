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

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 * @author bhunt
 * 
 */
public class MongoId
{
	private long nextId = 1;
	private IDatabaseLocator databaseLocator;

	public void activate(Map<String, Object> parameters)
	{
		String uri = (String) parameters.get("uri"); // TODO make constant
		String collectionName = (String) parameters.get("collection");

		DB db = databaseLocator.getDatabase(uri);
		DBCollection collection = db.getCollection(collectionName);
		DBCursor cursor = collection.find().sort(new BasicDBObject("_id", -1)).limit(1);

		if (cursor.hasNext())
			nextId = ((Long) cursor.next().get("_id")) + 1;
	}

	public void bindDatabaseLocator(IDatabaseLocator databaseLocator)
	{
		this.databaseLocator = databaseLocator;
	}

	public synchronized long getNextId()
	{
		return nextId++;
	}
}
