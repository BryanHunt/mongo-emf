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

package org.eclipselabs.mongo.emf.junit.support;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.emf.developer.junit.MongoDatabase;
import org.eclipselabs.mongo.emf.ext.IResourceSetFactory;
import org.junit.Before;
import org.junit.Rule;

import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * @author bhunt
 * 
 */
public abstract class TestHarness
{
	@Rule
	public MongoDatabase database = new MongoDatabase();

	public TestHarness()
	{}

	public TestHarness(int port)
	{
		this.port = port;
	}

	@Before
	public void setUp() throws UnknownHostException
	{
		db = database.getMongoDB();
		assertThat(db, is(notNullValue()));
	}

	protected URI createCollectionURI(EClass eClass)
	{
		return URI.createURI("mongodb://localhost" + (port != null ? ":" + port : "") + "/junit/" + eClass.getName() + "/");
	}

	protected URI createObjectURI(EClass eClass, Object id)
	{
		return createCollectionURI(eClass).trimSegments(1).appendSegment(id.toString());
	}

	protected DBCollection getCollection(EClass eClass)
	{
		return db.getCollection(eClass.getName());
	}

	protected ResourceSet createResourceSet()
	{
		return resourceSetFactory.createResourceSet();
	}

	protected void saveObject(EObject object) throws IOException
	{
		ResourceSet resourceSet = createResourceSet();
		saveObject(resourceSet, object, createCollectionURI(object.eClass()), null);
	}

	protected void saveObject(ResourceSet resourceSet, EObject object) throws IOException
	{
		saveObject(resourceSet, object, createCollectionURI(object.eClass()), null);
	}

	protected void saveObject(EObject object, URI uri, Map<String, Object> options) throws IOException
	{
		ResourceSet resourceSet = createResourceSet();
		saveObject(resourceSet, object, uri, options);
	}

	public void bindResourceSetFactory(IResourceSetFactory factory)
	{
		resourceSetFactory = factory;
	}

	private void saveObject(ResourceSet resourceSet, EObject object, URI uri, Map<String, Object> options) throws IOException
	{
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(object);
		resource.save(options);
	}

	private DB db;
	private Integer port;
	private static IResourceSetFactory resourceSetFactory;
}
