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

package org.eclipselabs.mongo.emf.junit.support;

import java.io.IOException;

import org.osgi.service.cm.ConfigurationAdmin;

/**
 * @author bhunt
 * 
 */
public abstract class BaseConfigurator
{
	protected abstract void configureMongoProvider(ConfigurationAdmin configurationAdmin) throws IOException;

	void bindConfigurationAdmin(ConfigurationAdmin configurationAdmin) throws IOException
	{
		configureMongoProvider(configurationAdmin);
	}
}
