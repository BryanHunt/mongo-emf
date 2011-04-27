/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mongo.emf.log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mongo.emf.log.LogPackage#getLogLevel()
 * @model
 * @generated
 */
public enum LogLevel implements Enumerator
{
	/**
	 * The '<em><b>LOG ERROR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_ERROR(1, "LOG_ERROR", "ERROR"),

	/**
	 * The '<em><b>LOG WARNING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_WARNING_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_WARNING(2, "LOG_WARNING", "WARNING"),

	/**
	 * The '<em><b>LOG INFO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_INFO_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_INFO(3, "LOG_INFO", "INFO"),

	/**
	 * The '<em><b>LOG DEBUG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_DEBUG_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_DEBUG(4, "LOG_DEBUG", "DEBUG");

	/**
	 * The '<em><b>LOG ERROR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOG ERROR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOG_ERROR
	 * @model literal="ERROR"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_ERROR_VALUE = 1;

	/**
	 * The '<em><b>LOG WARNING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOG WARNING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOG_WARNING
	 * @model literal="WARNING"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_WARNING_VALUE = 2;

	/**
	 * The '<em><b>LOG INFO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOG INFO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOG_INFO
	 * @model literal="INFO"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_INFO_VALUE = 3;

	/**
	 * The '<em><b>LOG DEBUG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOG DEBUG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOG_DEBUG
	 * @model literal="DEBUG"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_DEBUG_VALUE = 4;

	/**
	 * An array of all the '<em><b>Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LogLevel[] VALUES_ARRAY =
		new LogLevel[]
		{
			LOG_ERROR,
			LOG_WARNING,
			LOG_INFO,
			LOG_DEBUG,
		};

	/**
	 * A public read-only list of all the '<em><b>Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<LogLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LogLevel get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			LogLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LogLevel getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			LogLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LogLevel get(int value)
	{
		switch (value)
		{
			case LOG_ERROR_VALUE: return LOG_ERROR;
			case LOG_WARNING_VALUE: return LOG_WARNING;
			case LOG_INFO_VALUE: return LOG_INFO;
			case LOG_DEBUG_VALUE: return LOG_DEBUG;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private LogLevel(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //LogLevel
