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

package org.eclipselabs.mongo.emf.impl;

import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.emf.ext.UriHandlerProvider;
import org.eclipselabs.emongo.DatabaseLocator;
import org.eclipselabs.mongo.emf.IInputStreamFactory;
import org.eclipselabs.mongo.emf.IOutputStreamFactory;
import org.eclipselabs.mongo.emf.MongoURIHandlerImpl;

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

	public void bindInputStreamFactory(IInputStreamFactory inputStreamFactory)
	{
		this.inputStreamFactory = inputStreamFactory;
	}

	public void bindOutputStreamFactory(IOutputStreamFactory outputStreamFactory)
	{
		this.outputStreamFactory = outputStreamFactory;
	}

	private MongoURIHandlerImpl uriHandler;
	private DatabaseLocator databseLocator;
	private IInputStreamFactory inputStreamFactory;
	private IOutputStreamFactory outputStreamFactory;
}
