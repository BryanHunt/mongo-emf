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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.Book#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.Book#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.Book#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends EObject
{
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getBook_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Authors</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.junit.model.Person}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mongo.emf.junit.model.Person#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' reference list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getBook_Authors()
	 * @see org.eclipselabs.mongo.emf.junit.model.Person#getBooks
	 * @model opposite="books"
	 * @generated
	 */
	EList<Person> getAuthors();

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' attribute list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getBook_Tags()
	 * @model
	 * @generated
	 */
	EList<String> getTags();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Character}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getBook_Data()
	 * @model
	 * @generated
	 */
	EList<Character> getData();

} // Book
