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

import org.eclipse.emf.ecore.EDataType;

/**
 * @author bhunt
 * 
 */
public interface IMongoEmfConverter
{
	/**
	 * Convert a value from MongoDB to a value used by EMF of the specified type.
	 * 
	 * An example might be converting a long read from MongoDB into an EDataType of
	 * java.util.Calendar.
	 * 
	 * @param eDataType the EMF type that the value needs to be converted to
	 * @param databaseValue the value read from MongoDB
	 * @return the value that will be set in the EMF object being built.
	 */
	Object convertMongoDBValueToEMFValue(EDataType eDataType, Object databaseValue);

	/**
	 * Convert a value from EMF of the specified type to a value stored in MongoDB.
	 * 
	 * An example might be converting an EDataType of java.util.Calendar to a long
	 * that is stored in MongoDB
	 * 
	 * @param eDataType the EMF type that the value needs to be converted from
	 * @param emfValue the value from the EMF object
	 * @return the value that will be stored in MongoDB
	 */
	Object convertEMFValueToMongoDBValue(EDataType eDataType, Object emfValue);

	/**
	 * Determines whether or not this converter can convert a value of a specific type.
	 * 
	 * @param eDataType the type of the value that needs to be converted
	 * @return true if this converter can handle values of the specified type; false otherwise
	 */
	boolean isConverterForType(EDataType eDataType);
}
