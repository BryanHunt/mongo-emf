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

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;
import org.eclipselabs.mongo.emf.MongoResourceSetImpl;
import org.eclipselabs.mongo.emf.perf.model.ModelFactory;
import org.eclipselabs.mongo.emf.perf.model.ObjectGroup;
import org.eclipselabs.mongo.emf.perf.model.TestObject1;
import org.eclipselabs.mongo.emf.perf.support.TreeVisitor;
import org.eclipselabs.mongo.junit.MongoDatabase;
import org.eclipselabs.mongo.junit.MongoUtil;
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
public class TestResourceSetPerformance
{
	@Rule
	public static MongoDatabase db = new MongoDatabase("junit");

	@Parameters
	public static Collection<Object[]> data()
	{
		Object[][] data = new Object[][] { { Boolean.TRUE }, { Boolean.FALSE } };
		return Arrays.asList(data);
	}

	public TestResourceSetPerformance(boolean useMongoResourceSet)
	{
		this.useMongoResourceSet = useMongoResourceSet;
	}

	@Test
	public void testObjectTree() throws Exception
	{
		ResourceSet resourceSet = createResourceSet();
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("http://localhost/junit/"), URI.createURI("mongo://localhost/junit/"));
		URI uri = URI.createURI("http://localhost/junit/objects/");

		System.out.println("Initializing");

		ObjectGroup root = createObjectGroup(0);

		for (int i = 0; i < 10000; i++)
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
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("http://localhost/junit/"), URI.createURI("mongo://localhost/junit/"));

		System.out.println("Loading data");

		long startTime = System.currentTimeMillis();
		Resource resultResource = resourceSet.getResource(root.eResource().getURI(), true);

		System.out.println("Traversing the object tree");

		new TreeVisitor().doSwitch(resultResource.getContents().get(0));
		long endTime = System.currentTimeMillis();

		System.out.println("Time to load children using " + (useMongoResourceSet ? "custom map" : "default map") + ": " + (endTime - startTime) + " ms");
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

	private ResourceSet createResourceSet()
	{
		ResourceSet resourceSet;

		if (useMongoResourceSet)
		{
			resourceSet = new MongoResourceSetImpl();
			EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
			uriHandlers.add(0, new MongoDBURIHandlerImpl());
		}
		else
			resourceSet = MongoUtil.createResourceSet();

		return resourceSet;
	}

	private boolean useMongoResourceSet;
}
