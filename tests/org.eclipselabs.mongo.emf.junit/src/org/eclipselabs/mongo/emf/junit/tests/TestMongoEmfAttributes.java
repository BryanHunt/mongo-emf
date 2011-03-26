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

package org.eclipselabs.mongo.emf.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.eclipselabs.mongo.emf.junit.model.ModelFactory;
import org.eclipselabs.mongo.emf.junit.model.TargetObject;
import org.eclipselabs.mongo.emf.junit.support.TestHarness;
import org.eclipselabs.mongo.junit.MongoUtil;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestMongoEmfAttributes extends TestHarness
{
	@Test
	public void testTargetObjectWithSingleAttribute() throws IOException
	{
		// Setup : Create a target object with the single attribute set.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		// Test : Store the object to MongoDB

		saveObject(targetObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(targetObject);
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

		MongoUtil.checkObject(targetObject);
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

		MongoUtil.checkObject(targetObject);
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

		MongoUtil.checkObject(targetObject);
		assertThat(getCollection(targetObject.eClass()).getCount(), is(1L));
	}
}
