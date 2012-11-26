/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.emf.log;

import java.util.Date;

import org.eclipselabs.emf.ext.ECollection;

/**
 * @author bhunt
 * 
 */
public interface ILogService
{
	/**
	 * 
	 * @param count the number of log entries to return
	 * @return the most recent N log entries
	 */
	ECollection getLogEntries(int count);

	/**
	 * 
	 * @param cutoff the date of the oldest log entry to return
	 * @return the most recent log entries up to the cutoff date
	 */
	ECollection getLogEntries(Date cutoff);

	/**
	 * 
	 * @param query the search query
	 * @return the log entries matching the search query
	 */
	ECollection getLogEntries(String query);
}
