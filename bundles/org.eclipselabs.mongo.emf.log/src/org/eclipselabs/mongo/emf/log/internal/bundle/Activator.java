
package org.eclipselabs.mongo.emf.log.internal.bundle;

import org.eclipselabs.mongo.emf.log.IMongoLogService;
import org.eclipselabs.mongo.emf.log.impl.MongoEmfLogServiceProxy;
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
		context.registerService(IMongoLogService.class, new MongoEmfLogServiceProxy(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		bundleContext = null;
	}

	private static BundleContext bundleContext;
}
