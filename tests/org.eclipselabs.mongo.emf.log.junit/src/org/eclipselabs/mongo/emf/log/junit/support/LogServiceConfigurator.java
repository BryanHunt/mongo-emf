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

package org.eclipselabs.mongo.emf.log.junit.support;

import java.io.IOException;
import java.util.Hashtable;

import org.eclipselabs.mongo.emf.log.LogLevel;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

/**
 * @author bhunt
 * 
 */
public class LogServiceConfigurator
{
	void bindConfigurationAdmin(ConfigurationAdmin configurationAdmin) throws IOException
	{
		Configuration configuration = configurationAdmin.getConfiguration("org.eclipselabs.mongo.emf.log", null);
		Hashtable<String, Object> properties = new Hashtable<String, Object>();
		properties.put("uri", "mongodb://localhost/junit/logs/");
		properties.put("logLevel", LogLevel.LOG_INFO.getValue());
		configuration.update(properties);
	}
}
