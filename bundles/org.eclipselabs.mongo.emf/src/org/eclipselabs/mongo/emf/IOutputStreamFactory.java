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

import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import com.mongodb.DBCollection;

/**
 * This interface provides the API for for the OutputStream factory. If you wish to use a custom OutputStream,
 * you must create a factory class for your stream that implements this interface.
 * 
 * @author bhunt
 */
public interface IOutputStreamFactory
{
	/**
	 * Constructs the OutputStream
	 * 
	 * @param uri the URI of the resource
	 * @param options the EMF load options
	 * @param collection the MongoDB collection specified in the URI
	 * @param response the EMF response
	 * @return the stream for saving the EMF object to MongoDB
	 */
	OutputStream createOutputStream(URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response);
}
