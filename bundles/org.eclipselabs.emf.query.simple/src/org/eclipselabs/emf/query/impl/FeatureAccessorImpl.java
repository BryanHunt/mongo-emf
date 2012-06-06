/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.query.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.emf.query.FeatureAccessor;
import org.eclipselabs.emf.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Accessor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.query.impl.FeatureAccessorImpl#getFeatureAccessor <em>Feature Accessor</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.impl.FeatureAccessorImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.eclipselabs.emf.query.impl.FeatureAccessorImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureAccessorImpl extends ExpressionImpl implements FeatureAccessor
{
  /**
	 * The cached value of the '{@link #getFeatureAccessor() <em>Feature Accessor</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeatureAccessor()
	 * @generated
	 * @ordered
	 */
  protected FeatureAccessor featureAccessor;

  /**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
  protected static final String FEATURE_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
  protected String featureName = FEATURE_NAME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
  protected EStructuralFeature feature;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected FeatureAccessorImpl()
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
		return QueryPackage.Literals.FEATURE_ACCESSOR;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FeatureAccessor getFeatureAccessor()
  {
		return featureAccessor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetFeatureAccessor(FeatureAccessor newFeatureAccessor, NotificationChain msgs)
  {
		FeatureAccessor oldFeatureAccessor = featureAccessor;
		featureAccessor = newFeatureAccessor;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR, oldFeatureAccessor, newFeatureAccessor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFeatureAccessor(FeatureAccessor newFeatureAccessor)
  {
		if (newFeatureAccessor != featureAccessor)
		{
			NotificationChain msgs = null;
			if (featureAccessor != null)
				msgs = ((InternalEObject)featureAccessor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR, null, msgs);
			if (newFeatureAccessor != null)
				msgs = ((InternalEObject)newFeatureAccessor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR, null, msgs);
			msgs = basicSetFeatureAccessor(newFeatureAccessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR, newFeatureAccessor, newFeatureAccessor));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getFeatureName()
  {
		return featureName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFeatureName(String newFeatureName)
  {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FEATURE_ACCESSOR__FEATURE_NAME, oldFeatureName, featureName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EStructuralFeature getFeature()
  {
		if (feature != null && feature.eIsProxy())
		{
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (EStructuralFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.FEATURE_ACCESSOR__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EStructuralFeature basicGetFeature()
  {
		return feature;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFeature(EStructuralFeature newFeature)
  {
		EStructuralFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FEATURE_ACCESSOR__FEATURE, oldFeature, feature));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID)
		{
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR:
				return basicSetFeatureAccessor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR:
				return getFeatureAccessor();
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_NAME:
				return getFeatureName();
			case QueryPackage.FEATURE_ACCESSOR__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
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
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR:
				setFeatureAccessor((FeatureAccessor)newValue);
				return;
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case QueryPackage.FEATURE_ACCESSOR__FEATURE:
				setFeature((EStructuralFeature)newValue);
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
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR:
				setFeatureAccessor((FeatureAccessor)null);
				return;
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case QueryPackage.FEATURE_ACCESSOR__FEATURE:
				setFeature((EStructuralFeature)null);
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
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_ACCESSOR:
				return featureAccessor != null;
			case QueryPackage.FEATURE_ACCESSOR__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case QueryPackage.FEATURE_ACCESSOR__FEATURE:
				return feature != null;
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
		result.append(" (featureName: ");
		result.append(featureName);
		result.append(')');
		return result.toString();
	}

} //FeatureAccessorImpl
