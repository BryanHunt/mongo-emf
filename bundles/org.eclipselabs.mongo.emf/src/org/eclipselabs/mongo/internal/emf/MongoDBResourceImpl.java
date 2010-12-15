/*******************************************************************************
 * Copyright (c) 2010 Bryan Hunt & Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt & Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.internal.emf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

/**
 * @author bhunt
 * 
 */
public class MongoDBResourceImpl extends XMIResourceImpl
{
	public MongoDBResourceImpl(URI uri)
	{
		super(uri);
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException
	{
		if (inputStream instanceof MongoDBURIHandlerImpl.MongoDBInputStream)
		{
			((MongoDBURIHandlerImpl.MongoDBInputStream) inputStream).load(this);
		}
		else
		{
			super.doLoad(inputStream, options);
		}
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException
	{
		if (outputStream instanceof MongoDBURIHandlerImpl.MongoDBOutputStream)
		{
			((MongoDBURIHandlerImpl.MongoDBOutputStream) outputStream).saveResource(this);
		}
		else
		{
			super.doSave(outputStream, options);
		}
	}
}
