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

package org.eclipselabs.mongo;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * This OSGi service gives clients access to a configured Mongo instance lookup by URI.
 * The URI may be any extension of the MongoDB server URI. If your MongoDB server requires
 * authentication, you should use getDatabase() instead of getMongo().
 * 
 * @author bhunt
 */
public interface IMongoLocator
{
	/**
	 * Locate a DB instance using the provided URI. If the MongoDB server requires
	 * authentication, the instance of DB returned will have the user id and password
	 * set that was specified in the IMongoProvider configuration.
	 * 
	 * @param uri the full or base URI of the Mongo database instance
	 * @return the DB instance with authentication if necessary
	 */
	DB getDatabase(String uri);

	/**
	 * Locate a Mongo instance using the provided URI. The URI may be a full URI
	 * or a base URI. If the MongoDB server requires authentication, and you
	 * call mongo.getDB(), the DB instance returned will not be authenticated.
	 * In this case, you should call getDatabase(String uri) instead to get an
	 * authenticated instance of DB.
	 * 
	 * @param uri the full or base URI of the Mongo instance
	 * @return the Mongo instance if found; null otherwise
	 */
	Mongo getMongo(String uri);
}
