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

package org.eclipselabs.emf.mongodb;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public interface EObjectBuilder
{
	/**
	 * Build an EMF EObject from the supplied DBObject from MongoDB.
	 * 
	 * @param collection the MongoDB collection containing the DBObject
	 * @param dbObject the object read from MongoDB
	 * @param resource the resource that will contain the EMF Object
	 *          This function will not add the created to the supplied resource
	 *          to support the case where the user wishes to return a collection
	 *          of objects such as the result of a query.
	 * @param isProxy true if the object is to be built as a proxy; false otherwise
	 * @return the newly created EMF object instance
	 */
	EObject buildEObject(DBCollection collection, DBObject dbObject, Resource resource, boolean isProxy);

	URI buildURI(DBCollection collection, DBObject object);
}
