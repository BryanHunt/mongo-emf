package org.eclipselabs.emf.query.util;


import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.emf.query.BinaryOperation;
import org.eclipselabs.emf.query.Expression;
import org.eclipselabs.emf.query.FeatureAccessor;
import org.eclipselabs.emf.query.Literal;
import org.eclipselabs.emf.query.QueryFactory;

public class ExpressionBuilder
{
  public static void main(String[] args)
  {
    Expression expression;
    expression = new ExpressionBuilder("name=='Stephen%20King'").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("w + x + y + z").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("w + (x + y) + z").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("w + x + (y + z)").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("(x==y || (z == '10')) || y == z").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("x==y || ((z == '10') || y == z").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("x==y || (z == '10')").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("x==y || (z == '10') || y == z").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("x==y").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("x == y").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("x == 'foo'").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("a.b").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("(a.b)").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("'foo'").parseExpression();
    System.out.println("##" + toString(expression));
  }
  
  protected BasicDiagnostic diagnostic = new BasicDiagnostic();
  protected String text;
  protected int index;
  
  public ExpressionBuilder(String text)
  {
    this.text = text;
  }

  protected int peek()
  {
    return Character.codePointAt(text, index);
  }

  protected void next()
  {
    index = Character.offsetByCodePoints(text, index, 1);
  }
  
  protected boolean hasNext()
  {
    return index < text.length();
  }
  
  protected void accept(int match)
  {
    if (!hasNext())
    {
      // Expecting match
    }
    else
    {
      if (peek() == match)
      {
        next();
      }
      else
      {
        // Expecting match
      }
    }
  }

  protected void skipWhitespace()
  {
    while (hasNext())
    {
      int codePoint = peek();
      if (Character.isWhitespace(codePoint))
      {
        next();
      }
      else
      {
        break;
      }
    }
  }
  
  public Expression parseExpression()
  {
    Expression result = null;
    skipWhitespace();
    if (!hasNext())
    {
      // Expecting an expression.
    }
    else
    {
      result = parseTerm();
      while (hasNext() && peek() != ')')
      {
        BinaryOperation binaryOperation = QueryFactory.eINSTANCE.createBinaryOperation();
        binaryOperation.setLeftOperand(result);
        int start = index;
        int end = -1;
        for (; hasNext(); next())
        {
          if (Character.isJavaIdentifierStart(peek()) || Character.isWhitespace(peek()) || peek() == '\'')
          {
            end = index;
            break;
          }
        }
        binaryOperation.setOperator(end == -1 ? text.substring(start) : text.substring(start, end));
        binaryOperation.setRightOperand(parseTerm());
        result = binaryOperation;
      }
      /*
      int codePoint = Character.codePointAt(text, index);
      if (codePoint == '(')
      {
        index = Character.offsetByCodePoints(text, index, 1);
        result = parseExpression();
        skipWhitespace();
        accept(')');
        skipWhitespace();
        if (hasNext() && peek() != ')')
        {
          BinaryOperation binaryOperation = QueryFactory.eINSTANCE.createBinaryOperation();
          binaryOperation.setLeftOperand(result);
          int start = index;
          int end = -1;
          for (next(); hasNext(); next())
          {
            if (Character.isJavaIdentifierStart(peek()) || Character.isWhitespace(peek()))
            {
              end = index;
              break;
            }
          }
          binaryOperation.setOperator(end == -1 ? text.substring(start) : text.substring(start, end));
          binaryOperation.setRightOperand(parseExpression());
          result = binaryOperation;
        }
      }
      else if (codePoint == '\'')
      {
        int start = index;
        int end = -1;
        for (next(); hasNext(); next())
        {
          if (peek() == '\'')
          {
            end = index;
            next();
            break;
          }
        }
        if (end == -1)
        {
          // Expecting '
        }
        else
        {
          Literal literal = QueryFactory.eINSTANCE.createLiteral();
          literal.setLiteralValue(text.substring(start + 1, end));
          result = literal;
        }
      }
      else if (Character.isJavaIdentifierStart(codePoint))
      {
        int start = index;
        int end = -1;
        for (next(); hasNext(); next())
        {
          if (!Character.isJavaIdentifierPart(peek()))
          {
            end = index;
            break;
          }
        }
        FeatureAccessor featureAccessor = QueryFactory.eINSTANCE.createFeatureAccessor();
        featureAccessor.setFeatureName(end == -1 ? text.substring(start) : text.substring(start, end));
        for (skipWhitespace(); hasNext() && peek() == '.'; skipWhitespace())
        {
          next();
          if (!Character.isJavaIdentifierStart(peek()))
          {
            // Expecting an identifier;
          }
          start = index;
          end = -1;
          for (next(); hasNext(); next())
          {
            if (!Character.isJavaIdentifierPart(peek()))
            {
              end = index;
              break;
            }
          }
          FeatureAccessor baseFeatureAccessor = featureAccessor;
          featureAccessor = QueryFactory.eINSTANCE.createFeatureAccessor();
          featureAccessor.setFeatureName(end == -1 ? text.substring(start) : text.substring(start, end));
          featureAccessor.setFeatureAccessor(baseFeatureAccessor);
        }
        result = featureAccessor;
        skipWhitespace();
        if (hasNext() && peek() != ')')
        {
          BinaryOperation binaryOperation = QueryFactory.eINSTANCE.createBinaryOperation();
          binaryOperation.setLeftOperand(featureAccessor);
          start = index;
          end = -1;
          for (next(); hasNext(); next())
          {
            if (Character.isJavaIdentifierStart(peek()) || Character.isWhitespace(peek()))
            {
              end = index;
              break;
            }
          }
          binaryOperation.setOperator(end == -1 ? text.substring(start) : text.substring(start, end));
          binaryOperation.setRightOperand(parseExpression());
          result = binaryOperation;
        }
      }
      skipWhitespace();
      if (hasNext())
      {
        // End expected.
      }
      */
    }
    return result;
  }

  public Expression parseTerm()
  {
    Expression result = null;
    skipWhitespace();
    if (!hasNext())
    {
      // Expecting an expression.
    }
    else
    {
      int codePoint = Character.codePointAt(text, index);
      if (codePoint == '(')
      {
        index = Character.offsetByCodePoints(text, index, 1);
        result = parseExpression();
        skipWhitespace();
        accept(')');
      }
      else if (codePoint == '\'')
      {
        int start = index;
        int end = -1;
        for (next(); hasNext(); next())
        {
          if (peek() == '\'')
          {
            end = index;
            next();
            break;
          }
        }
        if (end == -1)
        {
          // Expecting '
        }
        else
        {
          Literal literal = QueryFactory.eINSTANCE.createLiteral();
          literal.setLiteralValue(text.substring(start + 1, end));
          result = literal;
        }
      }
      else if (Character.isJavaIdentifierStart(codePoint))
      {
        int start = index;
        int end = -1;
        for (next(); hasNext(); next())
        {
          if (!Character.isJavaIdentifierPart(peek()))
          {
            end = index;
            break;
          }
        }
        FeatureAccessor featureAccessor = QueryFactory.eINSTANCE.createFeatureAccessor();
        featureAccessor.setFeatureName(end == -1 ? text.substring(start) : text.substring(start, end));
        for (skipWhitespace(); hasNext() && peek() == '.'; skipWhitespace())
        {
          next();
          if (!Character.isJavaIdentifierStart(peek()))
          {
            // Expecting an identifier;
          }
          start = index;
          end = -1;
          for (next(); hasNext(); next())
          {
            if (!Character.isJavaIdentifierPart(peek()))
            {
              end = index;
              break;
            }
          }
          FeatureAccessor baseFeatureAccessor = featureAccessor;
          featureAccessor = QueryFactory.eINSTANCE.createFeatureAccessor();
          featureAccessor.setFeatureName(end == -1 ? text.substring(start) : text.substring(start, end));
          featureAccessor.setFeatureAccessor(baseFeatureAccessor);
        }
        result = featureAccessor;
      }
      skipWhitespace();
      if (hasNext())
      {
        // End expected.
      }
    }
    return result;
  }

  public Diagnostic getDiagnostic()
  {
    return diagnostic;
  }

  protected BasicDiagnostic createDiagnostic
  (int severity, String source, int code, String messageKey, Object[] messageSubstitutions, Object[] data)
  {
    String message = getString(messageKey, messageSubstitutions);
    return new BasicDiagnostic(severity, source, code, message, data);
  }
  
  protected String getString(String key, Object [] substitutions)
  {
    ResourceLocator resourceLocator = getResourceLocator();
    return substitutions == null ? resourceLocator.getString(key) : resourceLocator.getString(key, substitutions);
  }
  
  protected ResourceLocator getResourceLocator()
  {
    return EcorePlugin.INSTANCE;
  }

  private final static QuerySwitch<String> PRINTER =
    new QuerySwitch<String>()     
    {
      @Override
      public String caseFeatureAccessor(FeatureAccessor object)
      {
        FeatureAccessor featureAccessor = object.getFeatureAccessor();
        return (featureAccessor != null ? PRINTER.caseFeatureAccessor(featureAccessor) + '.' : "" ) + object.getFeatureName();
      }

      @Override
      public String caseLiteral(Literal object)
      {
        return "'" + object.getLiteralValue() + "'";
      }

      @Override
      public String caseBinaryOperation(BinaryOperation object)
      {
        Expression leftOperand = object.getLeftOperand();
        Expression rightOperand = object.getRightOperand();
        boolean needsParentheses = rightOperand instanceof BinaryOperation;
        return 
          (leftOperand == null ? "null"  : PRINTER.doSwitch(leftOperand)) + " " +
             object.getOperator() + " " +
             (needsParentheses ? "(" : "") +  (rightOperand == null ? "null"  : PRINTER.doSwitch(rightOperand)) + (needsParentheses ? ")" : "");
      }
    };
    
  public static String toString(Expression expression)
  {
    return PRINTER.doSwitch(expression);
  }
}
