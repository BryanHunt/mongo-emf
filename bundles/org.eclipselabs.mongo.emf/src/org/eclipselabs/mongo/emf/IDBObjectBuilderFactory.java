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

import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * This interface provides the API for for the DBObjectBuilder factory. If you wish to use a custom DBObjectBuilder,
 * you must create a factory class for your builder that implements this interface.
 * 
 * @author bhunt
 */
public interface IDBObjectBuilderFactory
{
	/**
	 * Constructs a DBObjectBuilder
	 * 
	 * @param converterService the converter service to use for converting non-native values
	 * @param uriHandler the uri handler to use for creating relative URIs
	 * @param serializeDefaultAttributeValues true indicates that default attribute values must be stored in the DBObject; false otherwise
	 * @return the DBObject builder
	 */
	DBObjectBuilder createBuilder(IConverterService converterService, XMLResource.URIHandler uriHandler, boolean serializeDefaultAttributeValues);
}
