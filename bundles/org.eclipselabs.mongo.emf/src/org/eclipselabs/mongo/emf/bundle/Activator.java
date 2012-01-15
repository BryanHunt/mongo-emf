/*******************************************************************************
 * Copyright (c) 2010 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf.bundle;

import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.emf.IMongoEmfQueryEngine;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
	public static Activator getInstance()
	{
		return instance;
	}

	public IMongoDB getMongoDB()
	{
		return mongoTracker.getService();
	}

	public IMongoEmfQueryEngine getQueryEngine()
	{
		return queryEngineTracker.getService();
	}

	@Override
	public void start(BundleContext context) throws Exception
	{
		mongoTracker = new ServiceTracker<IMongoDB, IMongoDB>(context, IMongoDB.class, null);
		mongoTracker.open();

		queryEngineTracker = new ServiceTracker<IMongoEmfQueryEngine, IMongoEmfQueryEngine>(context, IMongoEmfQueryEngine.class, null);
		queryEngineTracker.open();

		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		instance = null;

		if (mongoTracker != null)
			mongoTracker.close();

		if (queryEngineTracker != null)
			queryEngineTracker.close();
	}

	private static Activator instance;
	private ServiceTracker<IMongoDB, IMongoDB> mongoTracker;
	private ServiceTracker<IMongoEmfQueryEngine, IMongoEmfQueryEngine> queryEngineTracker;
}
