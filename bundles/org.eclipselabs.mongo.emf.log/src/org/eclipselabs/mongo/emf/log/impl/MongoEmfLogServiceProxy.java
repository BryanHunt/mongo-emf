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

package org.eclipselabs.mongo.emf.log.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emf.query.Expression;
import org.eclipselabs.mongo.emf.log.IMongoLogService;
import org.eclipselabs.mongo.emf.log.LogEntry;
import org.eclipselabs.mongo.emf.log.LogLevel;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;

/**
 * @author bhunt
 * 
 */
public class MongoEmfLogServiceProxy implements IMongoLogService
{
	@Override
	public Collection<LogEntry> getLogEntries()
	{
		return logService.getLogEntries();
	}

	@Override
	public Collection<LogEntry> getLogEntries(Expression query)
	{
		return logService.getLogEntries(query);
	}

	@Override
	public LogLevel getLogLevel()
	{
		return logService.getLogLevel();
	}

	@Override
	public void setLogLevel(LogLevel logLevel)
	{
		logService.setLogLevel(logLevel);
	}

	protected void activate(ComponentContext context)
	{
		String baseURI = (String) context.getProperties().get("baseURI");

		if (baseURI == null)
			throw new IllegalStateException("baseURI property was not found");

		MongoEmfLogService mongoEmfLogService = new MongoEmfLogService(URI.createURI(baseURI));

		Integer logLevel = (Integer) context.getProperties().get("logLevel");

		if (logLevel != null)
			mongoEmfLogService.setLogLevel(LogLevel.get(logLevel));

		logService = mongoEmfLogService;
		logListener = mongoEmfLogService;
		logReaderService.addLogListener(logListener);
	}

	protected void bindLogReaderService(LogReaderService logReaderService)
	{
		this.logReaderService = logReaderService;
	}

	protected void unbindLogReaderService(LogReaderService logReaderService)
	{
		if (logReaderService == this.logReaderService)
		{
			this.logReaderService.removeLogListener(logListener);
			this.logReaderService = null;
		}
	}

	private LogReaderService logReaderService;
	private IMongoLogService logService;
	private LogListener logListener;
}
