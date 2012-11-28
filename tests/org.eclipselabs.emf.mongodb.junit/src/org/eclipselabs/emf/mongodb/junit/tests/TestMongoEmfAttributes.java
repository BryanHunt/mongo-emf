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

package org.eclipselabs.emf.mongodb.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emf.ext.junit.util.EChecker;
import org.eclipselabs.emf.mongodb.junit.model.ModelFactory;
import org.eclipselabs.emf.mongodb.junit.model.ModelPackage;
import org.eclipselabs.emf.mongodb.junit.model.PrimaryObject;
import org.eclipselabs.emf.mongodb.junit.model.TargetObject;
import org.eclipselabs.emf.mongodb.junit.support.TestHarness;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestMongoEmfAttributes extends TestHarness
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

	@Test
	public void testTargetObjectWithSingleAttribute() throws IOException
	{
		// Setup : Create a target object with the single attribute set.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		// Test : Store the object to MongoDB

		saveObject(targetObject);

		// Verify : Check that the object was stored correctly.

		EChecker.checkObject(targetObject, createResourceSet());
	}

	@Test
	public void testTargetObjectWithArrayAttribute() throws IOException
	{
		// Setup : Create a target object with the array attribute set.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.getArrayAttribute().add("one");
		targetObject.getArrayAttribute().add("two");

		// Test : Store the object to MongoDB

		saveObject(targetObject);

		// Verify : Check that the object was stored correctly.

		EChecker.checkObject(targetObject, createResourceSet());
	}

	@Test
	public void testTargetObjectUpdateSingleAttribute() throws IOException
	{
		// Setup : Create a target object with the single attribute set and store it to the database.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(targetObject);

		// Test : Update the attribute and store it back to the database

		targetObject.setSingleAttribute("green");
		targetObject.eResource().save(null);

		// Verify : Check that the object was stored correctly and there is only one object in the
		// collection.

		EChecker.checkObject(targetObject, createResourceSet());
		assertThat(getCollection(targetObject.eClass()).getCount(), is(1L));
	}

	@Test
	public void testTargetObjectUpdateArrayAttribute() throws IOException
	{
		// Setup : Create a target object with an array attribute set and store it to the database.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.getArrayAttribute().add("one");
		saveObject(targetObject);

		// Test : Update the attribute and store it back to the database

		targetObject.getArrayAttribute().add("two");
		targetObject.eResource().save(null);

		// Verify : Check that the object was stored correctly and there is only one object in the
		// collection.

		EChecker.checkObject(targetObject, createResourceSet());
		assertThat(getCollection(targetObject.eClass()).getCount(), is(1L));
	}

	@Test
	public void testUnsettableAttributeSetToNULL() throws IOException
	{
		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setUnsettableAttribute(null);
		saveObject(primaryObject);

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.getResource(primaryObject.eResource().getURI(), true);
		PrimaryObject object = (PrimaryObject) resource.getContents().get(0);
		assertTrue(object.isSetUnsettableAttribute());
		assertThat(object.getUnsettableAttribute(), is(nullValue()));
	}

	@Test
	public void testUnsettableAttributeUnset() throws IOException
	{
		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		saveObject(primaryObject);

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.getResource(primaryObject.eResource().getURI(), true);
		PrimaryObject object = (PrimaryObject) resource.getContents().get(0);
		assertFalse(object.isSetUnsettableAttribute());
	}

	@Test
	public void testUnsettableAttributeWithNonNullDefaultSetToNULL() throws IOException
	{
		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setUnsettableAttributeWithNonNullDefault(null);
		saveObject(primaryObject);

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.getResource(primaryObject.eResource().getURI(), true);
		PrimaryObject object = (PrimaryObject) resource.getContents().get(0);
		assertFalse(object.isSetUnsettableAttribute());
		assertThat(object.getUnsettableAttribute(), is(nullValue()));
	}

	@Test
	public void testUnsettableAttributeWithNonNullDefaultUnset() throws IOException
	{
		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		saveObject(primaryObject);

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.getResource(primaryObject.eResource().getURI(), true);
		PrimaryObject object = (PrimaryObject) resource.getContents().get(0);
		assertFalse(object.isSetUnsettableAttribute());
	}

	@Test
	public void testFeatureMap() throws IOException
	{
		// Setup : Create a primary object and two attributes for the feature map.

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");

		primaryObject.getFeatureMapAttributeType1().add("Hello");
		primaryObject.getFeatureMapAttributeType2().add("World");

		assertThat(primaryObject.getFeatureMapAttributeCollection().size(), is(2));
		assertThat(primaryObject.getFeatureMapAttributeType1().size(), is(1));
		assertThat(primaryObject.getFeatureMapAttributeType2().size(), is(1));

		// Test : Store the object to MongDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		HashSet<EStructuralFeature> excludeFeatures = new HashSet<EStructuralFeature>(1);
		excludeFeatures.add(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION);
		PrimaryObject actual = EChecker.checkObject(primaryObject, excludeFeatures, createResourceSet());
		assertThat(actual.getFeatureMapAttributeCollection().size(), is(2));
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
