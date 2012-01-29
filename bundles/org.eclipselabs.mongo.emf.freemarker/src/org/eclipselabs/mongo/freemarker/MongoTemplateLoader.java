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

package org.eclipselabs.mongo.freemarker;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.emf.MongoURIHandlerImpl;

import freemarker.cache.TemplateLoader;

/**
 * This class is used for loading FreeMaker templates from MongoDB. This class is also used to
 * store templates to MongoDB. When accessing the template outside of FreeMaker, you must use
 * a synchronized(resource) block for thread safety. For example:
 * 
 * <code>
 * FreeMarkerTemplate template = loader.getTemplate(id);
 * 
 * synchronized(template.eResource())
 * {
 *   template.setContents(newTemplateData);
 * }
 * </code>
 * 
 * @author bhunt
 */
public class MongoTemplateLoader implements TemplateLoader
{
	/**
	 * Constructs the template loader using an internally created resource set.
	 * 
	 * @param baseURI The base MongoDB URI up to and including the collection. For example:
	 *          mongo://localhost/db/collection. The URI must contain exactly two segments.
	 */
	public MongoTemplateLoader(URI baseURI)
	{
		if (baseURI.segmentCount() != 2)
			throw new IllegalArgumentException("The base URI: '" + baseURI + "' must contain exactly two segments");

		this.baseURI = baseURI;
		resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoURIHandlerImpl());
		loadTemplates();
	}

	/**
	 * Constructs the template loader using the user supplied resource set.
	 * 
	 * @param baseURI The base MongoDB URI up to and including the collection. For example:
	 *          mongo://localhost/db/collection. The URI must contain exactly two segments.
	 * @param resourceSet The resource set to use for loading and storing the templates.
	 */
	public MongoTemplateLoader(URI baseURI, ResourceSet resourceSet)
	{
		if (baseURI.segmentCount() != 2)
			throw new IllegalArgumentException("The base URI: '" + baseURI + "' must contain exactly two segments");

		if (resourceSet == null)
			throw new IllegalArgumentException("The resource set must not be null");

		this.baseURI = baseURI;
		this.resourceSet = resourceSet;
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoURIHandlerImpl());
		loadTemplates();
	}

	/**
	 * Adds the specified template to MongoDB.
	 * 
	 * @param id The unique ID of the template.
	 * @param template The FreeMarker template.
	 * @throws IOException If there was a problem saving the template.
	 */
	public void addTemplate(String id, FreeMarkerTemplate template) throws IOException
	{
		synchronized (resourceSet)
		{
			Resource resource = resourceSet.createResource(baseURI.appendSegment(id));
			resource.getContents().add(template);
			resource.save(null);
		}
	}

	@Override
	public void closeTemplateSource(Object templateSource) throws IOException
	{}

	@Override
	public Object findTemplateSource(String name) throws IOException
	{
		synchronized (resourceSet)
		{
			return resourceSet.getResource(baseURI.appendSegment(name), false);
		}
	}

	@Override
	public long getLastModified(Object templateSource)
	{
		Resource resource = (Resource) templateSource;

		synchronized (resource)
		{
			return resource.getTimeStamp();
		}
	}

	@Override
	public Reader getReader(Object templateSource, String encoding) throws IOException
	{
		Resource resource = (Resource) templateSource;

		synchronized (resource)
		{
			FreeMarkerTemplate template = (FreeMarkerTemplate) resource.getContents().get(0);
			return new StringReader(template.getContents());
		}

	}

	/**
	 * Gets the FreeMarker template for the specified ID.
	 * 
	 * @param id The unique ID of the template.
	 * @return the FreeMarker template for the specified ID or null if not found.
	 * @throws IOException If there was a problem loading the template.
	 */
	public FreeMarkerTemplate getTemplate(String id) throws IOException
	{
		Resource resource = (Resource) findTemplateSource(id);

		if (resource == null)
			return null;

		synchronized (resource)
		{
			return resource.getContents().isEmpty() ? null : (FreeMarkerTemplate) resource.getContents().get(0);
		}
	}

	/**
	 * Gets the entire list of FreeMarker templates
	 * 
	 * @return All of the FreeMarker templates.
	 */
	public Collection<FreeMarkerTemplate> getTemplates()
	{
		ArrayList<FreeMarkerTemplate> templates = new ArrayList<FreeMarkerTemplate>();

		synchronized (resourceSet)
		{
			for (Resource resource : resourceSet.getResources())
			{
				EObject eObject = resource.getContents().get(0);

				if (eObject instanceof FreeMarkerTemplate)
					templates.add((FreeMarkerTemplate) eObject);
			}
		}

		return templates;
	}

	public void loadTemplates()
	{
		Resource resource = resourceSet.getResource(baseURI.appendSegment("").appendQuery(""), true);
		Result result = (Result) resource.getContents().get(0);
		EcoreUtil.resolveAll(result);
		resourceSet.getResources().remove(0);
	}

	/**
	 * Removed the FreeMarker template for the specified ID.
	 * 
	 * @param id The unique ID of the template.
	 * @throws IOException If the template could not be found or there was a problem deleting the
	 *           template.
	 */
	public void removeTemplate(String id) throws IOException
	{
		synchronized (resourceSet)
		{
			Resource resource = (Resource) findTemplateSource(id);

			if (resource == null)
				throw new IOException("Template was not found");

			resource.delete(null);
		}
	}

	/**
	 * Overwrites an existing template with a new version
	 * 
	 * @param template The new template to store to the database.
	 * @throws IOException If there was a problem saving the template.
	 */
	public void updateTemplate(FreeMarkerTemplate template) throws IOException
	{
		synchronized (resourceSet)
		{
			FreeMarkerTemplate targetTemplate = getTemplate(template.eResource().getURI().segment(2));

			if (targetTemplate == null)
				throw new IOException("Template was not found");

			targetTemplate.eResource().getContents().set(0, template);
			targetTemplate.eResource().save(null);
		}
	}

	private URI baseURI;
	private ResourceSet resourceSet;
}
