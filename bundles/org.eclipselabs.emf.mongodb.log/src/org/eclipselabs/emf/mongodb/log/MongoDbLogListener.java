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

package org.eclipselabs.emf.mongodb.log;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.emf.mongodb.Options;
import org.eclipselabs.emodeling.ResourceSetFactory;
import org.eclipselabs.emodeling.log.LogEntry;
import org.eclipselabs.emodeling.log.LogFactory;
import org.eclipselabs.emodeling.log.LogLevel;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;

/**
 * @author bhunt
 * 
 */
public class MongoDbLogListener implements LogListener
{
	public MongoDbLogListener()
	{}

	public MongoDbLogListener(URI baseURI, LogLevel logLevel)
	{
		this.uri = baseURI;
		this.logLevel = logLevel;
	}

	@Override
	public void logged(org.osgi.service.log.LogEntry entry)
	{
		if (entry.getLevel() > logLevel.getValue())
			return;

		LogEntry logEntry = LogFactory.eINSTANCE.createLogEntry();
		logEntry.setLevel(LogLevel.get(entry.getLevel()));
		logEntry.setMessage(entry.getMessage());
		logEntry.setCreatedOn(new Date());

		Throwable exception = entry.getException();

		if (exception != null)
		{
			StringWriter stack = new StringWriter();
			PrintWriter out = new PrintWriter(stack);
			exception.printStackTrace(out);

			logEntry.setExceptionMessage(exception.getMessage());
			logEntry.setExceptionStack(stack.toString());
		}

		ResourceSet resourceSet = resourceSetFactory.createResourceSet();

		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(logEntry);

		HashMap<String, Object> options = new HashMap<String, Object>(1);
		options.put(Options.OPTION_SERIALIZE_DEFAULT_ATTRIBUTE_VALUES, Boolean.TRUE);

		try
		{
			resource.save(options);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void bindLogReaderService(LogReaderService logReaderService)
	{
		this.logReaderService = logReaderService;
	}

	public void bindResourceSetFactory(ResourceSetFactory resourceSetFactory)
	{
		this.resourceSetFactory = resourceSetFactory;
	}

	void activate(Map<String, Object> properties)
	{
		uri = URI.createURI((String) properties.get("uri"));

		if (uri == null)
			throw new IllegalStateException("uri property was not found");

		Integer logLevelValue = (Integer) properties.get("logLevel");

		if (logLevelValue != null)
			this.logLevel = LogLevel.get(logLevelValue);

		logReaderService.addLogListener(this);
	}

	void deactivate()
	{
		logReaderService.removeLogListener(this);
	}

	private URI uri;
	private LogLevel logLevel = LogLevel.ERROR;
	private LogReaderService logReaderService;
	private ResourceSetFactory resourceSetFactory;
}
