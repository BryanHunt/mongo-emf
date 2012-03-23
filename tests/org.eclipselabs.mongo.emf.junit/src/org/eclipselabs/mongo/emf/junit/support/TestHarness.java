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

package org.eclipselabs.mongo.emf.junit.support;

import org.eclipselabs.mongo.junit.MongoDatabase;
import org.junit.Rule;

import com.mongodb.DB;

/**
 * This class was introduced because the replica test needs to set up a replica set
 * instead of a single database.
 * 
 * @author bhunt
 */
public class TestHarness extends BaseTestHarness
{
	@Rule
	public MongoDatabase database = new MongoDatabase();

	@Override
	protected DB createDatabase()
	{
		return database.getMongoDB();
	}
}
