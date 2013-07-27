/**
 */
package org.eclipselabs.mongoemf.junit.model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongoemf.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}</li>
 *   <li>{@link org.eclipselabs.mongoemf.junit.model.TargetObject#getArrayAttribute <em>Array Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongoemf.junit.model.ModelPackage#getTargetObject()
 * @model kind="class"
 * @generated
 */
public class TargetObject extends EObjectImpl implements EObject
{
	/**
	 * The default value of the '{@link #getSingleAttribute() <em>Single Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String SINGLE_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSingleAttribute() <em>Single Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleAttribute()
	 * @generated
	 * @ordered
	 */
	protected String singleAttribute = SINGLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArrayAttribute() <em>Array Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<String> arrayAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetObject()
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
		return ModelPackage.Literals.TARGET_OBJECT;
	}

	/**
	 * Returns the value of the '<em><b>Single Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Attribute</em>' attribute.
	 * @see #setSingleAttribute(String)
	 * @see org.eclipselabs.mongoemf.junit.model.ModelPackage#getTargetObject_SingleAttribute()
	 * @model
	 * @generated
	 */
	public String getSingleAttribute()
	{
		return singleAttribute;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongoemf.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Attribute</em>' attribute.
	 * @see #getSingleAttribute()
	 * @generated
	 */
	public void setSingleAttribute(String newSingleAttribute)
	{
		String oldSingleAttribute = singleAttribute;
		singleAttribute = newSingleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE, oldSingleAttribute, singleAttribute));
	}

	/**
	 * Returns the value of the '<em><b>Array Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Attribute</em>' attribute list.
	 * @see org.eclipselabs.mongoemf.junit.model.ModelPackage#getTargetObject_ArrayAttribute()
	 * @model
	 * @generated
	 */
	public EList<String> getArrayAttribute()
	{
		if (arrayAttribute == null)
		{
			arrayAttribute = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE);
		}
		return arrayAttribute;
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
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				return getSingleAttribute();
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				return getArrayAttribute();
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
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				setSingleAttribute((String)newValue);
				return;
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				getArrayAttribute().clear();
				getArrayAttribute().addAll((Collection<? extends String>)newValue);
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
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				setSingleAttribute(SINGLE_ATTRIBUTE_EDEFAULT);
				return;
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				getArrayAttribute().clear();
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
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				return SINGLE_ATTRIBUTE_EDEFAULT == null ? singleAttribute != null : !SINGLE_ATTRIBUTE_EDEFAULT.equals(singleAttribute);
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				return arrayAttribute != null && !arrayAttribute.isEmpty();
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
		result.append(" (singleAttribute: ");
		result.append(singleAttribute);
		result.append(", arrayAttribute: ");
		result.append(arrayAttribute);
		result.append(')');
		return result.toString();
	}

} // TargetObject
