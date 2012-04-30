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

package org.eclipselabs.mongo.emf.converter;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EDataType;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.IValueConverter;

/**
 * This class is thread safe
 * 
 * @author bhunt
 * 
 */
public class DefaultConverterService implements IConverterService
{
	public DefaultConverterService()
	{
		this.converters = new LinkedList<IValueConverter>();
		converters.add(new DefaultConverter());
	}

	@Override
	public synchronized void addConverter(IValueConverter converter)
	{
		// The converter must be added at the beginning of the list so that the default converter is considered last

		converters.addFirst(converter);
	}

	@Override
	public synchronized IValueConverter getConverter(EDataType eDataType)
	{
		for (IValueConverter converter : converters)
		{
			if (converter.isConverterForType(eDataType))
				return converter;
		}

		// We should never return null since the list of converters always contains a default converter

		throw new IllegalStateException("The default converter was not found - this should never happen");
	}

	@Override
	public synchronized void removeConverter(IValueConverter converter)
	{
		converters.remove(converter);
	}

	private LinkedList<IValueConverter> converters;
}
