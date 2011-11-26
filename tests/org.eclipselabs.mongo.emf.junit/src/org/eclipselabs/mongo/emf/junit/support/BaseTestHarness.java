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
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.junit.MongoUtil;
import org.junit.Before;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;

/**
 * @author bhunt
 * 
 */
public abstract class BaseTestHarness
{
	@Before
	public void setUp() throws UnknownHostException, MongoException
	{
		db = createDatabase();
		assertThat(db, is(notNullValue()));
	}

	protected URI createCollectionURI(EClass eClass)
	{
		return URI.createURI("mongo://localhost/junit/" + eClass.getName() + "/");
	}

	protected abstract DB createDatabase();

	protected URI createObjectURI(EClass eClass, Object id)
	{
		return createCollectionURI(eClass).trimSegments(1).appendSegment(id.toString());
	}

	protected DBCollection getCollection(EClass eClass)
	{
		return db.getCollection(eClass.getName());
	}

	protected void saveObject(EObject object) throws IOException
	{
		ResourceSet resourceSet = MongoUtil.createResourceSet();
		saveObject(resourceSet, object, createCollectionURI(object.eClass()), null);
	}

	protected void saveObject(ResourceSet resourceSet, EObject object) throws IOException
	{
		saveObject(resourceSet, object, createCollectionURI(object.eClass()), null);
	}

	protected void saveObject(EObject object, URI uri, HashMap<String, Object> options) throws IOException
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

	private DB db;
}
