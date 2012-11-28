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

package org.eclipselabs.emf.mongodb.handlers;

import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.emf.ext.UriHandlerProvider;
import org.eclipselabs.emf.mongodb.InputStreamFactory;
import org.eclipselabs.emf.mongodb.OutputStreamFactory;
import org.eclipselabs.emongo.DatabaseLocator;

/**
 * @author bhunt
 * 
 */
public class MongoURIHandlerProvider implements UriHandlerProvider
{
	@Override
	public synchronized URIHandler getURIHandler()
	{
		if (uriHandler == null)
			uriHandler = new MongoURIHandlerImpl(databseLocator, inputStreamFactory, outputStreamFactory);

		return uriHandler;
	}

	public void bindDatabaseLocator(DatabaseLocator mongoLocator)
	{
		this.databseLocator = mongoLocator;
	}

	public void bindInputStreamFactory(InputStreamFactory inputStreamFactory)
	{
		this.inputStreamFactory = inputStreamFactory;
	}

	public void bindOutputStreamFactory(OutputStreamFactory outputStreamFactory)
	{
		this.outputStreamFactory = outputStreamFactory;
	}

	private MongoURIHandlerImpl uriHandler;
	private DatabaseLocator databseLocator;
	private InputStreamFactory inputStreamFactory;
	private OutputStreamFactory outputStreamFactory;
}
