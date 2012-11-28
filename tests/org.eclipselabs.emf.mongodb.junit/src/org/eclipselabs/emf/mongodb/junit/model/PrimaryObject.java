/**
 */
package org.eclipselabs.emf.mongodb.junit.model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceType1 <em>Feature Map Reference Type1</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceType2 <em>Feature Map Reference Type2</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceCollection <em>Feature Map Reference Collection</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeType1 <em>Feature Map Attribute Type1</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeType2 <em>Feature Map Attribute Type2</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeCollection <em>Feature Map Attribute Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject()
 * @model kind="class"
 * @generated
 */
public class PrimaryObject extends EObjectImpl implements EObject
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
	 * The default value of the '{@link #getIdAttribute() <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdAttribute() <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdAttribute()
	 * @generated
	 * @ordered
	 */
	protected String idAttribute = ID_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnsettableAttribute() <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String UNSETTABLE_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnsettableAttribute() <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttribute()
	 * @generated
	 * @ordered
	 */
	protected String unsettableAttribute = UNSETTABLE_ATTRIBUTE_EDEFAULT;

	/**
	 * This is true if the Unsettable Attribute attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unsettableAttributeESet;

	/**
	 * The default value of the '{@link #getUnsettableAttributeWithNonNullDefault() <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT = "junit";

	/**
	 * The cached value of the '{@link #getUnsettableAttributeWithNonNullDefault() <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @generated
	 * @ordered
	 */
	protected String unsettableAttributeWithNonNullDefault = UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT;

	/**
	 * This is true if the Unsettable Attribute With Non Null Default attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unsettableAttributeWithNonNullDefaultESet;

	/**
	 * The cached value of the '{@link #getUnsettableReference() <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableReference()
	 * @generated
	 * @ordered
	 */
	protected TargetObject unsettableReference;

	/**
	 * This is true if the Unsettable Reference reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unsettableReferenceESet;

	/**
	 * The cached value of the '{@link #getContainmentReferenceSameCollectioin() <em>Containment Reference Same Collectioin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainmentReferenceSameCollectioin()
	 * @generated
	 * @ordered
	 */
	protected PrimaryObject containmentReferenceSameCollectioin;

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
	 * The cached value of the '{@link #getSingleNonContainmentReferenceNoProxies() <em>Single Non Containment Reference No Proxies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleNonContainmentReferenceNoProxies()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleNonContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getFeatureMapReferenceCollection() <em>Feature Map Reference Collection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapReferenceCollection()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap featureMapReferenceCollection;

	/**
	 * The cached value of the '{@link #getFeatureMapAttributeCollection() <em>Feature Map Attribute Collection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapAttributeCollection()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap featureMapAttributeCollection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimaryObject()
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_Name()
	 * @model
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getName <em>Name</em>}' attribute.
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__NAME, oldName, name));
	}

	/**
	 * Returns the value of the '<em><b>Id Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Attribute</em>' attribute.
	 * @see #setIdAttribute(String)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_IdAttribute()
	 * @model id="true"
	 * @generated
	 */
	public String getIdAttribute()
	{
		return idAttribute;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Attribute</em>' attribute.
	 * @see #getIdAttribute()
	 * @generated
	 */
	public void setIdAttribute(String newIdAttribute)
	{
		String oldIdAttribute = idAttribute;
		idAttribute = newIdAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE, oldIdAttribute, idAttribute));
	}

	/**
	 * Returns the value of the '<em><b>Unsettable Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsettable Attribute</em>' attribute.
	 * @see #isSetUnsettableAttribute()
	 * @see #unsetUnsettableAttribute()
	 * @see #setUnsettableAttribute(String)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_UnsettableAttribute()
	 * @model unsettable="true"
	 * @generated
	 */
	public String getUnsettableAttribute()
	{
		return unsettableAttribute;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsettable Attribute</em>' attribute.
	 * @see #isSetUnsettableAttribute()
	 * @see #unsetUnsettableAttribute()
	 * @see #getUnsettableAttribute()
	 * @generated
	 */
	public void setUnsettableAttribute(String newUnsettableAttribute)
	{
		String oldUnsettableAttribute = unsettableAttribute;
		unsettableAttribute = newUnsettableAttribute;
		boolean oldUnsettableAttributeESet = unsettableAttributeESet;
		unsettableAttributeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE, oldUnsettableAttribute, unsettableAttribute, !oldUnsettableAttributeESet));
	}

	/**
	 * Unsets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnsettableAttribute()
	 * @see #getUnsettableAttribute()
	 * @see #setUnsettableAttribute(String)
	 * @generated
	 */
	public void unsetUnsettableAttribute()
	{
		String oldUnsettableAttribute = unsettableAttribute;
		boolean oldUnsettableAttributeESet = unsettableAttributeESet;
		unsettableAttribute = UNSETTABLE_ATTRIBUTE_EDEFAULT;
		unsettableAttributeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE, oldUnsettableAttribute, UNSETTABLE_ATTRIBUTE_EDEFAULT, oldUnsettableAttributeESet));
	}

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unsettable Attribute</em>' attribute is set.
	 * @see #unsetUnsettableAttribute()
	 * @see #getUnsettableAttribute()
	 * @see #setUnsettableAttribute(String)
	 * @generated
	 */
	public boolean isSetUnsettableAttribute()
	{
		return unsettableAttributeESet;
	}

	/**
	 * Returns the value of the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute.
	 * The default value is <code>"junit"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Attribute With Non Null Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute.
	 * @see #isSetUnsettableAttributeWithNonNullDefault()
	 * @see #unsetUnsettableAttributeWithNonNullDefault()
	 * @see #setUnsettableAttributeWithNonNullDefault(String)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_UnsettableAttributeWithNonNullDefault()
	 * @model default="junit" unsettable="true"
	 * @generated
	 */
	public String getUnsettableAttributeWithNonNullDefault()
	{
		return unsettableAttributeWithNonNullDefault;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute.
	 * @see #isSetUnsettableAttributeWithNonNullDefault()
	 * @see #unsetUnsettableAttributeWithNonNullDefault()
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @generated
	 */
	public void setUnsettableAttributeWithNonNullDefault(String newUnsettableAttributeWithNonNullDefault)
	{
		String oldUnsettableAttributeWithNonNullDefault = unsettableAttributeWithNonNullDefault;
		unsettableAttributeWithNonNullDefault = newUnsettableAttributeWithNonNullDefault;
		boolean oldUnsettableAttributeWithNonNullDefaultESet = unsettableAttributeWithNonNullDefaultESet;
		unsettableAttributeWithNonNullDefaultESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT, oldUnsettableAttributeWithNonNullDefault, unsettableAttributeWithNonNullDefault, !oldUnsettableAttributeWithNonNullDefaultESet));
	}

	/**
	 * Unsets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnsettableAttributeWithNonNullDefault()
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @see #setUnsettableAttributeWithNonNullDefault(String)
	 * @generated
	 */
	public void unsetUnsettableAttributeWithNonNullDefault()
	{
		String oldUnsettableAttributeWithNonNullDefault = unsettableAttributeWithNonNullDefault;
		boolean oldUnsettableAttributeWithNonNullDefaultESet = unsettableAttributeWithNonNullDefaultESet;
		unsettableAttributeWithNonNullDefault = UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT;
		unsettableAttributeWithNonNullDefaultESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT, oldUnsettableAttributeWithNonNullDefault, UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT, oldUnsettableAttributeWithNonNullDefaultESet));
	}

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute is set.
	 * @see #unsetUnsettableAttributeWithNonNullDefault()
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @see #setUnsettableAttributeWithNonNullDefault(String)
	 * @generated
	 */
	public boolean isSetUnsettableAttributeWithNonNullDefault()
	{
		return unsettableAttributeWithNonNullDefaultESet;
	}

	/**
	 * Returns the value of the '<em><b>Unsettable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsettable Reference</em>' reference.
	 * @see #isSetUnsettableReference()
	 * @see #unsetUnsettableReference()
	 * @see #setUnsettableReference(TargetObject)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_UnsettableReference()
	 * @model unsettable="true"
	 * @generated
	 */
	public TargetObject getUnsettableReference()
	{
		if (unsettableReference != null && unsettableReference.eIsProxy())
		{
			InternalEObject oldUnsettableReference = (InternalEObject)unsettableReference;
			unsettableReference = (TargetObject)eResolveProxy(oldUnsettableReference);
			if (unsettableReference != oldUnsettableReference)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE, oldUnsettableReference, unsettableReference));
			}
		}
		return unsettableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject basicGetUnsettableReference()
	{
		return unsettableReference;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsettable Reference</em>' reference.
	 * @see #isSetUnsettableReference()
	 * @see #unsetUnsettableReference()
	 * @see #getUnsettableReference()
	 * @generated
	 */
	public void setUnsettableReference(TargetObject newUnsettableReference)
	{
		TargetObject oldUnsettableReference = unsettableReference;
		unsettableReference = newUnsettableReference;
		boolean oldUnsettableReferenceESet = unsettableReferenceESet;
		unsettableReferenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE, oldUnsettableReference, unsettableReference, !oldUnsettableReferenceESet));
	}

	/**
	 * Unsets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnsettableReference()
	 * @see #getUnsettableReference()
	 * @see #setUnsettableReference(TargetObject)
	 * @generated
	 */
	public void unsetUnsettableReference()
	{
		TargetObject oldUnsettableReference = unsettableReference;
		boolean oldUnsettableReferenceESet = unsettableReferenceESet;
		unsettableReference = null;
		unsettableReferenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE, oldUnsettableReference, null, oldUnsettableReferenceESet));
	}

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unsettable Reference</em>' reference is set.
	 * @see #unsetUnsettableReference()
	 * @see #getUnsettableReference()
	 * @see #setUnsettableReference(TargetObject)
	 * @generated
	 */
	public boolean isSetUnsettableReference()
	{
		return unsettableReferenceESet;
	}

	/**
	 * Returns the value of the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Reference Same Collectioin</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Reference Same Collectioin</em>' containment reference.
	 * @see #setContainmentReferenceSameCollectioin(PrimaryObject)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_ContainmentReferenceSameCollectioin()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	public PrimaryObject getContainmentReferenceSameCollectioin()
	{
		if (containmentReferenceSameCollectioin != null && containmentReferenceSameCollectioin.eIsProxy())
		{
			InternalEObject oldContainmentReferenceSameCollectioin = (InternalEObject)containmentReferenceSameCollectioin;
			containmentReferenceSameCollectioin = (PrimaryObject)eResolveProxy(oldContainmentReferenceSameCollectioin);
			if (containmentReferenceSameCollectioin != oldContainmentReferenceSameCollectioin)
			{
				InternalEObject newContainmentReferenceSameCollectioin = (InternalEObject)containmentReferenceSameCollectioin;
				NotificationChain msgs = oldContainmentReferenceSameCollectioin.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, null);
				if (newContainmentReferenceSameCollectioin.eInternalContainer() == null)
				{
					msgs = newContainmentReferenceSameCollectioin.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, oldContainmentReferenceSameCollectioin, containmentReferenceSameCollectioin));
			}
		}
		return containmentReferenceSameCollectioin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryObject basicGetContainmentReferenceSameCollectioin()
	{
		return containmentReferenceSameCollectioin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainmentReferenceSameCollectioin(PrimaryObject newContainmentReferenceSameCollectioin, NotificationChain msgs)
	{
		PrimaryObject oldContainmentReferenceSameCollectioin = containmentReferenceSameCollectioin;
		containmentReferenceSameCollectioin = newContainmentReferenceSameCollectioin;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, oldContainmentReferenceSameCollectioin, newContainmentReferenceSameCollectioin);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Reference Same Collectioin</em>' containment reference.
	 * @see #getContainmentReferenceSameCollectioin()
	 * @generated
	 */
	public void setContainmentReferenceSameCollectioin(PrimaryObject newContainmentReferenceSameCollectioin)
	{
		if (newContainmentReferenceSameCollectioin != containmentReferenceSameCollectioin)
		{
			NotificationChain msgs = null;
			if (containmentReferenceSameCollectioin != null)
				msgs = ((InternalEObject)containmentReferenceSameCollectioin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
			if (newContainmentReferenceSameCollectioin != null)
				msgs = ((InternalEObject)newContainmentReferenceSameCollectioin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
			msgs = basicSetContainmentReferenceSameCollectioin(newContainmentReferenceSameCollectioin, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, newContainmentReferenceSameCollectioin, newContainmentReferenceSameCollectioin));
	}

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
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_SingleNonContainmentReference()
	 * @model
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
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Non Containment Reference</em>' reference.
	 * @see #getSingleNonContainmentReference()
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
	 * Returns the value of the '<em><b>Multiple Non Containment Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.emf.mongodb.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Non Containment Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Non Containment Reference</em>' reference list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_MultipleNonContainmentReference()
	 * @model
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
	 * Returns the value of the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference No Proxies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @see #setSingleContainmentReferenceNoProxies(TargetObject)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_SingleContainmentReferenceNoProxies()
	 * @model containment="true"
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
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @see #getSingleContainmentReferenceNoProxies()
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
	 * Returns the value of the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emf.mongodb.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference No Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Containment Reference No Proxies</em>' containment reference list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_MultipleContainmentReferenceNoProxies()
	 * @model containment="true"
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
	 * Returns the value of the '<em><b>Single Containment Reference Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference Proxies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @see #setSingleContainmentReferenceProxies(TargetObject)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_SingleContainmentReferenceProxies()
	 * @model containment="true" resolveProxies="true"
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
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @see #getSingleContainmentReferenceProxies()
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
	 * Returns the value of the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emf.mongodb.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Containment Reference Proxies</em>' containment reference list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_MultipleContainmentReferenceProxies()
	 * @model containment="true" resolveProxies="true"
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
	 * Returns the value of the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Non Containment Reference No Proxies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Non Containment Reference No Proxies</em>' reference.
	 * @see #setSingleNonContainmentReferenceNoProxies(TargetObject)
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_SingleNonContainmentReferenceNoProxies()
	 * @model resolveProxies="false"
	 * @generated
	 */
	public TargetObject getSingleNonContainmentReferenceNoProxies()
	{
		return singleNonContainmentReferenceNoProxies;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Non Containment Reference No Proxies</em>' reference.
	 * @see #getSingleNonContainmentReferenceNoProxies()
	 * @generated
	 */
	public void setSingleNonContainmentReferenceNoProxies(TargetObject newSingleNonContainmentReferenceNoProxies)
	{
		TargetObject oldSingleNonContainmentReferenceNoProxies = singleNonContainmentReferenceNoProxies;
		singleNonContainmentReferenceNoProxies = newSingleNonContainmentReferenceNoProxies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES, oldSingleNonContainmentReferenceNoProxies, singleNonContainmentReferenceNoProxies));
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Type1</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emf.mongodb.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Type1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Reference Type1</em>' containment reference list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_FeatureMapReferenceType1()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#featureMapReferenceCollection'"
	 * @generated
	 */
	public EList<TargetObject> getFeatureMapReferenceType1()
	{
		return getFeatureMapReferenceCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Type2</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emf.mongodb.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Type2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Reference Type2</em>' containment reference list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_FeatureMapReferenceType2()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#featureMapReferenceCollection'"
	 * @generated
	 */
	public EList<TargetObject> getFeatureMapReferenceType2()
	{
		return getFeatureMapReferenceCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Collection</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Collection</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Reference Collection</em>' attribute list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_FeatureMapReferenceCollection()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
	 *        extendedMetaData="kind='group'"
	 * @generated
	 */
	public FeatureMap getFeatureMapReferenceCollection()
	{
		if (featureMapReferenceCollection == null)
		{
			featureMapReferenceCollection = new BasicFeatureMap(this, ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION);
		}
		return featureMapReferenceCollection;
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Type1</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Type1</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Attribute Type1</em>' attribute list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_FeatureMapAttributeType1()
	 * @model transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#featureMapAttributeCollection'"
	 * @generated
	 */
	public EList<String> getFeatureMapAttributeType1()
	{
		return getFeatureMapAttributeCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Type2</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Type2</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Attribute Type2</em>' attribute list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_FeatureMapAttributeType2()
	 * @model transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#featureMapAttributeCollection'"
	 * @generated
	 */
	public EList<String> getFeatureMapAttributeType2()
	{
		return getFeatureMapAttributeCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Collection</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Collection</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Attribute Collection</em>' attribute list.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject_FeatureMapAttributeCollection()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group'"
	 * @generated
	 */
	public FeatureMap getFeatureMapAttributeCollection()
	{
		if (featureMapAttributeCollection == null)
		{
			featureMapAttributeCollection = new BasicFeatureMap(this, ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION);
		}
		return featureMapAttributeCollection;
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
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				return basicSetContainmentReferenceSameCollectioin(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return basicSetSingleContainmentReferenceNoProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return ((InternalEList<?>)getMultipleContainmentReferenceNoProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				return basicSetSingleContainmentReferenceProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return ((InternalEList<?>)getMultipleContainmentReferenceProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				return ((InternalEList<?>)getFeatureMapReferenceType1()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				return ((InternalEList<?>)getFeatureMapReferenceType2()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				return ((InternalEList<?>)getFeatureMapReferenceCollection()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				return ((InternalEList<?>)getFeatureMapAttributeCollection()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				return getIdAttribute();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				return getUnsettableAttribute();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				return getUnsettableAttributeWithNonNullDefault();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				if (resolve) return getUnsettableReference();
				return basicGetUnsettableReference();
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				if (resolve) return getContainmentReferenceSameCollectioin();
				return basicGetContainmentReferenceSameCollectioin();
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
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				return getSingleNonContainmentReferenceNoProxies();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				return getFeatureMapReferenceType1();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				return getFeatureMapReferenceType2();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				if (coreType) return getFeatureMapReferenceCollection();
				return ((FeatureMap.Internal)getFeatureMapReferenceCollection()).getWrapper();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				return getFeatureMapAttributeType1();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				return getFeatureMapAttributeType2();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				if (coreType) return getFeatureMapAttributeCollection();
				return ((FeatureMap.Internal)getFeatureMapAttributeCollection()).getWrapper();
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
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				setIdAttribute((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				setUnsettableAttribute((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				setUnsettableAttributeWithNonNullDefault((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				setUnsettableReference((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				setContainmentReferenceSameCollectioin((PrimaryObject)newValue);
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
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleNonContainmentReferenceNoProxies((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				getFeatureMapReferenceType1().clear();
				getFeatureMapReferenceType1().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				getFeatureMapReferenceType2().clear();
				getFeatureMapReferenceType2().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				((FeatureMap.Internal)getFeatureMapReferenceCollection()).set(newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				getFeatureMapAttributeType1().clear();
				getFeatureMapAttributeType1().addAll((Collection<? extends String>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				getFeatureMapAttributeType2().clear();
				getFeatureMapAttributeType2().addAll((Collection<? extends String>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				((FeatureMap.Internal)getFeatureMapAttributeCollection()).set(newValue);
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
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				setIdAttribute(ID_ATTRIBUTE_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				unsetUnsettableAttribute();
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				unsetUnsettableAttributeWithNonNullDefault();
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				unsetUnsettableReference();
				return;
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				setContainmentReferenceSameCollectioin((PrimaryObject)null);
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
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleNonContainmentReferenceNoProxies((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				getFeatureMapReferenceType1().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				getFeatureMapReferenceType2().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				getFeatureMapReferenceCollection().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				getFeatureMapAttributeType1().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				getFeatureMapAttributeType2().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				getFeatureMapAttributeCollection().clear();
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
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				return ID_ATTRIBUTE_EDEFAULT == null ? idAttribute != null : !ID_ATTRIBUTE_EDEFAULT.equals(idAttribute);
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				return isSetUnsettableAttribute();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				return isSetUnsettableAttributeWithNonNullDefault();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				return isSetUnsettableReference();
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				return containmentReferenceSameCollectioin != null;
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
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				return singleNonContainmentReferenceNoProxies != null;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				return !getFeatureMapReferenceType1().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				return !getFeatureMapReferenceType2().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				return featureMapReferenceCollection != null && !featureMapReferenceCollection.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				return !getFeatureMapAttributeType1().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				return !getFeatureMapAttributeType2().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				return featureMapAttributeCollection != null && !featureMapAttributeCollection.isEmpty();
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
		result.append(", idAttribute: ");
		result.append(idAttribute);
		result.append(", unsettableAttribute: ");
		if (unsettableAttributeESet) result.append(unsettableAttribute); else result.append("<unset>");
		result.append(", unsettableAttributeWithNonNullDefault: ");
		if (unsettableAttributeWithNonNullDefaultESet) result.append(unsettableAttributeWithNonNullDefault); else result.append("<unset>");
		result.append(", featureMapReferenceCollection: ");
		result.append(featureMapReferenceCollection);
		result.append(", featureMapAttributeCollection: ");
		result.append(featureMapAttributeCollection);
		result.append(')');
		return result.toString();
	}

} // PrimaryObject
