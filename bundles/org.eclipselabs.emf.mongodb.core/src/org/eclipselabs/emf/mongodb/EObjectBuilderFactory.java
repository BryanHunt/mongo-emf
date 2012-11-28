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

package org.eclipselabs.emf.mongodb;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * This interface provides the API for for the EObjectBuilder factory. If you wish to use a custom EObjectBuilder,
 * you must create a factory class for your builder that implements this interface.
 * 
 * @author bhunt
 */
public interface EObjectBuilderFactory
{
	/**
	 * Constructs an EObjectBuilder
	 * 
	 * @param converterService the converter service to use for converting non-native values
	 * @param uriHandler the uri handler to use for creating relative URIs
	 * @param includeAttributesForProxyReferences true indicate that attribute values must be included on proxy references; false otherwise
	 * @param eClassCache the optional EClass cache to use - may be null
	 * @return the EObject builder
	 */
	EObjectBuilder createObjectBuilder(ConverterService converterService, XMLResource.URIHandler uriHandler, boolean includeAttributesForProxyReferences, Map<String, EClass> eClassCache);
}
