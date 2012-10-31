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

import java.util.Collection;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * This OSGi service builds an EMF ResourceSet.
 * 
 * @author bhunt
 * 
 */
public interface IResourceSetFactory
{
	/**
	 * 
	 * @return the newly created ResourceSet
	 */
	ResourceSet createResourceSet();

	/**
	 * @return the collection of resource set configurators currently bound to the factory
	 */
	Collection<IResourceSetConfigurator> getResourceSetConfigurators();
}
