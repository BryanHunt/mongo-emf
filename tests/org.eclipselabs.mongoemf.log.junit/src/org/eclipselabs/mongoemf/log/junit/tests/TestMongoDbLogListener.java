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
import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emodeling.ResourceSetFactory;
import org.eclipselabs.emodeling.log.LogEntry;
import org.eclipselabs.emodeling.log.LogLevel;
import org.eclipselabs.emongo.MongoClientProvider;
import org.eclipselabs.emongo.junit.util.MongoDatabase;
import org.eclipselabs.eunit.junit.utils.ServiceLocator;
import org.eclipselabs.mongoemf.log.junit.support.EChecker;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.log.LogService;

/**
 * @author bhunt
 * 
 */
public class TestMongoDbLogListener
{
	@Rule
	public MongoDatabase DB = new MongoDatabase();

	@Rule
	public ServiceLocator<LogService> logServiceLocator = new ServiceLocator<LogService>(LogService.class);

	@Rule
	public ServiceLocator<ResourceSetFactory> resourceSetFactoryLocator = new ServiceLocator<ResourceSetFactory>(ResourceSetFactory.class);

	@Rule
	public ServiceLocator<ConfigurationAdmin> configurationAdminLocator = new ServiceLocator<ConfigurationAdmin>(ConfigurationAdmin.class);

	private static final String DB_LOGS = "logs";
	private LogService osgiLogService;
	private ResourceSetFactory resourceSetFactory;
	private ConfigurationAdmin configurationAdmin;

	@Before
	public void setUp() throws IOException
	{
		osgiLogService = logServiceLocator.getService();
		resourceSetFactory = resourceSetFactoryLocator.getService();
		configurationAdmin = configurationAdminLocator.getService();

		Configuration config = configurationAdmin.createFactoryConfiguration("org.eclipselabs.emongo.clientProvider", null);

		Dictionary<String, Object> properties = new Hashtable<String, Object>();

		properties.put(MongoClientProvider.PROP_CLIENT_ID, "junit");
		properties.put(MongoClientProvider.PROP_URI, "mongodb://localhost");
		properties.put("type", "mongo");
		config.update(properties);

		config = configurationAdmin.createFactoryConfiguration("org.eclipselabs.emongo.databaseConfigurationProvider", null);
		properties = new Hashtable<String, Object>();
		properties.put("client_id", "junit");
		properties.put("alias", "junit");
		properties.put("database", "junit");
		config.update(properties);
	}

	@Test
	public void testLogDebug() throws InterruptedException, IOException
	{
		setLogLevel(LogLevel.DEBUG);
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
		setLogLevel(LogLevel.ERROR);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_ERROR, "error");
		Thread.sleep(200);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("error"));
	}

	@Test
	public void testLogInfo() throws InterruptedException, IOException
	{
		setLogLevel(LogLevel.INFO);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_INFO, "info");
		Thread.sleep(200);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("info"));
	}

	@Test
	public void testLogWarning() throws InterruptedException, IOException
	{
		setLogLevel(LogLevel.WARNING);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_ERROR, "warning");
		Thread.sleep(200);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("warning"));
	}

	@Test
	public void testLogFilteredEntry() throws InterruptedException, IOException
	{
		setLogLevel(LogLevel.ERROR);
		Thread.sleep(100);
		osgiLogService.log(LogService.LOG_WARNING, "error");
		Thread.sleep(200);
		LogEntry logEntry = EChecker.getObject(createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(nullValue()));
	}

	private ResourceSet createResourceSet()
	{
		return resourceSetFactory.createResourceSet();
	}

	private void setLogLevel(LogLevel logLevel) throws IOException
	{
		Configuration configuration = configurationAdmin.getConfiguration("org.eclipselabs.mongoemf.log", null);
		Hashtable<String, Object> properties = new Hashtable<String, Object>();
		properties.put("uri", "mongodb://localhost/junit/logs/");
		properties.put("logLevel", logLevel.getValue());
		configuration.update(properties);
	}
}
