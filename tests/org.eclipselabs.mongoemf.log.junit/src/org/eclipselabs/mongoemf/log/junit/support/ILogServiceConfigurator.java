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

package org.eclipselabs.mongoemf.log.junit.support;

import java.io.IOException;

import org.eclipselabs.emodeling.log.LogLevel;

/**
 * @author bhunt
 * 
 */
public interface ILogServiceConfigurator
{
	public void setLogLevel(LogLevel logLevel) throws IOException;
}