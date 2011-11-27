
package org.eclipselabs.mongo.internal;

import org.eclipselabs.mongo.IMongoDB;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{

	@Override
	public void start(BundleContext context) throws Exception
	{
		context.registerService(IMongoDB.class, new MongoDB(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{}
}
