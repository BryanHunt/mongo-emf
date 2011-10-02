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

package org.eclipselabs.mongo.emf.log;

import java.util.Collection;

import org.eclipselabs.emf.query.Expression;

/**
 * @author bhunt
 * 
 */
public interface IMongoLogService
{
	Collection<LogEntry> getLogEntries();

	Collection<LogEntry> getLogEntries(Expression query);

	LogLevel getLogLevel();

	void setLogLevel(LogLevel logLevel);
}
