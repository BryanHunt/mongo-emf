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

import org.eclipse.emf.ecore.EObject;

import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public interface DBObjectBuilder
{
	/**
	 * Build a DBObject from the supplied EMF object.
	 * 
	 * @param eObject the EMF object to serialize
	 * @return the newly created DBObject
	 */
	DBObject buildDBObject(EObject eObject);
}
