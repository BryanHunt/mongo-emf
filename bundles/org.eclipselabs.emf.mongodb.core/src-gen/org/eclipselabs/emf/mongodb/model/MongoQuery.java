/**
 */
package org.eclipselabs.emf.mongodb.model;

import com.mongodb.DBObject;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mongo Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getProjection <em>Projection</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getSort <em>Sort</em>}</li>
 *   <li>{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getLimit <em>Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoQuery()
 * @model kind="class"
 * @generated
 */
public class MongoQuery extends MinimalEObjectImpl.Container implements EObject
{
  /**
   * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilter()
   * @generated
   * @ordered
   */
  protected static final DBObject FILTER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilter()
   * @generated
   * @ordered
   */
  protected DBObject filter = FILTER_EDEFAULT;

  /**
   * The default value of the '{@link #getProjection() <em>Projection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjection()
   * @generated
   * @ordered
   */
  protected static final DBObject PROJECTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProjection() <em>Projection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjection()
   * @generated
   * @ordered
   */
  protected DBObject projection = PROJECTION_EDEFAULT;

  /**
   * The default value of the '{@link #getSort() <em>Sort</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSort()
   * @generated
   * @ordered
   */
  protected static final DBObject SORT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSort() <em>Sort</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSort()
   * @generated
   * @ordered
   */
  protected DBObject sort = SORT_EDEFAULT;

  /**
   * The default value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected static final Integer LIMIT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected Integer limit = LIMIT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MongoQuery()
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
    return ModelPackage.Literals.MONGO_QUERY;
  }

  /**
   * Returns the value of the '<em><b>Filter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filter</em>' attribute.
   * @see #setFilter(DBObject)
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoQuery_Filter()
   * @model unique="false" dataType="org.eclipselabs.emf.mongodb.model.DBObject"
   * @generated
   */
  public DBObject getFilter()
  {
    return filter;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getFilter <em>Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filter</em>' attribute.
   * @see #getFilter()
   * @generated
   */
  public void setFilter(DBObject newFilter)
  {
    DBObject oldFilter = filter;
    filter = newFilter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_QUERY__FILTER, oldFilter, filter));
  }

  /**
   * Returns the value of the '<em><b>Projection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Projection</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Projection</em>' attribute.
   * @see #setProjection(DBObject)
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoQuery_Projection()
   * @model unique="false" dataType="org.eclipselabs.emf.mongodb.model.DBObject"
   * @generated
   */
  public DBObject getProjection()
  {
    return projection;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getProjection <em>Projection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Projection</em>' attribute.
   * @see #getProjection()
   * @generated
   */
  public void setProjection(DBObject newProjection)
  {
    DBObject oldProjection = projection;
    projection = newProjection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_QUERY__PROJECTION, oldProjection, projection));
  }

  /**
   * Returns the value of the '<em><b>Sort</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sort</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sort</em>' attribute.
   * @see #setSort(DBObject)
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoQuery_Sort()
   * @model unique="false" dataType="org.eclipselabs.emf.mongodb.model.DBObject"
   * @generated
   */
  public DBObject getSort()
  {
    return sort;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getSort <em>Sort</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sort</em>' attribute.
   * @see #getSort()
   * @generated
   */
  public void setSort(DBObject newSort)
  {
    DBObject oldSort = sort;
    sort = newSort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_QUERY__SORT, oldSort, sort));
  }

  /**
   * Returns the value of the '<em><b>Limit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Limit</em>' attribute.
   * @see #setLimit(Integer)
   * @see org.eclipselabs.emf.mongodb.model.ModelPackage#getMongoQuery_Limit()
   * @model unique="false"
   * @generated
   */
  public Integer getLimit()
  {
    return limit;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.mongodb.model.MongoQuery#getLimit <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Limit</em>' attribute.
   * @see #getLimit()
   * @generated
   */
  public void setLimit(Integer newLimit)
  {
    Integer oldLimit = limit;
    limit = newLimit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MONGO_QUERY__LIMIT, oldLimit, limit));
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
      case ModelPackage.MONGO_QUERY__FILTER:
        return getFilter();
      case ModelPackage.MONGO_QUERY__PROJECTION:
        return getProjection();
      case ModelPackage.MONGO_QUERY__SORT:
        return getSort();
      case ModelPackage.MONGO_QUERY__LIMIT:
        return getLimit();
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
      case ModelPackage.MONGO_QUERY__FILTER:
        setFilter((DBObject)newValue);
        return;
      case ModelPackage.MONGO_QUERY__PROJECTION:
        setProjection((DBObject)newValue);
        return;
      case ModelPackage.MONGO_QUERY__SORT:
        setSort((DBObject)newValue);
        return;
      case ModelPackage.MONGO_QUERY__LIMIT:
        setLimit((Integer)newValue);
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
      case ModelPackage.MONGO_QUERY__FILTER:
        setFilter(FILTER_EDEFAULT);
        return;
      case ModelPackage.MONGO_QUERY__PROJECTION:
        setProjection(PROJECTION_EDEFAULT);
        return;
      case ModelPackage.MONGO_QUERY__SORT:
        setSort(SORT_EDEFAULT);
        return;
      case ModelPackage.MONGO_QUERY__LIMIT:
        setLimit(LIMIT_EDEFAULT);
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
      case ModelPackage.MONGO_QUERY__FILTER:
        return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
      case ModelPackage.MONGO_QUERY__PROJECTION:
        return PROJECTION_EDEFAULT == null ? projection != null : !PROJECTION_EDEFAULT.equals(projection);
      case ModelPackage.MONGO_QUERY__SORT:
        return SORT_EDEFAULT == null ? sort != null : !SORT_EDEFAULT.equals(sort);
      case ModelPackage.MONGO_QUERY__LIMIT:
        return LIMIT_EDEFAULT == null ? limit != null : !LIMIT_EDEFAULT.equals(limit);
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
    result.append(" (filter: ");
    result.append(filter);
    result.append(", projection: ");
    result.append(projection);
    result.append(", sort: ");
    result.append(sort);
    result.append(", limit: ");
    result.append(limit);
    result.append(')');
    return result.toString();
  }

} // MongoQuery
