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

import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * @author bhunt
 * 
 */
public class MongoProviderTestHarness extends MongoProvider
{
	private MongoOptions options;
	private ServerAddress serverAddress;
	private List<ServerAddress> serverAddresses;

	public MongoProviderTestHarness(String uri) throws MongoException, UnknownHostException, URISyntaxException
	{
		super(uri);
	}

	public MongoOptions getOptions()
	{
		return options;
	}

	public ServerAddress getServerAddress()
	{
		return serverAddress;
	}

	public List<ServerAddress> getServerAddresses()
	{
		return serverAddresses;
	}

	@Override
	protected Mongo createMongo(MongoOptions options, ArrayList<ServerAddress> serverAddresses)
	{
		this.options = options;
		this.serverAddresses = serverAddresses;
		return null;
	}

	@Override
	protected Mongo createMongo(MongoOptions options, ServerAddress serverAddress)
	{
		this.options = options;
		this.serverAddress = serverAddress;
		return null;
	}
}
