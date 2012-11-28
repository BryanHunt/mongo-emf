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

package org.eclipselabs.mongo.emf.converter;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emf.mongodb.ValueConverter;

/**
 * @author bhunt
 * 
 */
public class DefaultConverter implements ValueConverter
{
	@Override
	public Object convertMongoDBValueToEMFValue(EDataType eDataType, Object databaseValue)
	{
		return EcoreUtil.createFromString(eDataType, (String) databaseValue);
	}

	@Override
	public Object convertEMFValueToMongoDBValue(EDataType eDataType, Object emfValue)
	{
		return EcoreUtil.convertToString(eDataType, emfValue);
	}

	@Override
	public boolean isConverterForType(EDataType eDataType)
	{
		return true;
	}
}
