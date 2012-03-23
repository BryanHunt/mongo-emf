/**
 */
package org.eclipselabs.mongo.emf.query.simple.junit.model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Library#getBooks <em>Books</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Library#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Library#getLatestBook <em>Latest Book</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLibrary()
 * @model kind="class"
 * @generated
 */
public class Library extends EObjectImpl implements EObject
{
	/**
	 * The cached value of the '{@link #getBooks() <em>Books</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooks()
	 * @generated
	 * @ordered
	 */
	protected EList<Book> books;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Location location;

	/**
	 * The cached value of the '{@link #getLatestBook() <em>Latest Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatestBook()
	 * @generated
	 * @ordered
	 */
	protected Book latestBook;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Library()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ModelPackage.Literals.LIBRARY;
	}

	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLibrary_Books()
	 * @model containment="true"
	 * @generated
	 */
	public EList<Book> getBooks()
	{
		if (books == null)
		{
			books = new EObjectContainmentEList<Book>(Book.class, this, ModelPackage.LIBRARY__BOOKS);
		}
		return books;
	}

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Location)
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLibrary_Location()
	 * @model containment="true"
	 * @generated
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(Location newLocation, NotificationChain msgs)
	{
		Location oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.LIBRARY__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Library#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	public void setLocation(Location newLocation)
	{
		if (newLocation != location)
		{
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LIBRARY__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LIBRARY__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LIBRARY__LOCATION, newLocation, newLocation));
	}

	/**
	 * Returns the value of the '<em><b>Latest Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latest Book</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latest Book</em>' reference.
	 * @see #setLatestBook(Book)
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLibrary_LatestBook()
	 * @model
	 * @generated
	 */
	public Book getLatestBook()
	{
		if (latestBook != null && latestBook.eIsProxy())
		{
			InternalEObject oldLatestBook = (InternalEObject)latestBook;
			latestBook = (Book)eResolveProxy(oldLatestBook);
			if (latestBook != oldLatestBook)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.LIBRARY__LATEST_BOOK, oldLatestBook, latestBook));
			}
		}
		return latestBook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Book basicGetLatestBook()
	{
		return latestBook;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Library#getLatestBook <em>Latest Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latest Book</em>' reference.
	 * @see #getLatestBook()
	 * @generated
	 */
	public void setLatestBook(Book newLatestBook)
	{
		Book oldLatestBook = latestBook;
		latestBook = newLatestBook;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LIBRARY__LATEST_BOOK, oldLatestBook, latestBook));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelPackage.LIBRARY__BOOKS:
				return ((InternalEList<?>)getBooks()).basicRemove(otherEnd, msgs);
			case ModelPackage.LIBRARY__LOCATION:
				return basicSetLocation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ModelPackage.LIBRARY__BOOKS:
				return getBooks();
			case ModelPackage.LIBRARY__LOCATION:
				return getLocation();
			case ModelPackage.LIBRARY__LATEST_BOOK:
				if (resolve) return getLatestBook();
				return basicGetLatestBook();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ModelPackage.LIBRARY__BOOKS:
				getBooks().clear();
				getBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case ModelPackage.LIBRARY__LOCATION:
				setLocation((Location)newValue);
				return;
			case ModelPackage.LIBRARY__LATEST_BOOK:
				setLatestBook((Book)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ModelPackage.LIBRARY__BOOKS:
				getBooks().clear();
				return;
			case ModelPackage.LIBRARY__LOCATION:
				setLocation((Location)null);
				return;
			case ModelPackage.LIBRARY__LATEST_BOOK:
				setLatestBook((Book)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ModelPackage.LIBRARY__BOOKS:
				return books != null && !books.isEmpty();
			case ModelPackage.LIBRARY__LOCATION:
				return location != null;
			case ModelPackage.LIBRARY__LATEST_BOOK:
				return latestBook != null;
		}
		return super.eIsSet(featureID);
	}

} // Library
