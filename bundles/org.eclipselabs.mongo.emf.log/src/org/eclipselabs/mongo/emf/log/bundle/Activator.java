
package org.eclipselabs.mongo.emf.log.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
	public static BundleContext getBundleContext()
	{
		return bundleContext;
	}

	@Override
	public void start(BundleContext context) throws Exception
	{
		bundleContext = context;
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		bundleContext = null;
	}

	private static BundleContext bundleContext;
}
