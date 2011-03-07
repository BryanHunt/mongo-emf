/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mongo.emf.junit.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapType2 <em>Feature Map Type2</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapType1 <em>Feature Map Type1</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getFeatureMapCollection <em>Feature Map Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject()
 * @model
 * @generated
 */
public interface PrimaryObject extends EObject
{
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
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Single Non Containment Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Non Containment Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Non Containment Reference</em>' reference.
	 * @see #setSingleNonContainmentReference(TargetObject)
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_SingleNonContainmentReference()
	 * @model
	 * @generated
	 */
	TargetObject getSingleNonContainmentReference();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Non Containment Reference</em>' reference.
	 * @see #getSingleNonContainmentReference()
	 * @generated
	 */
	void setSingleNonContainmentReference(TargetObject value);

	/**
	 * Returns the value of the '<em><b>Multiple Non Containment Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Non Containment Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Non Containment Reference</em>' reference list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_MultipleNonContainmentReference()
	 * @model
	 * @generated
	 */
	EList<TargetObject> getMultipleNonContainmentReference();

	/**
	 * Returns the value of the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference No Proxies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @see #setSingleContainmentReferenceNoProxies(TargetObject)
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_SingleContainmentReferenceNoProxies()
	 * @model containment="true"
	 * @generated
	 */
	TargetObject getSingleContainmentReferenceNoProxies();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @see #getSingleContainmentReferenceNoProxies()
	 * @generated
	 */
	void setSingleContainmentReferenceNoProxies(TargetObject value);

	/**
	 * Returns the value of the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference No Proxies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Containment Reference No Proxies</em>' containment reference list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_MultipleContainmentReferenceNoProxies()
	 * @model containment="true"
	 * @generated
	 */
	EList<TargetObject> getMultipleContainmentReferenceNoProxies();

	/**
	 * Returns the value of the '<em><b>Single Containment Reference Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference Proxies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @see #setSingleContainmentReferenceProxies(TargetObject)
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_SingleContainmentReferenceProxies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	TargetObject getSingleContainmentReferenceProxies();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @see #getSingleContainmentReferenceProxies()
	 * @generated
	 */
	void setSingleContainmentReferenceProxies(TargetObject value);

	/**
	 * Returns the value of the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference Proxies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Containment Reference Proxies</em>' containment reference list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_MultipleContainmentReferenceProxies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<TargetObject> getMultipleContainmentReferenceProxies();

	/**
	 * Returns the value of the '<em><b>Feature Map Type2</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Type2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Type2</em>' containment reference list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_FeatureMapType2()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#featureMapCollection'"
	 * @generated
	 */
	EList<TargetObject> getFeatureMapType2();

	/**
	 * Returns the value of the '<em><b>Feature Map Type1</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Type1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Type1</em>' containment reference list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_FeatureMapType1()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#featureMapCollection'"
	 * @generated
	 */
	EList<TargetObject> getFeatureMapType1();

	/**
	 * Returns the value of the '<em><b>Feature Map Collection</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Collection</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Collection</em>' attribute list.
	 * @see org.eclipselabs.mongo.emf.junit.model.ModelPackage#getPrimaryObject_FeatureMapCollection()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
	 *        extendedMetaData="kind='group'"
	 * @generated
	 */
	FeatureMap getFeatureMapCollection();

} // PrimaryObject
