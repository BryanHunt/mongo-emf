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

package org.eclipselabs.mongoemf.junit.suite;

import org.eclipselabs.mongoemf.junit.tests.TestMongoCursor;
import org.eclipselabs.mongoemf.junit.tests.TestMongoEmfAttributes;
import org.eclipselabs.mongoemf.junit.tests.TestMongoEmfBasics;
import org.eclipselabs.mongoemf.junit.tests.TestMongoEmfReferences;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestMongoEmfBasics.class, TestMongoEmfAttributes.class, TestMongoEmfReferences.class, TestMongoCursor.class })
public class TestMongoEmfSuite
{}
