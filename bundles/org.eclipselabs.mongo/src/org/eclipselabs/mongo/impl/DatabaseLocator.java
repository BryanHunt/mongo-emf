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

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.mongo.IDatabaseAuthenticationProvider;
import org.eclipselabs.mongo.IDatabaseLocator;
import org.eclipselabs.mongo.IMongoProvider;

import com.mongodb.DB;

/**
 * @author bhunt
 * 
 */
public class DatabaseLocator implements IDatabaseLocator
{
	@Override
	public DB getDatabase(String uri)
	{
		URI dbURI = URI.createURI(uri).trimFragment().trimQuery();

		if (dbURI.segmentCount() > 1)
			dbURI = dbURI.trimSegments(dbURI.segmentCount() - 1);

		synchronized (databasesByURI)
		{
			DB database = databasesByURI.get(dbURI.toString());

			if (database != null)
				return database;

			IMongoProvider mongoProvider = null;

			synchronized (mongoProvidersByURI)
			{
				mongoProvider = mongoProvidersByURI.get(dbURI.trimSegments(1).toString());
			}

			if (mongoProvider == null)
				return null;

			database = mongoProvider.getMongo().getDB(dbURI.segment(0));
			databasesByURI.put(dbURI.toString(), database);

			synchronized (databaseAuthenticationProvidersByURI)
			{
				IDatabaseAuthenticationProvider databaseAuthenticationProvider = databaseAuthenticationProvidersByURI.get(dbURI.toString());

				if (databaseAuthenticationProvider != null)
					database.authenticate(databaseAuthenticationProvider.getUser(), databaseAuthenticationProvider.getPassword().toCharArray());
			}

			return database;
		}
	}

	public void bindDatabaseAuthenticationProvider(IDatabaseAuthenticationProvider databaseAuthenticationProvider)
	{
		synchronized (databaseAuthenticationProvidersByURI)
		{
			databaseAuthenticationProvidersByURI.put(databaseAuthenticationProvider.getURI(), databaseAuthenticationProvider);
		}
	}

	public void unbindDatabaseAuthenticationProvider(IDatabaseAuthenticationProvider databaseAuthenticationProvider)
	{
		synchronized (databaseAuthenticationProvidersByURI)
		{
			databaseAuthenticationProvidersByURI.remove(databaseAuthenticationProvider.getURI());
		}
	}

	public void bindMongoProvider(IMongoProvider mongoProvider)
	{
		synchronized (mongoProvidersByURI)
		{
			for (String uri : mongoProvider.getURIs())
				mongoProvidersByURI.put(uri, mongoProvider);
		}
	}

	public void unbindMongoProvider(IMongoProvider mongoProvider)
	{
		synchronized (mongoProvidersByURI)
		{
			for (String uri : mongoProvider.getURIs())
				mongoProvidersByURI.remove(uri);
		}
	}

	private Map<String, IMongoProvider> mongoProvidersByURI = new HashMap<String, IMongoProvider>();
	private Map<String, IDatabaseAuthenticationProvider> databaseAuthenticationProvidersByURI = new HashMap<String, IDatabaseAuthenticationProvider>();
	private Map<String, DB> databasesByURI = new HashMap<String, DB>();
}
