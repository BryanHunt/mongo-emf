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
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1 <em>Test Object1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1
	 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1()
	 * @generated
	 */
	public static final int TEST_OBJECT1 = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__CATEGORY = 2;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__TAG = 3;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__CREATED = 4;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__LAST_MODIFIED = 5;

	/**
	 * The feature id for the '<em><b>First Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__FIRST_AVAILABLE = 6;

	/**
	 * The feature id for the '<em><b>Last Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__LAST_AVAILABLE = 7;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__COUNT = 8;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1__DATA = 9;

	/**
	 * The number of structural features of the '<em>Test Object1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEST_OBJECT1_FEATURE_COUNT = 10;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testObject1EClass = null;

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
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getName()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_Name()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getDescription()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_Description()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getCategory()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_Category()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getTag()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_Tag()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getCreated()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_Created()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastModified <em>Last Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Modified</em>'.
	 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1#getLastModified()
	 * @see #getTestObject1()
	 * @generated
	 */
	public EAttribute getTestObject1_LastModified()
	{
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(5);
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
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(6);
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
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(7);
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
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(8);
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
		return (EAttribute)testObject1EClass.getEStructuralFeatures().get(9);
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
		testObject1EClass = createEClass(TEST_OBJECT1);
		createEAttribute(testObject1EClass, TEST_OBJECT1__NAME);
		createEAttribute(testObject1EClass, TEST_OBJECT1__DESCRIPTION);
		createEAttribute(testObject1EClass, TEST_OBJECT1__CATEGORY);
		createEAttribute(testObject1EClass, TEST_OBJECT1__TAG);
		createEAttribute(testObject1EClass, TEST_OBJECT1__CREATED);
		createEAttribute(testObject1EClass, TEST_OBJECT1__LAST_MODIFIED);
		createEAttribute(testObject1EClass, TEST_OBJECT1__FIRST_AVAILABLE);
		createEAttribute(testObject1EClass, TEST_OBJECT1__LAST_AVAILABLE);
		createEAttribute(testObject1EClass, TEST_OBJECT1__COUNT);
		createEAttribute(testObject1EClass, TEST_OBJECT1__DATA);
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

		// Initialize classes and features; add operations and parameters
		initEClass(testObject1EClass, TestObject1.class, "TestObject1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestObject1_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Description(), ecorePackage.getEString(), "description", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Category(), ecorePackage.getEString(), "category", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Created(), ecorePackage.getEDate(), "created", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_LastModified(), ecorePackage.getEDate(), "lastModified", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_FirstAvailable(), ecorePackage.getEDate(), "firstAvailable", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_LastAvailable(), ecorePackage.getEDate(), "lastAvailable", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Count(), ecorePackage.getEInt(), "count", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject1_Data(), ecorePackage.getEString(), "data", null, 0, 1, TestObject1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.perf.model.TestObject1 <em>Test Object1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.perf.model.TestObject1
		 * @see org.eclipselabs.mongo.emf.perf.model.ModelPackage#getTestObject1()
		 * @generated
		 */
		public static final EClass TEST_OBJECT1 = eINSTANCE.getTestObject1();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__NAME = eINSTANCE.getTestObject1_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__DESCRIPTION = eINSTANCE.getTestObject1_Description();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__CATEGORY = eINSTANCE.getTestObject1_Category();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__TAG = eINSTANCE.getTestObject1_Tag();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__CREATED = eINSTANCE.getTestObject1_Created();

		/**
		 * The meta object literal for the '<em><b>Last Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TEST_OBJECT1__LAST_MODIFIED = eINSTANCE.getTestObject1_LastModified();

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

	}

} //ModelPackage
