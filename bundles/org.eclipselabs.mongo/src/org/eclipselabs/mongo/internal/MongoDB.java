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

package org.eclipselabs.mongo.internal;

import java.net.UnknownHostException;
import java.util.HashMap;

import org.eclipselabs.mongo.IMongoDB;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

/**
 * @author bhunt
 * 
 */
public class MongoDB implements IMongoDB
{
	@Override
	public Mongo getMongo(MongoURI uri) throws MongoException, UnknownHostException
	{
		Mongo mongo = mongos.get(uri.toString());

		if (mongo == null)
		{
			mongo = new Mongo(uri);
			mongos.put(uri.toString(), mongo);
		}

		return mongo;
	}

	private HashMap<String, Mongo> mongos = new HashMap<String, Mongo>();
}
