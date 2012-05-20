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
 * This OSGi service configures a resource set during construction. It is
 * expected that a system may define more than one configurator and that the
 * ResourceSet factory will apply all configurators.
 * 
 * @author bhunt
 * 
 */
public interface IResourceSetConfigurator
{
	/**
	 * Configure a newly constructed ResourceSet
	 * 
	 * @param resourceSet the ResourceSet to configure
	 */
	void configureResourceSet(ResourceSet resourceSet);
}
