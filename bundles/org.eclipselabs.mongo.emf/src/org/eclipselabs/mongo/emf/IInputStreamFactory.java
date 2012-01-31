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

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import com.mongodb.DBCollection;

/**
 * This interface provides the API for for the InputStream factory. If you wish to use a custom InputStream,
 * you must create a factory class for your stream that implements this interface.
 * 
 * @author bhunt
 */
public interface IInputStreamFactory
{
	/**
	 * Constructs the InputStream
	 * 
	 * @param converterService the converter service to use for converting non-native values
	 * @param eObjectBuilderFactory the factory to use for creating the EObjectBuilder
	 * @param queryEngine the query engine to use for processing a query string from the URI
	 * @param uri the URI of the resource
	 * @param options the EMF load options
	 * @param collection the MongoDB collection specified in the URI
	 * @param response the EMF response
	 * @return the stream for loading an EMF object from MongoDB
	 * @throws IOException if there is a problem constructing the EMF object
	 */
	InputStream createInputStream(IConverterService converterService, IEObjectBuilderFactory eObjectBuilderFactory, IQueryEngine queryEngine, URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response) throws IOException;
}
