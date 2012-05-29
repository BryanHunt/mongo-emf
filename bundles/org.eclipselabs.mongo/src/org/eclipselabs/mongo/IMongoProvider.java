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

import com.mongodb.Mongo;

/**
 * This OSGi service provides access to a configured MongoDB driver. The MongoDB driver
 * is initialized using the configured service properties.
 * 
 * @author bhunt
 * 
 */
public interface IMongoProvider
{
	//--- MongoOptions properties ---------------------------------------------------------

	public String PROP_DESCRIPTION = "description";
	public String PROP_CONNECTIONS_PER_HOST = "connectionsPerHost";
	public String PROP_THREADS_ALLOWED_TO_BLOCK_FOR_CONNECTION_MULTIPLIER = "threadsAllowedToBlockForConnectionMultiplier";
	public String PROP_MAX_WAIT_TIME = "maxWaitTime";
	public String PROP_CONNECT_TIMEOUT = "connectTimeout";
	public String PROP_SOCKET_TIMEOUT = "socketTimeout";
	public String PROP_SOCKET_KEEP_ALIVE = "socketKeepAlive";
	public String PROP_AUTO_CONNECT_RETRY = "autoConnectRetry";
	public String PROP_MAX_AUTO_CONNECT_RETRY_TIME = "maxAutoConnectRetryTime";
	public String PROP_SAFE = "safe";
	public String PROP_W = "w";
	public String PROP_WTIMEOUT = "wtimeout";
	public String PROP_FSYNC = "fsync";
	public String PROP_J = "j";

	//--- Provider service specific properties ---------------------------------------------

	public String PROP_URI = "uri";

	//--------------------------------------------------------------------------------------

	/**
	 * 
	 * @return the MongoDB driver configured by the service properties
	 */
	Mongo getMongo();

	String getURI();
}
