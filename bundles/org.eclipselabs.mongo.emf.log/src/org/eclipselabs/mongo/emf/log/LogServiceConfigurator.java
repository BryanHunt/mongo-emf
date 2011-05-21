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

package org.eclipselabs.mongo.emf.log;

import java.io.IOException;
import java.util.Hashtable;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.mongo.emf.log.internal.bundle.Activator;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * @author bhunt
 * 
 */
public class LogServiceConfigurator
{
	public static void configureLogService(URI baseURI, int logLevel)
	{
		if (configAdminServiceTracker == null)
		{
			configAdminServiceTracker = new ServiceTracker<ConfigurationAdmin, ConfigurationAdmin>(Activator.getBundleContext(), ConfigurationAdmin.class, new Configurator(baseURI, logLevel));
			configAdminServiceTracker.open();
		}
	}

	private LogServiceConfigurator()
	{}

	private static ServiceTracker<ConfigurationAdmin, ConfigurationAdmin> configAdminServiceTracker;

	private static class Configurator implements ServiceTrackerCustomizer<ConfigurationAdmin, ConfigurationAdmin>
	{
		public Configurator(URI baseURI, int logLevel)
		{
			this.baseURI = baseURI;
			this.logLevel = logLevel;
		}

		@Override
		public ConfigurationAdmin addingService(ServiceReference<ConfigurationAdmin> reference)
		{
			ConfigurationAdmin configAdmin = Activator.getBundleContext().getService(reference);

			try
			{
				Configuration config = configAdmin.getConfiguration("org.eclipselabs.mongo.emf.log", null);
				Hashtable<String, Object> properties = new Hashtable<String, Object>(2);
				properties.put("baseURI", baseURI.toString());
				properties.put("logLevel", Integer.valueOf(logLevel));
				config.update(properties);
			}
			catch (IOException e)
			{}

			return configAdmin;
		}

		@Override
		public void modifiedService(ServiceReference<ConfigurationAdmin> reference, ConfigurationAdmin service)
		{}

		@Override
		public void removedService(ServiceReference<ConfigurationAdmin> reference, ConfigurationAdmin service)
		{}

		private URI baseURI;
		private int logLevel;
	}
}
