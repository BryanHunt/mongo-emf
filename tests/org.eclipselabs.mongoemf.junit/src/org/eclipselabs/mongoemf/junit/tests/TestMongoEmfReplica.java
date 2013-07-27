/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongoemf.junit.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongoemf.junit.model.ModelFactory;
import org.eclipselabs.mongoemf.junit.model.TargetObject;
import org.eclipselabs.mongoemf.junit.support.EChecker;
import org.eclipselabs.mongoemf.junit.support.TestHarness;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This test assumes you have a MongoDB replica set running on localhost.
 * 
 * The ports are: 27020, 27021, 27022.
 * The tags are: {"locale", "us"}, {"locale", "in"}, {"locale", "de"}
 * 
 * @author bhunt
 * 
 */
public class TestMongoEmfReplica extends TestHarness
{
	public TestMongoEmfReplica()
	{
		super(27021);
	}

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

	@Test
	public void testReplicaRead() throws IOException
	{
		// Setup : Create a target object and ObjectId for the ID

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		// Test : Store the object to MongoDB

		saveObject(targetObject, createCollectionURI(targetObject.eClass()), null);

		// Verify : Check that the object was stored correctly

		ResourceSet actualResourceSet = createResourceSet();

		HashMap<String, String> tags = new HashMap<String, String>(1);
		tags.put("locale", "in");

// FIXME uncomment when MongoDB properly supports tagged reads		
//		actualResourceSet.getLoadOptions().put(MongoDBURIHandlerImpl.OPTION_TAGGED_READ_PREFERENCE, tags);
		Resource actualResource = actualResourceSet.getResource(targetObject.eResource().getURI(), true);
		EObject actual = actualResource.getContents().get(0);
		EChecker.checkObject(targetObject, actual);
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
}
