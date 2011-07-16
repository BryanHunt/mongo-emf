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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;
import org.eclipselabs.mongo.emf.MongoDBUtil;
import org.eclipselabs.mongo.emf.junit.model.ModelFactory;
import org.eclipselabs.mongo.emf.junit.model.ModelPackage;
import org.eclipselabs.mongo.emf.junit.model.PrimaryObject;
import org.eclipselabs.mongo.emf.junit.model.TargetObject;
import org.eclipselabs.mongo.emf.junit.support.TestHarness;
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

		primaryObject.getFeatureMapReferenceType1().add(targetObject1);
		primaryObject.getFeatureMapReferenceType2().add(targetObject2);

		assertThat(primaryObject.getFeatureMapReferenceCollection().size(), is(2));
		assertThat(primaryObject.getFeatureMapReferenceType1().size(), is(1));
		assertThat(primaryObject.getFeatureMapReferenceType2().size(), is(1));

		// Test : Store the object to MongDB

		saveObject(primaryObject);

		// Verify : Check that the object was stored correctly.

		HashSet<EStructuralFeature> excludeFeatures = new HashSet<EStructuralFeature>(1);
		excludeFeatures.add(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION);
		PrimaryObject actual = MongoUtil.checkObject(primaryObject, excludeFeatures);
		assertThat(actual.getFeatureMapReferenceCollection().size(), is(2));
	}

	@Test
	public void testPrimaryObjectWithProxiesDoesNotResolveThemOnSave() throws IOException
	{
		ResourceSet resourceSet = MongoUtil.createResourceSet();

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");

		{
			TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
			targetObject.setSingleAttribute("one");
			saveObject(resourceSet, targetObject);
			primaryObject.setSingleContainmentReferenceProxies(targetObject);
			targetObject.eResource().unload();
		}

		{
			TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
			targetObject.setSingleAttribute("one");
			saveObject(resourceSet, targetObject);
			primaryObject.setSingleNonContainmentReference(targetObject);
			targetObject.eResource().unload();
		}
		{
			TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
			targetObject.setSingleAttribute("one");
			saveObject(resourceSet, targetObject);
			primaryObject.getMultipleContainmentReferenceProxies().add(targetObject);
			targetObject.eResource().unload();
		}
		{
			TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
			targetObject.setSingleAttribute("one");
			saveObject(resourceSet, targetObject);
			primaryObject.getMultipleNonContainmentReference().add(targetObject);
			targetObject.eResource().unload();
		}

		saveObject(resourceSet, primaryObject);

		// Verify that proxies aren't resolved as a result of saving to Mongo DB.
		//
		assertTrue(((EObject) primaryObject.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, false)).eIsProxy());
		assertTrue(((EObject) primaryObject.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, false)).eIsProxy());
		assertTrue(((EObject) ((InternalEList<?>) primaryObject.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES)).basicGet(0)).eIsProxy());
		assertTrue(((EObject) ((InternalEList<?>) primaryObject.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE)).basicGet(0)).eIsProxy());

		ResourceSet resourceSet2 = MongoUtil.createResourceSet();
		resourceSet2.getLoadOptions().put(MongoDBURIHandlerImpl.OPTION_PROXY_ATTRIBUTES, Boolean.TRUE);
		Resource primaryResource2 = resourceSet2.getResource(primaryObject.eResource().getURI(), true);
		PrimaryObject primaryObject2 = (PrimaryObject) primaryResource2.getContents().get(0);

		// Verify that proxies are created when loading from Mongo DB.
		//
		assertTrue(((EObject) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, false)).eIsProxy());
		assertTrue(((EObject) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, false)).eIsProxy());
		assertTrue(((EObject) ((InternalEList<?>) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES)).basicGet(0)).eIsProxy());
		assertTrue(((EObject) ((InternalEList<?>) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE)).basicGet(0)).eIsProxy());

		// Verify that those proxies have attributes populated as expected for OPTION_PROXY_ATTRIBUTES
		//
		assertThat(((TargetObject) ((EObject) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, false))).getSingleAttribute(), is("one"));
		assertThat(((TargetObject) ((EObject) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, false))).getSingleAttribute(), is("one"));
		assertThat(((TargetObject) ((EObject) ((InternalEList<?>) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES)).basicGet(0))).getSingleAttribute(),
				is("one"));
		assertThat(((TargetObject) ((EObject) ((InternalEList<?>) primaryObject2.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE)).basicGet(0))).getSingleAttribute(),
				is("one"));

		// Save it to XML, again with proxy attributes.
		//
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_PROXY_ATTRIBUTES, Boolean.TRUE);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		primaryResource2.save(out, options);

		ResourceSet resourceSet3 = MongoUtil.createResourceSet();
		Resource primaryResource3 = resourceSet3.createResource(primaryObject.eResource().getURI());
		primaryResource3.load(new ByteArrayInputStream(out.toByteArray()), null);

		// Verify that proxies are created when loading from XML.
		//
		PrimaryObject primaryObject3 = (PrimaryObject) primaryResource3.getContents().get(0);
		assertTrue(((EObject) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, false)).eIsProxy());
		assertTrue(((EObject) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, false)).eIsProxy());
		assertTrue(((EObject) ((InternalEList<?>) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES)).basicGet(0)).eIsProxy());
		assertTrue(((EObject) ((InternalEList<?>) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE)).basicGet(0)).eIsProxy());

		// Verify that those proxies have attributes populated as expected for OPTION_PROXY_ATTRIBUTES.
		//
		assertThat(((TargetObject) ((EObject) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, false))).getSingleAttribute(), is("one"));
		assertThat(((TargetObject) ((EObject) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, false))).getSingleAttribute(), is("one"));
		assertThat(((TargetObject) ((EObject) ((InternalEList<?>) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES)).basicGet(0))).getSingleAttribute(),
				is("one"));
		assertThat(((TargetObject) ((EObject) ((InternalEList<?>) primaryObject3.eGet(ModelPackage.Literals.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE)).basicGet(0))).getSingleAttribute(),
				is("one"));
	}

	@Test
	public void testCascadeDelete() throws IOException
	{
		// Setup : Create a primary object with a cross-document containment reference to a target object.

		ResourceSet resourceSet = MongoUtil.createResourceSet();

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(resourceSet, targetObject);

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");
		primaryObject.setSingleContainmentReferenceProxies(targetObject);
		saveObject(resourceSet, primaryObject);

		URI primaryURI = primaryObject.eResource().getURI();
		URI targetURI = targetObject.eResource().getURI();

		// Test : Cascade delete the primary object.

		MongoDBUtil.cascadeDelete(primaryObject, null);

		// Verify : Check that the target object was also deleted.

		ResourceSet targetResourceSet = MongoUtil.createResourceSet();
		Resource primaryResource = targetResourceSet.getResource(primaryURI, true);
		assertTrue(primaryResource.getContents().isEmpty());
		Resource targetResource = targetResourceSet.getResource(targetURI, true);
		assertTrue(targetResource.getContents().isEmpty());
	}
}
