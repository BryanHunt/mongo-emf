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

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.MappedLibrary#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.MappedLibrary#getRareBooks <em>Rare Books</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.MappedLibrary#getRegularBooks <em>Regular Books</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.MappedLibrary#getBooks <em>Books</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getMappedLibrary()
 * @model kind="class"
 * @generated
 */
public class MappedLibrary extends EObjectImpl implements EObject
{
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
	 * The cached value of the '{@link #getBooks() <em>Books</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooks()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap books;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedLibrary()
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
		return ModelPackage.Literals.MAPPED_LIBRARY;
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
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getMappedLibrary_Location()
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.MAPPED_LIBRARY__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.MappedLibrary#getLocation <em>Location</em>}' containment reference.
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
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MAPPED_LIBRARY__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MAPPED_LIBRARY__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MAPPED_LIBRARY__LOCATION, newLocation, newLocation));
	}

	/**
	 * Returns the value of the '<em><b>Rare Books</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rare Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rare Books</em>' containment reference list.
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getMappedLibrary_RareBooks()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#books'"
	 * @generated
	 */
	public EList<Book> getRareBooks()
	{
		return getBooks().list(ModelPackage.Literals.MAPPED_LIBRARY__RARE_BOOKS);
	}

	/**
	 * Returns the value of the '<em><b>Regular Books</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regular Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regular Books</em>' containment reference list.
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getMappedLibrary_RegularBooks()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#books'"
	 * @generated
	 */
	public EList<Book> getRegularBooks()
	{
		return getBooks().list(ModelPackage.Literals.MAPPED_LIBRARY__REGULAR_BOOKS);
	}

	/**
	 * Returns the value of the '<em><b>Books</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' attribute list.
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getMappedLibrary_Books()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
	 *        extendedMetaData="kind='group'"
	 * @generated
	 */
	public FeatureMap getBooks()
	{
		if (books == null)
		{
			books = new BasicFeatureMap(this, ModelPackage.MAPPED_LIBRARY__BOOKS);
		}
		return books;
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
			case ModelPackage.MAPPED_LIBRARY__LOCATION:
				return basicSetLocation(null, msgs);
			case ModelPackage.MAPPED_LIBRARY__RARE_BOOKS:
				return ((InternalEList<?>)getRareBooks()).basicRemove(otherEnd, msgs);
			case ModelPackage.MAPPED_LIBRARY__REGULAR_BOOKS:
				return ((InternalEList<?>)getRegularBooks()).basicRemove(otherEnd, msgs);
			case ModelPackage.MAPPED_LIBRARY__BOOKS:
				return ((InternalEList<?>)getBooks()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.MAPPED_LIBRARY__LOCATION:
				return getLocation();
			case ModelPackage.MAPPED_LIBRARY__RARE_BOOKS:
				return getRareBooks();
			case ModelPackage.MAPPED_LIBRARY__REGULAR_BOOKS:
				return getRegularBooks();
			case ModelPackage.MAPPED_LIBRARY__BOOKS:
				if (coreType) return getBooks();
				return ((FeatureMap.Internal)getBooks()).getWrapper();
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
			case ModelPackage.MAPPED_LIBRARY__LOCATION:
				setLocation((Location)newValue);
				return;
			case ModelPackage.MAPPED_LIBRARY__RARE_BOOKS:
				getRareBooks().clear();
				getRareBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case ModelPackage.MAPPED_LIBRARY__REGULAR_BOOKS:
				getRegularBooks().clear();
				getRegularBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case ModelPackage.MAPPED_LIBRARY__BOOKS:
				((FeatureMap.Internal)getBooks()).set(newValue);
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
			case ModelPackage.MAPPED_LIBRARY__LOCATION:
				setLocation((Location)null);
				return;
			case ModelPackage.MAPPED_LIBRARY__RARE_BOOKS:
				getRareBooks().clear();
				return;
			case ModelPackage.MAPPED_LIBRARY__REGULAR_BOOKS:
				getRegularBooks().clear();
				return;
			case ModelPackage.MAPPED_LIBRARY__BOOKS:
				getBooks().clear();
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
			case ModelPackage.MAPPED_LIBRARY__LOCATION:
				return location != null;
			case ModelPackage.MAPPED_LIBRARY__RARE_BOOKS:
				return !getRareBooks().isEmpty();
			case ModelPackage.MAPPED_LIBRARY__REGULAR_BOOKS:
				return !getRegularBooks().isEmpty();
			case ModelPackage.MAPPED_LIBRARY__BOOKS:
				return books != null && !books.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (books: ");
		result.append(books);
		result.append(')');
		return result.toString();
	}

} // MappedLibrary
