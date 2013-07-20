/**
 */
package org.eclipselabs.emf.mongodb.model;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.lang.Iterable;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipselabs.emf.mongodb.EObjectBuilder;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.emf.mongodb.model.ModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel suppressInterfaces='true' containmentProxies='true' basePackage='org.eclipselabs.emf.mongodb'"
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
  public static final String eNS_URI = "org.eclipselabs.emf.mongodb.model";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_PREFIX = "model";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final ModelPackage eINSTANCE = org.eclipselabs.emf.mongodb.model.ModelPackage.init();

  /**
   * The meta object id for the '{@link java.lang.Iterable<org.eclipse.emf.ecore.EObject> <em>Iterable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Iterable<org.eclipse.emf.ecore.EObject>
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getIterable()
   * @generated
   */
  public static final int ITERABLE = 0;

  /**
   * The number of structural features of the '<em>Iterable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ITERABLE_FEATURE_COUNT = 0;

  /**
   * The number of operations of the '<em>Iterable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ITERABLE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.emf.mongodb.model.MongoCursor <em>Mongo Cursor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.emf.mongodb.model.MongoCursor
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoCursor()
   * @generated
   */
  public static final int MONGO_CURSOR = 1;

  /**
   * The feature id for the '<em><b>Db Cursor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_CURSOR__DB_CURSOR = ITERABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Db Collection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_CURSOR__DB_COLLECTION = ITERABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Object Builder</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_CURSOR__OBJECT_BUILDER = ITERABLE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Mongo Cursor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_CURSOR_FEATURE_COUNT = ITERABLE_FEATURE_COUNT + 3;

  /**
   * The operation id for the '<em>Iterator</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_CURSOR___ITERATOR = ITERABLE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Mongo Cursor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_CURSOR_OPERATION_COUNT = ITERABLE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.emf.mongodb.model.MongoQuery <em>Mongo Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.emf.mongodb.model.MongoQuery
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoQuery()
   * @generated
   */
  public static final int MONGO_QUERY = 2;

  /**
   * The feature id for the '<em><b>Filter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_QUERY__FILTER = 0;

  /**
   * The feature id for the '<em><b>Projection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_QUERY__PROJECTION = 1;

  /**
   * The feature id for the '<em><b>Sort</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_QUERY__SORT = 2;

  /**
   * The feature id for the '<em><b>Limit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_QUERY__LIMIT = 3;

  /**
   * The number of structural features of the '<em>Mongo Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_QUERY_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Mongo Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MONGO_QUERY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '<em>DB Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.mongodb.DBObject
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getDBObject()
   * @generated
   */
  public static final int DB_OBJECT = 3;

  /**
   * The meta object id for the '<em>DB Cursor</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.mongodb.DBCursor
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getDBCursor()
   * @generated
   */
  public static final int DB_CURSOR = 4;

  /**
   * The meta object id for the '<em>DB Collection</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.mongodb.DBCollection
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getDBCollection()
   * @generated
   */
  public static final int DB_COLLECTION = 5;

  /**
   * The meta object id for the '<em>EObject Builder</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.emf.mongodb.EObjectBuilder
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getEObjectBuilder()
   * @generated
   */
  public static final int EOBJECT_BUILDER = 6;

  /**
   * The meta object id for the '<em>Iterator</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.Iterator
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getIterator()
   * @generated
   */
  public static final int ITERATOR = 7;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iterableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mongoCursorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mongoQueryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dbObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dbCursorEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dbCollectionEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType eObjectBuilderEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iteratorEDataType = null;

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
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#eNS_URI
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

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

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
   * Returns the meta object for class '{@link java.lang.Iterable<org.eclipse.emf.ecore.EObject> <em>Iterable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iterable</em>'.
   * @see java.lang.Iterable<org.eclipse.emf.ecore.EObject>
   * @model instanceClass="java.lang.Iterable<org.eclipse.emf.ecore.EObject>"
   * @generated
   */
  public EClass getIterable()
  {
    return iterableEClass;
  }

  /**
   * Returns the meta object for class '{@link org.eclipselabs.emf.mongodb.model.MongoCursor <em>Mongo Cursor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mongo Cursor</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoCursor
   * @generated
   */
  public EClass getMongoCursor()
  {
    return mongoCursorEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCursor <em>Db Cursor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Db Cursor</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCursor()
   * @see #getMongoCursor()
   * @generated
   */
  public EAttribute getMongoCursor_DbCursor()
  {
    return (EAttribute)mongoCursorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCollection <em>Db Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Db Collection</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCollection()
   * @see #getMongoCursor()
   * @generated
   */
  public EAttribute getMongoCursor_DbCollection()
  {
    return (EAttribute)mongoCursorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getObjectBuilder <em>Object Builder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Object Builder</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoCursor#getObjectBuilder()
   * @see #getMongoCursor()
   * @generated
   */
  public EAttribute getMongoCursor_ObjectBuilder()
  {
    return (EAttribute)mongoCursorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the '{@link org.eclipselabs.emf.mongodb.model.MongoCursor#iterator() <em>Iterator</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Iterator</em>' operation.
   * @see org.eclipselabs.emf.mongodb.model.MongoCursor#iterator()
   * @generated
   */
  public EOperation getMongoCursor__Iterator()
  {
    return mongoCursorEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.eclipselabs.emf.mongodb.model.MongoQuery <em>Mongo Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mongo Query</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoQuery
   * @generated
   */
  public EClass getMongoQuery()
  {
    return mongoQueryEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getFilter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Filter</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoQuery#getFilter()
   * @see #getMongoQuery()
   * @generated
   */
  public EAttribute getMongoQuery_Filter()
  {
    return (EAttribute)mongoQueryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getProjection <em>Projection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Projection</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoQuery#getProjection()
   * @see #getMongoQuery()
   * @generated
   */
  public EAttribute getMongoQuery_Projection()
  {
    return (EAttribute)mongoQueryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getSort <em>Sort</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sort</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoQuery#getSort()
   * @see #getMongoQuery()
   * @generated
   */
  public EAttribute getMongoQuery_Sort()
  {
    return (EAttribute)mongoQueryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getLimit <em>Limit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Limit</em>'.
   * @see org.eclipselabs.emf.mongodb.model.MongoQuery#getLimit()
   * @see #getMongoQuery()
   * @generated
   */
  public EAttribute getMongoQuery_Limit()
  {
    return (EAttribute)mongoQueryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for data type '{@link com.mongodb.DBObject <em>DB Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>DB Object</em>'.
   * @see com.mongodb.DBObject
   * @model instanceClass="com.mongodb.DBObject"
   * @generated
   */
  public EDataType getDBObject()
  {
    return dbObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link com.mongodb.DBCursor <em>DB Cursor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>DB Cursor</em>'.
   * @see com.mongodb.DBCursor
   * @model instanceClass="com.mongodb.DBCursor"
   * @generated
   */
  public EDataType getDBCursor()
  {
    return dbCursorEDataType;
  }

  /**
   * Returns the meta object for data type '{@link com.mongodb.DBCollection <em>DB Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>DB Collection</em>'.
   * @see com.mongodb.DBCollection
   * @model instanceClass="com.mongodb.DBCollection"
   * @generated
   */
  public EDataType getDBCollection()
  {
    return dbCollectionEDataType;
  }

  /**
   * Returns the meta object for data type '{@link org.eclipselabs.emf.mongodb.EObjectBuilder <em>EObject Builder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>EObject Builder</em>'.
   * @see org.eclipselabs.emf.mongodb.EObjectBuilder
   * @model instanceClass="org.eclipselabs.emf.mongodb.EObjectBuilder"
   * @generated
   */
  public EDataType getEObjectBuilder()
  {
    return eObjectBuilderEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.util.Iterator <em>Iterator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Iterator</em>'.
   * @see java.util.Iterator
   * @model instanceClass="java.util.Iterator<org.eclipse.emf.ecore.EObject>"
   * @generated
   */
  public EDataType getIterator()
  {
    return iteratorEDataType;
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
    iterableEClass = createEClass(ITERABLE);

    mongoCursorEClass = createEClass(MONGO_CURSOR);
    createEAttribute(mongoCursorEClass, MONGO_CURSOR__DB_CURSOR);
    createEAttribute(mongoCursorEClass, MONGO_CURSOR__DB_COLLECTION);
    createEAttribute(mongoCursorEClass, MONGO_CURSOR__OBJECT_BUILDER);
    createEOperation(mongoCursorEClass, MONGO_CURSOR___ITERATOR);

    mongoQueryEClass = createEClass(MONGO_QUERY);
    createEAttribute(mongoQueryEClass, MONGO_QUERY__FILTER);
    createEAttribute(mongoQueryEClass, MONGO_QUERY__PROJECTION);
    createEAttribute(mongoQueryEClass, MONGO_QUERY__SORT);
    createEAttribute(mongoQueryEClass, MONGO_QUERY__LIMIT);

    // Create data types
    dbObjectEDataType = createEDataType(DB_OBJECT);
    dbCursorEDataType = createEDataType(DB_CURSOR);
    dbCollectionEDataType = createEDataType(DB_COLLECTION);
    eObjectBuilderEDataType = createEDataType(EOBJECT_BUILDER);
    iteratorEDataType = createEDataType(ITERATOR);
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

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    mongoCursorEClass.getESuperTypes().add(this.getIterable());

    // Initialize classes, features, and operations; add parameters
    initEClass(iterableEClass, Iterable.class, "Iterable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS, "java.lang.Iterable<org.eclipse.emf.ecore.EObject>");

    initEClass(mongoCursorEClass, MongoCursor.class, "MongoCursor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMongoCursor_DbCursor(), this.getDBCursor(), "dbCursor", null, 0, 1, MongoCursor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMongoCursor_DbCollection(), this.getDBCollection(), "dbCollection", null, 0, 1, MongoCursor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMongoCursor_ObjectBuilder(), this.getEObjectBuilder(), "objectBuilder", null, 0, 1, MongoCursor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getMongoCursor__Iterator(), this.getIterator(), "iterator", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(mongoQueryEClass, MongoQuery.class, "MongoQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMongoQuery_Filter(), this.getDBObject(), "filter", null, 0, 1, MongoQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMongoQuery_Projection(), this.getDBObject(), "projection", null, 0, 1, MongoQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMongoQuery_Sort(), this.getDBObject(), "sort", null, 0, 1, MongoQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMongoQuery_Limit(), theEcorePackage.getEIntegerObject(), "limit", null, 0, 1, MongoQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(dbObjectEDataType, DBObject.class, "DBObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(dbCursorEDataType, DBCursor.class, "DBCursor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(dbCollectionEDataType, DBCollection.class, "DBCollection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(eObjectBuilderEDataType, EObjectBuilder.class, "EObjectBuilder", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iteratorEDataType, Iterator.class, "Iterator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Iterator<org.eclipse.emf.ecore.EObject>");

    // Create resource
    createResource(eNS_URI);
  }

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  public interface Literals
  {
    /**
     * The meta object literal for the '{@link java.lang.Iterable<org.eclipse.emf.ecore.EObject> <em>Iterable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Iterable<org.eclipse.emf.ecore.EObject>
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getIterable()
     * @generated
     */
    public static final EClass ITERABLE = eINSTANCE.getIterable();

    /**
     * The meta object literal for the '{@link org.eclipselabs.emf.mongodb.model.MongoCursor <em>Mongo Cursor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.emf.mongodb.model.MongoCursor
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoCursor()
     * @generated
     */
    public static final EClass MONGO_CURSOR = eINSTANCE.getMongoCursor();

    /**
     * The meta object literal for the '<em><b>Db Cursor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MONGO_CURSOR__DB_CURSOR = eINSTANCE.getMongoCursor_DbCursor();

    /**
     * The meta object literal for the '<em><b>Db Collection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MONGO_CURSOR__DB_COLLECTION = eINSTANCE.getMongoCursor_DbCollection();

    /**
     * The meta object literal for the '<em><b>Object Builder</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MONGO_CURSOR__OBJECT_BUILDER = eINSTANCE.getMongoCursor_ObjectBuilder();

    /**
     * The meta object literal for the '<em><b>Iterator</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation MONGO_CURSOR___ITERATOR = eINSTANCE.getMongoCursor__Iterator();

    /**
     * The meta object literal for the '{@link org.eclipselabs.emf.mongodb.model.MongoQuery <em>Mongo Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.emf.mongodb.model.MongoQuery
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoQuery()
     * @generated
     */
    public static final EClass MONGO_QUERY = eINSTANCE.getMongoQuery();

    /**
     * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MONGO_QUERY__FILTER = eINSTANCE.getMongoQuery_Filter();

    /**
     * The meta object literal for the '<em><b>Projection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MONGO_QUERY__PROJECTION = eINSTANCE.getMongoQuery_Projection();

    /**
     * The meta object literal for the '<em><b>Sort</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MONGO_QUERY__SORT = eINSTANCE.getMongoQuery_Sort();

    /**
     * The meta object literal for the '<em><b>Limit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MONGO_QUERY__LIMIT = eINSTANCE.getMongoQuery_Limit();

    /**
     * The meta object literal for the '<em>DB Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.mongodb.DBObject
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getDBObject()
     * @generated
     */
    public static final EDataType DB_OBJECT = eINSTANCE.getDBObject();

    /**
     * The meta object literal for the '<em>DB Cursor</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.mongodb.DBCursor
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getDBCursor()
     * @generated
     */
    public static final EDataType DB_CURSOR = eINSTANCE.getDBCursor();

    /**
     * The meta object literal for the '<em>DB Collection</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.mongodb.DBCollection
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getDBCollection()
     * @generated
     */
    public static final EDataType DB_COLLECTION = eINSTANCE.getDBCollection();

    /**
     * The meta object literal for the '<em>EObject Builder</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.emf.mongodb.EObjectBuilder
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getEObjectBuilder()
     * @generated
     */
    public static final EDataType EOBJECT_BUILDER = eINSTANCE.getEObjectBuilder();

    /**
     * The meta object literal for the '<em>Iterator</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Iterator
     * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getIterator()
     * @generated
     */
    public static final EDataType ITERATOR = eINSTANCE.getIterator();

  }

} //ModelPackage
