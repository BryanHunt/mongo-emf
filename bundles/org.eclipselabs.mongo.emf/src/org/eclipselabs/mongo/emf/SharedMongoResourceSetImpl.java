/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt and Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt and Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This implementation of ResourceSet gives better performance when loading many
 * EMF objects in conjunction with URI normalization. If your URI converter
 * normalizes the URI to another form, then this resource set will load resources
 * with O(n) complexity whereas the default ResourceSetImpl will load resources
 * with O(n^2) complexity.
 * 
 * @author bhunt
 * 
 */
public class SharedMongoResourceSetImpl extends MongoResourceSetImpl
{
	public SharedMongoResourceSetImpl()
	{
		// Call getResources() to create the resources instance in the base class.
		// We will synchronize on the instance variable later, so it must be created now.

		getResources();
	}

	@Override
	public Resource createResource(URI uri, String contentType)
	{
		Resource.Factory resourceFactory = getResourceFactoryRegistry().getFactory(uri, contentType);

		if (resourceFactory != null)
		{
			Resource result = resourceFactory.createResource(uri);
			EList<Resource> localResources = getResources();

			synchronized (localResources)
			{
				localResources.add(result);
			}

			return result;
		}
		else
		{
			return null;
		}
	}

	@Override
	public synchronized Resource getResource(URI uri, boolean loadOnDemand)
	{
		URI normalizedURI = uriConverter.normalize(uri);
		Resource resource = getCachedResource(normalizedURI);

		if (resource != null)
		{
			if (loadOnDemand && !resource.isLoaded())
				demandLoadHelper(resource);
		}
		else
		{
			resource = delegatedGetResource(uri, loadOnDemand);

			if (resource == null && loadOnDemand)
			{
				resource = demandCreateResource(uri);

				if (resource == null)
					throw new RuntimeException("Cannot create a resource for '" + uri + "'; a registered resource factory is needed");

				demandLoadHelper(resource);
			}
		}

		return resource;
	}

	protected void addCachedResource(URI uri, Resource resource)
	{
		synchronized (uriResourceMap)
		{
			uriResourceMap.put(uri, resource);
		}
	}

	protected Resource getCachedResource(URI uri)
	{
		synchronized (uriResourceMap)
		{
			return uriResourceMap.get(uri);
		}
	}

	protected void removeCachedResource(URI uri)
	{
		synchronized (uriResourceMap)
		{
			uriResourceMap.remove(uri);
		}
	}
}
