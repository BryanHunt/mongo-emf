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

import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class MongoQuery
{
	/**
	 * @param objectFilter the object filter
	 * @param fieldFilter the field filter
	 */
	public MongoQuery(DBObject objectFilter, DBObject fieldFilter)
	{
		this.objectFilter = objectFilter;
		this.fieldFilter = fieldFilter;
	}

	/**
	 * @return the objectFilter
	 */
	public DBObject getObjectFilter()
	{
		return objectFilter;
	}

	/**
	 * @return the fieldFilter
	 */
	public DBObject getFieldFilter()
	{
		return fieldFilter;
	}

	private DBObject objectFilter;
	private DBObject fieldFilter;
}
