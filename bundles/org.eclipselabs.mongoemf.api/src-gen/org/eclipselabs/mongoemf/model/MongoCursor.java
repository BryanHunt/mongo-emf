/**
 */
package org.eclipselabs.mongoemf.model;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipselabs.mongoemf.EObjectBuilder;

import org.eclipselabs.mongoemf.util.MongoIterator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mongo Cursor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongoemf.model.MongoCursor#getDbCursor <em>Db Cursor</em>}</li>
 *   <li>{@link org.eclipselabs.mongoemf.model.MongoCursor#getDbCollection <em>Db Collection</em>}</li>
 *   <li>{@link org.eclipselabs.mongoemf.model.MongoCursor#getObjectBuilder <em>Object Builder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongoemf.model.ModelPackage#getMongoCursor()
 * @model kind="class" superTypes="org.eclipselabs.mongoemf.model.Iterable"
 * @generated
 */
public class MongoCursor extends MinimalEObjectImpl.Container implements EObject, Iterable<EObject>
{
	/**
	 * The default value of the '{@link #getDbCursor() <em>Db Cursor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbCursor()
	 * @generated
	 * @ordered
	 */
	protected static final DBCursor DB_CURSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbCursor() <em>Db Cursor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbCursor()
	 * @generated
	 * @ordered
	 */
	protected DBCursor dbCursor = DB_CURSOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbCollection() <em>Db Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbCollection()
	 * @generated
	 * @ordered
	 */
	protected static final DBCollection DB_COLLECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbCollection() <em>Db Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbCollection()
	 * @generated
	 * @ordered
	 */
	protected DBCollection dbCollection = DB_COLLECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectBuilder() <em>Object Builder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectBuilder()
	 * @generated
	 * @ordered
	 */
	protected static final EObjectBuilder OBJECT_BUILDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectBuilder() <em>Object Builder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectBuilder()
	 * @generated
	 * @ordered
	 */
	protected EObjectBuilder objectBuilder = OBJECT_BUILDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MongoCursor()
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
		return ModelPackage.Literals.MONGO_CURSOR;
	}

	/**
	 * Returns the value of the '<em><b>Db Cursor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Cursor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Cursor</em>' attribute.
	 * @see #setDbCursor(DBCursor)
	 * @see org.eclipselabs.mongoemf.model.ModelPackage#getMongoCursor_DbCursor()
	 * @model unique="false" dataType="org.eclipselabs.mongoemf.model.DBCursor"
	 * @generated
	 */
	public DBCursor getDbCursor()
	{
		return dbCursor;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongoemf.model.MongoCursor#getDbCursor <em>Db Cursor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Cursor</em>' attribute.
	 * @see #getDbCursor()
	 * @generated
	 */
	public void setDbCursor(DBCursor newDbCursor)
	{
		DBCursor oldDbCursor = dbCursor;
		dbCursor = newDbCursor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_CURSOR__DB_CURSOR, oldDbCursor, dbCursor));
	}

	/**
	 * Returns the value of the '<em><b>Db Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Collection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Collection</em>' attribute.
	 * @see #setDbCollection(DBCollection)
	 * @see org.eclipselabs.mongoemf.model.ModelPackage#getMongoCursor_DbCollection()
	 * @model unique="false" dataType="org.eclipselabs.mongoemf.model.DBCollection"
	 * @generated
	 */
	public DBCollection getDbCollection()
	{
		return dbCollection;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongoemf.model.MongoCursor#getDbCollection <em>Db Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Collection</em>' attribute.
	 * @see #getDbCollection()
	 * @generated
	 */
	public void setDbCollection(DBCollection newDbCollection)
	{
		DBCollection oldDbCollection = dbCollection;
		dbCollection = newDbCollection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_CURSOR__DB_COLLECTION, oldDbCollection, dbCollection));
	}

	/**
	 * Returns the value of the '<em><b>Object Builder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Builder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Builder</em>' attribute.
	 * @see #setObjectBuilder(EObjectBuilder)
	 * @see org.eclipselabs.mongoemf.model.ModelPackage#getMongoCursor_ObjectBuilder()
	 * @model unique="false" dataType="org.eclipselabs.mongoemf.model.EObjectBuilder"
	 * @generated
	 */
	public EObjectBuilder getObjectBuilder()
	{
		return objectBuilder;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongoemf.model.MongoCursor#getObjectBuilder <em>Object Builder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Builder</em>' attribute.
	 * @see #getObjectBuilder()
	 * @generated
	 */
	public void setObjectBuilder(EObjectBuilder newObjectBuilder)
	{
		EObjectBuilder oldObjectBuilder = objectBuilder;
		objectBuilder = newObjectBuilder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_CURSOR__OBJECT_BUILDER, oldObjectBuilder, objectBuilder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipselabs.mongoemf.model.Iterator" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.ecore.resource.Resource%> _eResource = this.eResource();\nreturn new <%org.eclipselabs.mongoemf.util.MongoIterator%>(this.dbCursor, this.dbCollection, _eResource, this.objectBuilder);'"
	 * @generated
	 */
	public Iterator<EObject> iterator()
	{
		Resource _eResource = this.eResource();
		return new MongoIterator(this.dbCursor, this.dbCollection, _eResource, this.objectBuilder);
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
			case ModelPackage.MONGO_CURSOR__DB_CURSOR:
				return getDbCursor();
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				return getDbCollection();
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				return getObjectBuilder();
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
			case ModelPackage.MONGO_CURSOR__DB_CURSOR:
				setDbCursor((DBCursor)newValue);
				return;
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				setDbCollection((DBCollection)newValue);
				return;
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				setObjectBuilder((EObjectBuilder)newValue);
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
			case ModelPackage.MONGO_CURSOR__DB_CURSOR:
				setDbCursor(DB_CURSOR_EDEFAULT);
				return;
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				setDbCollection(DB_COLLECTION_EDEFAULT);
				return;
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				setObjectBuilder(OBJECT_BUILDER_EDEFAULT);
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
			case ModelPackage.MONGO_CURSOR__DB_CURSOR:
				return DB_CURSOR_EDEFAULT == null ? dbCursor != null : !DB_CURSOR_EDEFAULT.equals(dbCursor);
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				return DB_COLLECTION_EDEFAULT == null ? dbCollection != null : !DB_COLLECTION_EDEFAULT.equals(dbCollection);
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				return OBJECT_BUILDER_EDEFAULT == null ? objectBuilder != null : !OBJECT_BUILDER_EDEFAULT.equals(objectBuilder);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case ModelPackage.MONGO_CURSOR___ITERATOR:
				return iterator();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (dbCursor: ");
		result.append(dbCursor);
		result.append(", dbCollection: ");
		result.append(dbCollection);
		result.append(", objectBuilder: ");
		result.append(objectBuilder);
		result.append(')');
		return result.toString();
	}

} // MongoCursor
