/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emf.freemarker;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Free Marker Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.freemarker.FreeMarkerTemplate#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.freemarker.FreemarkerPackage#getFreeMarkerTemplate()
 * @model kind="class" interface="true" abstract="true"
 * @generated
 */
public interface FreeMarkerTemplate extends EObject
{
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' attribute.
	 * @see #setContents(String)
	 * @see org.eclipselabs.emf.freemarker.FreemarkerPackage#getFreeMarkerTemplate_Contents()
	 * @model
	 * @generated
	 */
	String getContents();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emf.freemarker.FreeMarkerTemplate#getContents <em>Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contents</em>' attribute.
	 * @see #getContents()
	 * @generated
	 */
	void setContents(String value);

} // FreeMarkerTemplate
