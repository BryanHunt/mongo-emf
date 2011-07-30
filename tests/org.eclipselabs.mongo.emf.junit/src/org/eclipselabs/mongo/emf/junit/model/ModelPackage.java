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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mongo.emf.junit.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/mongo/emf/junit";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipselabs.mongo.emf.junit";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.PersonImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__BOOKS = 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.BookImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__AUTHORS = 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TAGS = 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__DATA = 3;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.LibraryImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 2;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__BOOKS = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Latest Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__LATEST_BOOK = 2;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.LocationImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>Featured Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__FEATURED_BOOK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__ID = 2;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl <em>ETypes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getETypes()
	 * @generated
	 */
	int ETYPES = 4;

	/**
	 * The feature id for the '<em><b>EBig Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EBIG_DECIMAL = 0;

	/**
	 * The feature id for the '<em><b>EBig Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EBIG_INTEGER = 1;

	/**
	 * The feature id for the '<em><b>EBoolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EBOOLEAN = 2;

	/**
	 * The feature id for the '<em><b>EByte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EBYTE = 3;

	/**
	 * The feature id for the '<em><b>EByte Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EBYTE_ARRAY = 4;

	/**
	 * The feature id for the '<em><b>EChar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__ECHAR = 5;

	/**
	 * The feature id for the '<em><b>EDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EDATE = 6;

	/**
	 * The feature id for the '<em><b>EDouble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EDOUBLE = 7;

	/**
	 * The feature id for the '<em><b>EFloat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EFLOAT = 8;

	/**
	 * The feature id for the '<em><b>EInt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__EINT = 9;

	/**
	 * The feature id for the '<em><b>ELong</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__ELONG = 10;

	/**
	 * The feature id for the '<em><b>EShort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__ESHORT = 11;

	/**
	 * The feature id for the '<em><b>EString</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__ESTRING = 12;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES__URIS = 13;

	/**
	 * The number of structural features of the '<em>ETypes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPES_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.MappedLibraryImpl <em>Mapped Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.MappedLibraryImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getMappedLibrary()
	 * @generated
	 */
	int MAPPED_LIBRARY = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_LIBRARY__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Rare Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_LIBRARY__RARE_BOOKS = 1;

	/**
	 * The feature id for the '<em><b>Regular Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_LIBRARY__REGULAR_BOOKS = 2;

	/**
	 * The feature id for the '<em><b>Books</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_LIBRARY__BOOKS = 3;

	/**
	 * The number of structural features of the '<em>Mapped Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_LIBRARY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl <em>Primary Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getPrimaryObject()
	 * @generated
	 */
	int PRIMARY_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Unsettable Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT = 2;

	/**
	 * The feature id for the '<em><b>Unsettable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__UNSETTABLE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN = 4;

	/**
	 * The feature id for the '<em><b>Single Non Containment Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Multiple Non Containment Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES = 7;

	/**
	 * The feature id for the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES = 8;

	/**
	 * The feature id for the '<em><b>Single Containment Reference Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES = 9;

	/**
	 * The feature id for the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES = 10;

	/**
	 * The feature id for the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES = 11;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Type2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2 = 12;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Type1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1 = 13;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Collection</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION = 14;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Type1</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1 = 15;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Type2</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2 = 16;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Collection</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION = 17;

	/**
	 * The number of structural features of the '<em>Primary Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_OBJECT_FEATURE_COUNT = 18;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.TargetObjectImpl <em>Target Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.TargetObjectImpl
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getTargetObject()
	 * @generated
	 */
	int TARGET_OBJECT = 7;

	/**
	 * The feature id for the '<em><b>Single Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OBJECT__SINGLE_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Array Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OBJECT__ARRAY_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>Target Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getURI()
	 * @generated
	 */
	int URI = 8;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mongo.emf.junit.model.Person#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Books</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Person#getBooks()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Books();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.Book#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Book#getTitle()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Title();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mongo.emf.junit.model.Book#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Authors</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Book#getAuthors()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Authors();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.Book#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tags</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Book#getTags()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Tags();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.Book#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Book#getData()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.junit.model.Library#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Books</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Library#getBooks()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Books();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mongo.emf.junit.model.Library#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Library#getLocation()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Location();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mongo.emf.junit.model.Library#getLatestBook <em>Latest Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Latest Book</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Library#getLatestBook()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_LatestBook();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.Location#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Location#getAddress()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Address();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mongo.emf.junit.model.Location#getFeaturedBook <em>Featured Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Featured Book</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Location#getFeaturedBook()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_FeaturedBook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.Location#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.Location#getId()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.ETypes <em>ETypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETypes</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes
	 * @generated
	 */
	EClass getETypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEBigDecimal <em>EBig Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBig Decimal</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEBigDecimal()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EBigDecimal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEBigInteger <em>EBig Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBig Integer</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEBigInteger()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EBigInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#isEBoolean <em>EBoolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBoolean</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#isEBoolean()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EBoolean();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEByte <em>EByte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EByte</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEByte()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EByte();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEByteArray <em>EByte Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EByte Array</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEByteArray()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EByteArray();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEChar <em>EChar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EChar</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEChar()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EChar();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEDate <em>EDate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EDate</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEDate()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EDate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEDouble <em>EDouble</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EDouble</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEDouble()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EDouble();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEFloat <em>EFloat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EFloat</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEFloat()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EFloat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEInt <em>EInt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EInt</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEInt()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EInt();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getELong <em>ELong</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ELong</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getELong()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_ELong();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEShort <em>EShort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EShort</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEShort()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EShort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getEString <em>EString</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EString</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getEString()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_EString();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.ETypes#getUris <em>Uris</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Uris</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.ETypes#getUris()
	 * @see #getETypes()
	 * @generated
	 */
	EAttribute getETypes_Uris();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.MappedLibrary <em>Mapped Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Library</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.MappedLibrary
	 * @generated
	 */
	EClass getMappedLibrary();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getLocation()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	EReference getMappedLibrary_Location();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Books</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getBooks()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	EAttribute getMappedLibrary_Books();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject <em>Primary Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Object</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject
	 * @generated
	 */
	EClass getPrimaryObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getName()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EAttribute getPrimaryObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsettable Attribute</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getUnsettableAttribute()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EAttribute getPrimaryObject_UnsettableAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsettable Attribute With Non Null Default</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EAttribute getPrimaryObject_UnsettableAttributeWithNonNullDefault();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unsettable Reference</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getUnsettableReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_UnsettableReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Containment Reference Same Collectioin</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_ContainmentReferenceSameCollectioin();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Non Containment Reference</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleNonContainmentReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_SingleNonContainmentReference();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multiple Non Containment Reference</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleNonContainmentReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_MultipleNonContainmentReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Containment Reference No Proxies</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_SingleContainmentReferenceNoProxies();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multiple Containment Reference No Proxies</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_MultipleContainmentReferenceNoProxies();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Containment Reference Proxies</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_SingleContainmentReferenceProxies();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multiple Containment Reference Proxies</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_MultipleContainmentReferenceProxies();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Non Containment Reference No Proxies</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_SingleNonContainmentReferenceNoProxies();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapReferenceType2 <em>Feature Map Reference Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Map Reference Type2</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapReferenceType2()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_FeatureMapReferenceType2();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapReferenceType1 <em>Feature Map Reference Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Map Reference Type1</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapReferenceType1()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EReference getPrimaryObject_FeatureMapReferenceType1();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapReferenceCollection <em>Feature Map Reference Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Reference Collection</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapReferenceCollection()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EAttribute getPrimaryObject_FeatureMapReferenceCollection();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapAttributeType1 <em>Feature Map Attribute Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Type1</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapAttributeType1()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EAttribute getPrimaryObject_FeatureMapAttributeType1();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapAttributeType2 <em>Feature Map Attribute Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Type2</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapAttributeType2()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EAttribute getPrimaryObject_FeatureMapAttributeType2();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapAttributeCollection <em>Feature Map Attribute Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Collection</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapAttributeCollection()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	EAttribute getPrimaryObject_FeatureMapAttributeCollection();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.junit.model.TargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Object</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.TargetObject
	 * @generated
	 */
	EClass getTargetObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Single Attribute</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.TargetObject#getSingleAttribute()
	 * @see #getTargetObject()
	 * @generated
	 */
	EAttribute getTargetObject_SingleAttribute();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongo.emf.junit.model.TargetObject#getArrayAttribute <em>Array Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Array Attribute</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.TargetObject#getArrayAttribute()
	 * @see #getTargetObject()
	 * @generated
	 */
	EAttribute getTargetObject_ArrayAttribute();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getRareBooks <em>Rare Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rare Books</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getRareBooks()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	EReference getMappedLibrary_RareBooks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getRegularBooks <em>Regular Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regular Books</em>'.
	 * @see org.eclipselabs.mongo.emf.junit.model.MappedLibrary#getRegularBooks()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	EReference getMappedLibrary_RegularBooks();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.PersonImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__BOOKS = eINSTANCE.getPerson_Books();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.BookImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__TITLE = eINSTANCE.getBook_Title();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__AUTHORS = eINSTANCE.getBook_Authors();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__TAGS = eINSTANCE.getBook_Tags();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__DATA = eINSTANCE.getBook_Data();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.LibraryImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__BOOKS = eINSTANCE.getLibrary_Books();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__LOCATION = eINSTANCE.getLibrary_Location();

		/**
		 * The meta object literal for the '<em><b>Latest Book</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__LATEST_BOOK = eINSTANCE.getLibrary_LatestBook();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.LocationImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__ADDRESS = eINSTANCE.getLocation_Address();

		/**
		 * The meta object literal for the '<em><b>Featured Book</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__FEATURED_BOOK = eINSTANCE.getLocation_FeaturedBook();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__ID = eINSTANCE.getLocation_Id();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl <em>ETypes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getETypes()
		 * @generated
		 */
		EClass ETYPES = eINSTANCE.getETypes();

		/**
		 * The meta object literal for the '<em><b>EBig Decimal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EBIG_DECIMAL = eINSTANCE.getETypes_EBigDecimal();

		/**
		 * The meta object literal for the '<em><b>EBig Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EBIG_INTEGER = eINSTANCE.getETypes_EBigInteger();

		/**
		 * The meta object literal for the '<em><b>EBoolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EBOOLEAN = eINSTANCE.getETypes_EBoolean();

		/**
		 * The meta object literal for the '<em><b>EByte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EBYTE = eINSTANCE.getETypes_EByte();

		/**
		 * The meta object literal for the '<em><b>EByte Array</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EBYTE_ARRAY = eINSTANCE.getETypes_EByteArray();

		/**
		 * The meta object literal for the '<em><b>EChar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__ECHAR = eINSTANCE.getETypes_EChar();

		/**
		 * The meta object literal for the '<em><b>EDate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EDATE = eINSTANCE.getETypes_EDate();

		/**
		 * The meta object literal for the '<em><b>EDouble</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EDOUBLE = eINSTANCE.getETypes_EDouble();

		/**
		 * The meta object literal for the '<em><b>EFloat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EFLOAT = eINSTANCE.getETypes_EFloat();

		/**
		 * The meta object literal for the '<em><b>EInt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__EINT = eINSTANCE.getETypes_EInt();

		/**
		 * The meta object literal for the '<em><b>ELong</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__ELONG = eINSTANCE.getETypes_ELong();

		/**
		 * The meta object literal for the '<em><b>EShort</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__ESHORT = eINSTANCE.getETypes_EShort();

		/**
		 * The meta object literal for the '<em><b>EString</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__ESTRING = eINSTANCE.getETypes_EString();

		/**
		 * The meta object literal for the '<em><b>Uris</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPES__URIS = eINSTANCE.getETypes_Uris();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.MappedLibraryImpl <em>Mapped Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.MappedLibraryImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getMappedLibrary()
		 * @generated
		 */
		EClass MAPPED_LIBRARY = eINSTANCE.getMappedLibrary();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_LIBRARY__LOCATION = eINSTANCE.getMappedLibrary_Location();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_LIBRARY__BOOKS = eINSTANCE.getMappedLibrary_Books();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl <em>Primary Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getPrimaryObject()
		 * @generated
		 */
		EClass PRIMARY_OBJECT = eINSTANCE.getPrimaryObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_OBJECT__NAME = eINSTANCE.getPrimaryObject_Name();

		/**
		 * The meta object literal for the '<em><b>Unsettable Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE = eINSTANCE.getPrimaryObject_UnsettableAttribute();

		/**
		 * The meta object literal for the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT = eINSTANCE.getPrimaryObject_UnsettableAttributeWithNonNullDefault();

		/**
		 * The meta object literal for the '<em><b>Unsettable Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__UNSETTABLE_REFERENCE = eINSTANCE.getPrimaryObject_UnsettableReference();

		/**
		 * The meta object literal for the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN = eINSTANCE.getPrimaryObject_ContainmentReferenceSameCollectioin();

		/**
		 * The meta object literal for the '<em><b>Single Non Containment Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE = eINSTANCE.getPrimaryObject_SingleNonContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Multiple Non Containment Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE = eINSTANCE.getPrimaryObject_MultipleNonContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_SingleContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_MultipleContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Single Containment Reference Proxies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES = eINSTANCE.getPrimaryObject_SingleContainmentReferenceProxies();

		/**
		 * The meta object literal for the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES = eINSTANCE.getPrimaryObject_MultipleContainmentReferenceProxies();

		/**
		 * The meta object literal for the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_SingleNonContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Type2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2 = eINSTANCE.getPrimaryObject_FeatureMapReferenceType2();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Type1</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1 = eINSTANCE.getPrimaryObject_FeatureMapReferenceType1();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Collection</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION = eINSTANCE.getPrimaryObject_FeatureMapReferenceCollection();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Type1</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1 = eINSTANCE.getPrimaryObject_FeatureMapAttributeType1();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Type2</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2 = eINSTANCE.getPrimaryObject_FeatureMapAttributeType2();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Collection</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION = eINSTANCE.getPrimaryObject_FeatureMapAttributeCollection();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.junit.model.impl.TargetObjectImpl <em>Target Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.TargetObjectImpl
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getTargetObject()
		 * @generated
		 */
		EClass TARGET_OBJECT = eINSTANCE.getTargetObject();

		/**
		 * The meta object literal for the '<em><b>Single Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_OBJECT__SINGLE_ATTRIBUTE = eINSTANCE.getTargetObject_SingleAttribute();

		/**
		 * The meta object literal for the '<em><b>Array Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_OBJECT__ARRAY_ATTRIBUTE = eINSTANCE.getTargetObject_ArrayAttribute();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipselabs.mongo.emf.junit.model.impl.ModelPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em><b>Rare Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_LIBRARY__RARE_BOOKS = eINSTANCE.getMappedLibrary_RareBooks();

		/**
		 * The meta object literal for the '<em><b>Regular Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_LIBRARY__REGULAR_BOOKS = eINSTANCE.getMappedLibrary_RegularBooks();

	}

} //ModelPackage
