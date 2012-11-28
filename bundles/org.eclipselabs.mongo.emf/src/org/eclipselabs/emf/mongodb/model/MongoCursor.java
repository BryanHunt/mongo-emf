/**
 */

package org.eclipselabs.emf.mongodb.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.emf.mongodb.EObjectBuilder;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mongo Cursor</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCursor <em>Db Cursor</em>}</li>
 * <li>{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getObjectBuilder <em>Object Builder</em>}</li>
 * <li>{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCollection <em>Db Collection</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoCursor()
 * @model superTypes="org.eclipselabs.emf.mongodb.model.Iterable"
 * @generated
 */
public interface MongoCursor extends EObject, Iterable<EObject>
{
	/**
	 * Returns the value of the '<em><b>Db Cursor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Cursor</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Db Cursor</em>' attribute.
	 * @see #setDbCursor(DBCursor)
	 * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoCursor_DbCursor()
	 * @model dataType="org.eclipselabs.emf.mongodb.model.DBCursor" transient="true"
	 * @generated
	 */
	DBCursor getDbCursor();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCursor <em>Db Cursor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Db Cursor</em>' attribute.
	 * @see #getDbCursor()
	 * @generated
	 */
	void setDbCursor(DBCursor value);

	/**
	 * Returns the value of the '<em><b>Object Builder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Builder</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Object Builder</em>' attribute.
	 * @see #setObjectBuilder(EObjectBuilder)
	 * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoCursor_ObjectBuilder()
	 * @model dataType="org.eclipselabs.emf.mongodb.model.EObjectBuilder" transient="true"
	 * @generated
	 */
	EObjectBuilder getObjectBuilder();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getObjectBuilder <em>Object Builder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Object Builder</em>' attribute.
	 * @see #getObjectBuilder()
	 * @generated
	 */
	void setObjectBuilder(EObjectBuilder value);

	/**
	 * Returns the value of the '<em><b>Db Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Collection</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Db Collection</em>' attribute.
	 * @see #setDbCollection(DBCollection)
	 * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoCursor_DbCollection()
	 * @model dataType="org.eclipselabs.emf.mongodb.model.DBCollection" transient="true"
	 * @generated
	 */
	DBCollection getDbCollection();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.mongodb.model.MongoCursor#getDbCollection <em>Db Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Db Collection</em>' attribute.
	 * @see #getDbCollection()
	 * @generated
	 */
	void setDbCollection(DBCollection value);

} // MongoCursor
