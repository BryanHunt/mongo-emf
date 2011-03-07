/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mongo.emf.junit.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mongo.emf.junit.model.ModelPackage;
import org.eclipselabs.mongo.emf.junit.model.PrimaryObject;
import org.eclipselabs.mongo.emf.junit.model.TargetObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getFeatureMapType2 <em>Feature Map Type2</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getFeatureMapType1 <em>Feature Map Type1</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.PrimaryObjectImpl#getFeatureMapCollection <em>Feature Map Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryObjectImpl extends EObjectImpl implements PrimaryObject
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
	 * The cached value of the '{@link #getSingleNonContainmentReference() <em>Single Non Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleNonContainmentReference()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleNonContainmentReference;

	/**
	 * The cached value of the '{@link #getMultipleNonContainmentReference() <em>Multiple Non Containment Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleNonContainmentReference()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetObject> multipleNonContainmentReference;

	/**
	 * The cached value of the '{@link #getSingleContainmentReferenceNoProxies() <em>Single Containment Reference No Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleContainmentReferenceNoProxies()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getMultipleContainmentReferenceNoProxies() <em>Multiple Containment Reference No Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleContainmentReferenceNoProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetObject> multipleContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getSingleContainmentReferenceProxies() <em>Single Containment Reference Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleContainmentReferenceProxies()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleContainmentReferenceProxies;

	/**
	 * The cached value of the '{@link #getMultipleContainmentReferenceProxies() <em>Multiple Containment Reference Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleContainmentReferenceProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetObject> multipleContainmentReferenceProxies;

	/**
	 * The cached value of the '{@link #getFeatureMapCollection() <em>Feature Map Collection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapCollection()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap featureMapCollection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimaryObjectImpl()
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
		return ModelPackage.Literals.PRIMARY_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject getSingleNonContainmentReference()
	{
		if (singleNonContainmentReference != null && singleNonContainmentReference.eIsProxy())
		{
			InternalEObject oldSingleNonContainmentReference = (InternalEObject)singleNonContainmentReference;
			singleNonContainmentReference = (TargetObject)eResolveProxy(oldSingleNonContainmentReference);
			if (singleNonContainmentReference != oldSingleNonContainmentReference)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, oldSingleNonContainmentReference, singleNonContainmentReference));
			}
		}
		return singleNonContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject basicGetSingleNonContainmentReference()
	{
		return singleNonContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleNonContainmentReference(TargetObject newSingleNonContainmentReference)
	{
		TargetObject oldSingleNonContainmentReference = singleNonContainmentReference;
		singleNonContainmentReference = newSingleNonContainmentReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, oldSingleNonContainmentReference, singleNonContainmentReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetObject> getMultipleNonContainmentReference()
	{
		if (multipleNonContainmentReference == null)
		{
			multipleNonContainmentReference = new EObjectResolvingEList<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE);
		}
		return multipleNonContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject getSingleContainmentReferenceNoProxies()
	{
		return singleContainmentReferenceNoProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSingleContainmentReferenceNoProxies(TargetObject newSingleContainmentReferenceNoProxies, NotificationChain msgs)
	{
		TargetObject oldSingleContainmentReferenceNoProxies = singleContainmentReferenceNoProxies;
		singleContainmentReferenceNoProxies = newSingleContainmentReferenceNoProxies;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, oldSingleContainmentReferenceNoProxies, newSingleContainmentReferenceNoProxies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleContainmentReferenceNoProxies(TargetObject newSingleContainmentReferenceNoProxies)
	{
		if (newSingleContainmentReferenceNoProxies != singleContainmentReferenceNoProxies)
		{
			NotificationChain msgs = null;
			if (singleContainmentReferenceNoProxies != null)
				msgs = ((InternalEObject)singleContainmentReferenceNoProxies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, null, msgs);
			if (newSingleContainmentReferenceNoProxies != null)
				msgs = ((InternalEObject)newSingleContainmentReferenceNoProxies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, null, msgs);
			msgs = basicSetSingleContainmentReferenceNoProxies(newSingleContainmentReferenceNoProxies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, newSingleContainmentReferenceNoProxies, newSingleContainmentReferenceNoProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetObject> getMultipleContainmentReferenceNoProxies()
	{
		if (multipleContainmentReferenceNoProxies == null)
		{
			multipleContainmentReferenceNoProxies = new EObjectContainmentEList<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES);
		}
		return multipleContainmentReferenceNoProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject getSingleContainmentReferenceProxies()
	{
		if (singleContainmentReferenceProxies != null && singleContainmentReferenceProxies.eIsProxy())
		{
			InternalEObject oldSingleContainmentReferenceProxies = (InternalEObject)singleContainmentReferenceProxies;
			singleContainmentReferenceProxies = (TargetObject)eResolveProxy(oldSingleContainmentReferenceProxies);
			if (singleContainmentReferenceProxies != oldSingleContainmentReferenceProxies)
			{
				InternalEObject newSingleContainmentReferenceProxies = (InternalEObject)singleContainmentReferenceProxies;
				NotificationChain msgs = oldSingleContainmentReferenceProxies.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, null);
				if (newSingleContainmentReferenceProxies.eInternalContainer() == null)
				{
					msgs = newSingleContainmentReferenceProxies.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, oldSingleContainmentReferenceProxies, singleContainmentReferenceProxies));
			}
		}
		return singleContainmentReferenceProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject basicGetSingleContainmentReferenceProxies()
	{
		return singleContainmentReferenceProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSingleContainmentReferenceProxies(TargetObject newSingleContainmentReferenceProxies, NotificationChain msgs)
	{
		TargetObject oldSingleContainmentReferenceProxies = singleContainmentReferenceProxies;
		singleContainmentReferenceProxies = newSingleContainmentReferenceProxies;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, oldSingleContainmentReferenceProxies, newSingleContainmentReferenceProxies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleContainmentReferenceProxies(TargetObject newSingleContainmentReferenceProxies)
	{
		if (newSingleContainmentReferenceProxies != singleContainmentReferenceProxies)
		{
			NotificationChain msgs = null;
			if (singleContainmentReferenceProxies != null)
				msgs = ((InternalEObject)singleContainmentReferenceProxies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
			if (newSingleContainmentReferenceProxies != null)
				msgs = ((InternalEObject)newSingleContainmentReferenceProxies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
			msgs = basicSetSingleContainmentReferenceProxies(newSingleContainmentReferenceProxies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, newSingleContainmentReferenceProxies, newSingleContainmentReferenceProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetObject> getMultipleContainmentReferenceProxies()
	{
		if (multipleContainmentReferenceProxies == null)
		{
			multipleContainmentReferenceProxies = new EObjectContainmentEList.Resolving<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES);
		}
		return multipleContainmentReferenceProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetObject> getFeatureMapType2()
	{
		return getFeatureMapCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_TYPE2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetObject> getFeatureMapType1()
	{
		return getFeatureMapCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_TYPE1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getFeatureMapCollection()
	{
		if (featureMapCollection == null)
		{
			featureMapCollection = new BasicFeatureMap(this, ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_COLLECTION);
		}
		return featureMapCollection;
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
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return basicSetSingleContainmentReferenceNoProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return ((InternalEList<?>)getMultipleContainmentReferenceNoProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				return basicSetSingleContainmentReferenceProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return ((InternalEList<?>)getMultipleContainmentReferenceProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE2:
				return ((InternalEList<?>)getFeatureMapType2()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE1:
				return ((InternalEList<?>)getFeatureMapType1()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_COLLECTION:
				return ((InternalEList<?>)getFeatureMapCollection()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PRIMARY_OBJECT__NAME:
				return getName();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				if (resolve) return getSingleNonContainmentReference();
				return basicGetSingleNonContainmentReference();
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				return getMultipleNonContainmentReference();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return getSingleContainmentReferenceNoProxies();
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return getMultipleContainmentReferenceNoProxies();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				if (resolve) return getSingleContainmentReferenceProxies();
				return basicGetSingleContainmentReferenceProxies();
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return getMultipleContainmentReferenceProxies();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE2:
				return getFeatureMapType2();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE1:
				return getFeatureMapType1();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_COLLECTION:
				if (coreType) return getFeatureMapCollection();
				return ((FeatureMap.Internal)getFeatureMapCollection()).getWrapper();
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
			case ModelPackage.PRIMARY_OBJECT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				setSingleNonContainmentReference((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				getMultipleNonContainmentReference().clear();
				getMultipleNonContainmentReference().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleContainmentReferenceNoProxies((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				getMultipleContainmentReferenceNoProxies().clear();
				getMultipleContainmentReferenceNoProxies().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				setSingleContainmentReferenceProxies((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				getMultipleContainmentReferenceProxies().clear();
				getMultipleContainmentReferenceProxies().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE2:
				getFeatureMapType2().clear();
				getFeatureMapType2().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE1:
				getFeatureMapType1().clear();
				getFeatureMapType1().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_COLLECTION:
				((FeatureMap.Internal)getFeatureMapCollection()).set(newValue);
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
			case ModelPackage.PRIMARY_OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				setSingleNonContainmentReference((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				getMultipleNonContainmentReference().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleContainmentReferenceNoProxies((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				getMultipleContainmentReferenceNoProxies().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				setSingleContainmentReferenceProxies((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				getMultipleContainmentReferenceProxies().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE2:
				getFeatureMapType2().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE1:
				getFeatureMapType1().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_COLLECTION:
				getFeatureMapCollection().clear();
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
			case ModelPackage.PRIMARY_OBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				return singleNonContainmentReference != null;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				return multipleNonContainmentReference != null && !multipleNonContainmentReference.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return singleContainmentReferenceNoProxies != null;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return multipleContainmentReferenceNoProxies != null && !multipleContainmentReferenceNoProxies.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				return singleContainmentReferenceProxies != null;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return multipleContainmentReferenceProxies != null && !multipleContainmentReferenceProxies.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE2:
				return !getFeatureMapType2().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_TYPE1:
				return !getFeatureMapType1().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_COLLECTION:
				return featureMapCollection != null && !featureMapCollection.isEmpty();
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
		result.append(", featureMapCollection: ");
		result.append(featureMapCollection);
		result.append(')');
		return result.toString();
	}

} //PrimaryObjectImpl
