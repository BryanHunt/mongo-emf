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

package org.eclipselabs.mongo.emf.ext.impl;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.mongo.emf.ext.IResourceSetConfigurator;
import org.eclipselabs.mongo.emf.ext.IUriHandlerProvider;

/**
 * This implementation of the IResourceSetConfigurator service will attach
 * all currently bound URI handlers to the ResourceSet. This service is
 * intended to be used with the IResourceSetFactory service.
 * 
 * @author bhunt
 * 
 */
public class ResourceSetUriHandlerConfigurator implements IResourceSetConfigurator
{
	@Override
	public void configureResourceSet(ResourceSet resourceSet)
	{
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		lock.readLock().lock();

		try
		{
			for (IUriHandlerProvider provider : providers)
				uriHandlers.add(0, provider.getURIHandler());
		}
		finally
		{
			lock.readLock().unlock();
		}
	}

	public void bindUriHandlerProvider(IUriHandlerProvider handlerProvider)
	{
		lock.writeLock().lock();

		try
		{
			providers.add(handlerProvider);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	public void unbindUriHandlerProvider(IUriHandlerProvider handlerProvider)
	{
		lock.writeLock().lock();

		try
		{
			providers.remove(handlerProvider);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	private HashSet<IUriHandlerProvider> providers = new HashSet<IUriHandlerProvider>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
}
