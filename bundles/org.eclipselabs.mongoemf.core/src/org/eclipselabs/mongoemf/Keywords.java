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

package org.eclipselabs.mongoemf;

/**
 * @author bhunt
 *
 */
public interface Keywords
{

	/**
	 * MongoDB ID field identifier. Not intended to be used by clients.
	 */
	public static final String ID_KEY = "_id";
	/**
	 * MongoDB eClass field identifier. Not intended to be used by clients.
	 */
	public static final String ECLASS_KEY = "_eClass";
	/**
	 * MongoDB eProxyURI field identifier. Not intended to be used by clients.
	 */
	public static final String PROXY_KEY = "_eProxyURI";
	/**
	 * MongoDB Extrensic ID field identifier. Not intended to be used by clients.
	 */
	public static final String EXTRINSIC_ID_KEY = "_eId";
	/**
	 * MongoDB Timestamp field identifier. Not intended to be used by clients.
	 */
	public static final String TIME_STAMP_KEY = "_timeStamp";

}
