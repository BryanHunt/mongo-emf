/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mongo.emf.perf.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

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
 * @see org.eclipselabs.mongo.emf.perf.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public class ModelPackage extends EPackageImpl
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipselabs.org/mongo/emf/perf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "org.eclipselabs.mongo.emf.perf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ModelPackage eINSTANCE = org.eclipselabs.mongo.emf.perf.model.ModelPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject <em>Base Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getBaseObject()
	 * @generated
	 */
	public static final int BASE_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASE_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASE_OBJECT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASE_OBJECT__CATEGORY = 2;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASE_OBJECT__TAG = 3;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASE_OBJECT__CREATED = 4;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASE_OBJECT__LAST_MODIFIED = 5;

	/**
	 * The number of structural features of the '<em>Base Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASE_OBJECT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1 <em>Test Object1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1()
	 * @generated
	 */
	public static final int TEST_OBJECT1 = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__NAME = BASE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__DESCRIPTION = BASE_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__CATEGORY = BASE_OBJECT__CATEGORY;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__TAG = BASE_OBJECT__TAG;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__CREATED = BASE_OBJECT__CREATED;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__LAST_MODIFIED = BASE_OBJECT__LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>First Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__FIRST_AVAILABLE = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__LAST_AVAILABLE = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__COUNT = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__DATA = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Test Object1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.perf.model.ObjectGroup <em>Object Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.perf.model.ObjectGroup
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getObjectGroup()
	 * @generated
	 */
	public static final int OBJECT_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP__NAME = BASE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP__DESCRIPTION = BASE_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP__CATEGORY = BASE_OBJECT__CATEGORY;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP__TAG = BASE_OBJECT__TAG;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP__CREATED = BASE_OBJECT__CREATED;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP__LAST_MODIFIED = BASE_OBJECT__LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP__CHILDREN = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_GROUP_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testObject1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectGroupEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackage()
	{
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init()
	{
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackage theModelPackage = (ModelPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackage());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject <em>Base Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Object</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject
	 * @generated
	 */
	public EClass getBaseObject()
	{
		return baseObjectEClass;
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject#getName()
	 * @see #getBaseObject()
	 * @generated
	 */
	public EAttribute getBaseObject_Name()
	{
		return (EAttribute)baseObjectEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject#getDescription()
	 * @see #getBaseObject()
	 * @generated
	 */
	public EAttribute getBaseObject_Description()
	{
		return (EAttribute)baseObjectEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject#getCategory()
	 * @see #getBaseObject()
	 * @generated
	 */
	public EAttribute getBaseObject_Category()
	{
		return (EAttribute)baseObjectEClass.getEStructuralFeatures().get(2);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject#getTag()
	 * @see #getBaseObject()
	 * @generated
	 */
	public EAttribute getBaseObject_Tag()
	{
		return (EAttribute)baseObjectEClass.getEStructuralFeatures().get(3);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject#getCreated()
	 * @see #getBaseObject()
	 * @generated
	 */
	public EAttribute getBaseObject_Created()
	{
		return (EAttribute)baseObjectEClass.getEStructuralFeatures().get(4);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject#getLastModified <em>Last Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Modified</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject#getLastModified()
	 * @see #getBaseObject()
	 * @generated
	 */
	public EAttribute getBaseObject_LastModified()
	{
		return (EAttribute)baseObjectEClass.getEStructuralFeatures().get(5);
	}


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1 <em>Test Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Object1</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1
	 * @generated
	 */
	public EClass getTestObject1()
	{
		return testObject1EClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getFirstAvailable <em>First Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Available</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getFirstAvailable()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_FirstAvailable()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastAvailable <em>Last Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Available</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastAvailable()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_LastAvailable()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getCount()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_Count()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getData()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_Data()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.perf.model.ObjectGroup <em>Object Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Group</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.ObjectGroup
	 * @generated
	 */
	public EClass getObjectGroup()
	{
		return objectGroupEClass;
	}


	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongo.emf.perf.model.ObjectGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.ObjectGroup#getChildren()
	 * @see #getObjectGroup()
	 * @generated
	 */
	public EReference getObjectGroup_Children()
	{
		return (EReference)objectGroupEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public ModelFactory getModelFactory()
	{
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		baseObjectEClass = createEClass(BASE_OBJECT);
		createEAttribute(baseObjectEClass, BASE_OBJECT__NAME);
		createEAttribute(baseObjectEClass, BASE_OBJECT__DESCRIPTION);
		createEAttribute(baseObjectEClass, BASE_OBJECT__CATEGORY);
		createEAttribute(baseObjectEClass, BASE_OBJECT__TAG);
		createEAttribute(baseObjectEClass, BASE_OBJECT__CREATED);
		createEAttribute(baseObjectEClass, BASE_OBJECT__LAST_MODIFIED);

		testObject1EClass = createEClass(TEST_OBJECT1);
		createEAttribute(testObject1EClass, TEST_OBJECT1__FIRST_AVAILABLE);
		createEAttribute(testObject1EClass, TEST_OBJECT1__LAST_AVAILABLE);
		createEAttribute(testObject1EClass, TEST_OBJECT1__COUNT);
		createEAttribute(testObject1EClass, TEST_OBJECT1__DATA);

		objectGroupEClass = createEClass(OBJECT_GROUP);
		createEReference(objectGroupEClass, OBJECT_GROUP__CHILDREN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		testObject1EClass.getESuperTypes().add(this.getBaseObject());
		objectGroupEClass.getESuperTypes().add(this.getBaseObject());

		// Initialize classes and features; add operations and parameters
		initEClass(baseObjectEClass, BaseObject.class, "BaseObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, BaseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, BaseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseObject_Category(), ecorePackage.getEString(), "category", null, 0, 1, BaseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseObject_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, BaseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseObject_Created(), ecorePackage.getEDate(), "created", null, 0, 1, BaseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseObject_LastModified(), ecorePackage.getEDate(), "lastModified", null, 0, 1, BaseObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testObject1EClass, TestObject1.class, "TestObject1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestObject1_FirstAvailable(), ecorePackage.getEDate(), "firstAvailable", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_LastAvailable(), ecorePackage.getEDate(), "lastAvailable", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Count(), ecorePackage.getEInt(), "count", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Data(), ecorePackage.getEString(), "data", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectGroupEClass, ObjectGroup.class, "ObjectGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectGroup_Children(), this.getBaseObject(), null, "children", null, 0, -1, ObjectGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

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
	public interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.perf.model.BaseObject <em>Base Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.perf.model.BaseObject
		 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getBaseObject()
		 * @generated
		 */
		public static final EClass BASE_OBJECT = eINSTANCE.getBaseObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BASE_OBJECT__NAME = eINSTANCE.getBaseObject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BASE_OBJECT__DESCRIPTION = eINSTANCE.getBaseObject_Description();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BASE_OBJECT__CATEGORY = eINSTANCE.getBaseObject_Category();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BASE_OBJECT__TAG = eINSTANCE.getBaseObject_Tag();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BASE_OBJECT__CREATED = eINSTANCE.getBaseObject_Created();

		/**
		 * The meta object literal for the '<em><b>Last Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BASE_OBJECT__LAST_MODIFIED = eINSTANCE.getBaseObject_LastModified();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1 <em>Test Object1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1
		 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1()
		 * @generated
		 */
		public static final EClass TEST_OBJECT1 = eINSTANCE.getTestObject1();

		/**
		 * The meta object literal for the '<em><b>First Available</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__FIRST_AVAILABLE = eINSTANCE.getTestObject1_FirstAvailable();

		/**
		 * The meta object literal for the '<em><b>Last Available</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__LAST_AVAILABLE = eINSTANCE.getTestObject1_LastAvailable();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__COUNT = eINSTANCE.getTestObject1_Count();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__DATA = eINSTANCE.getTestObject1_Data();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.perf.model.ObjectGroup <em>Object Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.perf.model.ObjectGroup
		 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getObjectGroup()
		 * @generated
		 */
		public static final EClass OBJECT_GROUP = eINSTANCE.getObjectGroup();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OBJECT_GROUP__CHILDREN = eINSTANCE.getObjectGroup_Children();

	}

} //ModelPackage
