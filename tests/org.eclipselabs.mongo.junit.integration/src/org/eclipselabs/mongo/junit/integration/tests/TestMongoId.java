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

package org.eclipselabs.mongo.junit.integration.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.eclipselabs.mongo.IMongoId;
import org.eclipselabs.mongo.emf.developer.junit.MongoDatabase;
import org.eclipselabs.mongo.emf.developer.junit.ServiceTestHarness;
import org.junit.Rule;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class TestMongoId extends ServiceTestHarness
{
	@Rule
	public MongoDatabase database = new MongoDatabase();

	private static IMongoId mongoId;

	@Test
	public void testGetNextId()
	{
		assertThat(mongoId.getNextId(), is("1"));
		DBCollection collection = database.getMongoDB().getCollection("junit_id");
		DBObject result = collection.findOne(new BasicDBObject("_id", Long.valueOf(0)));
		assertThat((Long) result.get("lastId"), is(1L));
	}

	void bindMongoId(IMongoId service)
	{
		mongoId = service;
	}
}
