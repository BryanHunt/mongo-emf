/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.query.BinaryOperation#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.BinaryOperation#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.BinaryOperation#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.query.QueryPackage#getBinaryOperation()
 * @model
 * @generated
 */
public interface BinaryOperation extends Expression
{
  /**
	 * Returns the value of the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Operand</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' reference.
	 * @see #setLeftOperand(Expression)
	 * @see org.eclipselabs.emf.query.QueryPackage#getBinaryOperation_LeftOperand()
	 * @model required="true"
	 * @generated
	 */
  Expression getLeftOperand();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.BinaryOperation#getLeftOperand <em>Left Operand</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
  void setLeftOperand(Expression value);

  /**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipselabs.emf.query.QueryPackage#getBinaryOperation_Operator()
	 * @model required="true"
	 * @generated
	 */
  String getOperator();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.BinaryOperation#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
  void setOperator(String value);

  /**
	 * Returns the value of the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Operand</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' reference.
	 * @see #setRightOperand(Expression)
	 * @see org.eclipselabs.emf.query.QueryPackage#getBinaryOperation_RightOperand()
	 * @model required="true"
	 * @generated
	 */
  Expression getRightOperand();

  /**
	 * Sets the value of the '{@link org.eclipselabs.emf.query.BinaryOperation#getRightOperand <em>Right Operand</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' reference.
	 * @see #getRightOperand()
	 * @generated
	 */
  void setRightOperand(Expression value);

} // BinaryOperation
