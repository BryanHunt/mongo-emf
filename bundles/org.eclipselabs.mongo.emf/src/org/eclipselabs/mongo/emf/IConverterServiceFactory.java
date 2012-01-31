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

/**
 * This interface provides the API for the converter service factory. If you wish to use a custom
 * converter service, you must create a factory class for your service that implements this interface.
 * 
 * @author bhunt
 */
public interface IConverterServiceFactory
{
	/**
	 * Constructs a converter service
	 * 
	 * @return an instance of your custom converter service
	 */
	IConverterService createConverterService();
}
