/**
 */

package org.eclipselabs.emf.mongodb.model.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emf.mongodb.EObjectBuilder;
import org.eclipselabs.emf.mongodb.model.ModelPackage;
import org.eclipselabs.emf.mongodb.model.MongoCursor;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mongo Cursor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.mongodb.model.impl.MongoCursorImpl#getDbCursor <em>Db Cursor</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.model.impl.MongoCursorImpl#getObjectBuilder <em>Object Builder</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.model.impl.MongoCursorImpl#getDbCollection <em>Db Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MongoCursorImpl extends EObjectImpl implements MongoCursor
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MongoCursorImpl()
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBCursor getDbCursor()
	{
		return dbCursor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectBuilder getObjectBuilder()
	{
		return objectBuilder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @generated
	 */
	public DBCollection getDbCollection()
	{
		return dbCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbCollection(DBCollection newDbCollection)
	{
		DBCollection oldDbCollection = dbCollection;
		dbCollection = newDbCollection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_CURSOR__DB_COLLECTION, oldDbCollection, dbCollection));
	}

	@Override
	public Iterator<EObject> iterator()
	{
		return new Iterator<EObject>()
		{
			@Override
			public void remove()
			{
				dbCursor.remove();
			}

			@Override
			public EObject next()
			{
				DBObject dbObject = dbCursor.next();
				URI uri = objectBuilder.buildURI(dbCollection, dbObject);
				Resource resource = eResource().getResourceSet().createResource(uri, null);
				EObject eObject = objectBuilder.buildEObject(dbCollection, dbObject, eResource(), false);
				resource.getContents().add(eObject);
				return eObject;
			}

			@Override
			public boolean hasNext()
			{
				return dbCursor.hasNext();
			}
		};
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
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				return getObjectBuilder();
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				return getDbCollection();
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
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				setObjectBuilder((EObjectBuilder)newValue);
				return;
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				setDbCollection((DBCollection)newValue);
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
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				setObjectBuilder(OBJECT_BUILDER_EDEFAULT);
				return;
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				setDbCollection(DB_COLLECTION_EDEFAULT);
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
			case ModelPackage.MONGO_CURSOR__OBJECT_BUILDER:
				return OBJECT_BUILDER_EDEFAULT == null ? objectBuilder != null : !OBJECT_BUILDER_EDEFAULT.equals(objectBuilder);
			case ModelPackage.MONGO_CURSOR__DB_COLLECTION:
				return DB_COLLECTION_EDEFAULT == null ? dbCollection != null : !DB_COLLECTION_EDEFAULT.equals(dbCollection);
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
		result.append(" (dbCursor: ");
		result.append(dbCursor);
		result.append(", objectBuilder: ");
		result.append(objectBuilder);
		result.append(", dbCollection: ");
		result.append(dbCollection);
		result.append(')');
		return result.toString();
	}

} //MongoCursorImpl
