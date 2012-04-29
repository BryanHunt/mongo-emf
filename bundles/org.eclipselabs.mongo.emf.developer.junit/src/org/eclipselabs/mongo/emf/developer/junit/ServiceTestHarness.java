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

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;

/**
 * This class is intended to be extended by clients creating unit tests in an OSGi environment
 * that requires services to be activated before the unit test runs. Clients should register
 * the extension of this class as a declarative service depending on the services required
 * services. If the JUnit test uses one of the services, the service bind function should
 * assign the service to a static data member.
 * 
 * The JUnit framework will automatically call waitForServices() on this class. This function
 * will wait until the OSGi declarative services manager calls activate() before allowing the
 * unit test to continue. The waitForServices() call has a built-in timeout of 60 seconds.
 * This timeout will keep your automated builds from hanging in the case that a service is not
 * bound.
 * 
 * If you need to change the timeout, add the following to your extension:
 * 
 * <pre>
 * &#064;BeforeClass
 * public static void waitForServices() throws InterruptedException
 * {
 * 	initializationTimeout = 10000;
 * 	ServiceTestHarness.waitForServices();
 * }
 * </pre>
 * 
 * This pattern was taken from the book OSGi and Equinox: Creating Highly Modular Java Systems,
 * Jeff McAffer, Paul VanderLei, and Simon Archer, Pearson Education, Inc, page 135.
 * 
 * @author bhunt
 * 
 */
public class ServiceTestHarness
{
	/**
	 * Called automatically by the JUnit framework once for all unit tests in the extending class.
	 * Clients should not have to call this function directly.
	 * 
	 * @throws InterruptedException if any thread interrupts the thread waiting for the activation
	 */
	@BeforeClass
	public static void waitForServices() throws InterruptedException
	{
		synchronized (lock)
		{
			if (!initialized)
				lock.wait(initializationTimeout);

			assertTrue("Timed out waiting for services to be bound", initialized);
		}
	}

	/**
	 * Called automatically by the OSGi declarative services manager. Clients should not have to call this
	 * function directly.
	 */
	protected void activate()
	{
		synchronized (lock)
		{
			initialized = true;
			lock.notifyAll();
		}
	}

	protected static long initializationTimeout = 60000;
	private static boolean initialized = false;
	private static Object lock = new Object();
}
