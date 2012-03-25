/**
 */
package org.eclipselabs.mongo.emf.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipselabs.mongo.emf.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/mongo/emf/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipselabs.mongo.emf.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongo.emf.model.impl.MongoCursorImpl <em>Mongo Cursor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.model.impl.MongoCursorImpl
	 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getMongoCursor()
	 * @generated
	 */
	int MONGO_CURSOR = 0;

	/**
	 * The meta object id for the '{@link java.lang.Iterable<EObject> <em>Iterable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable<EObject>
	 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getIterable()
	 * @generated
	 */
	int ITERABLE = 1;

	/**
	 * The number of structural features of the '<em>Iterable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERABLE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Db Cursor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_CURSOR__DB_CURSOR = ITERABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object Builder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_CURSOR__OBJECT_BUILDER = ITERABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Db Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_CURSOR__DB_COLLECTION = ITERABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mongo Cursor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_CURSOR_FEATURE_COUNT = ITERABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '<em>DB Cursor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mongodb.DBCursor
	 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getDBCursor()
	 * @generated
	 */
	int DB_CURSOR = 2;

	/**
	 * The meta object id for the '<em>EObject Builder</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongo.emf.EObjectBuilder
	 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getEObjectBuilder()
	 * @generated
	 */
	int EOBJECT_BUILDER = 3;

	/**
	 * The meta object id for the '<em>DB Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mongodb.DBCollection
	 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getDBCollection()
	 * @generated
	 */
	int DB_COLLECTION = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongo.emf.model.MongoCursor <em>Mongo Cursor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mongo Cursor</em>'.
	 * @see org.eclipselabs.mongo.emf.model.MongoCursor
	 * @generated
	 */
	EClass getMongoCursor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.model.MongoCursor#getDbCursor <em>Db Cursor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Cursor</em>'.
	 * @see org.eclipselabs.mongo.emf.model.MongoCursor#getDbCursor()
	 * @see #getMongoCursor()
	 * @generated
	 */
	EAttribute getMongoCursor_DbCursor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.model.MongoCursor#getObjectBuilder <em>Object Builder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Builder</em>'.
	 * @see org.eclipselabs.mongo.emf.model.MongoCursor#getObjectBuilder()
	 * @see #getMongoCursor()
	 * @generated
	 */
	EAttribute getMongoCursor_ObjectBuilder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongo.emf.model.MongoCursor#getDbCollection <em>Db Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Collection</em>'.
	 * @see org.eclipselabs.mongo.emf.model.MongoCursor#getDbCollection()
	 * @see #getMongoCursor()
	 * @generated
	 */
	EAttribute getMongoCursor_DbCollection();

	/**
	 * Returns the meta object for class '{@link java.lang.Iterable<EObject> <em>Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterable</em>'.
	 * @see java.lang.Iterable<EObject>
	 * @model instanceClass="java.lang.Iterable<EObject>"
	 * @generated
	 */
	EClass getIterable();

	/**
	 * Returns the meta object for data type '{@link com.mongodb.DBCursor <em>DB Cursor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>DB Cursor</em>'.
	 * @see com.mongodb.DBCursor
	 * @model instanceClass="com.mongodb.DBCursor" serializeable="false"
	 * @generated
	 */
	EDataType getDBCursor();

	/**
	 * Returns the meta object for data type '{@link org.eclipselabs.mongo.emf.EObjectBuilder <em>EObject Builder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EObject Builder</em>'.
	 * @see org.eclipselabs.mongo.emf.EObjectBuilder
	 * @model instanceClass="org.eclipselabs.mongo.emf.EObjectBuilder" serializeable="false"
	 * @generated
	 */
	EDataType getEObjectBuilder();

	/**
	 * Returns the meta object for data type '{@link com.mongodb.DBCollection <em>DB Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>DB Collection</em>'.
	 * @see com.mongodb.DBCollection
	 * @model instanceClass="com.mongodb.DBCollection" serializeable="false"
	 * @generated
	 */
	EDataType getDBCollection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongo.emf.model.impl.MongoCursorImpl <em>Mongo Cursor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.model.impl.MongoCursorImpl
		 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getMongoCursor()
		 * @generated
		 */
		EClass MONGO_CURSOR = eINSTANCE.getMongoCursor();

		/**
		 * The meta object literal for the '<em><b>Db Cursor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONGO_CURSOR__DB_CURSOR = eINSTANCE.getMongoCursor_DbCursor();

		/**
		 * The meta object literal for the '<em><b>Object Builder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONGO_CURSOR__OBJECT_BUILDER = eINSTANCE.getMongoCursor_ObjectBuilder();

		/**
		 * The meta object literal for the '<em><b>Db Collection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONGO_CURSOR__DB_COLLECTION = eINSTANCE.getMongoCursor_DbCollection();

		/**
		 * The meta object literal for the '{@link java.lang.Iterable<EObject> <em>Iterable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable<EObject>
		 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getIterable()
		 * @generated
		 */
		EClass ITERABLE = eINSTANCE.getIterable();

		/**
		 * The meta object literal for the '<em>DB Cursor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mongodb.DBCursor
		 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getDBCursor()
		 * @generated
		 */
		EDataType DB_CURSOR = eINSTANCE.getDBCursor();

		/**
		 * The meta object literal for the '<em>EObject Builder</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongo.emf.EObjectBuilder
		 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getEObjectBuilder()
		 * @generated
		 */
		EDataType EOBJECT_BUILDER = eINSTANCE.getEObjectBuilder();

		/**
		 * The meta object literal for the '<em>DB Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mongodb.DBCollection
		 * @see org.eclipselabs.mongo.emf.model.impl.ModelPackageImpl#getDBCollection()
		 * @generated
		 */
		EDataType DB_COLLECTION = eINSTANCE.getDBCollection();

	}

} //ModelPackage
