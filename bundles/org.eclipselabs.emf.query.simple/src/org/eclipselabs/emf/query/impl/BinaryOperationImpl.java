/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.query.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.emf.query.BinaryOperation;
import org.eclipselabs.emf.query.Expression;
import org.eclipselabs.emf.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.query.impl.BinaryOperationImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.impl.BinaryOperationImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.impl.BinaryOperationImpl#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryOperationImpl extends ExpressionImpl implements BinaryOperation
{
  /**
	 * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
  protected Expression leftOperand;

  /**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
  protected static final String OPERATOR_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
  protected String operator = OPERATOR_EDEFAULT;

  /**
	 * The cached value of the '{@link #getRightOperand() <em>Right Operand</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRightOperand()
	 * @generated
	 * @ordered
	 */
  protected Expression rightOperand;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected BinaryOperationImpl()
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
		return QueryPackage.Literals.BINARY_OPERATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Expression getLeftOperand()
  {
		if (leftOperand != null && leftOperand.eIsProxy())
		{
			InternalEObject oldLeftOperand = (InternalEObject)leftOperand;
			leftOperand = (Expression)eResolveProxy(oldLeftOperand);
			if (leftOperand != oldLeftOperand)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.BINARY_OPERATION__LEFT_OPERAND, oldLeftOperand, leftOperand));
			}
		}
		return leftOperand;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Expression basicGetLeftOperand()
  {
		return leftOperand;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLeftOperand(Expression newLeftOperand)
  {
		Expression oldLeftOperand = leftOperand;
		leftOperand = newLeftOperand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.BINARY_OPERATION__LEFT_OPERAND, oldLeftOperand, leftOperand));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getOperator()
  {
		return operator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOperator(String newOperator)
  {
		String oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.BINARY_OPERATION__OPERATOR, oldOperator, operator));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Expression getRightOperand()
  {
		if (rightOperand != null && rightOperand.eIsProxy())
		{
			InternalEObject oldRightOperand = (InternalEObject)rightOperand;
			rightOperand = (Expression)eResolveProxy(oldRightOperand);
			if (rightOperand != oldRightOperand)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.BINARY_OPERATION__RIGHT_OPERAND, oldRightOperand, rightOperand));
			}
		}
		return rightOperand;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Expression basicGetRightOperand()
  {
		return rightOperand;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRightOperand(Expression newRightOperand)
  {
		Expression oldRightOperand = rightOperand;
		rightOperand = newRightOperand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.BINARY_OPERATION__RIGHT_OPERAND, oldRightOperand, rightOperand));
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
			case QueryPackage.BINARY_OPERATION__LEFT_OPERAND:
				if (resolve) return getLeftOperand();
				return basicGetLeftOperand();
			case QueryPackage.BINARY_OPERATION__OPERATOR:
				return getOperator();
			case QueryPackage.BINARY_OPERATION__RIGHT_OPERAND:
				if (resolve) return getRightOperand();
				return basicGetRightOperand();
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
			case QueryPackage.BINARY_OPERATION__LEFT_OPERAND:
				setLeftOperand((Expression)newValue);
				return;
			case QueryPackage.BINARY_OPERATION__OPERATOR:
				setOperator((String)newValue);
				return;
			case QueryPackage.BINARY_OPERATION__RIGHT_OPERAND:
				setRightOperand((Expression)newValue);
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
			case QueryPackage.BINARY_OPERATION__LEFT_OPERAND:
				setLeftOperand((Expression)null);
				return;
			case QueryPackage.BINARY_OPERATION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case QueryPackage.BINARY_OPERATION__RIGHT_OPERAND:
				setRightOperand((Expression)null);
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
			case QueryPackage.BINARY_OPERATION__LEFT_OPERAND:
				return leftOperand != null;
			case QueryPackage.BINARY_OPERATION__OPERATOR:
				return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
			case QueryPackage.BINARY_OPERATION__RIGHT_OPERAND:
				return rightOperand != null;
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
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //BinaryOperationImpl
