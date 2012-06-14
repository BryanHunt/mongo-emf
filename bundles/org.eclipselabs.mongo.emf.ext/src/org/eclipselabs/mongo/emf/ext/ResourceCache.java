/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf.ext;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author bhunt
 * 
 */
public abstract class ResourceCache
{
	protected ResourceSet getResourceSet()
	{
		if (resourceSet == null)
		{
			IResourceSetFactory factory = resourceSetFactory;

			if (factory != null)
				resourceSet = factory.createResourceSet();
		}

		return resourceSet;
	}

	public void bindResourceSetFactory(IResourceSetFactory resourceSetFactory)
	{
		this.resourceSetFactory = resourceSetFactory;
	}

	public void unbindResourceSetFactory(IResourceSetFactory resourceSetFactory)
	{
		if (resourceSetFactory == this.resourceSetFactory)
			this.resourceSetFactory = null;
	}

	private volatile IResourceSetFactory resourceSetFactory;
	private ResourceSet resourceSet;
}
