/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt & Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt & Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.internal.emf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Internal;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipselabs.emf.query.BinaryOperation;
import org.eclipselabs.emf.query.Expression;
import org.eclipselabs.emf.query.Literal;
import org.eclipselabs.emf.query.QueryFactory;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.emf.query.util.ExpressionBuilder;
import org.eclipselabs.emf.query.util.QuerySwitch;
import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.emf.MongoDBURIHandlerImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author bhunt
 * 
 */
public class MongoDBInputStream extends InputStream implements URIConverter.Loadable
{
	private IMongoDB mongoDB;
	private URI uri;
	private Map<?, ?> options;
	private Map<Object, Object> response;

	public MongoDBInputStream(IMongoDB mongoDB, URI uri, Map<?, ?> options, Map<Object, Object> response)
	{
		this.mongoDB = mongoDB;
		this.uri = uri;
		this.options = options;
		this.response = response;
	}

	@Override
	public void loadResource(Resource resource) throws IOException
	{
		// We need to set up the XMLResource.URIHandler so that proxy URIs are handled properly.

		XMLResource.URIHandler uriHandler = (XMLResource.URIHandler) options.get(XMLResource.OPTION_URI_HANDLER);

		if (uriHandler == null)
			uriHandler = new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl();

		if (resource.getURI().hasQuery())
			uriHandler.setBaseURI(resource.getURI().trimSegments(1).appendSegment("-1"));
		else
			uriHandler.setBaseURI(resource.getURI());

		// If the URI contains a query string, use it to locate a collection of objects from
		// MongoDB, otherwise simply get the object from MongoDB using the id.

		String query = uri.query();
		DBCollection collection = MongoDBURIHandlerImpl.getCollection(mongoDB, uri);

		if (query != null)
		{
			System.err.println(URI.decode(query)); // TODO : remove debugging printout
			Result result = QueryFactory.eINSTANCE.createResult();
			EList<EObject> values = result.getValues();

			for (DBObject dbObject : collection.find(buildDBObjectQuery(collection, new ExpressionBuilder(URI.decode(query)).parseExpression())))
				values.add(buildEObject(collection, dbObject, resource, uriHandler, true));

			resource.getContents().add(result);
		}
		else
		{
			DBObject dbObject = collection.findOne(new BasicDBObject(MongoDBURIHandlerImpl.ID_KEY, MongoDBURIHandlerImpl.getID(uri)));

			if (dbObject != null)
			{
				EObject eObject = buildEObject(collection, dbObject, resource, uriHandler);

				if (eObject != null)
					resource.getContents().add(eObject);

				response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, dbObject.get(MongoDBURIHandlerImpl.TIME_STAMP_KEY));
			}
		}
	}

	@Override
	public int read() throws IOException
	{
		return 0;
	}

	private EObject buildEObject(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler)
	{
		return buildEObject(collection, dbObject, resource, uriHandler, false);
	}

	private EObject buildEObject(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler, boolean isProxy)
	{
		ResourceSet resourceSet = resource.getResourceSet();

		// Build an EMF object from the MongodDB object

		EObject eObject = createEObject(dbObject, resource.getResourceSet());

		if (eObject != null)
		{
			if (isProxy)
			{
				URI proxyURI = URI.createURI("../" + collection.getName() + "/" + dbObject.get(MongoDBURIHandlerImpl.ID_KEY) + "#/0");
				((InternalEObject) eObject).eSetProxyURI(uriHandler.resolve(proxyURI));
			}

			// Load the XML extrinsic id if necessary

			String id = (String) dbObject.get(MongoDBURIHandlerImpl.EXTRINSIC_ID_KEY);

			if (id != null && resource instanceof XMLResource)
				((XMLResource) resource).setID(eObject, id);

			// All features are mapped as key / value pairs with the key being the attribute name.

			for (EStructuralFeature feature : eObject.eClass().getEAllStructuralFeatures())
			{
				if (feature instanceof EAttribute)
				{
					EAttribute attribute = (EAttribute) feature;

					if (!isProxy || !FeatureMapUtil.isFeatureMap(attribute))
						buildEObjectAttribute(collection, dbObject, resource, uriHandler, resourceSet, eObject, attribute);
				}
				else if (!isProxy)
					buildEObjectReference(collection, dbObject, resource, uriHandler, eObject, (EReference) feature);
			}
		}
		return eObject;
	}

	/**
	 * @param collection
	 * @param dbObject
	 * @param resource
	 * @param uriHandler
	 * @param resourceSet
	 * @param eObject
	 * @param attribute
	 */
	@SuppressWarnings("unchecked")
	private void buildEObjectAttribute(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler, ResourceSet resourceSet, EObject eObject, EAttribute attribute)
	{
		if (!attribute.isTransient() && !(attribute.isID() && attribute.isDerived()) && dbObject.containsField(attribute.getName()))
		{
			Object value = dbObject.get(attribute.getName());

			if (FeatureMapUtil.isFeatureMap(attribute))
			{
				FeatureMap.Internal featureMap = (Internal) eObject.eGet(attribute);

				for (DBObject entry : (ArrayList<DBObject>) value)
				{
					EStructuralFeature feature = (EStructuralFeature) resourceSet.getEObject(URI.createURI((String) entry.get("key")), true);

					if (feature instanceof EAttribute)
						featureMap.add(feature, getEObjectAttributeValue((EAttribute) feature, entry.get("value")));
					else
					{
						EReference reference = (EReference) feature;
						EObject target = buildEObjectReference(collection, entry.get("value"), resource, uriHandler, reference.isResolveProxies());

						if (target != null)
							featureMap.add(feature, target);
					}
				}
			}
			else if (attribute.isMany() && !MongoDBURIHandlerImpl.isNativeType(attribute.getEAttributeType()))
			{
				ArrayList<Object> values = new ArrayList<Object>();
				ArrayList<String> rawValues = (ArrayList<String>) value;

				for (String rawValue : rawValues)
					values.add(EcoreUtil.createFromString(attribute.getEAttributeType(), rawValue));

				eObject.eSet(attribute, values);
			}
			else
				eObject.eSet(attribute, getEObjectAttributeValue(attribute, value));
		}
	}

	/**
	 * @param collection
	 * @param dbObject
	 * @param resource
	 * @param uriHandler
	 * @param eObject
	 * @param reference
	 */
	private void buildEObjectReference(DBCollection collection, DBObject dbObject, Resource resource, XMLResource.URIHandler uriHandler, EObject eObject, EReference reference)
	{
		if (reference.isTransient())
			return;

		String field = reference.getName();

		if (dbObject.containsField(field))
		{
			if (reference.isMany())
			{
				@SuppressWarnings("unchecked")
				List<Object> dbReferences = (List<Object>) dbObject.get(field);

				@SuppressWarnings("unchecked")
				EList<EObject> eObjects = (EList<EObject>) eObject.eGet(reference);

				for (Object dbReference : dbReferences)
				{
					EObject target = buildEObjectReference(collection, dbReference, resource, uriHandler, reference.isResolveProxies());
					eObjects.add(target);
				}
			}
			else
			{
				EObject target = buildEObjectReference(collection, dbObject.get(field), resource, uriHandler, reference.isResolveProxies());
				eObject.eSet(reference, target);
			}
		}
	}

	private EObject buildEObjectReference(DBCollection collection, Object dbReference, Resource resource, XMLResource.URIHandler uriHandler, boolean referenceResolvesProxies)
	{
		if (dbReference == null)
			return null;

		// Build an EMF reference from the data in MongoDB.

		DBObject dbObject = (DBObject) dbReference;
		String proxy = (String) dbObject.get(MongoDBURIHandlerImpl.PROXY_KEY);

		if (proxy == null)
			return buildEObject(collection, dbObject, resource, uriHandler);
		else
			return buildProxy(dbObject, resource.getResourceSet(), uriHandler, referenceResolvesProxies);
	}

	private EObject buildProxy(DBObject dbObject, ResourceSet resourceSet, XMLResource.URIHandler uriHandler, boolean referenceResolvedProxies)
	{
		EObject eObject = null;
		URI proxyURI = uriHandler.resolve(URI.createURI((String) dbObject.get(MongoDBURIHandlerImpl.PROXY_KEY)));

		if (!referenceResolvedProxies)
			eObject = resourceSet.getEObject(proxyURI, true);
		else
		{
			eObject = createEObject(dbObject, resourceSet);

			if (eObject != null)
				((InternalEObject) eObject).eSetProxyURI(proxyURI);
		}

		return eObject;
	}

	private EObject createEObject(DBObject dbObject, ResourceSet resourceSet)
	{
		if (dbObject == null)
			return null;

		EClass eClass = (EClass) resourceSet.getEObject(URI.createURI((String) dbObject.get(MongoDBURIHandlerImpl.ECLASS_KEY)), true);
		return EcoreUtil.create(eClass);
	}

	/**
	 * @param attribute
	 * @param value
	 * @return
	 */
	private Object getEObjectAttributeValue(EAttribute attribute, Object value)
	{
		if (!MongoDBURIHandlerImpl.isNativeType(attribute.getEAttributeType()))
			value = EcoreUtil.createFromString(attribute.getEAttributeType(), (String) value);
		else if (EcorePackage.Literals.EBYTE.equals(attribute.getEAttributeType()) || EcorePackage.Literals.EBYTE_OBJECT.equals(attribute.getEAttributeType()))
			value = ((Integer) value).byteValue();
		else if (EcorePackage.Literals.EFLOAT.equals(attribute.getEAttributeType()) || EcorePackage.Literals.EFLOAT_OBJECT.equals(attribute.getEAttributeType()))
			value = ((Double) value).floatValue();

		return value;
	}

	private DBObject buildDBObjectQuery(final DBCollection dbCollection, Expression expression)
	{
		// This function builds a DBObject to be used as a query to MongoDB from the EMF Expression

		final DBObject dbObject = new BasicDBObject();

		if (expression != null)
		{
			new QuerySwitch<Object>()
			{
				@Override
				public Object caseBinaryOperation(BinaryOperation binaryOperation)
				{
					Expression leftOperand = binaryOperation.getLeftOperand();
					String operator = binaryOperation.getOperator();

					if ("==".equals(operator))
					{
						Expression rightOperand = binaryOperation.getRightOperand();
						String property = ExpressionBuilder.toString(leftOperand);

						if (MongoDBURIHandlerImpl.ID_KEY.equals(property))
						{
							dbObject.put(property, new ObjectId(((Literal) rightOperand).getLiteralValue()));
						}
						else if (rightOperand instanceof Literal)
						{
							dbObject.put(property, ((Literal) rightOperand).getLiteralValue());
						}
						else if ("null".equals(ExpressionBuilder.toString(rightOperand)))
						{
							DBObject notExists = new BasicDBObject();
							notExists.put("$exists", Boolean.FALSE);
							dbObject.put(property, notExists);
						}
						else
						{
							// TODO: What to do?
						}
					}
					else if ("!=".equals(operator))
					{
						Expression rightOperand = binaryOperation.getRightOperand();
						String property = ExpressionBuilder.toString(leftOperand);
						if (rightOperand instanceof Literal)
						{
							DBObject notEqual = new BasicDBObject();
							notEqual.put("$ne", ((Literal) rightOperand).getLiteralValue());
							dbObject.put(property, notEqual);
						}
						else if ("null".equals(ExpressionBuilder.toString(rightOperand)))
						{
							DBObject exists = new BasicDBObject();
							exists.put("$exists", Boolean.TRUE);
							dbObject.put(property, exists);
						}
						else
						{
							// TODO: What to do?
						}
					}
					else if ("||".equals(operator))
					{
						DBObject leftObject = buildDBObjectQuery(dbCollection, leftOperand);
						DBObject rightObject = buildDBObjectQuery(dbCollection, binaryOperation.getRightOperand());
						@SuppressWarnings("unchecked")
						List<Object> or = (List<Object>) leftObject.get("$or");
						if (or != null)
						{
							or.add(rightObject);
							dbObject.putAll(leftObject);
						}
						else
						{
							or = new ArrayList<Object>();
							or.add(leftObject);
							or.add(rightObject);
							dbObject.put("$or", or);
						}
					}
					else if ("&&".equals(operator))
					{
						dbObject.putAll(buildDBObjectQuery(dbCollection, leftOperand));
						DBObject rightObject = buildDBObjectQuery(dbCollection, binaryOperation.getRightOperand());
						for (String field : rightObject.keySet())
						{
							Object rightValue = rightObject.get(field);
							Object leftValue = dbObject.get(field);
							if (leftValue instanceof DBObject)
							{
								DBObject leftDBObject = (DBObject) leftValue;
								if (rightValue instanceof DBObject)
								{
									DBObject rightDBObject = (DBObject) rightValue;
									if (leftDBObject.containsField("$nin") && rightDBObject.containsField("$ne"))
									{
										@SuppressWarnings("unchecked")
										List<Object> values = (List<Object>) leftDBObject.get("$nin");
										values.add(rightDBObject.get("$ne"));
									}
									else if (leftDBObject.containsField("$ne") && rightDBObject.containsField("$ne"))
									{
										DBObject nin = new BasicDBObject();
										List<Object> values = new ArrayList<Object>();
										values.add(leftDBObject.get("$ne"));
										values.add(rightDBObject.get("$ne"));
										nin.put("$nin", values);
										dbObject.put(field, nin);
									}
									else
									{
										leftDBObject.putAll(rightDBObject);
									}
								}
								else
								{
									Object all = leftDBObject.get("$all");
									if (all instanceof List<?>)
									{
										@SuppressWarnings("unchecked")
										List<Object> allList = (List<Object>) all;
										allList.add(rightValue);
									}
									else
									{
										// What to do?
									}
								}
							}
							else if (leftValue instanceof List<?>)
							{
								@SuppressWarnings("unchecked")
								List<Object> leftListValue = (List<Object>) leftValue;
								if (rightValue instanceof List<?>)
								{
									leftListValue.addAll((List<?>) rightValue);
								}
								else
								{
									leftListValue.add(rightValue);
								}
							}
							else if (leftValue != null)
							{
								if (rightValue instanceof List<?>)
								{
									@SuppressWarnings("unchecked")
									List<Object> rightListValue = (List<Object>) rightValue;
									rightListValue.add(0, leftValue);
									dbObject.put(field, rightListValue);
								}
								else
								{
									List<Object> listValue = new ArrayList<Object>();
									listValue.add(leftValue);
									listValue.add(rightValue);
									DBObject in = new BasicDBObject("$all", listValue);
									dbObject.put(field, in);
								}
							}
							else
							{
								dbObject.put(field, rightValue);
							}
						}
					}

					return null;
				}
			}.doSwitch(expression);
		}

		return dbObject;
	}
}
