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

package org.eclipselabs.mongo.emf.log.junit.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emf.query.BinaryOperation;
import org.eclipselabs.emf.query.FeatureAccessor;
import org.eclipselabs.emf.query.Literal;
import org.eclipselabs.emf.query.QueryFactory;
import org.eclipselabs.mongo.emf.log.IMongoLogService;
import org.eclipselabs.mongo.emf.log.LogEntry;
import org.eclipselabs.mongo.emf.log.LogLevel;
import org.eclipselabs.mongo.emf.log.LogPackage;
import org.eclipselabs.mongo.emf.log.LogServiceConfigurator;
import org.eclipselabs.mongo.emf.log.impl.MongoEmfLogService;
import org.eclipselabs.mongo.emf.log.junit.bundle.Activator;
import org.eclipselabs.mongo.junit.MongoDatabase;
import org.eclipselabs.mongo.junit.MongoUtil;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author bhunt
 * 
 */
public class TestLogService
{
	@Rule
	public static final MongoDatabase DB = new MongoDatabase("junit");

	@BeforeClass
	public static void globalSetUp()
	{
		MongoUtil.registerMongoDBService();
		LogReaderService logReaderService = Activator.getInstance().getLogReaderService();
		assertThat(logReaderService, is(notNullValue()));
		mongoLogService = new MongoEmfLogService(URI.createURI("mongo://localhost/junit/logs/"));
		osgiLogService = Activator.getInstance().getLogService();
		logReaderService.addLogListener((LogListener) mongoLogService);
	}

	@Test
	public void testLogDebug() throws InterruptedException
	{
		mongoLogService.setLogLevel(LogLevel.LOG_DEBUG);
		osgiLogService.log(LogService.LOG_DEBUG, "debug");
		Thread.sleep(500);
		Collection<LogEntry> logEntries = MongoUtil.getObjects(MongoUtil.createResourceSet(), "junit", DB_LOGS);

		for (LogEntry entry : logEntries)
		{
			if (entry.getLevel() == LogLevel.LOG_DEBUG)
				return;
		}

		fail("Could not find DEBUG log message");
	}

	@Test
	public void testLogError() throws InterruptedException
	{
		mongoLogService.setLogLevel(LogLevel.LOG_ERROR);
		osgiLogService.log(LogService.LOG_ERROR, "error");
		Thread.sleep(100);
		LogEntry logEntry = MongoUtil.getObject(MongoUtil.createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("error"));
	}

	@Test
	public void testLogInfo() throws InterruptedException
	{
		mongoLogService.setLogLevel(LogLevel.LOG_INFO);
		osgiLogService.log(LogService.LOG_INFO, "info");
		Thread.sleep(100);
		LogEntry logEntry = MongoUtil.getObject(MongoUtil.createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("info"));
	}

	@Test
	public void testLogWarning() throws InterruptedException
	{
		mongoLogService.setLogLevel(LogLevel.LOG_WARNING);
		osgiLogService.log(LogService.LOG_ERROR, "warning");
		Thread.sleep(100);
		LogEntry logEntry = MongoUtil.getObject(MongoUtil.createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(notNullValue()));
		assertThat(logEntry.getMessage(), is("warning"));
	}

	@Test
	public void testLogFilteredEntry() throws InterruptedException
	{
		mongoLogService.setLogLevel(LogLevel.LOG_ERROR);
		osgiLogService.log(LogService.LOG_WARNING, "error");
		Thread.sleep(100);
		LogEntry logEntry = MongoUtil.getObject(MongoUtil.createResourceSet(), "junit", DB_LOGS);
		assertThat(logEntry, is(nullValue()));
	}

	@Test
	public void testLogEntries() throws InterruptedException
	{
		osgiLogService.log(LogService.LOG_ERROR, "error1");
		osgiLogService.log(LogService.LOG_ERROR, "error2");
		Thread.sleep(100);

		Collection<LogEntry> entries = mongoLogService.getLogEntries();
		assertThat(entries.size(), is(2));
	}

	@Test
	public void testLogEntriesWithQuery() throws InterruptedException
	{
		mongoLogService.setLogLevel(LogLevel.LOG_WARNING);
		osgiLogService.log(LogService.LOG_ERROR, "error");
		osgiLogService.log(LogService.LOG_WARNING, "warning");
		Thread.sleep(200);

		BinaryOperation filter = QueryFactory.eINSTANCE.createBinaryOperation();
		FeatureAccessor feature = QueryFactory.eINSTANCE.createFeatureAccessor();
		feature.setFeatureName(LogPackage.Literals.LOG_ENTRY__LEVEL.getName());
		Literal literal = QueryFactory.eINSTANCE.createLiteral();
		literal.setLiteralValue(LogLevel.LOG_ERROR.getLiteral());
		filter.setOperator("==");
		filter.setLeftOperand(feature);
		filter.setRightOperand(literal);

		Collection<LogEntry> entries = mongoLogService.getLogEntries(filter);
		assertThat(entries.size(), is(1));
		assertThat(entries.iterator().next().getLevel(), is(LogLevel.LOG_ERROR));
	}

	@Test
	public void testConfigureLogService() throws InterruptedException, IOException
	{
		try
		{
			LogServiceConfigurator.configureLogService(URI.createURI("mongo://localhost/junit/logs/"), LogLevel.LOG_ERROR_VALUE);
			ServiceTracker<IMongoLogService, IMongoLogService> logServiceTracker = new ServiceTracker<IMongoLogService, IMongoLogService>(Activator.getInstance().getContext(), IMongoLogService.class, null);
			logServiceTracker.open();
			IMongoLogService logService = logServiceTracker.waitForService(2000);
			assertThat(logService, is(notNullValue()));
		}
		finally
		{
			LogServiceConfigurator.unconfigureLogService();
		}
	}

	private static final String DB_LOGS = "logs";
	private static LogService osgiLogService;
	private static IMongoLogService mongoLogService;
}
