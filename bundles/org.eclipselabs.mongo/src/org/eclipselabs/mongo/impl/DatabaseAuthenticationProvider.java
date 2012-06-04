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

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mongo.IDatabaseAuthenticationProvider;

/**
 * @author bhunt
 * 
 */
public class DatabaseAuthenticationProvider implements IDatabaseAuthenticationProvider
{
	public DatabaseAuthenticationProvider()
	{}

	public DatabaseAuthenticationProvider(String uri, String user, String password)
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(IDatabaseAuthenticationProvider.PROP_URI, uri);
		properties.put(IDatabaseAuthenticationProvider.PROP_USER, user);
		properties.put(IDatabaseAuthenticationProvider.PROP_PASSWORD, password);
		configure(properties);
	}

	@Override
	public String getURI()
	{
		return uri;
	}

	@Override
	public String getUser()
	{
		return user;
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	public void configure(Map<String, Object> properties)
	{
		uri = (String) properties.get(IDatabaseAuthenticationProvider.PROP_URI);
		user = (String) properties.get(IDatabaseAuthenticationProvider.PROP_USER);
		password = (String) properties.get(IDatabaseAuthenticationProvider.PROP_PASSWORD);

		if (uri == null)
			throw new IllegalStateException("The MongoDB uri was not found in the configuration properties");

		if (user == null)
			throw new IllegalStateException("The MongoDB user was not found in the configuration properties");

		if (password == null)
			throw new IllegalStateException("The MongoDB password was not found in the configuration properties");

		// The URI will be of the form: mongodb://host[:port]/db/collection/[id]
		// When the string is split on / the db will be the part at index 3

		if (uri.split("/").length < 4)
			throw new IllegalStateException("Could not determine database name from uri: '" + uri + "'");
	}

	private String uri;
	private String user;
	private String password;
}
