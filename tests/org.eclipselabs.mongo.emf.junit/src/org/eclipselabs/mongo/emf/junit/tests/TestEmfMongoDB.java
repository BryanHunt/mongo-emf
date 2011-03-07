/*******************************************************************************
 * Copyright (c) 2010 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf.junit.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;
import org.eclipselabs.mongo.emf.junit.internal.Activator;
import org.eclipselabs.mongo.emf.junit.model.ETypes;
import org.eclipselabs.mongo.emf.junit.model.ModelFactory;
import org.eclipselabs.mongo.emf.junit.model.ModelPackage;
import org.eclipselabs.mongo.emf.junit.model.Person;
import org.eclipselabs.mongo.emf.junit.model.PrimaryObject;
import org.eclipselabs.mongo.emf.junit.model.TargetObject;
import org.eclipselabs.mongo.junit.MongoDatabase;
import org.eclipselabs.mongo.junit.MongoUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

/**
 * @author bhunt
 * 
 */
public class TestEmfMongoDB
{
	@Rule
	public MongoDatabase database = new MongoDatabase(Activator.getInstance().getContext(), "junit");

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Before
	public void setUp() throws UnknownHostException, MongoException
	{
		IMongoDB mongoService = Activator.getInstance().getMongoDB();
		assertThat(mongoService, is(notNullValue()));

		Mongo mongo = mongoService.getMongo(new MongoURI("mongodb://localhost"));
		assertThat(mongo, is(notNullValue()));

		DB db = mongo.getDB("junit");
		assertThat(db, is(notNullValue()));

		targetCollection = db.getCollection(ModelPackage.Literals.TARGET_OBJECT.getName());
	}

	@Test(expected = IOException.class)
	public void testShortURI() throws IOException
	{
		// Setup : Create a target object to save.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		// Test : Save the target object with a short (invalid) URI

		saveObject(targetObject, createObjectURI(targetObject.eClass(), new ObjectId()).appendSegment(""), null);
	}

	@Test(expected = IOException.class)
	public void testLongURI() throws IOException
	{
		// Setup : Create a target object to save.

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		// Test : Save the target object with a long (invalid) URI

		saveObject(targetObject, createCollectionURI(targetObject.eClass()).trimSegments(1), null);
	}

	@Test
	public void testLoadNonexistentResource()
	{
		// Setup : Create an empty resource set

		ResourceSet resourceSet = MongoUtil.createResourceSet();

		// Test : Get the resource from the database

		Resource resource = resourceSet.getResource(createObjectURI(ModelPackage.Literals.TARGET_OBJECT, new ObjectId()), true);

		// Verify : The resource must be empty

		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(0));
	}

	@Test
	public void testTypes() throws IOException
	{
		// Setup

		ETypes eTypes = ModelFactory.eINSTANCE.createETypes();
		eTypes.setEBigDecimal(new BigDecimal(1));
		eTypes.setEBigInteger(new BigInteger(2, new Random()));
		eTypes.setEBoolean(true);
		eTypes.setEByte((byte) 3);
		eTypes.setEByteArray(new byte[] { 1, 2 });
		eTypes.setEChar('j');
		eTypes.setEDate(new Date());
		eTypes.setEDouble(1.0);
		eTypes.setEFloat(1.0f);
		eTypes.setEInt(1);
		eTypes.setELong(1L);
		eTypes.setEShort((short) 1);
		eTypes.setEString("j");

		// Test

		saveObject(eTypes);

		// Verify

		assertThat(eTypes.eResource().getURI().segmentCount(), is(3));
		assertThat(eTypes.eResource().getURI().segment(2), is(notNullValue()));
		MongoUtil.checkObject(eTypes);
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
		assertThat(targetCollection.getCount(), is(1L));
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
		assertThat(targetCollection.getCount(), is(1L));
	}

	@Test
	public void testTargetObjectWithObjectId() throws IOException
	{
		// Setup : Create a target object and ObjectId for the ID

		ObjectId id = new ObjectId();

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		HashMap<String, Object> options = new HashMap<String, Object>(1);
		options.put(MongoDBURIHandlerImpl.OPTION_GENERATE_ID, Boolean.FALSE);

		// Test : Store the object to MongoDB

		saveObject(targetObject, createObjectURI(targetObject.eClass(), id), options);

		// Verify : Check that the object was stored correctly, and that is has the ID we specified.

		TargetObject actual = MongoUtil.checkObject(targetObject);
		assertThat(MongoUtil.getID(actual), is(id.toString()));
	}

	@Test
	public void testTargetObjectWithArbitraryId() throws IOException
	{
		// Setup : Create a target object and arbitrary string for the ID

		String id = "ID";

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		HashMap<String, Object> options = new HashMap<String, Object>(1);
		options.put(MongoDBURIHandlerImpl.OPTION_GENERATE_ID, Boolean.FALSE);

		// Test : Store the object to MongoDB

		saveObject(targetObject, createObjectURI(targetObject.eClass(), id), options);

		// Verify : Check that the object was stored correctly, and that is has the ID we specified.

		TargetObject actual = MongoUtil.checkObject(targetObject);
		assertThat(MongoUtil.getID(actual), is(id));
	}

	@Test
	public void testDeleteTargetObject() throws IOException
	{
		// Setup : Create and store the target object

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(targetObject);

		// Test : Delete the target object

		targetObject.eResource().delete(null);

		// Verify : The target object was deleted

		assertThat(targetCollection.getCount(), is(0L));
	}

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

	@Test
	public void testXMIRepresentation() throws IOException
	{
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

		saveObject(resourceSet, primaryObject);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		primaryObject.eResource().save(out, null);

		ResourceSet testResourceSet = MongoUtil.createResourceSet();

		testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../TargetObject/"), targetObject1.eResource().getURI().trimSegments(1).appendSegment(""));
		Resource libraryXMI = new XMIResourceFactoryImpl().createResource(URI.createURI(temporaryFolder.newFile("model.xmi").getAbsolutePath()));
		testResourceSet.getResources().add(libraryXMI);

		libraryXMI.load(new ByteArrayInputStream(out.toByteArray()), null);
		MongoUtil.checkObject(primaryObject, libraryXMI.getContents().get(0));
	}

	@Test
	public void testBinaryRepresentation() throws IOException
	{
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

		saveObject(resourceSet, primaryObject);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_BINARY, Boolean.TRUE);
		primaryObject.eResource().save(out, options);

		{
			ResourceSet testResourceSet = MongoUtil.createResourceSet();

			testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../TargetObject/"), targetObject1.eResource().getURI().trimSegments(1).appendSegment(""));

			Resource libraryBinary = new BinaryResourceImpl(URI.createURI(temporaryFolder.newFile("model.binary").getAbsolutePath()));
			testResourceSet.getResources().add(libraryBinary);

			libraryBinary.load(new ByteArrayInputStream(out.toByteArray()), null);
			MongoUtil.checkObject(primaryObject, libraryBinary.getContents().get(0));
		}
		{
			ResourceSet testResourceSet = MongoUtil.createResourceSet();

			testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../TargetObject/"), targetObject1.eResource().getURI().trimSegments(1).appendSegment(""));

			Resource libraryXMI = new XMIResourceFactoryImpl().createResource(URI.createURI(temporaryFolder.newFile("model.mongo.binary").getAbsolutePath()));
			testResourceSet.getResources().add(libraryXMI);

			libraryXMI.load(new ByteArrayInputStream(out.toByteArray()), options);
			MongoUtil.checkObject(primaryObject, libraryXMI.getContents().get(0));
		}
	}

	@Test
	public void testXMLRepresentation() throws IOException
	{
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

		saveObject(resourceSet, primaryObject);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMIResource.OPTION_SUPPRESS_XMI, Boolean.TRUE);
		primaryObject.eResource().save(out, options);

		{
			ResourceSet testResourceSet = MongoUtil.createResourceSet();

			testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../TargetObject/"), targetObject1.eResource().getURI().trimSegments(1).appendSegment(""));

			Resource libraryXML = new XMLResourceFactoryImpl().createResource(URI.createURI(temporaryFolder.newFile("model.xml").getAbsolutePath()));
			testResourceSet.getResources().add(libraryXML);

			libraryXML.load(new ByteArrayInputStream(out.toByteArray()), null);
			MongoUtil.checkObject(primaryObject, libraryXML.getContents().get(0));
		}
		{
			ResourceSet testResourceSet = MongoUtil.createResourceSet();

			testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../TargetObject/"), targetObject1.eResource().getURI().trimSegments(1).appendSegment(""));

			Resource libraryXMI = new XMIResourceFactoryImpl().createResource(URI.createURI(temporaryFolder.newFile("model.mongo.xml").getAbsolutePath()));
			testResourceSet.getResources().add(libraryXMI);

			libraryXMI.load(new ByteArrayInputStream(out.toByteArray()), options);
			MongoUtil.checkObject(primaryObject, libraryXMI.getContents().get(0));
		}
	}

	@Test
	public void testExtrinsicIDs() throws IOException
	{
		// Setup : Create a target object and set its extrinsic ID

		ResourceSet resourceSet = MongoUtil.createResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl()
		{
			@Override
			public Resource createResource(URI uri)
			{
				return new XMIResourceImpl(uri)
				{
					@Override
					protected boolean useUUIDs()
					{
						return true;
					}
				};
			}
		});

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(resourceSet, targetObject);

		XMLResource resource = (XMLResource) targetObject.eResource();
		String authorID = resource.getID(targetObject);

		// Test : Reload the target object

		resource.unload();
		resource.load(null);

		// Verify : Check that the extrinsic ID was restored.

		EObject obj = resource.getContents().get(0);
		String id = ((XMLResource) resource).getID(obj);
		assertThat(id, equalTo(authorID));
	}

	@Ignore
	@Test
	public void testLargeDatabase() throws IOException
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		int numberObjects = 1000000;
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < numberObjects; i++)
		{
			Person person = ModelFactory.eINSTANCE.createPerson();
			person.setName("Person " + i);
			Resource resource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.PERSON));
			resource.getContents().add(person);
			resource.save(null);

			resourceSet.getResources().clear();

			if ((i % (numberObjects / 100)) == 0)
				System.out.print(".");
		}

		System.out.println();

		long endTime = System.currentTimeMillis();
		System.out.println("Time to load " + numberObjects + " objects: " + (endTime - startTime) + "ms");
	}

	private URI createCollectionURI(EClass eClass)
	{
		return URI.createURI("mongo://localhost/junit/" + eClass.getName() + "/");
	}

	private URI createObjectURI(EClass eClass, Object id)
	{
		return createCollectionURI(eClass).trimSegments(1).appendSegment(id.toString());
	}

	private void saveObject(EObject object) throws IOException
	{
		ResourceSet resourceSet = MongoUtil.createResourceSet();
		saveObject(resourceSet, object, createCollectionURI(object.eClass()), null);
	}

	private void saveObject(ResourceSet resourceSet, EObject object) throws IOException
	{
		saveObject(resourceSet, object, createCollectionURI(object.eClass()), null);
	}

	private void saveObject(EObject object, URI uri, HashMap<String, Object> options) throws IOException
	{
		ResourceSet resourceSet = MongoUtil.createResourceSet();
		saveObject(resourceSet, object, uri, options);
	}

	private void saveObject(ResourceSet resourceSet, EObject object, URI uri, HashMap<String, Object> options) throws IOException
	{
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(object);
		resource.save(options);
	}

	private DBCollection targetCollection;
}
