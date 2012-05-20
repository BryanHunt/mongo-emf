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
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.emf.ext.IResourceSetConfigurator;
import org.eclipselabs.mongo.emf.ext.IResourceSetFactory;

/**
 * This implementation of the IResourceSetFactory applies all currently
 * bound IResourceSetConfigurator services to the resource set after
 * construction.
 * 
 * @author bhunt
 * 
 */
public class MongoResourceSetFactory implements IResourceSetFactory
{
	@Override
	public ResourceSet createResourceSet()
	{
		MongoResourceSetImpl resourceSet = new MongoResourceSetImpl();
		lock.readLock().lock();

		try
		{
			for (IResourceSetConfigurator configurator : configurators)
				configurator.configureResourceSet(resourceSet);
		}
		finally
		{
			lock.readLock().unlock();
		}

		return resourceSet;
	}

	public void bindResourceSetConfigurator(IResourceSetConfigurator resourceSetConfigurator)
	{
		lock.writeLock().lock();

		try
		{
			configurators.add(resourceSetConfigurator);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	public void unbindResourceSetConfigurator(IResourceSetConfigurator resourceSetConfigurator)
	{
		lock.writeLock().lock();

		try
		{
			configurators.remove(resourceSetConfigurator);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}

	private Set<IResourceSetConfigurator> configurators = new HashSet<IResourceSetConfigurator>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
}
