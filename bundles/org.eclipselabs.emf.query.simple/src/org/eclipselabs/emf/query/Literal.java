/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.query.Literal#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.Literal#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.query.QueryPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends Expression
{
  /**
	 * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Value</em>' attribute.
	 * @see #setLiteralValue(String)
	 * @see org.eclipselabs.emf.query.QueryPackage#getLiteral_LiteralValue()
	 * @model required="true"
	 * @generated
	 */
  String getLiteralValue();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.Literal#getLiteralValue <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' attribute.
	 * @see #getLiteralValue()
	 * @generated
	 */
  void setLiteralValue(String value);

  /**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.eclipselabs.emf.query.QueryPackage#getLiteral_Value()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
  Object getValue();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.Literal#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(Object value);

} // Literal
