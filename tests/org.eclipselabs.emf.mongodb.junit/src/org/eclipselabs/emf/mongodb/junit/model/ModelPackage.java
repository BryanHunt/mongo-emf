/**
 */
package org.eclipselabs.emf.mongodb.junit.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipselabs.emf.mongodb.junit.model.ModelFactory
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
	public static final String eNS_URI = "http://www.eclipselabs.org/mongo/emf/junit";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "org.eclipselabs.mongo.emf.junit";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ModelPackage eINSTANCE = org.eclipselabs.emf.mongodb.junit.model.ModelPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes <em>ETypes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getETypes()
	 * @generated
	 */
	public static final int ETYPES = 0;

	/**
	 * The feature id for the '<em><b>EBig Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBIG_DECIMAL = 0;

	/**
	 * The feature id for the '<em><b>EBig Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBIG_INTEGER = 1;

	/**
	 * The feature id for the '<em><b>EBoolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBOOLEAN = 2;

	/**
	 * The feature id for the '<em><b>EByte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBYTE = 3;

	/**
	 * The feature id for the '<em><b>EByte Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBYTE_ARRAY = 4;

	/**
	 * The feature id for the '<em><b>EChar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ECHAR = 5;

	/**
	 * The feature id for the '<em><b>EDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EDATE = 6;

	/**
	 * The feature id for the '<em><b>EDouble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EDOUBLE = 7;

	/**
	 * The feature id for the '<em><b>EFloat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EFLOAT = 8;

	/**
	 * The feature id for the '<em><b>EInt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EINT = 9;

	/**
	 * The feature id for the '<em><b>ELong</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ELONG = 10;

	/**
	 * The feature id for the '<em><b>EShort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ESHORT = 11;

	/**
	 * The feature id for the '<em><b>EString</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ESTRING = 12;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__URIS = 13;

	/**
	 * The number of structural features of the '<em>ETypes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject <em>Primary Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject()
	 * @generated
	 */
	public static final int PRIMARY_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__ID_ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Unsettable Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT = 3;

	/**
	 * The feature id for the '<em><b>Unsettable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__UNSETTABLE_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN = 5;

	/**
	 * The feature id for the '<em><b>Single Non Containment Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Multiple Non Containment Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES = 8;

	/**
	 * The feature id for the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES = 9;

	/**
	 * The feature id for the '<em><b>Single Containment Reference Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES = 10;

	/**
	 * The feature id for the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES = 11;

	/**
	 * The feature id for the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES = 12;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Type1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1 = 13;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Type2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2 = 14;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Collection</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION = 15;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Type1</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1 = 16;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Type2</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2 = 17;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Collection</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION = 18;

	/**
	 * The number of structural features of the '<em>Primary Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT_FEATURE_COUNT = 19;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emf.mongodb.junit.model.TargetObject <em>Target Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.mongodb.junit.model.TargetObject
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getTargetObject()
	 * @generated
	 */
	public static final int TARGET_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Single Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OBJECT__SINGLE_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Array Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OBJECT__ARRAY_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>Target Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getURI()
	 * @generated
	 */
	public static final int URI = 3;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#eNS_URI
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
	 * Returns the meta object for class '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes <em>ETypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETypes</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes
	 * @generated
	 */
	public EClass getETypes()
	{
		return eTypesEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEBigDecimal <em>EBig Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBig Decimal</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEBigDecimal()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EBigDecimal()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEBigInteger <em>EBig Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBig Integer</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEBigInteger()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EBigInteger()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#isEBoolean <em>EBoolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBoolean</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#isEBoolean()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EBoolean()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEByte <em>EByte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EByte</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEByte()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EByte()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEByteArray <em>EByte Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EByte Array</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEByteArray()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EByteArray()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEChar <em>EChar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EChar</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEChar()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EChar()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEDate <em>EDate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EDate</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEDate()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EDate()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEDouble <em>EDouble</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EDouble</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEDouble()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EDouble()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEFloat <em>EFloat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EFloat</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEFloat()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EFloat()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEInt <em>EInt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EInt</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEInt()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EInt()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getELong <em>ELong</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ELong</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getELong()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_ELong()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEShort <em>EShort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EShort</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEShort()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EShort()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getEString <em>EString</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EString</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getEString()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EString()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes#getUris <em>Uris</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Uris</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes#getUris()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_Uris()
	{
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject <em>Primary Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Object</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject
	 * @generated
	 */
	public EClass getPrimaryObject()
	{
		return primaryObjectEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getName()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_Name()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Attribute</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getIdAttribute()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_IdAttribute()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsettable Attribute</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttribute()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_UnsettableAttribute()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsettable Attribute With Non Null Default</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_UnsettableAttributeWithNonNullDefault()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unsettable Reference</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getUnsettableReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_UnsettableReference()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Containment Reference Same Collectioin</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_ContainmentReferenceSameCollectioin()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Non Containment Reference</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleNonContainmentReference()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multiple Non Containment Reference</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleNonContainmentReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleNonContainmentReference()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Containment Reference No Proxies</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleContainmentReferenceNoProxies()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multiple Containment Reference No Proxies</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleContainmentReferenceNoProxies()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Containment Reference Proxies</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleContainmentReferenceProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleContainmentReferenceProxies()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multiple Containment Reference Proxies</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleContainmentReferenceProxies()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Non Containment Reference No Proxies</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleNonContainmentReferenceNoProxies()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceType1 <em>Feature Map Reference Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Map Reference Type1</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceType1()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_FeatureMapReferenceType1()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceType2 <em>Feature Map Reference Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Map Reference Type2</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceType2()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_FeatureMapReferenceType2()
	{
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceCollection <em>Feature Map Reference Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Reference Collection</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapReferenceCollection()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapReferenceCollection()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeType1 <em>Feature Map Attribute Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Type1</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeType1()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeType1()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeType2 <em>Feature Map Attribute Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Type2</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeType2()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeType2()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeCollection <em>Feature Map Attribute Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Collection</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject#getFeatureMapAttributeCollection()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeCollection()
	{
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emf.mongodb.junit.model.TargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Object</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.TargetObject
	 * @generated
	 */
	public EClass getTargetObject()
	{
		return targetObjectEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Single Attribute</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.TargetObject#getSingleAttribute()
	 * @see #getTargetObject()
	 * @generated
	 */
	public EAttribute getTargetObject_SingleAttribute()
	{
		return (EAttribute)targetObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.emf.mongodb.junit.model.TargetObject#getArrayAttribute <em>Array Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Array Attribute</em>'.
	 * @see org.eclipselabs.emf.mongodb.junit.model.TargetObject#getArrayAttribute()
	 * @see #getTargetObject()
	 * @generated
	 */
	public EAttribute getTargetObject_ArrayAttribute()
	{
		return (EAttribute)targetObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	public EDataType getURI()
	{
		return uriEDataType;
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
		eTypesEClass = createEClass(ETYPES);
		createEAttribute(eTypesEClass, ETYPES__EBIG_DECIMAL);
		createEAttribute(eTypesEClass, ETYPES__EBIG_INTEGER);
		createEAttribute(eTypesEClass, ETYPES__EBOOLEAN);
		createEAttribute(eTypesEClass, ETYPES__EBYTE);
		createEAttribute(eTypesEClass, ETYPES__EBYTE_ARRAY);
		createEAttribute(eTypesEClass, ETYPES__ECHAR);
		createEAttribute(eTypesEClass, ETYPES__EDATE);
		createEAttribute(eTypesEClass, ETYPES__EDOUBLE);
		createEAttribute(eTypesEClass, ETYPES__EFLOAT);
		createEAttribute(eTypesEClass, ETYPES__EINT);
		createEAttribute(eTypesEClass, ETYPES__ELONG);
		createEAttribute(eTypesEClass, ETYPES__ESHORT);
		createEAttribute(eTypesEClass, ETYPES__ESTRING);
		createEAttribute(eTypesEClass, ETYPES__URIS);

		primaryObjectEClass = createEClass(PRIMARY_OBJECT);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__NAME);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__ID_ATTRIBUTE);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__UNSETTABLE_REFERENCE);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION);

		targetObjectEClass = createEClass(TARGET_OBJECT);
		createEAttribute(targetObjectEClass, TARGET_OBJECT__SINGLE_ATTRIBUTE);
		createEAttribute(targetObjectEClass, TARGET_OBJECT__ARRAY_ATTRIBUTE);

		// Create data types
		uriEDataType = createEDataType(URI);
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
		initEClass(eTypesEClass, ETypes.class, "ETypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getETypes_EBigDecimal(), ecorePackage.getEBigDecimal(), "eBigDecimal", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EBigInteger(), ecorePackage.getEBigInteger(), "eBigInteger", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EBoolean(), ecorePackage.getEBoolean(), "eBoolean", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EByte(), ecorePackage.getEByte(), "eByte", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EByteArray(), ecorePackage.getEByteArray(), "eByteArray", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EChar(), ecorePackage.getEChar(), "eChar", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EDate(), ecorePackage.getEDate(), "eDate", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EDouble(), ecorePackage.getEDouble(), "eDouble", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EFloat(), ecorePackage.getEFloat(), "eFloat", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EInt(), ecorePackage.getEInt(), "eInt", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_ELong(), ecorePackage.getELong(), "eLong", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EShort(), ecorePackage.getEShort(), "eShort", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EString(), ecorePackage.getEString(), "eString", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_Uris(), this.getURI(), "uris", null, 0, -1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primaryObjectEClass, PrimaryObject.class, "PrimaryObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimaryObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_IdAttribute(), ecorePackage.getEString(), "idAttribute", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_UnsettableAttribute(), ecorePackage.getEString(), "unsettableAttribute", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_UnsettableAttributeWithNonNullDefault(), ecorePackage.getEString(), "unsettableAttributeWithNonNullDefault", "junit", 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_UnsettableReference(), this.getTargetObject(), null, "unsettableReference", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_ContainmentReferenceSameCollectioin(), this.getPrimaryObject(), null, "containmentReferenceSameCollectioin", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleNonContainmentReference(), this.getTargetObject(), null, "singleNonContainmentReference", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleNonContainmentReference(), this.getTargetObject(), null, "multipleNonContainmentReference", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleContainmentReferenceNoProxies(), this.getTargetObject(), null, "singleContainmentReferenceNoProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleContainmentReferenceNoProxies(), this.getTargetObject(), null, "multipleContainmentReferenceNoProxies", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleContainmentReferenceProxies(), this.getTargetObject(), null, "singleContainmentReferenceProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleContainmentReferenceProxies(), this.getTargetObject(), null, "multipleContainmentReferenceProxies", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleNonContainmentReferenceNoProxies(), this.getTargetObject(), null, "singleNonContainmentReferenceNoProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_FeatureMapReferenceType1(), this.getTargetObject(), null, "featureMapReferenceType1", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_FeatureMapReferenceType2(), this.getTargetObject(), null, "featureMapReferenceType2", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapReferenceCollection(), ecorePackage.getEFeatureMapEntry(), "featureMapReferenceCollection", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeType1(), ecorePackage.getEString(), "featureMapAttributeType1", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeType2(), ecorePackage.getEString(), "featureMapAttributeType2", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeCollection(), ecorePackage.getEFeatureMapEntry(), "featureMapAttributeCollection", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetObjectEClass, TargetObject.class, "TargetObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetObject_SingleAttribute(), ecorePackage.getEString(), "singleAttribute", null, 0, 1, TargetObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTargetObject_ArrayAttribute(), ecorePackage.getEString(), "arrayAttribute", null, 0, -1, TargetObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations()
	{
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getPrimaryObject_FeatureMapReferenceType1(), 
		   source, 
		   new String[] 
		   {
			 "group", "#featureMapReferenceCollection"
		   });		
		addAnnotation
		  (getPrimaryObject_FeatureMapReferenceType2(), 
		   source, 
		   new String[] 
		   {
			 "group", "#featureMapReferenceCollection"
		   });		
		addAnnotation
		  (getPrimaryObject_FeatureMapReferenceCollection(), 
		   source, 
		   new String[] 
		   {
			 "kind", "group"
		   });		
		addAnnotation
		  (getPrimaryObject_FeatureMapAttributeType1(), 
		   source, 
		   new String[] 
		   {
			 "group", "#featureMapAttributeCollection"
		   });		
		addAnnotation
		  (getPrimaryObject_FeatureMapAttributeType2(), 
		   source, 
		   new String[] 
		   {
			 "group", "#featureMapAttributeCollection"
		   });		
		addAnnotation
		  (getPrimaryObject_FeatureMapAttributeCollection(), 
		   source, 
		   new String[] 
		   {
			 "kind", "group"
		   });
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
		 * The meta object literal for the '{@link org.eclipselabs.emf.mongodb.junit.model.ETypes <em>ETypes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.mongodb.junit.model.ETypes
		 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getETypes()
		 * @generated
		 */
		public static final EClass ETYPES = eINSTANCE.getETypes();

		/**
		 * The meta object literal for the '<em><b>EBig Decimal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBIG_DECIMAL = eINSTANCE.getETypes_EBigDecimal();

		/**
		 * The meta object literal for the '<em><b>EBig Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBIG_INTEGER = eINSTANCE.getETypes_EBigInteger();

		/**
		 * The meta object literal for the '<em><b>EBoolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBOOLEAN = eINSTANCE.getETypes_EBoolean();

		/**
		 * The meta object literal for the '<em><b>EByte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBYTE = eINSTANCE.getETypes_EByte();

		/**
		 * The meta object literal for the '<em><b>EByte Array</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBYTE_ARRAY = eINSTANCE.getETypes_EByteArray();

		/**
		 * The meta object literal for the '<em><b>EChar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ECHAR = eINSTANCE.getETypes_EChar();

		/**
		 * The meta object literal for the '<em><b>EDate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EDATE = eINSTANCE.getETypes_EDate();

		/**
		 * The meta object literal for the '<em><b>EDouble</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EDOUBLE = eINSTANCE.getETypes_EDouble();

		/**
		 * The meta object literal for the '<em><b>EFloat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EFLOAT = eINSTANCE.getETypes_EFloat();

		/**
		 * The meta object literal for the '<em><b>EInt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EINT = eINSTANCE.getETypes_EInt();

		/**
		 * The meta object literal for the '<em><b>ELong</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ELONG = eINSTANCE.getETypes_ELong();

		/**
		 * The meta object literal for the '<em><b>EShort</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ESHORT = eINSTANCE.getETypes_EShort();

		/**
		 * The meta object literal for the '<em><b>EString</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ESTRING = eINSTANCE.getETypes_EString();

		/**
		 * The meta object literal for the '<em><b>Uris</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__URIS = eINSTANCE.getETypes_Uris();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emf.mongodb.junit.model.PrimaryObject <em>Primary Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.mongodb.junit.model.PrimaryObject
		 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getPrimaryObject()
		 * @generated
		 */
		public static final EClass PRIMARY_OBJECT = eINSTANCE.getPrimaryObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__NAME = eINSTANCE.getPrimaryObject_Name();

		/**
		 * The meta object literal for the '<em><b>Id Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__ID_ATTRIBUTE = eINSTANCE.getPrimaryObject_IdAttribute();

		/**
		 * The meta object literal for the '<em><b>Unsettable Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE = eINSTANCE.getPrimaryObject_UnsettableAttribute();

		/**
		 * The meta object literal for the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT = eINSTANCE.getPrimaryObject_UnsettableAttributeWithNonNullDefault();

		/**
		 * The meta object literal for the '<em><b>Unsettable Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__UNSETTABLE_REFERENCE = eINSTANCE.getPrimaryObject_UnsettableReference();

		/**
		 * The meta object literal for the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN = eINSTANCE.getPrimaryObject_ContainmentReferenceSameCollectioin();

		/**
		 * The meta object literal for the '<em><b>Single Non Containment Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE = eINSTANCE.getPrimaryObject_SingleNonContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Multiple Non Containment Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE = eINSTANCE.getPrimaryObject_MultipleNonContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_SingleContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_MultipleContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Single Containment Reference Proxies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES = eINSTANCE.getPrimaryObject_SingleContainmentReferenceProxies();

		/**
		 * The meta object literal for the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES = eINSTANCE.getPrimaryObject_MultipleContainmentReferenceProxies();

		/**
		 * The meta object literal for the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_SingleNonContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Type1</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1 = eINSTANCE.getPrimaryObject_FeatureMapReferenceType1();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Type2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2 = eINSTANCE.getPrimaryObject_FeatureMapReferenceType2();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Collection</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION = eINSTANCE.getPrimaryObject_FeatureMapReferenceCollection();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Type1</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1 = eINSTANCE.getPrimaryObject_FeatureMapAttributeType1();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Type2</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2 = eINSTANCE.getPrimaryObject_FeatureMapAttributeType2();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Collection</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION = eINSTANCE.getPrimaryObject_FeatureMapAttributeCollection();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emf.mongodb.junit.model.TargetObject <em>Target Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.mongodb.junit.model.TargetObject
		 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getTargetObject()
		 * @generated
		 */
		public static final EClass TARGET_OBJECT = eINSTANCE.getTargetObject();

		/**
		 * The meta object literal for the '<em><b>Single Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TARGET_OBJECT__SINGLE_ATTRIBUTE = eINSTANCE.getTargetObject_SingleAttribute();

		/**
		 * The meta object literal for the '<em><b>Array Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TARGET_OBJECT__ARRAY_ATTRIBUTE = eINSTANCE.getTargetObject_ArrayAttribute();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipselabs.emf.mongodb.junit.model.ModelPackage#getURI()
		 * @generated
		 */
		public static final EDataType URI = eINSTANCE.getURI();

	}

} //ModelPackage
