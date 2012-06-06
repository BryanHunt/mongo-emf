/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.emf.query.QueryFactory
 * @model kind="package"
 * @generated
 */
public interface QueryPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "query";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.eclipselabs.org/emf/2010/query";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "query";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  QueryPackage eINSTANCE = org.eclipselabs.emf.query.impl.QueryPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.eclipselabs.emf.query.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.query.impl.ExpressionImpl
	 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getExpression()
	 * @generated
	 */
  int EXPRESSION = 0;

  /**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.eclipselabs.emf.query.impl.FeatureAccessorImpl <em>Feature Accessor</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.query.impl.FeatureAccessorImpl
	 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getFeatureAccessor()
	 * @generated
	 */
  int FEATURE_ACCESSOR = 1;

  /**
	 * The feature id for the '<em><b>Feature Accessor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE_ACCESSOR__FEATURE_ACCESSOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE_ACCESSOR__FEATURE_NAME = EXPRESSION_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE_ACCESSOR__FEATURE = EXPRESSION_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Feature Accessor</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE_ACCESSOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.eclipselabs.emf.query.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.query.impl.LiteralImpl
	 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getLiteral()
	 * @generated
	 */
  int LITERAL = 2;

  /**
	 * The feature id for the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LITERAL__LITERAL_VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.eclipselabs.emf.query.impl.BinaryOperationImpl <em>Binary Operation</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.query.impl.BinaryOperationImpl
	 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getBinaryOperation()
	 * @generated
	 */
  int BINARY_OPERATION = 3;

  /**
	 * The feature id for the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_OPERATION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_OPERATION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_OPERATION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Binary Operation</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_OPERATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;


  /**
	 * Returns the meta object for class '{@link org.eclipselabs.emf.query.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipselabs.emf.query.Expression
	 * @generated
	 */
  EClass getExpression();

  /**
	 * Returns the meta object for class '{@link org.eclipselabs.emf.query.FeatureAccessor <em>Feature Accessor</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Accessor</em>'.
	 * @see org.eclipselabs.emf.query.FeatureAccessor
	 * @generated
	 */
  EClass getFeatureAccessor();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emf.query.FeatureAccessor#getFeatureAccessor <em>Feature Accessor</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Accessor</em>'.
	 * @see org.eclipselabs.emf.query.FeatureAccessor#getFeatureAccessor()
	 * @see #getFeatureAccessor()
	 * @generated
	 */
  EReference getFeatureAccessor_FeatureAccessor();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.query.FeatureAccessor#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipselabs.emf.query.FeatureAccessor#getFeatureName()
	 * @see #getFeatureAccessor()
	 * @generated
	 */
  EAttribute getFeatureAccessor_FeatureName();

  /**
	 * Returns the meta object for the reference '{@link org.eclipselabs.emf.query.FeatureAccessor#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipselabs.emf.query.FeatureAccessor#getFeature()
	 * @see #getFeatureAccessor()
	 * @generated
	 */
  EReference getFeatureAccessor_Feature();

  /**
	 * Returns the meta object for class '{@link org.eclipselabs.emf.query.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.eclipselabs.emf.query.Literal
	 * @generated
	 */
  EClass getLiteral();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.query.Literal#getLiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal Value</em>'.
	 * @see org.eclipselabs.emf.query.Literal#getLiteralValue()
	 * @see #getLiteral()
	 * @generated
	 */
  EAttribute getLiteral_LiteralValue();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.query.Literal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipselabs.emf.query.Literal#getValue()
	 * @see #getLiteral()
	 * @generated
	 */
  EAttribute getLiteral_Value();

  /**
	 * Returns the meta object for class '{@link org.eclipselabs.emf.query.BinaryOperation <em>Binary Operation</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operation</em>'.
	 * @see org.eclipselabs.emf.query.BinaryOperation
	 * @generated
	 */
  EClass getBinaryOperation();

  /**
	 * Returns the meta object for the reference '{@link org.eclipselabs.emf.query.BinaryOperation#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.emf.query.BinaryOperation#getLeftOperand()
	 * @see #getBinaryOperation()
	 * @generated
	 */
  EReference getBinaryOperation_LeftOperand();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.query.BinaryOperation#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.emf.query.BinaryOperation#getOperator()
	 * @see #getBinaryOperation()
	 * @generated
	 */
  EAttribute getBinaryOperation_Operator();

  /**
	 * Returns the meta object for the reference '{@link org.eclipselabs.emf.query.BinaryOperation#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.emf.query.BinaryOperation#getRightOperand()
	 * @see #getBinaryOperation()
	 * @generated
	 */
  EReference getBinaryOperation_RightOperand();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  QueryFactory getQueryFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link org.eclipselabs.emf.query.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.query.impl.ExpressionImpl
		 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getExpression()
		 * @generated
		 */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
		 * The meta object literal for the '{@link org.eclipselabs.emf.query.impl.FeatureAccessorImpl <em>Feature Accessor</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.query.impl.FeatureAccessorImpl
		 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getFeatureAccessor()
		 * @generated
		 */
    EClass FEATURE_ACCESSOR = eINSTANCE.getFeatureAccessor();

    /**
		 * The meta object literal for the '<em><b>Feature Accessor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FEATURE_ACCESSOR__FEATURE_ACCESSOR = eINSTANCE.getFeatureAccessor_FeatureAccessor();

    /**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FEATURE_ACCESSOR__FEATURE_NAME = eINSTANCE.getFeatureAccessor_FeatureName();

    /**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FEATURE_ACCESSOR__FEATURE = eINSTANCE.getFeatureAccessor_Feature();

    /**
		 * The meta object literal for the '{@link org.eclipselabs.emf.query.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.query.impl.LiteralImpl
		 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getLiteral()
		 * @generated
		 */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
		 * The meta object literal for the '<em><b>Literal Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LITERAL__LITERAL_VALUE = eINSTANCE.getLiteral_LiteralValue();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

    /**
		 * The meta object literal for the '{@link org.eclipselabs.emf.query.impl.BinaryOperationImpl <em>Binary Operation</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.query.impl.BinaryOperationImpl
		 * @see org.eclipselabs.emf.query.impl.QueryPackageImpl#getBinaryOperation()
		 * @generated
		 */
    EClass BINARY_OPERATION = eINSTANCE.getBinaryOperation();

    /**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference BINARY_OPERATION__LEFT_OPERAND = eINSTANCE.getBinaryOperation_LeftOperand();

    /**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute BINARY_OPERATION__OPERATOR = eINSTANCE.getBinaryOperation_Operator();

    /**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference BINARY_OPERATION__RIGHT_OPERAND = eINSTANCE.getBinaryOperation_RightOperand();

  }

} //QueryPackage
