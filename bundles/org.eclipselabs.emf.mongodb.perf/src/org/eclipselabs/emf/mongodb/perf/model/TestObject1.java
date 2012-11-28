/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.mongodb.perf.model;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Object1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getFirstAvailable <em>First Available</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getLastAvailable <em>Last Available</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.mongodb.perf.model.ModelPackage#getTestObject1()
 * @model kind="class"
 * @generated
 */
public class TestObject1 extends BaseObject
{
	/**
	 * The default value of the '{@link #getFirstAvailable() <em>First Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final Date FIRST_AVAILABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstAvailable() <em>First Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstAvailable()
	 * @generated
	 * @ordered
	 */
	protected Date firstAvailable = FIRST_AVAILABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastAvailable() <em>Last Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_AVAILABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastAvailable() <em>Last Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAvailable()
	 * @generated
	 * @ordered
	 */
	protected Date lastAvailable = LAST_AVAILABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected int count = COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected String data = DATA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestObject1()
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
		return ModelPackage.Literals.TEST_OBJECT1;
	}

	/**
	 * Returns the value of the '<em><b>First Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Available</em>' attribute.
	 * @see #setFirstAvailable(Date)
	 * @see org.eclipselabs.emf.mongodb.perf.model.ModelPackage#getTestObject1_FirstAvailable()
	 * @model
	 * @generated
	 */
	public Date getFirstAvailable()
	{
		return firstAvailable;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getFirstAvailable <em>First Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Available</em>' attribute.
	 * @see #getFirstAvailable()
	 * @generated
	 */
	public void setFirstAvailable(Date newFirstAvailable)
	{
		Date oldFirstAvailable = firstAvailable;
		firstAvailable = newFirstAvailable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE, oldFirstAvailable, firstAvailable));
	}

	/**
	 * Returns the value of the '<em><b>Last Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Available</em>' attribute.
	 * @see #setLastAvailable(Date)
	 * @see org.eclipselabs.emf.mongodb.perf.model.ModelPackage#getTestObject1_LastAvailable()
	 * @model
	 * @generated
	 */
	public Date getLastAvailable()
	{
		return lastAvailable;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getLastAvailable <em>Last Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Available</em>' attribute.
	 * @see #getLastAvailable()
	 * @generated
	 */
	public void setLastAvailable(Date newLastAvailable)
	{
		Date oldLastAvailable = lastAvailable;
		lastAvailable = newLastAvailable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__LAST_AVAILABLE, oldLastAvailable, lastAvailable));
	}

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see org.eclipselabs.emf.mongodb.perf.model.ModelPackage#getTestObject1_Count()
	 * @model
	 * @generated
	 */
	public int getCount()
	{
		return count;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	public void setCount(int newCount)
	{
		int oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__COUNT, oldCount, count));
	}

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(String)
	 * @see org.eclipselabs.emf.mongodb.perf.model.ModelPackage#getTestObject1_Data()
	 * @model
	 * @generated
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.perf.model.TestObject1#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	public void setData(String newData)
	{
		String oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__DATA, oldData, data));
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
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				return getFirstAvailable();
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				return getLastAvailable();
			case ModelPackage.TEST_OBJECT1__COUNT:
				return getCount();
			case ModelPackage.TEST_OBJECT1__DATA:
				return getData();
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
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				setFirstAvailable((Date)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				setLastAvailable((Date)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__COUNT:
				setCount((Integer)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__DATA:
				setData((String)newValue);
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
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				setFirstAvailable(FIRST_AVAILABLE_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				setLastAvailable(LAST_AVAILABLE_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__DATA:
				setData(DATA_EDEFAULT);
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
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				return FIRST_AVAILABLE_EDEFAULT == null ? firstAvailable != null : !FIRST_AVAILABLE_EDEFAULT.equals(firstAvailable);
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				return LAST_AVAILABLE_EDEFAULT == null ? lastAvailable != null : !LAST_AVAILABLE_EDEFAULT.equals(lastAvailable);
			case ModelPackage.TEST_OBJECT1__COUNT:
				return count != COUNT_EDEFAULT;
			case ModelPackage.TEST_OBJECT1__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
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
		result.append(" (firstAvailable: ");
		result.append(firstAvailable);
		result.append(", lastAvailable: ");
		result.append(lastAvailable);
		result.append(", count: ");
		result.append(count);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} // TestObject1
