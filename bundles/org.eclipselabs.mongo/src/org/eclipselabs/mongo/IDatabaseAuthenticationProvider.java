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

package org.eclipselabs.mongo;

/**
 * @author bhunt
 * 
 */
public interface IDatabaseAuthenticationProvider
{
	public String PROP_USER = "user";
	public String PROP_PASSWORD = "password";
	public String PROP_URI = "uri";

	String getURI();

	String getUser();

	String getPassword();
}
