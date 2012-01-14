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

package org.eclipselabs.mongo.internal.emf;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EDataType;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.IMongoEmfConverter;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

/**
 * @author bhunt
 * 
 */
public class ConverterService implements IConverterService
{
	public ConverterService()
	{
		this.converters = new LinkedList<IMongoEmfConverter>();
		converters.add(new DefaultMongoEmfConverter());
	}

	@Override
	public void addConverter(IMongoEmfConverter converter)
	{
		// The converter must be added at the beginning of the list so that the default converter is considered last

		converters.addFirst(converter);
	}

	@Override
	public Object convertEMFValueToMongoDBValue(EDataType eDataType, Object emfValue)
	{
		return getConverter(eDataType).convertEMFValueToMongoDBValue(eDataType, emfValue);
	}

	@Override
	public Object convertMongoDBValueToEMFValue(EDataType eDataType, Object value)
	{
		if (!MongoDBURIHandlerImpl.isNativeType(eDataType))
		{
			// Types not native to MongoDB are stored as strings and must be converted to the proper object type by EMF

			value = getConverter(eDataType).convertMongoDBValueToEMFValue(eDataType, value);
		}
		else if (value != null)
		{
			// If the type is a byte, float, or short, it must be converted from the native MongoDB type
			// It is valid to use == for string comparison in this case.

			String instanceClassName = eDataType.getInstanceClassName();

			if (instanceClassName == "byte" || instanceClassName == "java.lang.Byte")
				value = ((Integer) value).byteValue();
			else if (instanceClassName == "float" || instanceClassName == "java.lang.Float")
				value = ((Double) value).floatValue();
			else if (instanceClassName == "short" || instanceClassName == "java.lang.Short")
				value = ((Integer) value).shortValue();
		}

		return value;
	}

	@Override
	public IMongoEmfConverter getConverter(EDataType eDataType)
	{
		for (IMongoEmfConverter converter : converters)
		{
			if (converter.isConverterForType(eDataType))
				return converter;
		}

		// We should never return null since the list of converters always contains a default converter

		throw new IllegalStateException("The default converter was not found - this should never happen");
	}

	@Override
	public void removeConverter(IMongoEmfConverter converter)
	{
		converters.remove(converter);
	}

	private LinkedList<IMongoEmfConverter> converters;
}
