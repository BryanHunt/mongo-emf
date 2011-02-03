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

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;
import org.eclipselabs.mongo.emf.junit.internal.Activator;
import org.eclipselabs.mongo.emf.junit.model.Book;
import org.eclipselabs.mongo.emf.junit.model.ETypes;
import org.eclipselabs.mongo.emf.junit.model.Library;
import org.eclipselabs.mongo.emf.junit.model.Location;
import org.eclipselabs.mongo.emf.junit.model.MappedLibrary;
import org.eclipselabs.mongo.emf.junit.model.ModelFactory;
import org.eclipselabs.mongo.emf.junit.model.ModelPackage;
import org.eclipselabs.mongo.emf.junit.model.Person;
import org.eclipselabs.mongo.junit.MongoDatabase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
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

		mongo = mongoService.getMongo(new MongoURI("mongodb://localhost"));
		assertThat(mongo, is(notNullValue()));

		db = mongo.getDB("junit");
		assertThat(db, is(notNullValue()));

		typesCollection = db.getCollection(ModelPackage.Literals.ETYPES.getName());
		personCollection = db.getCollection(ModelPackage.Literals.PERSON.getName());
		libraryCollection = db.getCollection(ModelPackage.Literals.LIBRARY.getName());
		locationCollection = db.getCollection(ModelPackage.Literals.LOCATION.getName());

		personCollection.ensureIndex(ModelPackage.Literals.PERSON__NAME.getName());
	}

	@Test
	public void testSaveTypes() throws IOException
	{
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

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.ETYPES));
		resource.getContents().add(eTypes);
		resource.save(null);

		assertThat(typesCollection.getCount(), is(1L));
		assertThat(resource.getURI().segmentCount(), is(3));
		assertThat(resource.getURI().segment(2), is(notNullValue()));
	}

	@Test
	public void testSaveMultiplicityManyAttribute() throws IOException
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Book book = ModelFactory.eINSTANCE.createBook();
		book.setTitle("Title");
		book.getTags().add("tag1");
		book.getTags().add("tag2");
		book.getData().add('1');
		book.getData().add('2');

		Resource resource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.BOOK));
		resource.getContents().add(book);
		resource.save(null);

		ResourceSet testResourceSet = new ResourceSetImpl();
		uriHandlers = testResourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		URI uri = createCollectionURI(ModelPackage.Literals.BOOK).trimSegments(1).appendSegment(resource.getURI().segment(2));
		Resource targetResource = testResourceSet.getResource(uri, true);
		assertThat(targetResource, is(notNullValue()));
		assertThat(targetResource.getContents().size(), is(1));
		Book actualBook = (Book) targetResource.getContents().get(0);
		assertThat(actualBook.getTags().size(), is(2));
		assertThat(actualBook.getTags().get(0), is(book.getTags().get(0)));
		assertThat(actualBook.getTags().get(1), is(book.getTags().get(1)));
		assertThat(actualBook.getData().size(), is(2));
		assertThat(actualBook.getData().get(0), is(book.getData().get(0)));
		assertThat(actualBook.getData().get(1), is(book.getData().get(1)));
	}

	@Test
	public void testLoadTypes()
	{
		BasicDBObject object = new BasicDBObject();
		object.put("_timeStamp", System.currentTimeMillis());
		object.put("_eClass", EcoreUtil.getURI(ModelPackage.Literals.ETYPES).toString());

		BigDecimal bigDecimal = new BigDecimal(1);
		BigInteger bigInteger = new BigInteger(2, new Random());

		object.put(ModelPackage.Literals.ETYPES__EBIG_DECIMAL.getName(), bigDecimal.toString());
		object.put(ModelPackage.Literals.ETYPES__EBIG_INTEGER.getName(), bigInteger.toString());
		object.put(ModelPackage.Literals.ETYPES__EBOOLEAN.getName(), true);
		object.put(ModelPackage.Literals.ETYPES__EBYTE.getName(), new Byte((byte) 1));
		object.put(ModelPackage.Literals.ETYPES__EBYTE_ARRAY.getName(), new byte[] { 1, 2 });
		object.put(ModelPackage.Literals.ETYPES__ECHAR.getName(), new Character('j').toString());
		object.put(ModelPackage.Literals.ETYPES__EDATE.getName(), new Date());
		object.put(ModelPackage.Literals.ETYPES__EDOUBLE.getName(), new Double(1.0));
		object.put(ModelPackage.Literals.ETYPES__EFLOAT.getName(), new Float(1.0));
		object.put(ModelPackage.Literals.ETYPES__EINT.getName(), new Integer(1));
		object.put(ModelPackage.Literals.ETYPES__ELONG.getName(), new Long(1L));
		object.put(ModelPackage.Literals.ETYPES__ESHORT.getName(), new Short((short) 1).toString());
		object.put(ModelPackage.Literals.ETYPES__ESTRING.getName(), "j");

		typesCollection.insert(object);

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.getResource(createObjectURI(ModelPackage.Literals.ETYPES, (ObjectId) object.get(ID_KEY)), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		assertThat(resource.getContents().get(0), is(instanceOf(ETypes.class)));
		ETypes eTypes = (ETypes) resource.getContents().get(0);
		assertThat(eTypes.getEBigDecimal(), is(bigDecimal));
		assertThat(eTypes.getEBigInteger(), is(bigInteger));
		assertTrue(eTypes.isEBoolean());
		assertThat(eTypes.getEByte(), is((byte) 1));
		assertThat(eTypes.getEChar(), is('j'));
		assertThat(eTypes.getEInt(), is(1));
		assertThat(eTypes.getELong(), is(1L));
		assertThat(eTypes.getEShort(), is((short) 1));
		assertThat(eTypes.getEString(), is("j"));
	}

	@Test
	public void testSaveAuthorWithID() throws IOException
	{
		Person author = ModelFactory.eINSTANCE.createPerson();
		author.setName("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		ObjectId id = new ObjectId(new Date());
		Resource resource = resourceSet.createResource(createObjectURI(ModelPackage.Literals.PERSON, id));
		resource.getContents().add(author);
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(MongoDBURIHandlerImpl.OPTION_GENERATE_ID, Boolean.FALSE);
		long initialTimeStamp = resource.getTimeStamp();
		resource.save(options);
		long finalTimeStamp = resource.getTimeStamp();

		assertThat(initialTimeStamp < finalTimeStamp, is(true));
		assertThat(personCollection.getCount(), is(1L));
		assertThat(resource.getURI().segmentCount(), is(3));
		assertThat(resource.getURI().segment(2), is(notNullValue()));

	}

	@Test(expected = IOException.class)
	public void testSaveWithShortURI() throws IOException
	{
		Person author = ModelFactory.eINSTANCE.createPerson();
		author.setName("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.createResource(URI.createURI("mongo://localhost/collection"));
		resource.getContents().add(author);
		resource.save(null);
	}

	@Test(expected = IOException.class)
	public void testSaveWithLongURI() throws IOException
	{
		Person author = ModelFactory.eINSTANCE.createPerson();
		author.setName("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.createResource(URI.createURI("mongo://localhost/resources/junit/collection/id"));
		resource.getContents().add(author);
		resource.save(null);
	}

	@Test
	public void tesetLoadAuthor()
	{
		BasicDBObject object = createAuthor("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.getResource(createObjectURI(ModelPackage.Literals.PERSON, (ObjectId) object.get(ID_KEY)), true);
		assertThat(resource.getTimeStamp() > 0, is(true));
		assertThat(resource.getTimeStamp() <= System.currentTimeMillis(), is(true));
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		assertThat(resource.getContents().get(0), is(instanceOf(Person.class)));
		Person author = (Person) resource.getContents().get(0);
		assertThat(author.getName(), is(object.get(ModelPackage.Literals.PERSON__NAME.getName())));
	}

	@Test
	public void testDeleteAuthor() throws IOException
	{
		BasicDBObject object = new BasicDBObject();
		object.put(ModelPackage.Literals.BOOK__TITLE.getName(), "Stephen King");
		personCollection.insert(object);
		assertThat(personCollection.getCount(), is(1L));

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.createResource(createObjectURI(ModelPackage.Literals.PERSON, (ObjectId) object.get(ID_KEY)));
		resource.delete(null);

		assertThat(personCollection.getCount(), is(0L));

	}

	@Test
	public void testSaveLibrary() throws IOException
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Library library = ModelFactory.eINSTANCE.createLibrary();

		Location location = ModelFactory.eINSTANCE.createLocation();
		location.setAddress("Wastelands");
		library.setLocation(location);

		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setName("Stephen King");

		Resource personResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.PERSON));
		personResource.getContents().add(person);
		personResource.save(null);

		Book book = ModelFactory.eINSTANCE.createBook();
		book.setTitle("The Gunslinger");
		library.getBooks().add(book);
		book.getAuthors().add(person);
		location.setFeaturedBook(book);

		Resource libraryResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.LIBRARY));
		libraryResource.getContents().add(library);
		libraryResource.save(null);

		Resource locationResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.LOCATION));
		locationResource.getContents().add(location);
		locationResource.save(null);

		libraryResource.save(null);
		personResource.save(null);

		assertThat(location.getId(), is(notNullValue()));

		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			libraryResource.save(out, null);

			ResourceSet testResourceSet = new ResourceSetImpl();
			uriHandlers = testResourceSet.getURIConverter().getURIHandlers();
			uriHandlers.add(0, new MongoDBURIHandlerImpl());

			testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Person/"), personResource.getURI().trimSegments(1).appendSegment(""));
			testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Location/"), locationResource.getURI().trimSegments(1).appendSegment(""));
			Resource libraryXMI = new XMIResourceFactoryImpl().createResource(URI.createURI("library.xmi"));
			testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../../Library").appendSegment(libraryResource.getURI().lastSegment()), libraryXMI.getURI());
			testResourceSet.getResources().add(libraryXMI);

			libraryXMI.load(new ByteArrayInputStream(out.toByteArray()), null);
			assertThat(EcoreUtil.equals(libraryXMI.getContents().get(0), libraryResource.getContents().get(0)), is(true));
		}

		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_BINARY, Boolean.TRUE);
			libraryResource.save(out, options);

			{

				ResourceSet testResourceSet = new ResourceSetImpl();
				uriHandlers = testResourceSet.getURIConverter().getURIHandlers();
				uriHandlers.add(0, new MongoDBURIHandlerImpl());

				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Person/"), personResource.getURI().trimSegments(1).appendSegment(""));
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Location/"), locationResource.getURI().trimSegments(1).appendSegment(""));

				Resource libraryBinary = new BinaryResourceImpl(URI.createURI("library.binary"));
				testResourceSet.getResources().add(libraryBinary);
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../../Library").appendSegment(libraryResource.getURI().lastSegment()), libraryBinary.getURI());

				libraryBinary.load(new ByteArrayInputStream(out.toByteArray()), null);
				assertThat(EcoreUtil.equals(libraryBinary.getContents().get(0), libraryResource.getContents().get(0)), is(true));
			}
			{

				ResourceSet testResourceSet = new ResourceSetImpl();
				uriHandlers = testResourceSet.getURIConverter().getURIHandlers();
				uriHandlers.add(0, new MongoDBURIHandlerImpl());

				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Person/"), personResource.getURI().trimSegments(1).appendSegment(""));
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Location/"), locationResource.getURI().trimSegments(1).appendSegment(""));

				Resource libraryXMI = new XMIResourceFactoryImpl().createResource(URI.createURI("library.mongo.binary"));
				testResourceSet.getResources().add(libraryXMI);
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../../Library").appendSegment(libraryResource.getURI().lastSegment()), libraryXMI.getURI());

				libraryXMI.load(new ByteArrayInputStream(out.toByteArray()), options);
				assertThat(EcoreUtil.equals(libraryXMI.getContents().get(0), libraryResource.getContents().get(0)), is(true));
			}
		}

		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_SUPPRESS_XMI, Boolean.TRUE);
			libraryResource.save(out, options);

			{
				ResourceSet testResourceSet = new ResourceSetImpl();
				uriHandlers = testResourceSet.getURIConverter().getURIHandlers();
				uriHandlers.add(0, new MongoDBURIHandlerImpl());

				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Person/"), personResource.getURI().trimSegments(1).appendSegment(""));
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Location/"), locationResource.getURI().trimSegments(1).appendSegment(""));

				Resource libraryXML = new XMLResourceFactoryImpl().createResource(URI.createURI("library.xml"));
				testResourceSet.getResources().add(libraryXML);
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../../Library").appendSegment(libraryResource.getURI().lastSegment()), libraryXML.getURI());

				libraryXML.load(new ByteArrayInputStream(out.toByteArray()), null);
				assertThat(EcoreUtil.equals(libraryXML.getContents().get(0), libraryResource.getContents().get(0)), is(true));
			}
			{
				ResourceSet testResourceSet = new ResourceSetImpl();
				uriHandlers = testResourceSet.getURIConverter().getURIHandlers();
				uriHandlers.add(0, new MongoDBURIHandlerImpl());

				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Person/"), personResource.getURI().trimSegments(1).appendSegment(""));
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../Location/"), locationResource.getURI().trimSegments(1).appendSegment(""));

				Resource libraryXMI = new XMIResourceFactoryImpl().createResource(URI.createURI("library.mongo.xml"));
				testResourceSet.getResources().add(libraryXMI);
				testResourceSet.getURIConverter().getURIMap().put(URI.createURI("../../Library").appendSegment(libraryResource.getURI().lastSegment()), libraryXMI.getURI());

				libraryXMI.load(new ByteArrayInputStream(out.toByteArray()), options);
				assertThat(EcoreUtil.equals(libraryXMI.getContents().get(0), libraryResource.getContents().get(0)), is(true));
			}
		}

		assertThat(libraryCollection.getCount(), is(1L));
		assertThat(libraryResource.getURI().segmentCount(), is(3));
		assertThat(libraryResource.getURI().segment(2), is(notNullValue()));

		DBObject dbLibrary = libraryCollection.findOne();
		DBRef dbLocation = (DBRef) dbLibrary.get(ModelPackage.Literals.LIBRARY__LOCATION.getName());
		assertThat(dbLocation, is(notNullValue()));
		@SuppressWarnings("unchecked")
		List<DBObject> books = (List<DBObject>) libraryCollection.findOne().get(ModelPackage.Literals.LIBRARY__BOOKS.getName());
		assertThat(books, is(notNullValue()));
		assertThat(books.size(), is(1));
		DBObject dbBook = books.get(0);
		assertThat(dbBook, is(notNullValue()));
		assertThat((String) dbBook.get(ModelPackage.Literals.BOOK__TITLE.getName()), is(book.getTitle()));
		@SuppressWarnings("unchecked")
		List<DBRef> authors = (List<DBRef>) dbBook.get(ModelPackage.Literals.BOOK__AUTHORS.getName());
		assertThat(authors, is(notNullValue()));
		assertThat(authors.size(), is(1));

		DBObject dbPerson = personCollection.findOne();
		assertThat(dbPerson, is(notNullValue()));
		@SuppressWarnings("unchecked")
		List<DBObject> bookReferences = (List<DBObject>) dbPerson.get(ModelPackage.Literals.PERSON__BOOKS.getName());
		assertThat(bookReferences, is(notNullValue()));
		assertThat(bookReferences.size(), is(1));

		ResourceSet testResourceSet = new ResourceSetImpl();
		uriHandlers = testResourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource testResource = testResourceSet.getResource(libraryResource.getURI(), true);
		assertThat(testResource.getContents().size(), is(1));
		Library actualLibrary = (Library) testResource.getContents().get(0);
		assertThat(actualLibrary.getLocation(), is(notNullValue()));
		assertThat(actualLibrary.getLocation().getId(), is(location.getId()));
		assertThat(actualLibrary.getLocation().getAddress(), is(location.getAddress()));
		assertThat(actualLibrary.getLocation().getFeaturedBook().getTitle(), is(book.getTitle()));
	}

	@Test
	public void testLoadLibrary()
	{
		DBObject libraryObject = createLibrary("Wastelands");
		DBObject authorObject = createAuthor("Stephen King");
		ArrayList<DBObject> authors = new ArrayList<DBObject>();
		authors.add(authorObject);
		createBook(libraryObject, "The Gunslinger", authors);

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.getResource(createObjectURI(ModelPackage.Literals.LIBRARY, (ObjectId) libraryObject.get(ID_KEY)), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Library library = (Library) resource.getContents().get(0);

		assertThat(library.getLocation(), is(notNullValue()));
		assertThat(library.getLocation().getAddress(), is("Wastelands"));

		assertThat(library.getBooks().size(), is(1));
		Book book = library.getBooks().get(0);
		assertThat(book.getTitle(), is("The Gunslinger"));
		assertThat(book.getAuthors().size(), is(1));
		Person author = book.getAuthors().get(0);
		assertThat(author.getName(), is("Stephen King"));
		assertThat(author.getBooks().size(), is(1));
		assertThat(author.getBooks().get(0), is(book));
	}

	@Test
	public void testUpdateAttribute() throws IOException
	{
		DBObject authorObject = createAuthor("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource resource = resourceSet.getResource(createObjectURI(ModelPackage.Literals.PERSON, (ObjectId) authorObject.get(ID_KEY)), true);
		Person author = (Person) resource.getContents().get(0);
		author.setName("Tom Clancy");
		resource.save(null);

		assertThat(personCollection.getCount(), is(1L));
		DBObject testObject = personCollection.findOne();
		assertThat((String) testObject.get(ModelPackage.Literals.PERSON__NAME.getName()), is(author.getName()));

	}

	@Test
	public void testSaveUpdateLoad() throws IOException
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Library library = ModelFactory.eINSTANCE.createLibrary();
		Resource libraryResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.LIBRARY));
		libraryResource.getContents().add(library);
		libraryResource.save(null);

		Location location = ModelFactory.eINSTANCE.createLocation();
		location.setAddress("Austin, TX");
		Resource locationResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.LOCATION));
		locationResource.getContents().add(location);
		locationResource.save(null);

		library.setLocation(location);
		libraryResource.save(null);
		assertThat(libraryCollection.getCount(), is(1L));

		Person author = ModelFactory.eINSTANCE.createPerson();
		author.setName("Tom Clancy");
		Resource authorResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.PERSON));
		authorResource.getContents().add(author);
		authorResource.save(null);

		Book book1 = ModelFactory.eINSTANCE.createBook();
		book1.setTitle("The Hunt for Red October");
		book1.getAuthors().add(author);

		library.getBooks().add(book1);
		libraryResource.save(null);
		assertThat(libraryCollection.getCount(), is(1L));

		Book book2 = ModelFactory.eINSTANCE.createBook();
		book2.setTitle("The Cardinal of the Kremlin");
		book2.getAuthors().add(author);
		library.getBooks().add(book2);

		Book book3 = ModelFactory.eINSTANCE.createBook();
		book3.setTitle("Without Remorse");
		book3.getAuthors().add(author);
		library.getBooks().add(book3);

		libraryResource.save(null);
		assertThat(libraryCollection.getCount(), is(1L));
		authorResource.save(null);

		ObjectId libraryID = new ObjectId(libraryResource.getURI().segment(2));
		ResourceSet targetResourceSet = new ResourceSetImpl();
		uriHandlers = targetResourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource targetLibraryResource = targetResourceSet.getResource(createObjectURI(ModelPackage.Literals.LIBRARY, libraryID), true);

		assertThat(targetLibraryResource, is(notNullValue()));
		assertThat(targetLibraryResource.getContents().size(), is(1));
		Library targetLibrary = (Library) targetLibraryResource.getContents().get(0);

		assertThat(targetLibrary.getLocation(), is(notNullValue()));
		assertThat(targetLibrary.getLocation().getAddress(), is(location.getAddress()));

		assertThat(targetLibrary.getBooks().size(), is(3));
		assertThat(targetLibrary.getBooks().get(0).getTitle(), is(book1.getTitle()));
		assertThat(targetLibrary.getBooks().get(0).getAuthors().size(), is(1));
		assertThat(targetLibrary.getBooks().get(0).getAuthors().get(0).getName(), is(author.getName()));

		assertThat(targetLibrary.getBooks().get(1).getTitle(), is(book2.getTitle()));
		assertThat(targetLibrary.getBooks().get(1).getAuthors().size(), is(1));
		assertThat(targetLibrary.getBooks().get(1).getAuthors().get(0).getName(), is(author.getName()));

		assertThat(targetLibrary.getBooks().get(2).getTitle(), is(book3.getTitle()));
		assertThat(targetLibrary.getBooks().get(2).getAuthors().size(), is(1));
		assertThat(targetLibrary.getBooks().get(2).getAuthors().get(0).getName(), is(author.getName()));

		ObjectId authorID = new ObjectId(authorResource.getURI().segment(2));
		Resource targetPersonResource = targetResourceSet.getResource(createObjectURI(ModelPackage.Literals.PERSON, authorID), true);
		assertThat(targetPersonResource, is(notNullValue()));
		assertThat(targetPersonResource.getContents().size(), is(1));
		Person targetAuthor = (Person) targetPersonResource.getContents().get(0);
		assertThat(targetAuthor.getBooks().size(), is(3));
		assertThat(targetAuthor.getBooks().get(0), is(sameInstance(targetLibrary.getBooks().get(0))));
		assertThat(targetAuthor.getBooks().get(1), is(sameInstance(targetLibrary.getBooks().get(1))));
		assertThat(targetAuthor.getBooks().get(2), is(sameInstance(targetLibrary.getBooks().get(2))));
	}

	@Test
	public void testExternalReference() throws IOException
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Person author = ModelFactory.eINSTANCE.createPerson();
		author.setName("Ed Merks");
		Resource authorResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.PERSON));
		authorResource.getContents().add(author);

		URI bookURI = URI.createFileURI(temporaryFolder.newFile("book.xml").getAbsolutePath());
		Resource bookResource = resourceSet.createResource(bookURI);
		Book book = ModelFactory.eINSTANCE.createBook();
		book.setTitle("Eclipse Modeling Framework");
		book.getAuthors().add(author);
		bookResource.getContents().add(book);

		authorResource.save(null);
		bookResource.save(null);
		authorResource.save(null);

		ResourceSet targetResourceSet = new ResourceSetImpl();
		uriHandlers = targetResourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		ObjectId authorID = new ObjectId(authorResource.getURI().segment(2));
		Resource targetAuthorResource = targetResourceSet.getResource(createObjectURI(ModelPackage.Literals.PERSON, authorID), true);
		assertThat(targetAuthorResource, is(notNullValue()));
		assertThat(targetAuthorResource.getContents().size(), is(1));
		Person targetAuthor = (Person) targetAuthorResource.getContents().get(0);
		assertThat(targetAuthor.getBooks().size(), is(1));
		Book targetBook = targetAuthor.getBooks().get(0);
		assertThat(targetBook.getTitle(), is(book.getTitle()));
	}

	@Test
	public void testLoadNonexistentResource()
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createObjectURI(ModelPackage.Literals.LIBRARY, new ObjectId()), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(0));
	}

	@Test
	public void testQueryAllLibraries()
	{
		createLibrary("Wastelands");
		createLibrary("Badlands");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, ""), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(2));
		Library library1 = (Library) result.getValues().get(0);
		Library library2 = (Library) result.getValues().get(1);

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

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "books.title == 'Gunslinger'"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(2));
		Library library1 = (Library) result.getValues().get(0);
		Library library2 = (Library) result.getValues().get(1);

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

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "(books.title == 'Gunslinger') || (books.title == 'The Shining') || (books.title == 'Thinner')"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(3));
		Library library1 = (Library) result.getValues().get(0);
		Library library2 = (Library) result.getValues().get(1);
		Library library3 = (Library) result.getValues().get(2);

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

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "(books.title == 'Gunslinger') && (books.title == 'The Shining') && (books.title == 'Thinner')"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(1));
		Library library1 = (Library) result.getValues().get(0);

		assertThat(library1.getLocation(), is(notNullValue()));
		assertThat(library1.getLocation().getAddress(), is("Wetlands"));
	}

	@Test
	public void testQueryPersonNullName()
	{
		createAuthor(null);
		createAuthor("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "name == null"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(1));
		Person person = (Person) result.getValues().get(0);
		assertThat(person.getName(), is((String) null));
	}

	@Test
	public void testQueryPersonNonNullName()
	{
		createAuthor(null);
		createAuthor("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "name != null"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(1));
		Person person = (Person) result.getValues().get(0);
		assertThat(person.getName(), is("Stephen King"));
	}

	@Test
	public void testQueryPersonNotEqual()
	{
		createAuthor("Bryan Hunt");
		createAuthor("Dean Kontz");
		createAuthor("Ed Merks");
		createAuthor("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "(name != 'Dean Kontz') && (name != 'Stephen King') && (name != 'Bryan Hunt')"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(1));
		Person person = (Person) result.getValues().get(0);
		assertThat(person.getName(), is("Ed Merks"));
	}

	@Test
	public void testQueryLibraryID()
	{
		DBObject libraryObject = createLibrary("Wastelands");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.LIBRARY, "_id=='" + libraryObject.get(ID_KEY) + "'"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(1));
		Library library = (Library) result.getValues().get(0);

		assertThat(library.getLocation(), is(notNullValue()));
		assertThat(library.getLocation().getAddress(), is("Wastelands"));
	}

	@Test
	public void testQueryPerson()
	{
		createAuthor("Stephen King");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		Resource resource = resourceSet.getResource(createQueryURI(ModelPackage.Literals.PERSON, "name=='Stephen King'"), true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));

		Result result = (Result) resource.getContents().get(0);
		assertThat(result.getValues().size(), is(1));
		Person author = (Person) result.getValues().get(0);

		assertThat(author.getName(), is("Stephen King"));
	}

	@Test
	public void testFeatureMap() throws IOException
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		MappedLibrary library = ModelFactory.eINSTANCE.createMappedLibrary();
		Resource libraryResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.LIBRARY));
		libraryResource.getContents().add(library);

		Location location = ModelFactory.eINSTANCE.createLocation();
		location.setAddress("Austin, TX");
		Resource locationResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.LOCATION));
		locationResource.getContents().add(location);
		locationResource.save(null);
		library.setLocation(location);

		Person author = ModelFactory.eINSTANCE.createPerson();
		author.setName("Tom Clancy");
		Resource authorResource = resourceSet.createResource(createCollectionURI(ModelPackage.Literals.PERSON));
		authorResource.getContents().add(author);
		authorResource.save(null);

		Book book1 = ModelFactory.eINSTANCE.createBook();
		book1.setTitle("The Hunt for Red October");
		book1.getAuthors().add(author);
		library.getRegularBooks().add(book1);

		Book book2 = ModelFactory.eINSTANCE.createBook();
		book2.setTitle("The Cardinal of the Kremlin");
		book2.getAuthors().add(author);
		library.getRareBooks().add(book2);

		Book book3 = ModelFactory.eINSTANCE.createBook();
		book3.setTitle("Without Remorse");
		book3.getAuthors().add(author);
		library.getRareBooks().add(book3);

		libraryResource.save(null);
		assertThat(libraryCollection.getCount(), is(1L));
		authorResource.save(null);

		ObjectId libraryID = new ObjectId(libraryResource.getURI().segment(2));
		ResourceSet targetResourceSet = new ResourceSetImpl();
		uriHandlers = targetResourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		Resource targetLibraryResource = targetResourceSet.getResource(createObjectURI(ModelPackage.Literals.LIBRARY, libraryID), true);

		assertThat(targetLibraryResource, is(notNullValue()));
		assertThat(targetLibraryResource.getContents().size(), is(1));
		MappedLibrary targetLibrary = (MappedLibrary) targetLibraryResource.getContents().get(0);

		assertThat(targetLibrary.getLocation(), is(notNullValue()));
		assertThat(targetLibrary.getLocation().getAddress(), is(location.getAddress()));

		assertThat(targetLibrary.getBooks().size(), is(3));

		assertThat(targetLibrary.getRegularBooks().size(), is(1));
		assertThat(targetLibrary.getRegularBooks().get(0).getTitle(), is(book1.getTitle()));
		assertThat(targetLibrary.getRegularBooks().get(0).getAuthors().size(), is(1));
		assertThat(targetLibrary.getRegularBooks().get(0).getAuthors().get(0).getName(), is(author.getName()));

		assertThat(targetLibrary.getRareBooks().size(), is(2));
		assertThat(targetLibrary.getRareBooks().get(0).getTitle(), is(book2.getTitle()));
		assertThat(targetLibrary.getRareBooks().get(0).getAuthors().size(), is(1));
		assertThat(targetLibrary.getRareBooks().get(0).getAuthors().get(0).getName(), is(author.getName()));

		assertThat(targetLibrary.getRareBooks().get(1).getTitle(), is(book3.getTitle()));
		assertThat(targetLibrary.getRareBooks().get(1).getAuthors().size(), is(1));
		assertThat(targetLibrary.getRareBooks().get(1).getAuthors().get(0).getName(), is(author.getName()));

		ObjectId authorID = new ObjectId(authorResource.getURI().segment(2));
		Resource targetPersonResource = targetResourceSet.getResource(createObjectURI(ModelPackage.Literals.PERSON, authorID), true);
		assertThat(targetPersonResource, is(notNullValue()));
		assertThat(targetPersonResource.getContents().size(), is(1));
		Person targetAuthor = (Person) targetPersonResource.getContents().get(0);
		assertThat(targetAuthor.getBooks().size(), is(3));
		assertThat(targetAuthor.getBooks().get(0), is(sameInstance(targetLibrary.getRegularBooks().get(0))));
		assertThat(targetAuthor.getBooks().get(1), is(sameInstance(targetLibrary.getRareBooks().get(0))));
		assertThat(targetAuthor.getBooks().get(2), is(sameInstance(targetLibrary.getRareBooks().get(1))));

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

		startTime = System.currentTimeMillis();
		DBObject person = personCollection.findOne(new BasicDBObject("name", "Person 203500"));
		assertThat(person, is(notNullValue()));
		endTime = System.currentTimeMillis();
		System.out.println("Time to find: " + (endTime - startTime) + "ms");
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

		ArrayList<DBRef> authorsReferences = new ArrayList<DBRef>();

		for (DBObject author : authors)
			authorsReferences.add(new DBRef(db, ModelPackage.Literals.PERSON.getName(), author.get(ID_KEY)));

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
			proxy.put("_eProxyURI", "../../../junit/Library/" + library.get("_id") + "#//@books." + (bookReferences.size()));
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
		libraryObject.put(ModelPackage.Literals.LIBRARY__LOCATION.getName(), new DBRef(db, ModelPackage.Literals.LOCATION.getName(), locationObject.get(ID_KEY)));

		libraryCollection.insert(libraryObject);
		assertThat(libraryCollection.getCount(), is(libraryCount + 1));
		return libraryObject;
	}

	private URI createCollectionURI(EClass eClass)
	{
		return URI.createURI("mongo://localhost/junit/" + eClass.getName() + "/");
	}

	private URI createObjectURI(EClass eClass, ObjectId id)
	{
		return createCollectionURI(eClass).trimSegments(1).appendSegment(id.toString());
	}

	private URI createQueryURI(EClass eClass, String query)
	{
		return createCollectionURI(eClass).appendQuery(URI.encodeQuery(query, false));
	}

	private static final String ID_KEY = "_id";

	private DBCollection typesCollection;
	private DBCollection personCollection;
	private DBCollection libraryCollection;
	private DBCollection locationCollection;
	private DB db;

	private Mongo mongo;
}
