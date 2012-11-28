/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.freemarker;

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
 * @see org.eclipselabs.emf.freemarker.FreemarkerFactory
 * @model kind="package"
 * @generated
 */
public class FreemarkerPackage extends EPackageImpl
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "freemarker";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://code.google.com/a/eclipselabs.org/p/mongo-emf/1.0/freemarker";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "org.eclipselabs.mongo.freemarker";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FreemarkerPackage eINSTANCE = org.eclipselabs.emf.freemarker.FreemarkerPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.emf.freemarker.FreeMarkerTemplate <em>Free Marker Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emf.freemarker.FreeMarkerTemplate
	 * @see org.eclipselabs.emf.freemarker.FreemarkerPackage#getFreeMarkerTemplate()
	 * @generated
	 */
	public static final int FREE_MARKER_TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FREE_MARKER_TEMPLATE__CONTENTS = 0;

	/**
	 * The number of structural features of the '<em>Free Marker Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FREE_MARKER_TEMPLATE_FEATURE_COUNT = 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freeMarkerTemplateEClass = null;

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
	 * @see org.eclipselabs.emf.freemarker.FreemarkerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FreemarkerPackage()
	{
		super(eNS_URI, FreemarkerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FreemarkerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FreemarkerPackage init()
	{
		if (isInited) return (FreemarkerPackage)EPackage.Registry.INSTANCE.getEPackage(FreemarkerPackage.eNS_URI);

		// Obtain or create and register package
		FreemarkerPackage theFreemarkerPackage = (FreemarkerPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FreemarkerPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FreemarkerPackage());

		isInited = true;

		// Create package meta-data objects
		theFreemarkerPackage.createPackageContents();

		// Initialize created meta-data
		theFreemarkerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFreemarkerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FreemarkerPackage.eNS_URI, theFreemarkerPackage);
		return theFreemarkerPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emf.freemarker.FreeMarkerTemplate <em>Free Marker Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Marker Template</em>'.
	 * @see org.eclipselabs.emf.freemarker.FreeMarkerTemplate
	 * @generated
	 */
	public EClass getFreeMarkerTemplate()
	{
		return freeMarkerTemplateEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emf.freemarker.FreeMarkerTemplate#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contents</em>'.
	 * @see org.eclipselabs.emf.freemarker.FreeMarkerTemplate#getContents()
	 * @see #getFreeMarkerTemplate()
	 * @generated
	 */
	public EAttribute getFreeMarkerTemplate_Contents()
	{
		return (EAttribute)freeMarkerTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public FreemarkerFactory getFreemarkerFactory()
	{
		return (FreemarkerFactory)getEFactoryInstance();
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
		freeMarkerTemplateEClass = createEClass(FREE_MARKER_TEMPLATE);
		createEAttribute(freeMarkerTemplateEClass, FREE_MARKER_TEMPLATE__CONTENTS);
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
		initEClass(freeMarkerTemplateEClass, FreeMarkerTemplate.class, "FreeMarkerTemplate", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFreeMarkerTemplate_Contents(), ecorePackage.getEString(), "contents", null, 0, 1, FreeMarkerTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		 * The meta object literal for the '{@link org.eclipselabs.emf.freemarker.FreeMarkerTemplate <em>Free Marker Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emf.freemarker.FreeMarkerTemplate
		 * @see org.eclipselabs.emf.freemarker.FreemarkerPackage#getFreeMarkerTemplate()
		 * @generated
		 */
		public static final EClass FREE_MARKER_TEMPLATE = eINSTANCE.getFreeMarkerTemplate();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute FREE_MARKER_TEMPLATE__CONTENTS = eINSTANCE.getFreeMarkerTemplate_Contents();

	}

} //FreemarkerPackage
