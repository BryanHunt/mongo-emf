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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.emf.junit.model.ModelFactory;
import org.eclipselabs.mongo.emf.junit.model.ModelPackage;
import org.eclipselabs.mongo.emf.junit.model.PrimaryObject;
import org.eclipselabs.mongo.emf.junit.model.TargetObject;
import org.eclipselabs.mongo.junit.MongoUtil;
import org.junit.Test;

/**
 * @author bhunt
 * 
 */
public class TestMongoEmfReferences extends TestHarness
{
	@Test
	public void testPrimaryObject() throws IOException
	{
		// Setup : Create a primary object with only the name attribute set

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");

		// Test : Store the object to MongoDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testPrimaryObjectWithSingleContainmentReferenceNoProxies() throws IOException
	{
		// Setup : Create a primary object with a containment reference to a target object.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.setSingleContainmentReferenceNoProxies(targetObject);

		// Test : Store the object to MongoDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testPrimaryObjectWithMultipleContainmentReferenceNoProxies() throws IOException
	{
		// Setup : Create a primary object with multiple containment references to target objects.

		TargetObject targetObject1 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject1.setSingleAttribute("one");

		TargetObject targetObject2 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject2.setSingleAttribute("two");

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.getMultipleContainmentReferenceNoProxies().add(targetObject1);
		primaryObject.getMultipleContainmentReferenceNoProxies().add(targetObject2);

		// Test : Store the object to MongoDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testPrimaryObjectWithSingleNonContainmentReference() throws IOException
	{
		// Setup : Create a primary object with a non containment reference to a target object.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.setSingleContainmentReferenceNoProxies(targetObject);
		primaryObject.setSingleNonContainmentReference(targetObject);

		// Test : Store the object to MongoDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testPrimaryObjectWithMultipleNonContainmentReference() throws IOException
	{
		// Setup : Create a primary object with multiple containment references to target objects.

		TargetObject targetObject1 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject1.setSingleAttribute("one");

		TargetObject targetObject2 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject2.setSingleAttribute("two");

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.getMultipleContainmentReferenceNoProxies().add(targetObject1);
		primaryObject.getMultipleContainmentReferenceNoProxies().add(targetObject2);
		primaryObject.getMultipleNonContainmentReference().add(targetObject1);
		primaryObject.getMultipleNonContainmentReference().add(targetObject2);

		// Test : Store the object to MongoDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testPrimaryObjectWithSingleContainmentReferenceProxies() throws IOException
	{
		// Setup : Create a primary object with a cross-document containment reference to a target
		// object.

		ResourceSet resourceSet = MongoUtil.createResourceSet();

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(resourceSet, targetObject);

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.setSingleContainmentReferenceProxies(targetObject);

		// Test : Store the object to MongoDB

		saveObject(resourceSet, primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testPrimaryObjectWithMultipleContainmentReferenceProxies() throws IOException
	{
		// Setup : Create a primary object with multiple cross-document containment references to target
		// objects.

		ResourceSet resourceSet = MongoUtil.createResourceSet();

		TargetObject targetObject1 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject1.setSingleAttribute("one");
		saveObject(resourceSet, targetObject1);

		TargetObject targetObject2 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject2.setSingleAttribute("two");
		saveObject(resourceSet, targetObject2);

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.getMultipleContainmentReferenceProxies().add(targetObject1);
		primaryObject.getMultipleContainmentReferenceProxies().add(targetObject2);

		// Test : Store the object to MongoDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testPrimaryObjectWithSingleContainmentReferenceProxiesSameDocument() throws IOException
	{
		// Setup : Create a primary object with a containment reference to a target object.

		ResourceSet resourceSet = MongoUtil.createResourceSet();

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.setSingleContainmentReferenceProxies(targetObject);

		// Test : Store the object to MongoDB

		saveObject(resourceSet, primaryObject);

		// Verify : Check that the object was stored correctly.

		MongoUtil.checkObject(primaryObject);
	}

	@Test
	public void testDeletedCrossDocumentReference() throws IOException
	{
		// Setup : Create a primary object with a cross-document containment reference to a target
		// object.

		ResourceSet resourceSet = MongoUtil.createResourceSet();

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(resourceSet, targetObject);

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.setSingleContainmentReferenceProxies(targetObject);
		saveObject(resourceSet, primaryObject);

		// Test : Delete the target object and reload the primary object

		targetObject.eResource().delete(null);
		ResourceSet testResourceSet = MongoUtil.createResourceSet();
		Resource resource = testResourceSet.getResource(primaryObject.eResource().getURI(), true);

		// Verify : Check that the object was stored correctly.

		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		PrimaryObject actual = (PrimaryObject) resource.getContents().get(0);
		assertThat(actual.getSingleContainmentReferenceProxies(), is(notNullValue()));
		assertTrue(actual.getSingleContainmentReferenceProxies().eIsProxy());
	}

	@Test
	public void testFeatureMap() throws IOException
	{
		// Setup : Create a primary object and two target objects for the feature map.

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");

		TargetObject targetObject1 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject1.setSingleAttribute("one");

		TargetObject targetObject2 = ModelFactory.eINSTANCE.createTargetObject();
		targetObject2.setSingleAttribute("two");

		primaryObject.getFeatureMapType1().add(targetObject1);
		primaryObject.getFeatureMapType2().add(targetObject2);

		assertThat(primaryObject.getFeatureMapCollection().size(), is(2));
		assertThat(primaryObject.getFeatureMapType1().size(), is(1));
		assertThat(primaryObject.getFeatureMapType2().size(), is(1));

		// Test : Store the object to MongDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		HashSet<EStructuralFeature> excludeFeatures = new HashSet<EStructuralFeature>(1);
		excludeFeatures.add(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_COLLECTION);
		PrimaryObject actual = MongoUtil.checkObject(primaryObject, excludeFeatures);
		assertThat(actual.getFeatureMapCollection().size(), is(2));
	}
}
