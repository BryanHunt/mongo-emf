/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mongo.emf.perf.model;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Object1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getTag <em>Tag</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCreated <em>Created</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getFirstAvailable <em>First Available</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastAvailable <em>Last Available</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1()
 * @model kind="class"
 * @generated
 */
public class TestObject1 extends EObjectImpl implements EObject
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected static final String TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected String tag = TAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected Date created = CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected Date lastModified = LAST_MODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstAvailable() <em>First Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final Date FIRST_AVAILABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstAvailable() <em>First Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstAvailable()
	 * @generated
	 * @ordered
	 */
	protected Date firstAvailable = FIRST_AVAILABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastAvailable() <em>Last Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_AVAILABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastAvailable() <em>Last Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAvailable()
	 * @generated
	 * @ordered
	 */
	protected Date lastAvailable = LAST_AVAILABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected int count = COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected String data = DATA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestObject1()
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
		return ModelPackage.Literals.TEST_OBJECT1;
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
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_Name()
	 * @model
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getName <em>Name</em>}' attribute.
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__NAME, oldName, name));
	}

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_Description()
	 * @model
	 * @generated
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__DESCRIPTION, oldDescription, description));
	}

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_Category()
	 * @model
	 * @generated
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	public void setCategory(String newCategory)
	{
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__CATEGORY, oldCategory, category));
	}

	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see #setTag(String)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_Tag()
	 * @model
	 * @generated
	 */
	public String getTag()
	{
		return tag;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see #getTag()
	 * @generated
	 */
	public void setTag(String newTag)
	{
		String oldTag = tag;
		tag = newTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__TAG, oldTag, tag));
	}

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_Created()
	 * @model
	 * @generated
	 */
	public Date getCreated()
	{
		return created;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	public void setCreated(Date newCreated)
	{
		Date oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__CREATED, oldCreated, created));
	}

	/**
	 * Returns the value of the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modified</em>' attribute.
	 * @see #setLastModified(Date)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_LastModified()
	 * @model
	 * @generated
	 */
	public Date getLastModified()
	{
		return lastModified;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastModified <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified</em>' attribute.
	 * @see #getLastModified()
	 * @generated
	 */
	public void setLastModified(Date newLastModified)
	{
		Date oldLastModified = lastModified;
		lastModified = newLastModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__LAST_MODIFIED, oldLastModified, lastModified));
	}

	/**
	 * Returns the value of the '<em><b>First Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Available</em>' attribute.
	 * @see #setFirstAvailable(Date)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_FirstAvailable()
	 * @model
	 * @generated
	 */
	public Date getFirstAvailable()
	{
		return firstAvailable;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getFirstAvailable <em>First Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Available</em>' attribute.
	 * @see #getFirstAvailable()
	 * @generated
	 */
	public void setFirstAvailable(Date newFirstAvailable)
	{
		Date oldFirstAvailable = firstAvailable;
		firstAvailable = newFirstAvailable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE, oldFirstAvailable, firstAvailable));
	}

	/**
	 * Returns the value of the '<em><b>Last Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Available</em>' attribute.
	 * @see #setLastAvailable(Date)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_LastAvailable()
	 * @model
	 * @generated
	 */
	public Date getLastAvailable()
	{
		return lastAvailable;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastAvailable <em>Last Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Available</em>' attribute.
	 * @see #getLastAvailable()
	 * @generated
	 */
	public void setLastAvailable(Date newLastAvailable)
	{
		Date oldLastAvailable = lastAvailable;
		lastAvailable = newLastAvailable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__LAST_AVAILABLE, oldLastAvailable, lastAvailable));
	}

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_Count()
	 * @model
	 * @generated
	 */
	public int getCount()
	{
		return count;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	public void setCount(int newCount)
	{
		int oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__COUNT, oldCount, count));
	}

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(String)
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1_Data()
	 * @model
	 * @generated
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	public void setData(String newData)
	{
		String oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_OBJECT1__DATA, oldData, data));
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
			case ModelPackage.TEST_OBJECT1__NAME:
				return getName();
			case ModelPackage.TEST_OBJECT1__DESCRIPTION:
				return getDescription();
			case ModelPackage.TEST_OBJECT1__CATEGORY:
				return getCategory();
			case ModelPackage.TEST_OBJECT1__TAG:
				return getTag();
			case ModelPackage.TEST_OBJECT1__CREATED:
				return getCreated();
			case ModelPackage.TEST_OBJECT1__LAST_MODIFIED:
				return getLastModified();
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				return getFirstAvailable();
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				return getLastAvailable();
			case ModelPackage.TEST_OBJECT1__COUNT:
				return getCount();
			case ModelPackage.TEST_OBJECT1__DATA:
				return getData();
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
			case ModelPackage.TEST_OBJECT1__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__CATEGORY:
				setCategory((String)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__TAG:
				setTag((String)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__CREATED:
				setCreated((Date)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__LAST_MODIFIED:
				setLastModified((Date)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				setFirstAvailable((Date)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				setLastAvailable((Date)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__COUNT:
				setCount((Integer)newValue);
				return;
			case ModelPackage.TEST_OBJECT1__DATA:
				setData((String)newValue);
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
			case ModelPackage.TEST_OBJECT1__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__TAG:
				setTag(TAG_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__LAST_MODIFIED:
				setLastModified(LAST_MODIFIED_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				setFirstAvailable(FIRST_AVAILABLE_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				setLastAvailable(LAST_AVAILABLE_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case ModelPackage.TEST_OBJECT1__DATA:
				setData(DATA_EDEFAULT);
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
			case ModelPackage.TEST_OBJECT1__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.TEST_OBJECT1__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.TEST_OBJECT1__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case ModelPackage.TEST_OBJECT1__TAG:
				return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
			case ModelPackage.TEST_OBJECT1__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case ModelPackage.TEST_OBJECT1__LAST_MODIFIED:
				return LAST_MODIFIED_EDEFAULT == null ? lastModified != null : !LAST_MODIFIED_EDEFAULT.equals(lastModified);
			case ModelPackage.TEST_OBJECT1__FIRST_AVAILABLE:
				return FIRST_AVAILABLE_EDEFAULT == null ? firstAvailable != null : !FIRST_AVAILABLE_EDEFAULT.equals(firstAvailable);
			case ModelPackage.TEST_OBJECT1__LAST_AVAILABLE:
				return LAST_AVAILABLE_EDEFAULT == null ? lastAvailable != null : !LAST_AVAILABLE_EDEFAULT.equals(lastAvailable);
			case ModelPackage.TEST_OBJECT1__COUNT:
				return count != COUNT_EDEFAULT;
			case ModelPackage.TEST_OBJECT1__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
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
		result.append(", description: ");
		result.append(description);
		result.append(", category: ");
		result.append(category);
		result.append(", tag: ");
		result.append(tag);
		result.append(", created: ");
		result.append(created);
		result.append(", lastModified: ");
		result.append(lastModified);
		result.append(", firstAvailable: ");
		result.append(firstAvailable);
		result.append(", lastAvailable: ");
		result.append(lastAvailable);
		result.append(", count: ");
		result.append(count);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} // TestObject1
