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

package org.eclipselabs.mongo.emf.bundle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.IDBObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IEObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IInputStreamFactory;
import org.eclipselabs.mongo.emf.IQueryEngine;
import org.eclipselabs.mongo.emf.IOutputStreamFactory;

import com.mongodb.DBCollection;

/**
 * @author bhunt
 * 
 */
public class DefaultStreamFactory implements IInputStreamFactory, IOutputStreamFactory
{
	@Override
	public OutputStream createOutputStream(IConverterService converterService, IDBObjectBuilderFactory dbObjectBuilderFactory, URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response)
	{
		return new MongoOutputStream(converterService, dbObjectBuilderFactory, collection, uri, options, response);
	}

	@Override
	public InputStream createInputStream(IConverterService converterService, IEObjectBuilderFactory eObjectBuilderFactory, IQueryEngine queryEngine, URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response) throws IOException
	{
		return new MongoInputStream(converterService, eObjectBuilderFactory, queryEngine, collection, uri, options, response);
	}
}
