/**
 */
package org.eclipselabs.mongoemf.example.model;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongoemf.example.model.Child#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mongoemf.example.model.Child#getAge <em>Age</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongoemf.example.model.ModelPackage#getChild()
 * @model kind="class"
 * @generated
 */
public class Child extends MinimalEObjectImpl.Container implements EObject
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAge()
   * @generated
   * @ordered
   */
  protected static final int AGE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAge()
   * @generated
   * @ordered
   */
  protected int age = AGE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Child()
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
    return ModelPackage.Literals.CHILD;
  }

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipselabs.mongoemf.example.model.ModelPackage#getChild_Name()
   * @model unique="false"
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.mongoemf.example.model.Child#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CHILD__NAME, oldName, name));
  }

  /**
   * Returns the value of the '<em><b>Age</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Age</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Age</em>' attribute.
   * @see #setAge(int)
   * @see org.eclipselabs.mongoemf.example.model.ModelPackage#getChild_Age()
   * @model unique="false"
   * @generated
   */
  public int getAge()
  {
    return age;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.mongoemf.example.model.Child#getAge <em>Age</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Age</em>' attribute.
   * @see #getAge()
   * @generated
   */
  public void setAge(int newAge)
  {
    int oldAge = age;
    age = newAge;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CHILD__AGE, oldAge, age));
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
      case ModelPackage.CHILD__NAME:
        return getName();
      case ModelPackage.CHILD__AGE:
        return getAge();
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
      case ModelPackage.CHILD__NAME:
        setName((String)newValue);
        return;
      case ModelPackage.CHILD__AGE:
        setAge((Integer)newValue);
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
      case ModelPackage.CHILD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ModelPackage.CHILD__AGE:
        setAge(AGE_EDEFAULT);
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
      case ModelPackage.CHILD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ModelPackage.CHILD__AGE:
        return age != AGE_EDEFAULT;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", age: ");
    result.append(age);
    result.append(')');
    return result.toString();
  }

} // Child
