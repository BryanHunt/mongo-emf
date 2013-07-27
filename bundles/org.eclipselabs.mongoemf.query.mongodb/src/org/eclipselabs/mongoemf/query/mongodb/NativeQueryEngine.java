/*******************************************************************************
 * Copyright (c) 2013 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongoemf.query.mongodb;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.mongoemf.QueryEngine;
import org.eclipselabs.mongoemf.model.ModelFactory;
import org.eclipselabs.mongoemf.model.MongoQuery;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * @author bhunt
 * 
 */
public class NativeQueryEngine implements QueryEngine
{
	@Override
	public MongoQuery buildDBObjectQuery(URI uri)
	{
		DBObject query = (DBObject) JSON.parse(URI.decode(uri.query()));

		MongoQuery mongoQuery = ModelFactory.eINSTANCE.createMongoQuery();
		mongoQuery.setFilter((DBObject) query.get("filter"));
		mongoQuery.setProjection((DBObject) query.get("projection"));
		mongoQuery.setSort((DBObject) query.get("sort"));
		mongoQuery.setLimit((Integer) query.get("limit"));

		return mongoQuery;
	}
}
