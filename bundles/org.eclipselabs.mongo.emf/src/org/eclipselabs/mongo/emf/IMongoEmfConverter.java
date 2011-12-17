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
	Object convertMongoDBValueToEMFValue(EDataType eDataType, Object databaseValue);

	Object convertEMFValueToMongoDBValue(EDataType eDataType, Object emfValue);

	boolean isConverterForType(EDataType eDataType);
}
