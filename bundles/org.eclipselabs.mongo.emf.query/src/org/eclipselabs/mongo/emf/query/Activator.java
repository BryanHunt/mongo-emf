
package org.eclipselabs.mongo.emf.query;

import org.eclipselabs.mongo.emf.IQueryEngine;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
	public void start(BundleContext bundleContext) throws Exception
	{
		bundleContext.registerService(IQueryEngine.class, new QueryEngine(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception
	{}
}
