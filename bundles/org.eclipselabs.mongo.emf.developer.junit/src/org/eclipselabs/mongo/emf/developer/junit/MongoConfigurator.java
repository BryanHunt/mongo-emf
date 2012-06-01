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

package org.eclipselabs.mongo.emf.developer.junit;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipselabs.mongo.IMongoProvider;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

/**
 * This class configures a Mongo driver to connect to MongoDB running on localhost. This
 * class should be registered as an OSGi component (declarative service) dependent on
 * ConfigurationAdmin
 * 
 * @author bhunt
 */
public class MongoConfigurator
{
	void activate() throws IOException
	{
		Configuration config = configurationAdmin.createFactoryConfiguration("org.eclipselabs.mongo.provider", null);
		Dictionary<String, Object> properties = new Hashtable<String, Object>();
		properties.put(IMongoProvider.PROP_URI, "mongodb://localhost/");
		config.update(properties);
	}

	void bindConfigurationAdmin(ConfigurationAdmin configurationAdmin)
	{
		this.configurationAdmin = configurationAdmin;
	}

	private ConfigurationAdmin configurationAdmin;
}
