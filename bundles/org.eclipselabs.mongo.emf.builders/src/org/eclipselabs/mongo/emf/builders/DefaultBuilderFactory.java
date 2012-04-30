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

package org.eclipselabs.mongo.emf.builders;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipselabs.mongo.emf.DBObjectBuilder;
import org.eclipselabs.mongo.emf.EObjectBuilder;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.IDBObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IEObjectBuilderFactory;

/**
 * @author bhunt
 * 
 */
public class DefaultBuilderFactory implements IEObjectBuilderFactory, IDBObjectBuilderFactory
{
	@Override
	public DBObjectBuilder createBuilder(IConverterService converterService, URIHandler uriHandler, boolean serializeDefaultAttributeValues)
	{
		return new DBObjectBuilder(converterService, uriHandler, serializeDefaultAttributeValues);
	}

	@Override
	public EObjectBuilder createObjectBuilder(IConverterService converterService, URIHandler uriHandler, boolean includeAttributesForProxyReferences, Map<String, EClass> eClassCache)
	{
		return new EObjectBuilder(converterService, uriHandler, includeAttributesForProxyReferences, eClassCache);
	}
}
