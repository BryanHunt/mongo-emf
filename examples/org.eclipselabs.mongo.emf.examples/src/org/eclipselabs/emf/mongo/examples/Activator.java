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

package org.eclipselabs.emf.mongo.examples;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emf.mongo.examples.model.Child;
import org.eclipselabs.emf.mongo.examples.model.ModelFactory;
import org.eclipselabs.emf.mongo.examples.model.Parent;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author bhunt
 * 
 */
public class Activator implements BundleActivator
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception
	{
		System.out.println("Starting Mongo EMF example");

		URI firstParent = null;

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 1000; i++)
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
			uriHandlers.add(0, new MongoDBURIHandlerImpl());

			Parent parent = ModelFactory.eINSTANCE.createParent();
			parent.setName("Parent " + i);

			for (int j = 0; j < 1000; j++)
			{
				Child child = ModelFactory.eINSTANCE.createChild();
				child.setName("Child " + i + " " + j);
				parent.getChildren().add(child);

				Resource resource = resourceSet.createResource(URI.createURI("mongo://localhost/test/Child"));
				resource.getContents().add(child);
				resource.save(null);
			}

			Resource resource = resourceSet.createResource(URI.createURI("mongo://localhost/test/Parent"));
			resource.getContents().add(parent);
			resource.save(null);

			if (firstParent == null)
				firstParent = resource.getURI();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Time to create objects: " + ((endTime - startTime) / 1000.0) + " sec");

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());

		startTime = System.currentTimeMillis();
		Resource resource = resourceSet.getResource(firstParent, true);
		endTime = System.currentTimeMillis();
		System.out.println("Time to get first parent: " + (endTime - startTime) + " ms");

		Parent parent = (Parent) resource.getContents().get(0);

		startTime = System.currentTimeMillis();

		for (Child child : parent.getChildren())
			child.getName();

		endTime = System.currentTimeMillis();
		System.out.println("Time to walk children: " + (endTime - startTime) + " ms");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception
	{}
}
