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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emf.query.Expression;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.emf.query.util.ExpressionBuilder;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;
import org.eclipselabs.mongo.emf.log.ILogService;
import org.eclipselabs.mongo.emf.log.LogEntry;
import org.eclipselabs.mongo.emf.log.LogFactory;
import org.eclipselabs.mongo.emf.log.LogLevel;
import org.osgi.service.log.LogListener;

/**
 * @author bhunt
 * 
 */
public class MongoEmfLogService implements ILogService, LogListener
{
	public MongoEmfLogService(URI baseURI)
	{
		this.baseURI = baseURI;
		logLevel = LogLevel.LOG_ERROR;
	}

	@Override
	public void logged(org.osgi.service.log.LogEntry entry)
	{
		if (entry.getLevel() > logLevel.getValue())
			return;

		LogEntry logEntry = LogFactory.eINSTANCE.createLogEntry();
		logEntry.setLevel(LogLevel.get(entry.getLevel()));
		logEntry.setMessage(entry.getMessage());
		logEntry.setTime(new Date());

		Throwable exception = entry.getException();

		if (exception != null)
		{
			StringWriter stack = new StringWriter();
			PrintWriter out = new PrintWriter(stack);
			exception.printStackTrace(out);

			logEntry.setExceptionMessage(exception.getMessage());
			logEntry.setExceptionStack(stack.toString());
		}

		ResourceSet resourceSet = createResourceSet();

		Resource resource = resourceSet.createResource(baseURI);
		resource.getContents().add(logEntry);

		try
		{
			resource.save(null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Collection<LogEntry> getLogEntries()
	{
		return getLogEntries("");
	}

	@Override
	public Collection<LogEntry> getLogEntries(Expression query)
	{
		return getLogEntries(ExpressionBuilder.toString(query));
	}

	@Override
	public LogLevel getLogLevel()
	{
		return logLevel;
	}

	@Override
	public void setLogLevel(LogLevel logLevel)
	{
		this.logLevel = logLevel;
	}

	private ResourceSet createResourceSet()
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new MongoDBURIHandlerImpl());
		return resourceSet;
	}

	@SuppressWarnings("unchecked")
	private Collection<LogEntry> getLogEntries(String query)
	{
		ResourceSet resourceSet = createResourceSet();
		Resource resource = resourceSet.getResource(baseURI.appendQuery(URI.encodeQuery(query, false)), true);
		Result result = (Result) resource.getContents().get(0);
		return (Collection<LogEntry>) (Collection<?>) result.getValues();
	}

	private URI baseURI;
	private LogLevel logLevel;
}
