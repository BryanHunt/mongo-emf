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

package org.eclipselabs.mongo;

import java.net.UnknownHostException;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

/**
 * This interface provides the API for accessing a MongoDB database. It is intended to be accessed
 * as a service in an OSGi environment. The OSGi bundle containing this interface provides and
 * registers an OSGi service implementation.
 * 
 * @author bhunt
 * 
 */
public interface IMongoDB
{
	/**
	 * 
	 * @param uri the base URI of the MongoDB
	 * @return the Mongo instance for accessing the database
	 * @throws MongoException if there is an internal error
	 * @throws UnknownHostException if the host of the URI is unknown
	 */
	Mongo getMongo(MongoURI uri) throws MongoException, UnknownHostException;
}
