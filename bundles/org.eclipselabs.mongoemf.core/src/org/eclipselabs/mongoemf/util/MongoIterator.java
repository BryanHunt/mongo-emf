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

package org.eclipselabs.mongoemf.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.mongoemf.EObjectBuilder;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class MongoIterator implements Iterator<EObject>
{
	private DBCursor dbCursor;
	private DBCollection dbCollection;
	private Resource eResource;
	private EObjectBuilder objectBuilder;

	/**
	 * @param dbCursor
	 * @param dbCollection
	 * @param eResource
	 * @param objectBuilder
	 */
	public MongoIterator(DBCursor dbCursor, DBCollection dbCollection, Resource eResource, EObjectBuilder objectBuilder)
	{
		super();
		this.dbCursor = dbCursor;
		this.dbCollection = dbCollection;
		this.eResource = eResource;
		this.objectBuilder = objectBuilder;
	}

	@Override
	public boolean hasNext()
	{
		return dbCursor.hasNext();
	}

	@Override
	public EObject next()
	{
		DBObject dbObject = dbCursor.next();
		URI uri = objectBuilder.buildURI(dbCollection, dbObject);
		Resource resource = eResource.getResourceSet().createResource(uri, null);
		EObject eObject = objectBuilder.buildEObject(dbCollection, dbObject, eResource, false);
		resource.getContents().add(eObject);
		return eObject;
	}

	@Override
	public void remove()
	{
		dbCursor.remove();
	}

}
