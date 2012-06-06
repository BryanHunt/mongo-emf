/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.query;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Accessor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.query.FeatureAccessor#getFeatureAccessor <em>Feature Accessor</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.FeatureAccessor#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.FeatureAccessor#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.query.QueryPackage#getFeatureAccessor()
 * @model
 * @generated
 */
public interface FeatureAccessor extends Expression
{
  /**
	 * Returns the value of the '<em><b>Feature Accessor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature Accessor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Accessor</em>' containment reference.
	 * @see #setFeatureAccessor(FeatureAccessor)
	 * @see org.eclipselabs.emf.query.QueryPackage#getFeatureAccessor_FeatureAccessor()
	 * @model containment="true"
	 * @generated
	 */
  FeatureAccessor getFeatureAccessor();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.FeatureAccessor#getFeatureAccessor <em>Feature Accessor</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Accessor</em>' containment reference.
	 * @see #getFeatureAccessor()
	 * @generated
	 */
  void setFeatureAccessor(FeatureAccessor value);

  /**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see org.eclipselabs.emf.query.QueryPackage#getFeatureAccessor_FeatureName()
	 * @model required="true"
	 * @generated
	 */
  String getFeatureName();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.FeatureAccessor#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
  void setFeatureName(String value);

  /**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see org.eclipselabs.emf.query.QueryPackage#getFeatureAccessor_Feature()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
  EStructuralFeature getFeature();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.FeatureAccessor#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
  void setFeature(EStructuralFeature value);

} // FeatureAccessor
