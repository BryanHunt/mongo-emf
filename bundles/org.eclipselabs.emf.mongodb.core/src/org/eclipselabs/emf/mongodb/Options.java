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

import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

/**
 * @author bhunt
 * 
 */
public interface Options
{

	/**
	 * When you load an object with cross-document references, they will be proxies. When you access the reference, EMF will resolve the proxy and you can then access the attributes. This can cause
	 * performance problems for example when expanding a tree where you only need a name attribute to display the children and then only resolve the next child to be expanded. Setting this option to
	 * Boolean.TRUE will cause the proxy instance to have its attribute values populated so that you can display the child names in the tree without resolving the proxy.
	 * 
	 * Value type: Boolean
	 */
	String OPTION_PROXY_ATTRIBUTES = BinaryResourceImpl.OPTION_STYLE_PROXY_ATTRIBUTES;

	/**
	 * EMF's default serialization is designed to conserve space by not serializing attributes that are set to their default value. This is a problem when attempting to query objects by an attributes
	 * default value. By setting this option to Boolean.TRUE, all attribute values will be stored to MongoDB.
	 * 
	 * Value type: Boolean
	 */
	String OPTION_SERIALIZE_DEFAULT_ATTRIBUTE_VALUES = "SERIALIZE_DEFAULT_ATTRIBUTE_VALUES";

	/**
	 * If it is set to Boolean.TRUE and the ID was not specified in the URI, the value of the ID attribute will be used as the MongoDB _id if it exists.
	 * 
	 * Value type: Boolean
	 */
	String OPTION_USE_ID_ATTRIBUTE_AS_PRIMARY_KEY = "USE_ID_ATTRIBUTE_AS_PRIMARY_KEY";

	/**
	 * If set, the value must be an instance of WriteConcern and will be passed to MongoDB when the object is inserted into the database, or updated.
	 * 
	 * Value type: WriteConcern
	 */
	String OPTION_WRITE_CONCERN = "WRITE_CONCERN";

	/**
	 * If set to Boolean.TRUE, a query will return a MongoCursor instead of a Result
	 * 
	 * Value type: Boolean
	 */
	String OPTION_QUERY_CURSOR = "QUERY_CURSOR";

	/**
	 * This option may be used when you wish to read from a particular server in a MongoDB replica set that has been tagged. <code>
	 * HashMap<String, String> tags = new HashMap<String, String>(1);
	 * tags.put("locale", "in");
	 * 
	 * resourceSet.getLoadOptions().put(MongoDBURIHandlerImpl.OPTION_TAGGED_READ_PREFERENCE, tags);
	 * </code>
	 * 
	 * Value type: Map<String, String>
	 */
// FIXME uncomment when MongoDB supports tagged reads	
//	public static final String OPTION_TAGGED_READ_PREFERENCE = "TAGGED_READ_PREFERENCE";
}
