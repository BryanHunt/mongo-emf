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

package org.eclipselabs.mongo.emf.developer.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.emf.MongoResourceSetImpl;
import org.eclipselabs.mongo.emf.MongoURIHandlerImpl;

/**
 * This class provides a set of utility functions that may be useful when unit testing.
 * 
 * @author bhunt
 */
public class MongoUtil
{
	/**
	 * This function will compare two EMF objects by walking all of the features (attributes and
	 * references) of the expected object and comparing against the corresponding features in the
	 * actual object. The algorithm is recursive so that the entire reference hierarchy is checked.
	 * The acutual object is loaded in it's own resource set using the URI from the expected object.
	 * 
	 * @param expected The reference or expected EMF object instance.
	 */
	public static <T> T checkObject(EObject expected)
	{
		return checkObject(expected, new HashSet<EStructuralFeature>());
	}

	/**
	 * This function will compare two EMF objects by walking all of the features (attributes and
	 * references) of the expected object and comparing against the corresponding features in the
	 * actual object. The algorithm is recursive so that the entire reference hierarchy is checked.
	 * The acutual object is loaded in it's own resource set using the URI from the expected object.
	 * 
	 * @param expected The reference or expected EMF object instance.
	 * @param excludedFeatures The set of features to exclude from checking.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T checkObject(EObject expected, Set<EStructuralFeature> excludedFeatures)
	{
		ResourceSet actualResourceSet = MongoUtil.createResourceSet();
		Resource actualResource = actualResourceSet.getResource(expected.eResource().getURI(), true);
		EObject actual = actualResource.getContents().get(0);
		MongoUtil.checkObject(expected, actual, excludedFeatures);
		return (T) actual;
	}

	/**
	 * This function will compare two EMF objects by walking all of the features (attributes and
	 * references) of the expected object and comparing against the corresponding features in the
	 * actual object. The algorithm is recursive so that the entire reference hierarchy is checked.
	 * 
	 * @param expected The reference or expected EMF object instance.
	 * @param actual The actual object to compare against the expected.
	 */
	public static void checkObject(EObject expected, EObject actual)
	{
		checkObject(expected, actual, new HashSet<EStructuralFeature>(), new HashSet<EObject>());
	}

	/**
	 * This function will compare two EMF objects by walking all of the features (attributes and
	 * references) of the expected object and comparing against the corresponding feature in the
	 * actual object. The algorithm is recursive so that the entire reference hierarchy is checked
	 * with the exception of the excluded references.
	 * 
	 * @param expected The reference or expected EMF object instance.
	 * @param actual The actual object to compare against the expected.
	 * @param excludedFeatures The set of features to exclude from checking.
	 */
	public static void checkObject(EObject expected, EObject actual, Set<EStructuralFeature> excludedFeatures)
	{
		checkObject(expected, actual, excludedFeatures, new HashSet<EObject>());
	}

	/**
	 * This function will configure a resource set to use with MongoDB.
	 * 
	 * @param resourceSet The resource set to configure.
	 */
	public static void configureResourceSet(ResourceSet resourceSet)
	{
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoURIHandlerImpl());
	}

	/**
	 * This function will create a resource set and configure it with the MongoDB URI handler.
	 * 
	 * @return A resource set that can be used with mongo:// URIs.
	 */
	public static ResourceSet createResourceSet()
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		configureResourceSet(resourceSet);
		return resourceSet;
	}

	/**
	 * This function will create a mongo resource set and configure it with the MongoDB URI handler.
	 * 
	 * @return A resource set that can be used with mongo:// URIs.
	 */
	public static ResourceSet createMongoResourceSet()
	{
		ResourceSet resourceSet = new MongoResourceSetImpl();
		configureResourceSet(resourceSet);
		return resourceSet;
	}

	/**
	 * This function gets the specified EMF object from MongoDB. This function assumes that MongoDB is
	 * running on localhost.
	 * 
	 * @param <T> The type of object to return.
	 * @param resourceSet The resource set to use when loading the object.
	 * @param db The name of the MongoDB database containing the object.
	 * @param collection The name of the MongoDB collection containing the object.
	 * @param id The MongoDB _id of the object.
	 * @return The EMF object or null if it was not found.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getObject(ResourceSet resourceSet, String db, String collection, String id)
	{
		Resource resource = resourceSet.getResource(URI.createURI("mongo://localhost/" + db + "/" + collection + "/" + id), true);

		if (resource == null || resource.getContents().isEmpty())
			return null;

		return (T) resource.getContents().get(0);
	}

	/**
	 * This function gets the specified EMF object from MongoDB. The object is located by querying all
	 * of the objects in the collection. If more than one object is found in the collection, the unit
	 * test will be failed. This function is useful when you don't have full visibility to a process
	 * that stores a single object to MongoDB. This function assumes that MongoDB is running on
	 * localhost.
	 * 
	 * @param <T> The type of object to return.
	 * @param resourceSet The resource set to use when loading the object.
	 * @param db The name of the MongoDB database containing the object.
	 * @param collection The name of the MongoDB collection containing the object.
	 * @return The EMF object or null if it was not found.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getObject(ResourceSet resourceSet, String db, String collection)
	{
		Resource resource = resourceSet.getResource(URI.createURI("mongo://localhost/" + db + "/" + collection + "/?"), true);
		assertThat(resource, is(notNullValue()));

		Result result = (Result) resource.getContents().get(0);

		if (result.getValues().isEmpty())
			return null;

		assertThat(result.getValues().size(), is(1));
		return (T) result.getValues().get(0);
	}

	/**
	 * This function gets all EMF objects in the specified collection from MongoDB. This function
	 * assumes that MongoDB is running on localhost.
	 * 
	 * @param <T> The type of object to return.
	 * @param resourceSet The resource set to use when loading the objects.
	 * @param db The name of the MongoDB database containing the objects.
	 * @param collection The name of the MongoDB collection containing the objects.
	 * @return The EMF objects in the collection.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> Collection<T> getObjects(ResourceSet resourceSet, String db, String collection)
	{
		Resource resource = resourceSet.getResource(URI.createURI("mongo://localhost/" + db + "/" + collection + "/?"), true);
		assertThat(resource, is(notNullValue()));

		Result result = (Result) resource.getContents().get(0);
		ArrayList<T> objects = new ArrayList<T>();

		for (EObject object : result.getValues())
			objects.add((T) object);

		return objects;
	}

	/**
	 * This function gets the MongoDB _id for the given object. The value is retrieved from the
	 * resource URI so the URI must have exactly 3 segments to find the ID.
	 * 
	 * @param object
	 * @return The MongoDB _id or null if it has not been set.
	 */
	public static String getID(EObject object)
	{
		Resource resource = object.eResource();

		if (resource == null)
			return null;

		URI uri = resource.getURI();

		if (uri.segmentCount() != 3)
			return null;

		return uri.segment(2);
	}

	private static void checkObject(EObject expected, EObject actual, Set<EStructuralFeature> excludeFeatures, Set<EObject> visited)
	{
		if (expected == null)
		{
			assertThat(actual, is(nullValue()));
			return;
		}

		if (visited.contains(expected))
			return;

		visited.add(expected);

		assertThat("Actual instance for type '" + expected.eClass().getName() + "' must not be null", actual, is(notNullValue()));

		for (EAttribute attribute : expected.eClass().getEAllAttributes())
		{
			if (!excludeFeatures.contains(attribute))
				assertThat("Attribute '" + attribute.getName() + "' on class '" + expected.eClass().getName() + "' did not match", actual.eGet(attribute), is(expected.eGet(attribute)));
		}

		for (EReference reference : expected.eClass().getEAllReferences())
		{
			if (excludeFeatures.contains(reference))
				continue;

			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				EList<EObject> expectedObjects = (EList<EObject>) expected.eGet(reference);
				@SuppressWarnings("unchecked")
				EList<EObject> actualObjects = (EList<EObject>) actual.eGet(reference);
				assertThat("Reference size for '" + reference.getName() + "' does not match", actualObjects.size(), is(expectedObjects.size()));

				for (int i = 0; i < expectedObjects.size(); i++)
					checkObject(expectedObjects.get(i), actualObjects.get(i), excludeFeatures, visited);
			}
			else
				checkObject((EObject) expected.eGet(reference), (EObject) actual.eGet(reference), excludeFeatures, visited);
		}
	}

	private MongoUtil()
	{}
}
