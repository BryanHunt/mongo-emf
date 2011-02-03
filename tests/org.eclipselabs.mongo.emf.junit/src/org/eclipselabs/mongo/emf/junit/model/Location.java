/*******************************************************************************
 * Copyright (c) 2010 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf.junit.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.Location#getAddress <em>Address</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.Location#getFeaturedBook <em>Featured Book</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.Location#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject
{
	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getLocation_Address()
	 * @model
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.Location#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

	/**
	 * Returns the value of the '<em><b>Featured Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featured Book</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featured Book</em>' reference.
	 * @see #setFeaturedBook(Book)
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getLocation_FeaturedBook()
	 * @model
	 * @generated
	 */
	Book getFeaturedBook();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.Location#getFeaturedBook <em>Featured Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Featured Book</em>' reference.
	 * @see #getFeaturedBook()
	 * @generated
	 */
	void setFeaturedBook(Book value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Object)
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getLocation_Id()
	 * @model id="true" transient="true" derived="true"
	 * @generated
	 */
	Object getId();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.Location#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Object value);

} // Location
