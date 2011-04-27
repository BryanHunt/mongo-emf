/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mongo.emf.log;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipselabs.mongo.emf.log.LogFactory
 * @model kind="package"
 * @generated
 */
public class LogPackage extends EPackageImpl
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "log";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://code.google.com/a/eclipselabs.org/p/mongo-emf/1.0/log";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "org.eclipselabs.mongo.emf.log";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final LogPackage eINSTANCE = org.eclipselabs.mongo.emf.log.LogPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.log.LogEntry <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.log.LogEntry
	 * @see org.eclipselabs.mongo.emf.log.LogPackage#getLogEntry()
	 * @generated
	 */
	public static final int LOG_ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOG_ENTRY__LEVEL = 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOG_ENTRY__TIME = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOG_ENTRY__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Exception Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOG_ENTRY__EXCEPTION_MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Exception Stack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOG_ENTRY__EXCEPTION_STACK = 4;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOG_ENTRY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.log.LogLevel <em>Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.log.LogLevel
	 * @see org.eclipselabs.mongo.emf.log.LogPackage#getLogLevel()
	 * @generated
	 */
	public static final int LOG_LEVEL = 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logLevelEEnum = null;

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
	 * @see org.eclipselabs.mongo.emf.log.LogPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LogPackage()
	{
		super(eNS_URI, LogFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LogPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LogPackage init()
	{
		if (isInited) return (LogPackage)EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI);

		// Obtain or create and register package
		LogPackage theLogPackage = (LogPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LogPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LogPackage());

		isInited = true;

		// Create package meta-data objects
		theLogPackage.createPackageContents();

		// Initialize created meta-data
		theLogPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLogPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LogPackage.eNS_URI, theLogPackage);
		return theLogPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.log.LogEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see org.eclipselabs.mongo.emf.log.LogEntry
	 * @generated
	 */
	public EClass getLogEntry()
	{
		return logEntryEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.log.LogEntry#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.eclipselabs.mongo.emf.log.LogEntry#getLevel()
	 * @see #getLogEntry()
	 * @generated
	 */
	public EAttribute getLogEntry_Level()
	{
		return (EAttribute)logEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.log.LogEntry#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipselabs.mongo.emf.log.LogEntry#getTime()
	 * @see #getLogEntry()
	 * @generated
	 */
	public EAttribute getLogEntry_Time()
	{
		return (EAttribute)logEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.log.LogEntry#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipselabs.mongo.emf.log.LogEntry#getMessage()
	 * @see #getLogEntry()
	 * @generated
	 */
	public EAttribute getLogEntry_Message()
	{
		return (EAttribute)logEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.log.LogEntry#getExceptionMessage <em>Exception Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Message</em>'.
	 * @see org.eclipselabs.mongo.emf.log.LogEntry#getExceptionMessage()
	 * @see #getLogEntry()
	 * @generated
	 */
	public EAttribute getLogEntry_ExceptionMessage()
	{
		return (EAttribute)logEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.log.LogEntry#getExceptionStack <em>Exception Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Stack</em>'.
	 * @see org.eclipselabs.mongo.emf.log.LogEntry#getExceptionStack()
	 * @see #getLogEntry()
	 * @generated
	 */
	public EAttribute getLogEntry_ExceptionStack()
	{
		return (EAttribute)logEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mongo.emf.log.LogLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Level</em>'.
	 * @see org.eclipselabs.mongo.emf.log.LogLevel
	 * @generated
	 */
	public EEnum getLogLevel()
	{
		return logLevelEEnum;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public LogFactory getLogFactory()
	{
		return (LogFactory)getEFactoryInstance();
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
		logEntryEClass = createEClass(LOG_ENTRY);
		createEAttribute(logEntryEClass, LOG_ENTRY__LEVEL);
		createEAttribute(logEntryEClass, LOG_ENTRY__TIME);
		createEAttribute(logEntryEClass, LOG_ENTRY__MESSAGE);
		createEAttribute(logEntryEClass, LOG_ENTRY__EXCEPTION_MESSAGE);
		createEAttribute(logEntryEClass, LOG_ENTRY__EXCEPTION_STACK);

		// Create enums
		logLevelEEnum = createEEnum(LOG_LEVEL);
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
		initEClass(logEntryEClass, LogEntry.class, "LogEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogEntry_Level(), this.getLogLevel(), "level", null, 1, 1, LogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogEntry_Time(), ecorePackage.getEDate(), "time", null, 1, 1, LogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogEntry_Message(), ecorePackage.getEString(), "message", null, 1, 1, LogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogEntry_ExceptionMessage(), ecorePackage.getEString(), "exceptionMessage", null, 0, 1, LogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogEntry_ExceptionStack(), ecorePackage.getEString(), "exceptionStack", null, 0, 1, LogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(logLevelEEnum, LogLevel.class, "LogLevel");
		addEEnumLiteral(logLevelEEnum, LogLevel.LOG_ERROR);
		addEEnumLiteral(logLevelEEnum, LogLevel.LOG_WARNING);
		addEEnumLiteral(logLevelEEnum, LogLevel.LOG_INFO);
		addEEnumLiteral(logLevelEEnum, LogLevel.LOG_DEBUG);

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
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.log.LogEntry <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.log.LogEntry
		 * @see org.eclipselabs.mongo.emf.log.LogPackage#getLogEntry()
		 * @generated
		 */
		public static final EClass LOG_ENTRY = eINSTANCE.getLogEntry();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOG_ENTRY__LEVEL = eINSTANCE.getLogEntry_Level();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOG_ENTRY__TIME = eINSTANCE.getLogEntry_Time();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOG_ENTRY__MESSAGE = eINSTANCE.getLogEntry_Message();

		/**
		 * The meta object literal for the '<em><b>Exception Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOG_ENTRY__EXCEPTION_MESSAGE = eINSTANCE.getLogEntry_ExceptionMessage();

		/**
		 * The meta object literal for the '<em><b>Exception Stack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOG_ENTRY__EXCEPTION_STACK = eINSTANCE.getLogEntry_ExceptionStack();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.log.LogLevel <em>Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.log.LogLevel
		 * @see org.eclipselabs.mongo.emf.log.LogPackage#getLogLevel()
		 * @generated
		 */
		public static final EEnum LOG_LEVEL = eINSTANCE.getLogLevel();

	}

} //LogPackage
