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

package org.eclipselabs.mongoemf.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emongo.MongoIdFactory;
import org.eclipselabs.mongoemf.ConverterService;
import org.eclipselabs.mongoemf.DBObjectBuilderFactory;
import org.eclipselabs.mongoemf.EObjectBuilderFactory;
import org.eclipselabs.mongoemf.InputStreamFactory;
import org.eclipselabs.mongoemf.OutputStreamFactory;
import org.eclipselabs.mongoemf.QueryEngine;

import com.mongodb.DBCollection;

/**
 * @author bhunt
 * 
 */
public class DefaultStreamFactory implements InputStreamFactory, OutputStreamFactory
{
	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response)
	{
		return new MongoOutputStream(converterService, dbObjectBuilderFactory, collection, uri, idFactories, options, response);
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response) throws IOException
	{
		return new MongoInputStream(converterService, eObjectBuilderFactory, queryEngine, collection, uri, options, response);
	}

	public void bindConverterService(ConverterService converterService)
	{
		this.converterService = converterService;
	}

	public void bindDBObjectBuilderFactory(DBObjectBuilderFactory dbObjectBuilderFactory)
	{
		this.dbObjectBuilderFactory = dbObjectBuilderFactory;
	}

	public void bindEObjectBuilderFactory(EObjectBuilderFactory eObjectBuilderFactory)
	{
		this.eObjectBuilderFactory = eObjectBuilderFactory;
	}

	public void bindQueryEngine(QueryEngine queryEngine)
	{
		this.queryEngine = queryEngine;
	}

	public synchronized void bindMongoIdFactory(MongoIdFactory mongoIdFactory)
	{
		idFactories.put(mongoIdFactory.getCollectionURI(), mongoIdFactory);
	}

	public void unbindMongoIdFactory(MongoIdFactory mongoIdFactory)
	{
		MongoIdFactory target = idFactories.get(mongoIdFactory.getCollectionURI());

		if (mongoIdFactory == target)
			idFactories.remove(mongoIdFactory.getCollectionURI());
	}

	private DBObjectBuilderFactory dbObjectBuilderFactory;
	private EObjectBuilderFactory eObjectBuilderFactory;
	private QueryEngine queryEngine;
	private ConverterService converterService;
	private volatile Map<String, MongoIdFactory> idFactories;
}
