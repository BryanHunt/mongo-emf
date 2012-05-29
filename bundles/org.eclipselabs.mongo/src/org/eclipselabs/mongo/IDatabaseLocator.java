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

package org.eclipselabs.mongo;

import com.mongodb.DB;

/**
 * This OSGi service gives clients access to a configured DB instance lookup by URI.
 * The URI may be any extension of the MongoDB database URI.
 * 
 * @author bhunt
 */
public interface IDatabaseLocator
{
	/**
	 * @param uri the URI of the database - may contain extra path information
	 * @return the database instance if found; null otherwise
	 */
	DB getDatabase(String uri);
}
