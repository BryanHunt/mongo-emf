/*******************************************************************************
 * Copyright (c) 2011 Bryan Hunt and Ed Merks.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt and Ed Merks - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf.query.simple;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emf.query.BinaryOperation;
import org.eclipselabs.emf.query.Expression;
import org.eclipselabs.emf.query.Literal;
import org.eclipselabs.emf.query.util.ExpressionBuilder;
import org.eclipselabs.emf.query.util.QuerySwitch;
import org.eclipselabs.mongo.emf.IQueryEngine;
import org.eclipselabs.mongo.emf.MongoQuery;
import org.eclipselabs.mongo.emf.MongoURIHandlerImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

/**
 * @author merks
 * 
 */
public class QueryEngine implements IQueryEngine
{

	@Override
	public MongoQuery buildDBObjectQuery(URI uri)
	{
		return new MongoQuery(buildDBObjectQuery(new ExpressionBuilder(URI.decode(uri.query())).parseExpression()), null);
	}

	private DBObject buildDBObjectQuery(Expression expression)
	{
		final DBObject dbObject = new BasicDBObject();

		if (expression != null)
		{
			new QuerySwitch<Object>()
			{
				Object getValue(Literal literal)
				{
					return literal.getValue() == null ? literal.getLiteralValue() : literal.getValue();
				}

				@Override
				public Object caseBinaryOperation(BinaryOperation binaryOperation)
				{
					Expression leftOperand = binaryOperation.getLeftOperand();
					String operator = binaryOperation.getOperator();

					if ("==".equals(operator))
					{
						Expression rightOperand = binaryOperation.getRightOperand();
						String property = ExpressionBuilder.toString(leftOperand);

						if (MongoURIHandlerImpl.ID_KEY.equals(property))
						{
							dbObject.put(property, new ObjectId(((Literal) rightOperand).getLiteralValue()));
						}
						else if (rightOperand instanceof Literal)
						{
							dbObject.put(property, getValue((Literal) rightOperand));
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
							notEqual.put("$ne", getValue((Literal) rightOperand));
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
					else if ("<".equals(operator) || "<=".equals(operator) || ">".equals(operator) || ">=".equals(operator))
					{
						Expression rightOperand = binaryOperation.getRightOperand();
						String property = ExpressionBuilder.toString(leftOperand);
						if (rightOperand instanceof Literal)
						{
							DBObject compare = new BasicDBObject();
							compare.put("<".equals(operator) ? QueryOperators.LT : "<=".equals(operator) ? QueryOperators.LTE : ">".equals(operator) ? QueryOperators.GT : QueryOperators.GTE,
									getValue((Literal) rightOperand));
							dbObject.put(property, compare);
						}
						else
						{
							// TODO: What to do?
						}
					}
					else if ("||".equals(operator))
					{
						DBObject leftObject = buildDBObjectQuery(leftOperand);
						DBObject rightObject = buildDBObjectQuery(binaryOperation.getRightOperand());
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
						dbObject.putAll(buildDBObjectQuery(leftOperand));
						DBObject rightObject = buildDBObjectQuery(binaryOperation.getRightOperand());
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
