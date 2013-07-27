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

package org.eclipselabs.mongoemf.perf.support;

import org.eclipselabs.mongoemf.perf.model.BaseObject;
import org.eclipselabs.mongoemf.perf.model.ObjectGroup;
import org.eclipselabs.mongoemf.perf.model.TestObject1;
import org.eclipselabs.mongoemf.perf.model.util.ModelSwitch;

/**
 * @author bhunt
 * 
 */
public class TreeVisitor extends ModelSwitch<Boolean>
{
	@Override
	public Boolean caseTestObject1(TestObject1 object)
	{
		return Boolean.TRUE;
	}

	@Override
	public Boolean caseObjectGroup(ObjectGroup group)
	{
		for (BaseObject object : group.getChildren())
			doSwitch(object);

		return Boolean.TRUE;
	}
}
