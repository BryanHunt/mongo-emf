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

package org.eclipselabs.emf.mongodb.perf.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emf.mongodb.junit.support.TestHarness;
import org.eclipselabs.emf.mongodb.perf.model.ModelFactory;
import org.eclipselabs.emf.mongodb.perf.model.ObjectGroup;
import org.eclipselabs.emf.mongodb.perf.model.TestObject1;
import org.eclipselabs.emf.mongodb.perf.support.TreeVisitor;
import org.eclipselabs.emongo.junit.util.MongoDatabase;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author bhunt
 * 
 */
@RunWith(value = Parameterized.class)
public class TestResourceSetPerformance extends TestHarness
{
	@Rule
	public static MongoDatabase db = new MongoDatabase("junit");

	@Parameters
	public static Collection<Object[]> data()
	{
		Object[][] data = new Object[][] { { Boolean.FALSE, 1000 }, { Boolean.FALSE, 2000 }, { Boolean.FALSE, 3000 }, { Boolean.FALSE, 4000 }, { Boolean.FALSE, 5000 }, { Boolean.FALSE, 6000 },
				{ Boolean.FALSE, 7000 }, { Boolean.FALSE, 8000 }, { Boolean.FALSE, 9000 }, { Boolean.FALSE, 10000 }, { Boolean.TRUE, 1000 }, { Boolean.TRUE, 2000 }, { Boolean.TRUE, 3000 },
				{ Boolean.TRUE, 4000 }, { Boolean.TRUE, 5000 }, { Boolean.TRUE, 6000 }, { Boolean.TRUE, 7000 }, { Boolean.TRUE, 8000 }, { Boolean.TRUE, 9000 }, { Boolean.TRUE, 10000 } };

		return Arrays.asList(data);
	}

	public TestResourceSetPerformance(boolean useMongoResourceSet, int numberObjects)
	{
		this.useMongoResourceSet = useMongoResourceSet;
		this.numberObjects = numberObjects;
	}

	@Test
	@Ignore
	public void testObjectTree() throws Exception
	{
		ResourceSet resourceSet = createResourceSet();
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("http://localhost/junit/"), URI.createURI("mongodb://localhost/junit/"));
		URI uri = URI.createURI("http://localhost/junit/objects/");

		System.out.println("Initializing");

		ObjectGroup root = createObjectGroup(0);

		for (int i = 0; i < numberObjects; i++)
		{
			TestObject1 object = createTestObject1(i);
			root.getChildren().add(object);

			Resource resource = resourceSet.createResource(uri);
			resource.getContents().add(object);
			resource.save(null);
		}

		Resource rootResource = resourceSet.createResource(uri);
		rootResource.getContents().add(root);
		rootResource.save(null);

		resourceSet = createResourceSet();
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("http://localhost/junit/"), URI.createURI("mongodb://localhost/junit/"));

		System.out.println("Loading data");

		long startTime = System.currentTimeMillis();
		Resource resultResource = resourceSet.getResource(root.eResource().getURI(), true);

		System.out.println("Traversing the object tree");

		new TreeVisitor().doSwitch(resultResource.getContents().get(0));
		long endTime = System.currentTimeMillis();

		System.out.println("Time to load " + numberObjects + " children using " + (useMongoResourceSet ? "custom map" : "default map") + ": " + (endTime - startTime) + " ms");
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

	/**
	 * @param i unique object index
	 * @return test group filled with dummy data
	 */
	private ObjectGroup createObjectGroup(int i)
	{
		ObjectGroup group = ModelFactory.eINSTANCE.createObjectGroup();

		group.setName("Test Object " + i);
		group.setDescription("MongoDB test object " + i);
		group.setCategory("Test Object");
		group.setTag("Object Tag");
		group.setCreated(new Date());

		return group;
	}

//	private ResourceSet createResourceSet()
//	{
//		ResourceSet resourceSet;
//
//		if (useMongoResourceSet)
//			resourceSet = MongoUtil.createMongoResourceSet();
//		else
//			resourceSet = MongoUtil.createResourceSet();
//
//		return resourceSet;
//	}

	private boolean useMongoResourceSet;
	private int numberObjects;
}
