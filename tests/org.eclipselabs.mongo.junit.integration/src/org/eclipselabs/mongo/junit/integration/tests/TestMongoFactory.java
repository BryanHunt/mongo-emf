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

import org.eclipselabs.mongo.IMongoProvider;
import org.eclipselabs.mongo.emf.developer.junit.ServiceTestHarness;
import org.junit.Test;

import com.mongodb.Mongo;

/**
 * @author bhunt
 * 
 */
public class TestMongoFactory extends ServiceTestHarness
{
	@Test
	public void testCreateMongo()
	{
		Mongo mongo = mongoProvider.getMongo();
		assertThat(mongo.getAddress().getHost(), is("localhost"));
		assertThat(mongo.getAddress().getPort(), is(27017));
	}

	void bindMongoProvider(IMongoProvider service)
	{
		mongoProvider = service;
	}

	private static IMongoProvider mongoProvider;
}
