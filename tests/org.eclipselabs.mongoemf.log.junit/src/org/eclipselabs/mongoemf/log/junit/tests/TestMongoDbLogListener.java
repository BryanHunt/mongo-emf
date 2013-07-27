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

package org.eclipselabs.mongoemf.log.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceSetFactory;
import org.eclipselabs.emodeling.log.LogEntry;
import org.eclipselabs.emodeling.log.LogLevel;
import org.eclipselabs.emongo.junit.util.MongoDatabase;
import org.eclipselabs.eunit.junit.utils.ServiceLocator;
import org.eclipselabs.mongoemf.log.junit.support.EChecker;
import org.eclipselabs.mongoemf.log.junit.support.ILogServiceConfigurator;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.osgi.service.log.LogService;

/**
 * @author bhunt
 * 
 */
public class TestMongoDbLogListener
{
	@Rule
	public static final MongoDatabase DB = new MongoDatabase();

	@Rule
	public static final ServiceLocator<LogService> logServiceLocator = new ServiceLocator<LogService>(LogService.class);

	@Rule
	public static final ServiceLocator<ILogServiceConfigurator> logServiceConfiguratorLocator = new ServiceLocator<ILogServiceConfigurator>(ILogServiceConfigurator.class);

	@Rule
	public static final ServiceLocator<ResourceSetFactory> resourceSetFactoryLocator = new ServiceLocator<ResourceSetFactory>(ResourceSetFactory.class);

	@BeforeClass
	public void globalSetUp()
	{
		osgiLogService = logServiceLocator.getService();
		resourceSetFactory = resourceSetFactoryLocator.getService();
		logServiceConfigurator = logServiceConfiguratorLocator.getService();
	}

	@Test
	public void testLogDebug() throws InterruptedException, IOException
	{
		logServiceConfigurator.setLogLevel(LogLevel.DEBUG);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_DEBUG, "debug");
		Thread.sleep(200);
		Collection<LogEntry> logEntries = EChecker.getObjects(createResourceSet(), "junit", DB_LOGS);

		for (LogEntry entry : logEntries)
		{
			if (entry.getLevel() == LogLevel.DEBUG)
				return;
		}

		fail("Could not find DEBUG log message");
	}

	@Test
	public void testLogError() throws InterruptedException, IOException
	{
		logServiceConfigurator.setLogLevel(LogLevel.ERROR);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_ERROR, "error");
		Thread.sleep(100);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("error"));
	}

	@Test
	public void testLogInfo() throws InterruptedException, IOException
	{
		logServiceConfigurator.setLogLevel(LogLevel.INFO);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_INFO, "info");
		Thread.sleep(100);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("info"));
	}

	@Test
	public void testLogWarning() throws InterruptedException, IOException
	{
		logServiceConfigurator.setLogLevel(LogLevel.WARNING);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_ERROR, "warning");
		Thread.sleep(100);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("warning"));
	}

	@Test
	public void testLogFilteredEntry() throws InterruptedException, IOException
	{
		logServiceConfigurator.setLogLevel(LogLevel.ERROR);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_WARNING, "error");
		Thread.sleep(100);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(nullValue()));
	}

	private ResourceSet createResourceSet()
	{
		return resourceSetFactory.createResourceSet();
	}

	private static final String DB_LOGS = "logs";
	private static LogService osgiLogService;
	private static ResourceSetFactory resourceSetFactory;
	private static ILogServiceConfigurator logServiceConfigurator;
}
