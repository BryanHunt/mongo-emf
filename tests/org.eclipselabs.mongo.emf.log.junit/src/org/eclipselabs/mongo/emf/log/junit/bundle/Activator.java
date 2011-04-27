
package org.eclipselabs.mongo.emf.log.junit.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
	public static Activator getInstance()
	{
		return instance;
	}

	public BundleContext getContext()
	{
		return context;
	}

	public LogService getLogService()
	{
		try
		{
			return logServiceTracker.waitForService(2000);
		}
		catch (InterruptedException e)
		{
			return null;
		}
	}

	public LogReaderService getLogReaderService()
	{
		try
		{
			return logReaderServiceTracker.waitForService(2000);
		}
		catch (InterruptedException e)
		{
			return null;
		}
	}

	@Override
	public void start(BundleContext context) throws Exception
	{
		logReaderServiceTracker = new ServiceTracker<LogReaderService, LogReaderService>(context, LogReaderService.class, null);
		logReaderServiceTracker.open();

		logServiceTracker = new ServiceTracker<LogService, LogService>(context, LogService.class, null);
		logServiceTracker.open();

		this.context = context;
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		if (logReaderServiceTracker != null)
			logReaderServiceTracker.close();

		if (logServiceTracker != null)
			logServiceTracker.close();
	}

	private static Activator instance;
	private BundleContext context;
	private ServiceTracker<LogReaderService, LogReaderService> logReaderServiceTracker;
	private ServiceTracker<LogService, LogService> logServiceTracker;

}
