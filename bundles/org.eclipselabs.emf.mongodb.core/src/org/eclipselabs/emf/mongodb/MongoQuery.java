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
	 * @param sortFilter the sort filter
	 */
	public MongoQuery(DBObject objectFilter, DBObject fieldFilter, DBObject sortFilter)
	{
		this.objectFilter = objectFilter;
		this.fieldFilter = fieldFilter;
		this.sortFilter = sortFilter;
	}

	/**
	 * @return the object filter
	 */
	public DBObject getObjectFilter()
	{
		return objectFilter;
	}

	/**
	 * @return the field filter
	 */
	public DBObject getFieldFilter()
	{
		return fieldFilter;
	}

	/**
	 * @return the sort filter
	 */
	public DBObject getSortFilter()
	{
		return sortFilter;
	}

	private DBObject objectFilter;
	private DBObject fieldFilter;
	private DBObject sortFilter;
}
