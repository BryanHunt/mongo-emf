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

package org.eclipselabs.mongo.emf.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.IDBObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IEObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IInputStreamFactory;
import org.eclipselabs.mongo.emf.IOutputStreamFactory;
import org.eclipselabs.mongo.emf.IQueryEngine;

import com.mongodb.DBCollection;

/**
 * @author bhunt
 * 
 */
public class DefaultStreamFactory implements IInputStreamFactory, IOutputStreamFactory
{
	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response)
	{
		return new MongoOutputStream(converterService, dbObjectBuilderFactory, collection, uri, options, response);
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response) throws IOException
	{
		return new MongoInputStream(converterService, eObjectBuilderFactory, queryEngine, collection, uri, options, response);
	}

	public void bindConverterService(IConverterService converterService)
	{
		this.converterService = converterService;
	}

	public void bindDBObjectBuilderFactory(IDBObjectBuilderFactory dbObjectBuilderFactory)
	{
		this.dbObjectBuilderFactory = dbObjectBuilderFactory;
	}

	public void bindEObjectBuilderFactory(IEObjectBuilderFactory eObjectBuilderFactory)
	{
		this.eObjectBuilderFactory = eObjectBuilderFactory;
	}

	public void bindQueryEngine(IQueryEngine queryEngine)
	{
		this.queryEngine = queryEngine;
	}

	private IDBObjectBuilderFactory dbObjectBuilderFactory;
	private IEObjectBuilderFactory eObjectBuilderFactory;
	private IQueryEngine queryEngine;
	private IConverterService converterService;
}
