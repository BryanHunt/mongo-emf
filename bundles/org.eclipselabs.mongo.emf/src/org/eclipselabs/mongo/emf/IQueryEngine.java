/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf;

import org.eclipse.emf.common.util.URI;

import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public interface IQueryEngine
{
	/**
	 * This function builds a DBObject to be used as a query to MongoDB from the EMF query
	 * 
	 * @param uri the incoming URI containing the query
	 * @return the DBObject representation of the query
	 */
	DBObject buildDBObjectQuery(URI uri);
}
