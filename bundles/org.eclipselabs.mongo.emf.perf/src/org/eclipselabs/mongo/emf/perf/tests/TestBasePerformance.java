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

package org.eclipselabs.mongo.emf.perf.tests;

import java.util.Date;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.emf.developer.junit.MongoDatabase;
import org.eclipselabs.mongo.emf.developer.junit.MongoUtil;
import org.eclipselabs.mongo.emf.perf.model.ModelFactory;
import org.eclipselabs.mongo.emf.perf.model.TestObject1;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.yourkit.api.Controller;
import com.yourkit.api.ProfilingModes;

/**
 * @author bhunt
 * 
 */
public class TestBasePerformance
{
	@Rule
	public static MongoDatabase db = new MongoDatabase("junit");

	@BeforeClass
	public static void globalSetUp() throws Exception
	{
		controller = new Controller();
		filters = new StringBuilder();
		filters.append("java.*\n");
		filters.append("javax.*\n");
		filters.append("sun.*\n");
		filters.append("sunw.*\n");
		filters.append("com.sun.*\n");
		filters.append("junit.*\n");
		filters.append("com.yourkit.*\n");
	}

	@SuppressWarnings("unused")
	@Test
	public void testCollectionOfObjects() throws Exception
	{
		ResourceSet resourceSet = MongoUtil.createResourceSet();
		URI uri = URI.createURI("mongo://localhost/junit/objects/");
		Resource resource = resourceSet.createResource(uri);

		System.out.println("Initializing");

		for (int i = 0; i < 2000; i++)
			resource.getContents().add(createTestObject1(i));

		System.out.println("Storing data");

		controller.startCPUProfiling(ProfilingModes.CPU_TRACING, filters.toString(), Controller.DEFAULT_WALLTIME_SPEC);
		resource.save(null);
		System.out.println("Stopping profile");
		controller.stopCPUProfiling();
		System.out.println("Capturing snapshot");
		System.out.println("Collection store snapshot: " + controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP));

		resourceSet = MongoUtil.createResourceSet();

		System.out.println("Loading data");

		controller.startCPUProfiling(ProfilingModes.CPU_TRACING, filters.toString(), Controller.DEFAULT_WALLTIME_SPEC);
		resource = resourceSet.getResource(uri.appendQuery(""), true);
		Result result = (Result) resource.getContents().get(0);

		System.out.println("Loading from a Result");

		for (EObject object : result.getValues());

		System.out.println("Stopping profile");
		controller.stopCPUProfiling();
		System.out.println("Capturing snapshot");
		System.out.println("Collection load snapshot: " + controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP));
	}

	/**
	 * @param i unique object index
	 * @return test object filled with dummy data
	 */
	private TestObject1 createTestObject1(int i)
	{
		TestObject1 object = ModelFactory.eINSTANCE.createTestObject1();

		object.setName("Test Object " + i);
		object.setDescription("MongoDB test object " + i);
		object.setCategory("Test Object");
		object.setCount(i);
		object.setTag("Object Tag");
		object.setCreated(new Date());
		object.setFirstAvailable(new Date());
		object.setLastAvailable(new Date());
		object.setLastModified(new Date());
		object.setData(object.toString());

		return object;
	}

	private static Controller controller;
	private static StringBuilder filters;
}
