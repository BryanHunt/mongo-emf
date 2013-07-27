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

import java.io.IOException;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;

/**
 * @author bhunt
 * 
 */
public class MongoUtils
{
	/**
	 * This function extracts the object ID from the given URI. The URI path must have exactly 3 segments and be of the form
	 * mongodb://host:[port]/database/collection/{id} where id is optional.
	 * 
	 * @param uri
	 * @return the object ID from the given URI or null if the id was not specified
	 * @throws IOException if the URI path is not exactly three segments
	 */
	public static Object getID(URI uri) throws IOException
	{
		// Require that the URI path has the form /database/collection/{id} making the id segment # 2.

		if (uri.segmentCount() != 3)
			throw new IOException("The URI is not of the form 'mongo:/database/collection/{id}");

		String id = uri.segment(2);

		// If the ID was specified in the URI, we first attempt to create a MongoDB ObjectId. If
		// that fails, we assume that the client has specified a non ObjectId and return the raw data.

		try
		{
			return id.isEmpty() ? null : new ObjectId(id);
		}
		catch (Throwable t)
		{
			return id;
		}
	}

	/**
	 * This function determines whether or not the given EDataType can be represented natively by MongoDB.
	 * 
	 * @param dataType the EMF data type to check
	 * @return true if the data type can be represneted natively by MongoDB; false otherwise
	 */
	public static boolean isNativeType(EDataType dataType)
	{
		String instanceClassName = dataType.getInstanceClassName();
		//@formatter:off
		return
			instanceClassName == "java.lang.String"  ||
			instanceClassName == "int"               ||
			instanceClassName == "boolean"           ||
			instanceClassName == "float"             ||
			instanceClassName == "long"              ||
			instanceClassName == "double"            ||
			instanceClassName == "java.util.Date"    ||
			instanceClassName == "short"             ||
			instanceClassName == "byte[]"            ||
			instanceClassName == "byte"              ||
			instanceClassName == "java.lang.Integer" ||
			instanceClassName == "java.lang.Boolean" ||
			instanceClassName == "java.lang.Long"    ||
			instanceClassName == "java.lang.Float"   ||
			instanceClassName == "java.lang.Double"  ||
			instanceClassName == "java.lang.Short"   ||
			instanceClassName == "java.lang.Byte";
		//@formatter:on
	}

	private MongoUtils()
	{}
}
