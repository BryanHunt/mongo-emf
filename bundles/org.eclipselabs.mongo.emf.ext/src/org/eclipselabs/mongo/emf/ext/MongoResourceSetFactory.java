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

import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;

/**
 * @author bhunt
 * 
 */
public class MongoResourceSetFactory implements IResourceSetFactory
{
	@Override
	public ResourceSet createResourceSet()
	{
		MongoResourceSetImpl resourceSet = new MongoResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();

		for (IUriHandlerProvider provider : providers)
			uriHandlers.add(0, provider.getURIHandler());

		return resourceSet;
	}

	public void bindUriHandlerProvider(IUriHandlerProvider handlerProvider)
	{
		providers.add(handlerProvider);
	}

	public void unbindUriHandlerProvider(IUriHandlerProvider handlerProvider)
	{
		providers.remove(handlerProvider);
	}

	private HashSet<IUriHandlerProvider> providers = new HashSet<IUriHandlerProvider>();
}
