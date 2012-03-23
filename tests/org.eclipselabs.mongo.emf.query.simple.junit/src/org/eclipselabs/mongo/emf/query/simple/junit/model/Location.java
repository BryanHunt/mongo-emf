/**
 */
package org.eclipselabs.mongo.emf.query.simple.junit.model;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Location#getAddress <em>Address</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Location#getFeaturedBook <em>Featured Book</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Location#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLocation()
 * @model kind="class"
 * @generated
 */
public class Location extends EObjectImpl implements EObject
{
	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeaturedBook() <em>Featured Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturedBook()
	 * @generated
	 * @ordered
	 */
	protected Book featuredBook;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Object ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Object id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Location()
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
		return ModelPackage.Literals.LOCATION;
	}

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
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLocation_Address()
	 * @model
	 * @generated
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Location#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	public void setAddress(String newAddress)
	{
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__ADDRESS, oldAddress, address));
	}

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
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLocation_FeaturedBook()
	 * @model
	 * @generated
	 */
	public Book getFeaturedBook()
	{
		if (featuredBook != null && featuredBook.eIsProxy())
		{
			InternalEObject oldFeaturedBook = (InternalEObject)featuredBook;
			featuredBook = (Book)eResolveProxy(oldFeaturedBook);
			if (featuredBook != oldFeaturedBook)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.LOCATION__FEATURED_BOOK, oldFeaturedBook, featuredBook));
			}
		}
		return featuredBook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Book basicGetFeaturedBook()
	{
		return featuredBook;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Location#getFeaturedBook <em>Featured Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Featured Book</em>' reference.
	 * @see #getFeaturedBook()
	 * @generated
	 */
	public void setFeaturedBook(Book newFeaturedBook)
	{
		Book oldFeaturedBook = featuredBook;
		featuredBook = newFeaturedBook;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__FEATURED_BOOK, oldFeaturedBook, featuredBook));
	}

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
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getLocation_Id()
	 * @model id="true" transient="true" derived="true"
	 * @generated
	 */
	public Object getId()
	{
		return id;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Location#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	public void setId(Object newId)
	{
		Object oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__ID, oldId, id));
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
			case ModelPackage.LOCATION__ADDRESS:
				return getAddress();
			case ModelPackage.LOCATION__FEATURED_BOOK:
				if (resolve) return getFeaturedBook();
				return basicGetFeaturedBook();
			case ModelPackage.LOCATION__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ModelPackage.LOCATION__ADDRESS:
				setAddress((String)newValue);
				return;
			case ModelPackage.LOCATION__FEATURED_BOOK:
				setFeaturedBook((Book)newValue);
				return;
			case ModelPackage.LOCATION__ID:
				setId(newValue);
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
			case ModelPackage.LOCATION__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case ModelPackage.LOCATION__FEATURED_BOOK:
				setFeaturedBook((Book)null);
				return;
			case ModelPackage.LOCATION__ID:
				setId(ID_EDEFAULT);
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
			case ModelPackage.LOCATION__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case ModelPackage.LOCATION__FEATURED_BOOK:
				return featuredBook != null;
			case ModelPackage.LOCATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (address: ");
		result.append(address);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // Location
