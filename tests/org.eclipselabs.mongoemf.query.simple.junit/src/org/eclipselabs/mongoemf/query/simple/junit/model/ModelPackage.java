/**
 */
package org.eclipselabs.mongoemf.query.simple.junit.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public class ModelPackage extends EPackageImpl
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipselabs.org/mongo/emf/query/simple/junit";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "org.eclipselabs.mongo.emf.query.simple.junit";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ModelPackage eINSTANCE = org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Person <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Person
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getPerson()
	 * @generated
	 */
	public static final int PERSON = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PERSON__NAME = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PERSON__BOOKS = 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PERSON_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Book <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Book
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getBook()
	 * @generated
	 */
	public static final int BOOK = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOK__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOK__AUTHORS = 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOK__TAGS = 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOK__DATA = 3;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Library <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Library
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getLibrary()
	 * @generated
	 */
	public static final int LIBRARY = 2;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__BOOKS = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Latest Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__LATEST_BOOK = 2;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Location <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Location
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getLocation()
	 * @generated
	 */
	public static final int LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATION__ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>Featured Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATION__FEATURED_BOOK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATION__ID = 2;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary <em>Mapped Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getMappedLibrary()
	 * @generated
	 */
	public static final int MAPPED_LIBRARY = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_LIBRARY__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Rare Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_LIBRARY__RARE_BOOKS = 1;

	/**
	 * The feature id for the '<em><b>Regular Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_LIBRARY__REGULAR_BOOKS = 2;

	/**
	 * The feature id for the '<em><b>Books</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_LIBRARY__BOOKS = 3;

	/**
	 * The number of structural features of the '<em>Mapped Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_LIBRARY_FEATURE_COUNT = 4;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bookEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedLibraryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackage()
	{
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init()
	{
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackage theModelPackage = (ModelPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackage());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Person
	 * @generated
	 */
	public EClass getPerson()
	{
		return personEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	public EAttribute getPerson_Name()
	{
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Person#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Books</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Person#getBooks()
	 * @see #getPerson()
	 * @generated
	 */
	public EReference getPerson_Books()
	{
		return (EReference)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Book
	 * @generated
	 */
	public EClass getBook()
	{
		return bookEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Book#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Book#getTitle()
	 * @see #getBook()
	 * @generated
	 */
	public EAttribute getBook_Title()
	{
		return (EAttribute)bookEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Book#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Authors</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Book#getAuthors()
	 * @see #getBook()
	 * @generated
	 */
	public EReference getBook_Authors()
	{
		return (EReference)bookEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Book#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tags</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Book#getTags()
	 * @see #getBook()
	 * @generated
	 */
	public EAttribute getBook_Tags()
	{
		return (EAttribute)bookEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Book#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Book#getData()
	 * @see #getBook()
	 * @generated
	 */
	public EAttribute getBook_Data()
	{
		return (EAttribute)bookEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Library
	 * @generated
	 */
	public EClass getLibrary()
	{
		return libraryEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Library#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Books</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Library#getBooks()
	 * @see #getLibrary()
	 * @generated
	 */
	public EReference getLibrary_Books()
	{
		return (EReference)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Library#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Library#getLocation()
	 * @see #getLibrary()
	 * @generated
	 */
	public EReference getLibrary_Location()
	{
		return (EReference)libraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Library#getLatestBook <em>Latest Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Latest Book</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Library#getLatestBook()
	 * @see #getLibrary()
	 * @generated
	 */
	public EReference getLibrary_LatestBook()
	{
		return (EReference)libraryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Location
	 * @generated
	 */
	public EClass getLocation()
	{
		return locationEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Location#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Location#getAddress()
	 * @see #getLocation()
	 * @generated
	 */
	public EAttribute getLocation_Address()
	{
		return (EAttribute)locationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Location#getFeaturedBook <em>Featured Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Featured Book</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Location#getFeaturedBook()
	 * @see #getLocation()
	 * @generated
	 */
	public EReference getLocation_FeaturedBook()
	{
		return (EReference)locationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Location#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Location#getId()
	 * @see #getLocation()
	 * @generated
	 */
	public EAttribute getLocation_Id()
	{
		return (EAttribute)locationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary <em>Mapped Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Library</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary
	 * @generated
	 */
	public EClass getMappedLibrary()
	{
		return mappedLibraryEClass;
	}


	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getLocation()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	public EReference getMappedLibrary_Location()
	{
		return (EReference)mappedLibraryEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getRareBooks <em>Rare Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rare Books</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getRareBooks()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	public EReference getMappedLibrary_RareBooks()
	{
		return (EReference)mappedLibraryEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getRegularBooks <em>Regular Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regular Books</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getRegularBooks()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	public EReference getMappedLibrary_RegularBooks()
	{
		return (EReference)mappedLibraryEClass.getEStructuralFeatures().get(2);
	}


	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Books</em>'.
	 * @see org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary#getBooks()
	 * @see #getMappedLibrary()
	 * @generated
	 */
	public EAttribute getMappedLibrary_Books()
	{
		return (EAttribute)mappedLibraryEClass.getEStructuralFeatures().get(3);
	}


	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public ModelFactory getModelFactory()
	{
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__NAME);
		createEReference(personEClass, PERSON__BOOKS);

		bookEClass = createEClass(BOOK);
		createEAttribute(bookEClass, BOOK__TITLE);
		createEReference(bookEClass, BOOK__AUTHORS);
		createEAttribute(bookEClass, BOOK__TAGS);
		createEAttribute(bookEClass, BOOK__DATA);

		libraryEClass = createEClass(LIBRARY);
		createEReference(libraryEClass, LIBRARY__BOOKS);
		createEReference(libraryEClass, LIBRARY__LOCATION);
		createEReference(libraryEClass, LIBRARY__LATEST_BOOK);

		locationEClass = createEClass(LOCATION);
		createEAttribute(locationEClass, LOCATION__ADDRESS);
		createEReference(locationEClass, LOCATION__FEATURED_BOOK);
		createEAttribute(locationEClass, LOCATION__ID);

		mappedLibraryEClass = createEClass(MAPPED_LIBRARY);
		createEReference(mappedLibraryEClass, MAPPED_LIBRARY__LOCATION);
		createEReference(mappedLibraryEClass, MAPPED_LIBRARY__RARE_BOOKS);
		createEReference(mappedLibraryEClass, MAPPED_LIBRARY__REGULAR_BOOKS);
		createEAttribute(mappedLibraryEClass, MAPPED_LIBRARY__BOOKS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_Name(), ecorePackage.getEString(), "name", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Books(), this.getBook(), this.getBook_Authors(), "books", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bookEClass, Book.class, "Book", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBook_Title(), ecorePackage.getEString(), "title", null, 0, 1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBook_Authors(), this.getPerson(), this.getPerson_Books(), "authors", null, 0, -1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBook_Tags(), ecorePackage.getEString(), "tags", null, 0, -1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBook_Data(), ecorePackage.getEChar(), "data", null, 0, -1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibrary_Books(), this.getBook(), null, "books", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Location(), this.getLocation(), null, "location", null, 0, 1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_LatestBook(), this.getBook(), null, "latestBook", null, 0, 1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locationEClass, Location.class, "Location", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocation_Address(), ecorePackage.getEString(), "address", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocation_FeaturedBook(), this.getBook(), null, "featuredBook", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocation_Id(), ecorePackage.getEJavaObject(), "id", null, 0, 1, Location.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(mappedLibraryEClass, MappedLibrary.class, "MappedLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedLibrary_Location(), this.getLocation(), null, "location", null, 0, 1, MappedLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedLibrary_RareBooks(), this.getBook(), null, "rareBooks", null, 0, -1, MappedLibrary.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappedLibrary_RegularBooks(), this.getBook(), null, "regularBooks", null, 0, -1, MappedLibrary.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappedLibrary_Books(), ecorePackage.getEFeatureMapEntry(), "books", null, 0, 1, MappedLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations()
	{
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getMappedLibrary_RareBooks(), 
		   source, 
		   new String[] 
		   {
			 "group", "#books"
		   });		
		addAnnotation
		  (getMappedLibrary_RegularBooks(), 
		   source, 
		   new String[] 
		   {
			 "group", "#books"
		   });		
		addAnnotation
		  (getMappedLibrary_Books(), 
		   source, 
		   new String[] 
		   {
			 "kind", "group"
		   });
	}

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
	public interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Person <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Person
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getPerson()
		 * @generated
		 */
		public static final EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PERSON__BOOKS = eINSTANCE.getPerson_Books();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Book <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Book
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getBook()
		 * @generated
		 */
		public static final EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BOOK__TITLE = eINSTANCE.getBook_Title();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference BOOK__AUTHORS = eINSTANCE.getBook_Authors();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BOOK__TAGS = eINSTANCE.getBook_Tags();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BOOK__DATA = eINSTANCE.getBook_Data();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Library <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Library
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getLibrary()
		 * @generated
		 */
		public static final EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference LIBRARY__BOOKS = eINSTANCE.getLibrary_Books();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference LIBRARY__LOCATION = eINSTANCE.getLibrary_Location();

		/**
		 * The meta object literal for the '<em><b>Latest Book</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference LIBRARY__LATEST_BOOK = eINSTANCE.getLibrary_LatestBook();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.Location <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.Location
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getLocation()
		 * @generated
		 */
		public static final EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOCATION__ADDRESS = eINSTANCE.getLocation_Address();

		/**
		 * The meta object literal for the '<em><b>Featured Book</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference LOCATION__FEATURED_BOOK = eINSTANCE.getLocation_FeaturedBook();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOCATION__ID = eINSTANCE.getLocation_Id();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary <em>Mapped Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.MappedLibrary
		 * @see org.eclipselabs.mongoemf.query.simple.junit.model.ModelPackage#getMappedLibrary()
		 * @generated
		 */
		public static final EClass MAPPED_LIBRARY = eINSTANCE.getMappedLibrary();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MAPPED_LIBRARY__LOCATION = eINSTANCE.getMappedLibrary_Location();

		/**
		 * The meta object literal for the '<em><b>Rare Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MAPPED_LIBRARY__RARE_BOOKS = eINSTANCE.getMappedLibrary_RareBooks();

		/**
		 * The meta object literal for the '<em><b>Regular Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MAPPED_LIBRARY__REGULAR_BOOKS = eINSTANCE.getMappedLibrary_RegularBooks();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute MAPPED_LIBRARY__BOOKS = eINSTANCE.getMappedLibrary_Books();

	}

} //ModelPackage
