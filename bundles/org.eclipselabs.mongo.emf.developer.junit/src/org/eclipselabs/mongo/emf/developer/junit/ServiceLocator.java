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

package org.eclipselabs.mongo.emf.developer.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.eclipselabs.mongo.emf.developer.junit.bundle.Activator;
import org.junit.rules.ExternalResource;
import org.osgi.util.tracker.ServiceTracker;

/**
 * This class is intended to be used as a JUnit @Rule. It will create a
 * service tracker for the specified service and wait for the service
 * up to the specified timeout.
 * 
 * @author bhunt
 */
public class ServiceLocator<T> extends ExternalResource
{
	/**
	 * Defaults the timeout to 1000 ms.
	 * 
	 * @param type the service class
	 */
	public ServiceLocator(Class<T> type)
	{
		this(type, 1000);
	}

	/**
	 * 
	 * @param type the service class
	 * @param timeout the timeout to wait for the service in ms.
	 */
	public ServiceLocator(Class<T> type, long timeout)
	{
		this.timeout = timeout;
		serviceTracker = new ServiceTracker<T, T>(Activator.getBundleContext(), type, null);
		serviceTracker.open();
	}

	/**
	 * 
	 * @return the service instance
	 */
	public T getService()
	{
		return service;
	}

	@Override
	protected void before() throws Throwable
	{
		service = serviceTracker.waitForService(timeout);
		assertThat("timed out waiting for service: " + service.getClass().getName(), service, is(notNullValue()));
		super.before();
	}

	private long timeout;
	private ServiceTracker<T, T> serviceTracker;
	private T service;
}
