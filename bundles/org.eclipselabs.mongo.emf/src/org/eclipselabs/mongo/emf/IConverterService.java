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

import org.eclipse.emf.ecore.EDataType;

/**
 * @author bhunt
 * 
 */
public interface IConverterService
{

	/**
	 * Adds the converter and makes it available for consideration when serializing and de-serializing an object.
	 * Converters are considered in the order in which they are added with the last one added being first. The
	 * default converter is added by the constructor and will therefore be considered last. The first converter
	 * where isConverterForType() returns true is the one used to convert the value.
	 * 
	 * @param converter the converter to add
	 */
	void addConverter(IMongoEmfConverter converter);

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
	 * This function converts the raw value read from MongoDB into the correct type for
	 * the given datatype.
	 * 
	 * @param eDataType the EMF datatype to convert to
	 * @param value the raw MongoDB value to convert from
	 * @return the converted value
	 */
	Object convertMongoDBValueToEMFValue(EDataType eDataType, Object value);

	/**
	 * Locates an appropriate converter for a given EDataType
	 * 
	 * @param eDataType the data type needing conversion
	 * @return the converter for the specified data type
	 */
	IMongoEmfConverter getConverter(EDataType eDataType);

	/**
	 * Removes the converter and the converter will no longer be considered during serialization and de-serialization of an object.
	 * 
	 * @param converter the converter to remove
	 */
	void removeConverter(IMongoEmfConverter converter);

}