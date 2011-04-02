/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

package org.eclipselabs.mongo.emf.junit.model.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipselabs.mongo.emf.junit.model.ETypes;
import org.eclipselabs.mongo.emf.junit.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ETypes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEBigDecimal <em>EBig Decimal</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEBigInteger <em>EBig Integer</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#isEBoolean <em>EBoolean</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEByte <em>EByte</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEByteArray <em>EByte Array</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEChar <em>EChar</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEDate <em>EDate</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEDouble <em>EDouble</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEFloat <em>EFloat</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEInt <em>EInt</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getELong <em>ELong</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEShort <em>EShort</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getEString <em>EString</em>}</li>
 *   <li>{@link org.eclipselabs.mongo.emf.junit.model.impl.ETypesImpl#getUris <em>Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ETypesImpl extends EObjectImpl implements ETypes
{
	/**
	 * The default value of the '{@link #getEBigDecimal() <em>EBig Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal EBIG_DECIMAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEBigDecimal() <em>EBig Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal eBigDecimal = EBIG_DECIMAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEBigInteger() <em>EBig Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigInteger()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger EBIG_INTEGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEBigInteger() <em>EBig Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigInteger()
	 * @generated
	 * @ordered
	 */
	protected BigInteger eBigInteger = EBIG_INTEGER_EDEFAULT;

	/**
	 * The default value of the '{@link #isEBoolean() <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEBoolean()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EBOOLEAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEBoolean() <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEBoolean()
	 * @generated
	 * @ordered
	 */
	protected boolean eBoolean = EBOOLEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getEByte() <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByte()
	 * @generated
	 * @ordered
	 */
	protected static final byte EBYTE_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getEByte() <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByte()
	 * @generated
	 * @ordered
	 */
	protected byte eByte = EBYTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEByteArray() <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByteArray()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] EBYTE_ARRAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEByteArray() <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByteArray()
	 * @generated
	 * @ordered
	 */
	protected byte[] eByteArray = EBYTE_ARRAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getEChar() <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEChar()
	 * @generated
	 * @ordered
	 */
	protected static final char ECHAR_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getEChar() <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEChar()
	 * @generated
	 * @ordered
	 */
	protected char eChar = ECHAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getEDate() <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date EDATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEDate() <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDate()
	 * @generated
	 * @ordered
	 */
	protected Date eDate = EDATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEDouble() <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDouble()
	 * @generated
	 * @ordered
	 */
	protected static final double EDOUBLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getEDouble() <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDouble()
	 * @generated
	 * @ordered
	 */
	protected double eDouble = EDOUBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEFloat() <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFloat()
	 * @generated
	 * @ordered
	 */
	protected static final float EFLOAT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getEFloat() <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFloat()
	 * @generated
	 * @ordered
	 */
	protected float eFloat = EFLOAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEInt() <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEInt()
	 * @generated
	 * @ordered
	 */
	protected static final int EINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEInt() <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEInt()
	 * @generated
	 * @ordered
	 */
	protected int eInt = EINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getELong() <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getELong()
	 * @generated
	 * @ordered
	 */
	protected static final long ELONG_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getELong() <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getELong()
	 * @generated
	 * @ordered
	 */
	protected long eLong = ELONG_EDEFAULT;

	/**
	 * The default value of the '{@link #getEShort() <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEShort()
	 * @generated
	 * @ordered
	 */
	protected static final short ESHORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEShort() <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEShort()
	 * @generated
	 * @ordered
	 */
	protected short eShort = ESHORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEString() <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEString()
	 * @generated
	 * @ordered
	 */
	protected static final String ESTRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEString() <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEString()
	 * @generated
	 * @ordered
	 */
	protected String eString = ESTRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUris() <em>Uris</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUris()
	 * @generated
	 * @ordered
	 */
	protected EList<URI> uris;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETypesImpl()
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
		return ModelPackage.Literals.ETYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getEBigDecimal()
	{
		return eBigDecimal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEBigDecimal(BigDecimal newEBigDecimal)
	{
		BigDecimal oldEBigDecimal = eBigDecimal;
		eBigDecimal = newEBigDecimal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBIG_DECIMAL, oldEBigDecimal, eBigDecimal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getEBigInteger()
	{
		return eBigInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEBigInteger(BigInteger newEBigInteger)
	{
		BigInteger oldEBigInteger = eBigInteger;
		eBigInteger = newEBigInteger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBIG_INTEGER, oldEBigInteger, eBigInteger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEBoolean()
	{
		return eBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEBoolean(boolean newEBoolean)
	{
		boolean oldEBoolean = eBoolean;
		eBoolean = newEBoolean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBOOLEAN, oldEBoolean, eBoolean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte getEByte()
	{
		return eByte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEByte(byte newEByte)
	{
		byte oldEByte = eByte;
		eByte = newEByte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBYTE, oldEByte, eByte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getEByteArray()
	{
		return eByteArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEByteArray(byte[] newEByteArray)
	{
		byte[] oldEByteArray = eByteArray;
		eByteArray = newEByteArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBYTE_ARRAY, oldEByteArray, eByteArray));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getEChar()
	{
		return eChar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEChar(char newEChar)
	{
		char oldEChar = eChar;
		eChar = newEChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ECHAR, oldEChar, eChar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEDate()
	{
		return eDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEDate(Date newEDate)
	{
		Date oldEDate = eDate;
		eDate = newEDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EDATE, oldEDate, eDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEDouble()
	{
		return eDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEDouble(double newEDouble)
	{
		double oldEDouble = eDouble;
		eDouble = newEDouble;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EDOUBLE, oldEDouble, eDouble));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEFloat()
	{
		return eFloat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEFloat(float newEFloat)
	{
		float oldEFloat = eFloat;
		eFloat = newEFloat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EFLOAT, oldEFloat, eFloat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEInt()
	{
		return eInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEInt(int newEInt)
	{
		int oldEInt = eInt;
		eInt = newEInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EINT, oldEInt, eInt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getELong()
	{
		return eLong;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setELong(long newELong)
	{
		long oldELong = eLong;
		eLong = newELong;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ELONG, oldELong, eLong));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getEShort()
	{
		return eShort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEShort(short newEShort)
	{
		short oldEShort = eShort;
		eShort = newEShort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ESHORT, oldEShort, eShort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEString()
	{
		return eString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEString(String newEString)
	{
		String oldEString = eString;
		eString = newEString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ESTRING, oldEString, eString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URI> getUris()
	{
		if (uris == null)
		{
			uris = new EDataTypeUniqueEList<URI>(URI.class, this, ModelPackage.ETYPES__URIS);
		}
		return uris;
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
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				return getEBigDecimal();
			case ModelPackage.ETYPES__EBIG_INTEGER:
				return getEBigInteger();
			case ModelPackage.ETYPES__EBOOLEAN:
				return isEBoolean();
			case ModelPackage.ETYPES__EBYTE:
				return getEByte();
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				return getEByteArray();
			case ModelPackage.ETYPES__ECHAR:
				return getEChar();
			case ModelPackage.ETYPES__EDATE:
				return getEDate();
			case ModelPackage.ETYPES__EDOUBLE:
				return getEDouble();
			case ModelPackage.ETYPES__EFLOAT:
				return getEFloat();
			case ModelPackage.ETYPES__EINT:
				return getEInt();
			case ModelPackage.ETYPES__ELONG:
				return getELong();
			case ModelPackage.ETYPES__ESHORT:
				return getEShort();
			case ModelPackage.ETYPES__ESTRING:
				return getEString();
			case ModelPackage.ETYPES__URIS:
				return getUris();
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
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				setEBigDecimal((BigDecimal)newValue);
				return;
			case ModelPackage.ETYPES__EBIG_INTEGER:
				setEBigInteger((BigInteger)newValue);
				return;
			case ModelPackage.ETYPES__EBOOLEAN:
				setEBoolean((Boolean)newValue);
				return;
			case ModelPackage.ETYPES__EBYTE:
				setEByte((Byte)newValue);
				return;
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				setEByteArray((byte[])newValue);
				return;
			case ModelPackage.ETYPES__ECHAR:
				setEChar((Character)newValue);
				return;
			case ModelPackage.ETYPES__EDATE:
				setEDate((Date)newValue);
				return;
			case ModelPackage.ETYPES__EDOUBLE:
				setEDouble((Double)newValue);
				return;
			case ModelPackage.ETYPES__EFLOAT:
				setEFloat((Float)newValue);
				return;
			case ModelPackage.ETYPES__EINT:
				setEInt((Integer)newValue);
				return;
			case ModelPackage.ETYPES__ELONG:
				setELong((Long)newValue);
				return;
			case ModelPackage.ETYPES__ESHORT:
				setEShort((Short)newValue);
				return;
			case ModelPackage.ETYPES__ESTRING:
				setEString((String)newValue);
				return;
			case ModelPackage.ETYPES__URIS:
				getUris().clear();
				getUris().addAll((Collection<? extends URI>)newValue);
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
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				setEBigDecimal(EBIG_DECIMAL_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EBIG_INTEGER:
				setEBigInteger(EBIG_INTEGER_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EBOOLEAN:
				setEBoolean(EBOOLEAN_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EBYTE:
				setEByte(EBYTE_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				setEByteArray(EBYTE_ARRAY_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ECHAR:
				setEChar(ECHAR_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EDATE:
				setEDate(EDATE_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EDOUBLE:
				setEDouble(EDOUBLE_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EFLOAT:
				setEFloat(EFLOAT_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EINT:
				setEInt(EINT_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ELONG:
				setELong(ELONG_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ESHORT:
				setEShort(ESHORT_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ESTRING:
				setEString(ESTRING_EDEFAULT);
				return;
			case ModelPackage.ETYPES__URIS:
				getUris().clear();
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
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				return EBIG_DECIMAL_EDEFAULT == null ? eBigDecimal != null : !EBIG_DECIMAL_EDEFAULT.equals(eBigDecimal);
			case ModelPackage.ETYPES__EBIG_INTEGER:
				return EBIG_INTEGER_EDEFAULT == null ? eBigInteger != null : !EBIG_INTEGER_EDEFAULT.equals(eBigInteger);
			case ModelPackage.ETYPES__EBOOLEAN:
				return eBoolean != EBOOLEAN_EDEFAULT;
			case ModelPackage.ETYPES__EBYTE:
				return eByte != EBYTE_EDEFAULT;
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				return EBYTE_ARRAY_EDEFAULT == null ? eByteArray != null : !EBYTE_ARRAY_EDEFAULT.equals(eByteArray);
			case ModelPackage.ETYPES__ECHAR:
				return eChar != ECHAR_EDEFAULT;
			case ModelPackage.ETYPES__EDATE:
				return EDATE_EDEFAULT == null ? eDate != null : !EDATE_EDEFAULT.equals(eDate);
			case ModelPackage.ETYPES__EDOUBLE:
				return eDouble != EDOUBLE_EDEFAULT;
			case ModelPackage.ETYPES__EFLOAT:
				return eFloat != EFLOAT_EDEFAULT;
			case ModelPackage.ETYPES__EINT:
				return eInt != EINT_EDEFAULT;
			case ModelPackage.ETYPES__ELONG:
				return eLong != ELONG_EDEFAULT;
			case ModelPackage.ETYPES__ESHORT:
				return eShort != ESHORT_EDEFAULT;
			case ModelPackage.ETYPES__ESTRING:
				return ESTRING_EDEFAULT == null ? eString != null : !ESTRING_EDEFAULT.equals(eString);
			case ModelPackage.ETYPES__URIS:
				return uris != null && !uris.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString()
	{
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (eBigDecimal: ");
		result.append(eBigDecimal);
		result.append(", eBigInteger: ");
		result.append(eBigInteger);
		result.append(", eBoolean: ");
		result.append(eBoolean);
		result.append(", eByte: ");
		result.append(eByte);
		result.append(", eByteArray: ");

		for (byte data : eByteArray)
			result.append(data);

		result.append(", eChar: ");
		result.append(eChar);
		result.append(", eDate: ");
		result.append(eDate);
		result.append(", eDouble: ");
		result.append(eDouble);
		result.append(", eFloat: ");
		result.append(eFloat);
		result.append(", eInt: ");
		result.append(eInt);
		result.append(", eLong: ");
		result.append(eLong);
		result.append(", eShort: ");
		result.append(eShort);
		result.append(", eString: ");
		result.append(eString);
		result.append(')');
		return result.toString();
	}

} // ETypesImpl
