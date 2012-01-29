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
 * @author bhunt
 * 
 */
public interface IInputStreamFactory
{
	InputStream createInputStream(IConverterService converterService, IEObjectBuilderFactory eObjectBuilderFactory, IQueryEngine queryEngine, URI uri, Map<?, ?> options, DBCollection collection, Map<Object, Object> response) throws IOException;
}
