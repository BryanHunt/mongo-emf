/**
 */
package org.eclipselabs.emf.log;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emf.log.LogEntry#getLevel <em>Level</em>}</li>
 *   <li>{@link org.eclipselabs.emf.log.LogEntry#getCreatedOn <em>Created On</em>}</li>
 *   <li>{@link org.eclipselabs.emf.log.LogEntry#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipselabs.emf.log.LogEntry#getExceptionMessage <em>Exception Message</em>}</li>
 *   <li>{@link org.eclipselabs.emf.log.LogEntry#getExceptionStack <em>Exception Stack</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emf.log.LogPackage#getLogEntry()
 * @model kind="class"
 * @generated
 */
public class LogEntry extends MinimalEObjectImpl.Container implements EObject
{
  /**
   * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected static final LogLevel LEVEL_EDEFAULT = LogLevel.ERROR;

  /**
   * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected LogLevel level = LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreatedOn()
   * @generated
   * @ordered
   */
  protected static final Date CREATED_ON_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreatedOn()
   * @generated
   * @ordered
   */
  protected Date createdOn = CREATED_ON_EDEFAULT;

  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getExceptionMessage() <em>Exception Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionMessage()
   * @generated
   * @ordered
   */
  protected static final String EXCEPTION_MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExceptionMessage() <em>Exception Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionMessage()
   * @generated
   * @ordered
   */
  protected String exceptionMessage = EXCEPTION_MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getExceptionStack() <em>Exception Stack</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionStack()
   * @generated
   * @ordered
   */
  protected static final String EXCEPTION_STACK_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExceptionStack() <em>Exception Stack</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionStack()
   * @generated
   * @ordered
   */
  protected String exceptionStack = EXCEPTION_STACK_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LogEntry()
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
    return LogPackage.Literals.LOG_ENTRY;
  }

  /**
   * Returns the value of the '<em><b>Level</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.emf.log.LogLevel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level</em>' attribute.
   * @see org.eclipselabs.emf.log.LogLevel
   * @see #setLevel(LogLevel)
   * @see org.eclipselabs.emf.log.LogPackage#getLogEntry_Level()
   * @model unique="false"
   * @generated
   */
  public LogLevel getLevel()
  {
    return level;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.log.LogEntry#getLevel <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Level</em>' attribute.
   * @see org.eclipselabs.emf.log.LogLevel
   * @see #getLevel()
   * @generated
   */
  public void setLevel(LogLevel newLevel)
  {
    LogLevel oldLevel = level;
    level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY__LEVEL, oldLevel, level));
  }

  /**
   * Returns the value of the '<em><b>Created On</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Created On</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Created On</em>' attribute.
   * @see #setCreatedOn(Date)
   * @see org.eclipselabs.emf.log.LogPackage#getLogEntry_CreatedOn()
   * @model unique="false" dataType="org.eclipselabs.emf.log.Date"
   * @generated
   */
  public Date getCreatedOn()
  {
    return createdOn;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.log.LogEntry#getCreatedOn <em>Created On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Created On</em>' attribute.
   * @see #getCreatedOn()
   * @generated
   */
  public void setCreatedOn(Date newCreatedOn)
  {
    Date oldCreatedOn = createdOn;
    createdOn = newCreatedOn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY__CREATED_ON, oldCreatedOn, createdOn));
  }

  /**
   * Returns the value of the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' attribute.
   * @see #setMessage(String)
   * @see org.eclipselabs.emf.log.LogPackage#getLogEntry_Message()
   * @model unique="false"
   * @generated
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.log.LogEntry#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  public void setMessage(String newMessage)
  {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY__MESSAGE, oldMessage, message));
  }

  /**
   * Returns the value of the '<em><b>Exception Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception Message</em>' attribute.
   * @see #setExceptionMessage(String)
   * @see org.eclipselabs.emf.log.LogPackage#getLogEntry_ExceptionMessage()
   * @model unique="false"
   * @generated
   */
  public String getExceptionMessage()
  {
    return exceptionMessage;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.log.LogEntry#getExceptionMessage <em>Exception Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Message</em>' attribute.
   * @see #getExceptionMessage()
   * @generated
   */
  public void setExceptionMessage(String newExceptionMessage)
  {
    String oldExceptionMessage = exceptionMessage;
    exceptionMessage = newExceptionMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY__EXCEPTION_MESSAGE, oldExceptionMessage, exceptionMessage));
  }

  /**
   * Returns the value of the '<em><b>Exception Stack</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception Stack</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception Stack</em>' attribute.
   * @see #setExceptionStack(String)
   * @see org.eclipselabs.emf.log.LogPackage#getLogEntry_ExceptionStack()
   * @model unique="false"
   * @generated
   */
  public String getExceptionStack()
  {
    return exceptionStack;
  }

  /**
   * Sets the value of the '{@link org.eclipselabs.emf.log.LogEntry#getExceptionStack <em>Exception Stack</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Stack</em>' attribute.
   * @see #getExceptionStack()
   * @generated
   */
  public void setExceptionStack(String newExceptionStack)
  {
    String oldExceptionStack = exceptionStack;
    exceptionStack = newExceptionStack;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY__EXCEPTION_STACK, oldExceptionStack, exceptionStack));
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
      case LogPackage.LOG_ENTRY__LEVEL:
        return getLevel();
      case LogPackage.LOG_ENTRY__CREATED_ON:
        return getCreatedOn();
      case LogPackage.LOG_ENTRY__MESSAGE:
        return getMessage();
      case LogPackage.LOG_ENTRY__EXCEPTION_MESSAGE:
        return getExceptionMessage();
      case LogPackage.LOG_ENTRY__EXCEPTION_STACK:
        return getExceptionStack();
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
      case LogPackage.LOG_ENTRY__LEVEL:
        setLevel((LogLevel)newValue);
        return;
      case LogPackage.LOG_ENTRY__CREATED_ON:
        setCreatedOn((Date)newValue);
        return;
      case LogPackage.LOG_ENTRY__MESSAGE:
        setMessage((String)newValue);
        return;
      case LogPackage.LOG_ENTRY__EXCEPTION_MESSAGE:
        setExceptionMessage((String)newValue);
        return;
      case LogPackage.LOG_ENTRY__EXCEPTION_STACK:
        setExceptionStack((String)newValue);
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
      case LogPackage.LOG_ENTRY__LEVEL:
        setLevel(LEVEL_EDEFAULT);
        return;
      case LogPackage.LOG_ENTRY__CREATED_ON:
        setCreatedOn(CREATED_ON_EDEFAULT);
        return;
      case LogPackage.LOG_ENTRY__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case LogPackage.LOG_ENTRY__EXCEPTION_MESSAGE:
        setExceptionMessage(EXCEPTION_MESSAGE_EDEFAULT);
        return;
      case LogPackage.LOG_ENTRY__EXCEPTION_STACK:
        setExceptionStack(EXCEPTION_STACK_EDEFAULT);
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
      case LogPackage.LOG_ENTRY__LEVEL:
        return level != LEVEL_EDEFAULT;
      case LogPackage.LOG_ENTRY__CREATED_ON:
        return CREATED_ON_EDEFAULT == null ? createdOn != null : !CREATED_ON_EDEFAULT.equals(createdOn);
      case LogPackage.LOG_ENTRY__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case LogPackage.LOG_ENTRY__EXCEPTION_MESSAGE:
        return EXCEPTION_MESSAGE_EDEFAULT == null ? exceptionMessage != null : !EXCEPTION_MESSAGE_EDEFAULT.equals(exceptionMessage);
      case LogPackage.LOG_ENTRY__EXCEPTION_STACK:
        return EXCEPTION_STACK_EDEFAULT == null ? exceptionStack != null : !EXCEPTION_STACK_EDEFAULT.equals(exceptionStack);
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
    result.append(" (level: ");
    result.append(level);
    result.append(", createdOn: ");
    result.append(createdOn);
    result.append(", message: ");
    result.append(message);
    result.append(", exceptionMessage: ");
    result.append(exceptionMessage);
    result.append(", exceptionStack: ");
    result.append(exceptionStack);
    result.append(')');
    return result.toString();
  }

} // LogEntry
