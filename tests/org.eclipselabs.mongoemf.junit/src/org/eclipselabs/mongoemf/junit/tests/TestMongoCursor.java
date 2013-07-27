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

package org.eclipselabs.mongoemf.junit.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongoemf.Options;
import org.eclipselabs.mongoemf.junit.model.ModelFactory;
import org.eclipselabs.mongoemf.junit.model.ModelPackage;
import org.eclipselabs.mongoemf.junit.model.TargetObject;
import org.eclipselabs.mongoemf.junit.support.TestHarness;
import org.eclipselabs.mongoemf.model.MongoCursor;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestMongoCursor extends TestHarness
{
	@BeforeClass
	public static void waitForServices() throws InterruptedException
	{
		synchronized (lock)
		{
			if (!initialized)
				lock.wait(60000);

			assertTrue("Timed out waiting for services to be bound", initialized);
		}
	}

	@Before
	public void setUp() throws UnknownHostException
	{
		queryURI = createCollectionURI(ModelPackage.Literals.TARGET_OBJECT).appendQuery(URI.encodeQuery("", false));
		super.setUp();
	}

	@Test
	public void testEmptyIteration() throws IOException
	{
		// Test: Query the database to return a cursor

		ResourceSet resourceSet = createResourceSet();
		resourceSet.getLoadOptions().put(Options.OPTION_QUERY_CURSOR, Boolean.TRUE);
		Resource resource = resourceSet.getResource(queryURI, true);

		// Verify: Make sure we got a cursor back with no elements

		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		assertThat(resource.getContents().get(0), is(instanceOf(MongoCursor.class)));

		MongoCursor cursor = (MongoCursor) resource.getContents().get(0);
		Iterator<EObject> iterator = cursor.iterator();
		assertThat(iterator, is(notNullValue()));
		assertFalse(iterator.hasNext());
	}

	@Test
	public void testSingleIteration() throws IOException
	{
		// Setup : Store a single target object to the database.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(targetObject);

		// Test: Query the database to return a cursor

		ResourceSet resourceSet = createResourceSet();
		resourceSet.getLoadOptions().put(Options.OPTION_QUERY_CURSOR, Boolean.TRUE);
		Resource resource = resourceSet.getResource(queryURI, true);

		// Verify: Make sure we got a cursor back with only one element that matches the target object

		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		assertThat(resource.getContents().get(0), is(instanceOf(MongoCursor.class)));

		MongoCursor cursor = (MongoCursor) resource.getContents().get(0);
		Iterator<EObject> iterator = cursor.iterator();
		assertThat(iterator, is(notNullValue()));

		assertTrue(iterator.hasNext());
		TargetObject actualObject = (TargetObject) iterator.next();
		assertThat(actualObject.getSingleAttribute(), is("junit"));
		assertThat(actualObject.eResource(), is(notNullValue()));
		assertThat(actualObject.eResource().getURI(), is(targetObject.eResource().getURI()));
		assertFalse(iterator.hasNext());
	}

	@Test
	public void testMultipleIteration() throws IOException
	{
		// Setup : Store multiple target objects to the database.

		TargetObject targetObject1 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject1.setSingleAttribute("junit1");
		saveObject(targetObject1);

		TargetObject targetObject2 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject2.setSingleAttribute("junit2");
		saveObject(targetObject2);

		TargetObject targetObject3 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject3.setSingleAttribute("junit3");
		saveObject(targetObject3);

		// Test: Query the database to return a cursor

		ResourceSet resourceSet = createResourceSet();
		resourceSet.getLoadOptions().put(Options.OPTION_QUERY_CURSOR, Boolean.TRUE);
		Resource resource = resourceSet.getResource(queryURI, true);

		// Verify: Make sure we got a cursor back with three elements that match the target objects

		HashSet<String> pendingTargets = new HashSet<String>(3);
		pendingTargets.add(targetObject1.getSingleAttribute());
		pendingTargets.add(targetObject2.getSingleAttribute());
		pendingTargets.add(targetObject3.getSingleAttribute());

		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		assertThat(resource.getContents().get(0), is(instanceOf(MongoCursor.class)));

		MongoCursor cursor = (MongoCursor) resource.getContents().get(0);
		Iterator<EObject> iterator = cursor.iterator();
		assertThat(iterator, is(notNullValue()));

		assertTrue(iterator.hasNext());
		TargetObject actualObject = (TargetObject) iterator.next();
		pendingTargets.remove(actualObject.getSingleAttribute());

		assertTrue(iterator.hasNext());
		actualObject = (TargetObject) iterator.next();
		pendingTargets.remove(actualObject.getSingleAttribute());

		assertTrue(iterator.hasNext());
		actualObject = (TargetObject) iterator.next();
		pendingTargets.remove(actualObject.getSingleAttribute());

		assertFalse(iterator.hasNext());
		assertTrue(pendingTargets.isEmpty());
	}

	protected void activate()
	{
		synchronized (lock)
		{
			initialized = true;
			lock.notifyAll();
		}
	}

	private static boolean initialized = false;
	private static Object lock = new Object();
	private static URI queryURI;
}
