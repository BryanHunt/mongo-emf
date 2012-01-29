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

package org.eclipselabs.mongo.emf;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * @author bhunt
 * 
 */
public interface IEObjectBuilderFactory
{
	EObjectBuilder createObjectBuilder(IConverterService converterService, XMLResource.URIHandler uriHandler, boolean includeAttributesForProxyReferences, Map<String, EClass> eClassCache);
}
