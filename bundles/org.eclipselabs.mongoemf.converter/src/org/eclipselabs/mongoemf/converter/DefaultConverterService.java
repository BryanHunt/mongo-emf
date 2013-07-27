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

package org.eclipselabs.mongoemf.converter;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EDataType;
import org.eclipselabs.mongoemf.ConverterService;
import org.eclipselabs.mongoemf.ValueConverter;

/**
 * This class is thread safe
 * 
 * @author bhunt
 * 
 */
public class DefaultConverterService implements ConverterService
{
	public DefaultConverterService()
	{
		this.converters = new LinkedList<ValueConverter>();
		converters.add(new DefaultConverter());
	}

	@Override
	public synchronized void addConverter(ValueConverter converter)
	{
		// The converter must be added at the beginning of the list so that the default converter is considered last

		converters.addFirst(converter);
	}

	@Override
	public synchronized ValueConverter getConverter(EDataType eDataType)
	{
		for (ValueConverter converter : converters)
		{
			if (converter.isConverterForType(eDataType))
				return converter;
		}

		// We should never return null since the list of converters always contains a default converter

		throw new IllegalStateException("The default converter was not found - this should never happen");
	}

	@Override
	public synchronized void removeConverter(ValueConverter converter)
	{
		converters.remove(converter);
	}

	private LinkedList<ValueConverter> converters;
}
