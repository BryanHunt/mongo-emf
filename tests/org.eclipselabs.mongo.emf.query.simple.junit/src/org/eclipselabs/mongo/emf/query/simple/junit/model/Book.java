/**
 */
package org.eclipselabs.mongo.emf.query.simple.junit.model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getBook()
 * @model kind="class"
 * @generated
 */
public class Book extends EObjectImpl implements EObject
{
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuthors() <em>Authors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthors()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> authors;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tags;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<Character> data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Book()
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
		return ModelPackage.Literals.BOOK;
	}

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getBook_Title()
	 * @model
	 * @generated
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Sets the value of the '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	public void setTitle(String newTitle)
	{
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOOK__TITLE, oldTitle, title));
	}

	/**
	 * Returns the value of the '<em><b>Authors</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mongo.emf.query.simple.junit.model.Person}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mongo.emf.query.simple.junit.model.Person#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' reference list.
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getBook_Authors()
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.Person#getBooks
	 * @model opposite="books"
	 * @generated
	 */
	public EList<Person> getAuthors()
	{
		if (authors == null)
		{
			authors = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this, ModelPackage.BOOK__AUTHORS, ModelPackage.PERSON__BOOKS);
		}
		return authors;
	}

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' attribute list.
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getBook_Tags()
	 * @model
	 * @generated
	 */
	public EList<String> getTags()
	{
		if (tags == null)
		{
			tags = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.BOOK__TAGS);
		}
		return tags;
	}

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Character}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute list.
	 * @see org.eclipselabs.mongo.emf.query.simple.junit.model.ModelPackage#getBook_Data()
	 * @model
	 * @generated
	 */
	public EList<Character> getData()
	{
		if (data == null)
		{
			data = new EDataTypeUniqueEList<Character>(Character.class, this, ModelPackage.BOOK__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelPackage.BOOK__AUTHORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAuthors()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelPackage.BOOK__AUTHORS:
				return ((InternalEList<?>)getAuthors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ModelPackage.BOOK__TITLE:
				return getTitle();
			case ModelPackage.BOOK__AUTHORS:
				return getAuthors();
			case ModelPackage.BOOK__TAGS:
				return getTags();
			case ModelPackage.BOOK__DATA:
				return getData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ModelPackage.BOOK__TITLE:
				setTitle((String)newValue);
				return;
			case ModelPackage.BOOK__AUTHORS:
				getAuthors().clear();
				getAuthors().addAll((Collection<? extends Person>)newValue);
				return;
			case ModelPackage.BOOK__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case ModelPackage.BOOK__DATA:
				getData().clear();
				getData().addAll((Collection<? extends Character>)newValue);
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
			case ModelPackage.BOOK__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case ModelPackage.BOOK__AUTHORS:
				getAuthors().clear();
				return;
			case ModelPackage.BOOK__TAGS:
				getTags().clear();
				return;
			case ModelPackage.BOOK__DATA:
				getData().clear();
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
			case ModelPackage.BOOK__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case ModelPackage.BOOK__AUTHORS:
				return authors != null && !authors.isEmpty();
			case ModelPackage.BOOK__TAGS:
				return tags != null && !tags.isEmpty();
			case ModelPackage.BOOK__DATA:
				return data != null && !data.isEmpty();
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
		result.append(" (title: ");
		result.append(title);
		result.append(", tags: ");
		result.append(tags);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} // Book
