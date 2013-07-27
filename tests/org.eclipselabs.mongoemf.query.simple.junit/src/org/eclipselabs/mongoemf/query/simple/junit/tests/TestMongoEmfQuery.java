/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt & Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt & Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongoemf.query.simple.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emodeling.ECollection;
import org.eclipselabs.mongoemf.Options;
import org.eclipselabs.mongoemf.junit.model.ETypes;
import org.eclipselabs.mongoemf.junit.model.PrimaryObject;
import org.eclipselabs.mongoemf.junit.model.TargetObject;
import org.eclipselabs.mongoemf.junit.support.TestHarness;
import org.eclipselabs.mongoemf.query.simple.junit.model.Library;
import org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage;
import org.eclipselabs.mongoemf.query.simple.junit.model.Person;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class TestMongoEmfQuery extends TestHarness
{
	@Before
	public void setUp() throws UnknownHostException
	{
		super.setUp();

		personCollection = getCollection(ModelPackage.Literals.PERSON);
		libraryCollection = getCollection(ModelPackage.Literals.LIBRARY);
		locationCollection = getCollection(ModelPackage.Literals.LOCATION);
		personCollection.ensureIndex(ModelPackage.Literals.PERSON__NAME.getName());
	}

	@Test
	public void testQueryLibraryID()
	{
		DBObject libraryObject = createLibrary("Wastelands");

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "_id=='" + libraryObject.get(ID_KEY) + "'"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
		Library library = (Library) eCollection.getValues().get(0);

		assertThat(library.getLocation(), is(notNullValue()));
		assertThat(library.getLocation().getAddress(), is("Wastelands"));
	}

	@Test
	public void testQueryIDAttribute() throws IOException
	{
		// Setup : Create a primary object with the ID attribute set

		String id = "Attribute ID";
		PrimaryObject primaryObject = org.eclipselabs.mongoemf.junit.model.ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setIdAttribute(id);

		// Test : Store the object with the option to use the ID attribute as the MongoDB _id

		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(Options.OPTION_USE_ID_ATTRIBUTE_AS_PRIMARY_KEY, Boolean.TRUE);

		saveObject(primaryObject, createCollectionURI(primaryObject.eClass()), options);

		// Verify : Check that the object was stored correctly

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.getResource(createQueryURI(org.eclipselabs.mongoemf.junit.model.ModelPackage.Literals.PRIMARY_OBJECT, "idAttribute=='" + id + "'"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
	}

	@Test
	public void testQueryAllLibraries()
	{
		createLibrary("Wastelands");
		createLibrary("Badlands");

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, ""), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(2));
		Library library1 = (Library) eCollection.getValues().get(0);
		Library library2 = (Library) eCollection.getValues().get(1);

		assertThat(library1.getLocation(), is(notNullValue()));
		assertThat(library1.getLocation().getAddress(), is("Wastelands"));

		assertThat(library2.getLocation(), is(notNullValue()));
		assertThat(library2.getLocation().getAddress(), is("Badlands"));
	}

	@Test
	public void testQueryLibraryBooks()
	{
		BasicDBObject wastelands = createLibrary("Wastelands");
		createBook(wastelands, "Gunslinger", Collections.<DBObject> emptyList());
		BasicDBObject badlands = createLibrary("Badlands");
		createBook(badlands, "Gunslinger", Collections.<DBObject> emptyList());
		createLibrary("Wetlands");

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "books.title == 'Gunslinger'"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(2));
		Library library1 = (Library) eCollection.getValues().get(0);
		Library library2 = (Library) eCollection.getValues().get(1);

		assertThat(library1.getLocation(), is(notNullValue()));
		assertThat(library1.getLocation().getAddress(), is("Wastelands"));

		assertThat(library2.getLocation(), is(notNullValue()));
		assertThat(library2.getLocation().getAddress(), is("Badlands"));
	}

	@Test
	public void testQueryLibraryOr()
	{
		BasicDBObject wastelands = createLibrary("Wastelands");
		createBook(wastelands, "Gunslinger", Collections.<DBObject> emptyList());
		BasicDBObject badlands = createLibrary("Badlands");
		createBook(badlands, "The Shining", Collections.<DBObject> emptyList());
		BasicDBObject wetlands = createLibrary("Wetlands");
		createBook(wetlands, "Thinner", Collections.<DBObject> emptyList());

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "(books.title == 'Gunslinger') || (books.title == 'The Shining') || (books.title == 'Thinner')"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(3));
		Library library1 = (Library) eCollection.getValues().get(0);
		Library library2 = (Library) eCollection.getValues().get(1);
		Library library3 = (Library) eCollection.getValues().get(2);

		assertThat(library1.getLocation(), is(notNullValue()));
		assertThat(library1.getLocation().getAddress(), is("Wastelands"));

		assertThat(library2.getLocation(), is(notNullValue()));
		assertThat(library2.getLocation().getAddress(), is("Badlands"));

		assertThat(library3.getLocation(), is(notNullValue()));
		assertThat(library3.getLocation().getAddress(), is("Wetlands"));
	}

	@Test
	public void testQueryLibraryAnd()
	{
		BasicDBObject wastelands = createLibrary("Wastelands");
		createBook(wastelands, "Gunslinger", Collections.<DBObject> emptyList());
		BasicDBObject badlands = createLibrary("Badlands");
		createBook(badlands, "Gunslinger", Collections.<DBObject> emptyList());
		createBook(badlands, "The Shining", Collections.<DBObject> emptyList());
		BasicDBObject wetlands = createLibrary("Wetlands");
		createBook(wetlands, "Thinner", Collections.<DBObject> emptyList());
		createBook(wetlands, "Gunslinger", Collections.<DBObject> emptyList());
		createBook(wetlands, "The Shining", Collections.<DBObject> emptyList());

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "(books.title == 'Gunslinger') && (books.title == 'The Shining') && (books.title == 'Thinner')"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
		Library library1 = (Library) eCollection.getValues().get(0);

		assertThat(library1.getLocation(), is(notNullValue()));
		assertThat(library1.getLocation().getAddress(), is("Wetlands"));
	}

	@Test
	public void testQueryPersonNullName()
	{
		createAuthor(null);
		createAuthor("Stephen King");

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "name == null"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
		Person person = (Person) eCollection.getValues().get(0);
		assertThat(person.getName(), is((String) null));
	}

	@Test
	public void testQueryPersonNonNullName()
	{
		createAuthor(null);
		createAuthor("Stephen King");

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "name != null"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
		Person person = (Person) eCollection.getValues().get(0);
		assertThat(person.getName(), is("Stephen King"));
	}

	@Test
	public void testQueryPersonNotEqual()
	{
		createAuthor("Bryan Hunt");
		createAuthor("Dean Kontz");
		createAuthor("Ed Merks");
		createAuthor("Stephen King");

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "(name != 'Dean Kontz') && (name != 'Stephen King') && (name != 'Bryan Hunt')"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
		Person person = (Person) eCollection.getValues().get(0);
		assertThat(person.getName(), is("Ed Merks"));
	}

	@Test
	public void testQueryPerson()
	{
		createAuthor("Stephen King");

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "name=='Stephen King'"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
		Person author = (Person) eCollection.getValues().get(0);

		assertThat(author.getName(), is("Stephen King"));
	}

	@Test
	public void testQueryDefaultAttribute() throws IOException
	{
		ETypes eTypes = org.eclipselabs.mongoemf.junit.model.ModelFactory.eINSTANCE.createETypes();
		eTypes.setELong(1);

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.createResource(createCollectionURI(org.eclipselabs.mongoemf.junit.model.ModelPackage.Literals.ETYPES));
		resource.getContents().add(eTypes);
		HashMap<String, Object> options = new HashMap<String, Object>(1);
		options.put(Options.OPTION_SERIALIZE_DEFAULT_ATTRIBUTE_VALUES, Boolean.TRUE);
		resource.save(options);

		eTypes = org.eclipselabs.mongoemf.junit.model.ModelFactory.eINSTANCE.createETypes();
		eTypes.setEInt(1);

		resource = resourceSet.createResource(createCollectionURI(org.eclipselabs.mongoemf.junit.model.ModelPackage.Literals.ETYPES));
		resource.getContents().add(eTypes);
		resource.save(null);

		resourceSet = createResourceSet();
		resource = resourceSet.getResource(createQueryURI(org.eclipselabs.mongoemf.junit.model.ModelPackage.Literals.ETYPES, "eInt == 0"), true);
		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
		ETypes target = (ETypes) eCollection.getValues().get(0);
		assertThat(target.getEInt(), is(0));
		assertThat(target.getELong(), is(1L));
	}

	@Test
	public void testQueryDate() throws IOException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);

		ETypes eTypes = org.eclipselabs.mongoemf.junit.model.ModelFactory.eINSTANCE.createETypes();
		eTypes.setEDate(calendar.getTime());

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.createResource(createCollectionURI(org.eclipselabs.mongoemf.junit.model.ModelPackage.Literals.ETYPES));
		resource.getContents().add(eTypes);
		resource.save(null);

		resourceSet = createResourceSet();
		resource = resourceSet.getResource(
				createQueryURI(org.eclipselabs.mongoemf.junit.model.ModelPackage.Literals.ETYPES, "eDate >= " + EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.EDATE, new Date())), true);
		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(1));
	}

	@Ignore
	@Test
	public void testQueryWithInvalidOperator() throws IOException
	{
		// Setup : Create and save a target object.

		TargetObject targetObject = org.eclipselabs.mongoemf.junit.model.ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");
		saveObject(targetObject);

		// Test : Query for the object using an invalid operator - this can happen if you forget to
		// enclose the value in ''

		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.getResource(createCollectionURI(targetObject.eClass()).appendQuery(URI.encodeQuery("singleAttribute==4d", false)), true);

		// Verify : The query should not return any results;

		ECollection eCollection = (ECollection) resource.getContents().get(0);
		assertThat(eCollection.getValues().size(), is(0));
	}

	private BasicDBObject createAuthor(String name)
	{
		long count = personCollection.count();

		BasicDBObject object = new BasicDBObject();
		object.put("_timeStamp", System.currentTimeMillis());
		object.put("_eClass", EcoreUtil.getURI(ModelPackage.Literals.PERSON).toString());
		if (name != null)
		{
			object.put(ModelPackage.Literals.PERSON__NAME.getName(), name);
		}

		personCollection.insert(object);
		assertThat(personCollection.getCount(), is(count + 1));
		return object;
	}

	private DBObject createBook(DBObject library, String title, List<DBObject> authors)
	{
		BasicDBObject object = new BasicDBObject();
		object.put("_timeStamp", System.currentTimeMillis());
		object.put("_eClass", EcoreUtil.getURI(ModelPackage.Literals.BOOK).toString());
		object.put(ModelPackage.Literals.BOOK__TITLE.getName(), title);
		object.put(ModelPackage.Literals.BOOK__TAGS.getName(), new ArrayList<String>());
		object.put(ModelPackage.Literals.BOOK__DATA.getName(), new ArrayList<String>());

		ArrayList<DBObject> authorsReferences = new ArrayList<DBObject>();

		for (DBObject author : authors)
		{
			ObjectId authorId = (ObjectId) author.get(ID_KEY);
			authorsReferences.add(createProxy(ModelPackage.Literals.PERSON, "../" + personCollection.getName() + "/" + authorId + "#/"));
		}

		object.put(ModelPackage.Literals.BOOK__AUTHORS.getName(), authorsReferences);

		@SuppressWarnings("unchecked")
		List<DBObject> books = (List<DBObject>) library.get(ModelPackage.Literals.LIBRARY__BOOKS.getName());

		if (books == null)
		{
			books = new ArrayList<DBObject>();
			library.put(ModelPackage.Literals.LIBRARY__BOOKS.getName(), books);
		}

		books.add(object);
		libraryCollection.update(new BasicDBObject(ID_KEY, library.get(ID_KEY)), library);

		for (DBObject author : authors)
		{
			@SuppressWarnings("unchecked")
			ArrayList<DBObject> bookReferences = (ArrayList<DBObject>) author.get(ModelPackage.Literals.PERSON__BOOKS.getName());

			if (bookReferences == null)
			{
				bookReferences = new ArrayList<DBObject>();
				author.put(ModelPackage.Literals.PERSON__BOOKS.getName(), bookReferences);
			}

			BasicDBObject proxy = new BasicDBObject();
			proxy.put("_eProxyURI", "../Library/" + library.get("_id") + "#//@books." + (bookReferences.size()));
			proxy.put("_eClass", EcoreUtil.getURI(ModelPackage.Literals.BOOK).toString());
			bookReferences.add(proxy);
			personCollection.update(new BasicDBObject(ID_KEY, author.get(ID_KEY)), author);
		}

		return object;
	}

	private BasicDBObject createLibrary(String location)
	{
		long locationCount = locationCollection.count();
		long libraryCount = libraryCollection.count();

		BasicDBObject locationObject = new BasicDBObject();
		locationObject.put("_timeStamp", System.currentTimeMillis());
		locationObject.put("_eClass", EcoreUtil.getURI(ModelPackage.Literals.LOCATION).toString());
		locationObject.put(ModelPackage.Literals.LOCATION__ADDRESS.getName(), location);

		locationCollection.insert(locationObject);
		assertThat(locationCollection.getCount(), is(locationCount + 1));

		BasicDBObject libraryObject = new BasicDBObject();
		libraryObject.put("_timeStamp", System.currentTimeMillis());
		libraryObject.put("_eClass", EcoreUtil.getURI(ModelPackage.Literals.LIBRARY).toString());
		ObjectId locationId = (ObjectId) locationObject.get(ID_KEY);
		libraryObject.put(ModelPackage.Literals.LIBRARY__LOCATION.getName(), createProxy(ModelPackage.Literals.LOCATION, "../" + locationCollection.getName() + "/" + locationId + "#/"));

		libraryCollection.insert(libraryObject);
		assertThat(libraryCollection.getCount(), is(libraryCount + 1));
		return libraryObject;
	}

	private DBObject createProxy(EClass eClass, String proxy)
	{
		BasicDBObject proxyObject = new BasicDBObject();
		proxyObject.put("_eProxyURI", proxy);
		proxyObject.put("_eClass", EcoreUtil.getURI(eClass).toString());
		return proxyObject;
	}

	private URI createQueryURI(EClass eClass, String query)
	{
		return createCollectionURI(eClass).appendQuery(URI.encodeQuery(query, false));
	}

	private static final String ID_KEY = "_id";
	private DBCollection personCollection;
	private DBCollection libraryCollection;
	private DBCollection locationCollection;
}
