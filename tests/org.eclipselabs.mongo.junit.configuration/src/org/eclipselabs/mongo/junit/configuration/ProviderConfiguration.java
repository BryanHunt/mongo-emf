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

package org.eclipselabs.mongo.junit.configuration;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipselabs.emongo.MongoProvider;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

/**
 * @author bhunt
 * 
 */
public class ProviderConfiguration
{
	private ConfigurationAdmin configurationAdmin;

	void activate() throws IOException
	{
		Configuration config = configurationAdmin.getConfiguration("org.eclipselabs.mongo.provider", null);

		Dictionary<String, Object> properties = config.getProperties();

		if (properties == null)
			properties = new Hashtable<String, Object>();

		properties.put(MongoProvider.PROP_URI, "mongodb://localhost/");
		config.update(properties);
	}

	void bindConfigurationAdmin(ConfigurationAdmin configurationAdmin)
	{
		this.configurationAdmin = configurationAdmin;
	}
}
