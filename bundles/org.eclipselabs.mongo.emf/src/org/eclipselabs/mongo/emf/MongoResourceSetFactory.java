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

package org.eclipselabs.mongo.emf;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.mongo.IMongoLocator;

/**
 * @author bhunt
 * 
 */
public class MongoResourceSetFactory implements IResourceSetFactory
{
	@Override
	public ResourceSet createResourceSet()
	{
		MongoResourceSetImpl resourceSet = new MongoResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoURIHandlerImpl(mongoLocator, queryEngine));
		return resourceSet;
	}

	public void bindMongoLocator(IMongoLocator mongoLocator)
	{
		this.mongoLocator = mongoLocator;
	}

	public void bindQueryEngine(IQueryEngine queryEngine)
	{
		this.queryEngine = queryEngine;
	}

	private IMongoLocator mongoLocator;
	private IQueryEngine queryEngine;
}
