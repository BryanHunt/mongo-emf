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

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.emf.developer.junit.MongoDatabase;
import org.eclipselabs.mongo.emf.developer.junit.MongoUtil;
import org.eclipselabs.mongo.emf.junit.model.ModelFactory;
import org.eclipselabs.mongo.emf.junit.model.TargetObject;
import org.eclipselabs.mongo.emf.junit.support.BaseTestHarness;
import org.junit.Rule;
import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.ServerAddress;

/**
 * This test assumes you have a MongoDB replica set running on localhost.
 * 
 * The ports are: 27020, 27021, 27022.
 * The tags are: {"locale", "us"}, {"locale", "in"}, {"locale", "de"}
 * 
 * @author bhunt
 * 
 */
public class TestMongoEmfReplica extends BaseTestHarness
{
	@Rule
	public MongoDatabase database = new MongoDatabase("localhost", 27021, "junit", replicaSet);

	public TestMongoEmfReplica()
	{
		super(27021);
	}

	@Test
	public void testReplicaRead() throws IOException
	{
		// Setup : Create a target object and ObjectId for the ID

		TargetObject targetObject = ModelFactory.eINSTANCE.createTargetObject();
		targetObject.setSingleAttribute("junit");

		// Test : Store the object to MongoDB

		saveObject(targetObject, createCollectionURI(targetObject.eClass()), null);

		// Verify : Check that the object was stored correctly

		ResourceSet actualResourceSet = MongoUtil.createResourceSet();

		HashMap<String, String> tags = new HashMap<String, String>(1);
		tags.put("locale", "in");

// FIXME uncomment when MongoDB properly supports tagged reads		
//		actualResourceSet.getLoadOptions().put(MongoDBURIHandlerImpl.OPTION_TAGGED_READ_PREFERENCE, tags);
		Resource actualResource = actualResourceSet.getResource(targetObject.eResource().getURI(), true);
		EObject actual = actualResource.getContents().get(0);
		MongoUtil.checkObject(targetObject, actual);
	}

	@Override
	protected DB createDatabase()
	{
		return database.getMongoDB();
	}

	private static List<ServerAddress> replicaSet = new ArrayList<ServerAddress>();

	static
	{
		try
		{
			replicaSet.add(new ServerAddress("localhost", 27020));
			replicaSet.add(new ServerAddress("localhost", 27021));
			replicaSet.add(new ServerAddress("localhost", 27022));
		}
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
