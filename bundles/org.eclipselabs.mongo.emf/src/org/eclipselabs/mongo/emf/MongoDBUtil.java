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

package org.eclipselabs.mongo.emf;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author bhunt
 * 
 */
public class MongoDBUtil
{
	public static void cascadeDelete(EObject object, Map<?, ?> options) throws IOException
	{
		if (object == null)
			return;

		for (EReference reference : object.eClass().getEAllReferences())
		{
			if (!reference.isContainment())
				continue;

			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				EList<EObject> targets = (EList<EObject>) object.eGet(reference);

				for (EObject target : targets)
					cascadeDelete(target, options);
			}
			else
			{
				EObject target = (EObject) object.eGet(reference);
				cascadeDelete(target, options);
			}
		}

		Resource directResource = ((InternalEObject) object).eDirectResource();

		if (directResource != null)
			directResource.delete(options);
	}
}
