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

package org.eclipselabs.emf.mongodb.builders;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipselabs.emf.mongodb.ConverterService;
import org.eclipselabs.emf.mongodb.DBObjectBuilder;
import org.eclipselabs.emf.mongodb.DBObjectBuilderFactory;
import org.eclipselabs.emf.mongodb.EObjectBuilder;
import org.eclipselabs.emf.mongodb.EObjectBuilderFactory;

/**
 * @author bhunt
 * 
 */
public class DefaultBuilderFactory implements EObjectBuilderFactory, DBObjectBuilderFactory
{
	@Override
	public DBObjectBuilder createBuilder(ConverterService converterService, URIHandler uriHandler, boolean serializeDefaultAttributeValues)
	{
		return new DBObjectBuilderImpl(converterService, uriHandler, serializeDefaultAttributeValues);
	}

	@Override
	public EObjectBuilder createObjectBuilder(ConverterService converterService, URIHandler uriHandler, boolean includeAttributesForProxyReferences, Map<String, EClass> eClassCache)
	{
		return new EObjectBuilderImpl(converterService, uriHandler, includeAttributesForProxyReferences, eClassCache);
	}
}
