package org.eclipselabs.emf.query.util;

import java.util.Date;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
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
    // System.err.println("? " + EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.EDATE, new Date()));
    expression = new ExpressionBuilder("condition == true").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("publicationDate > 1999 || publicationDate > 1999L").parseExpression();
    System.out.println("##" + toString(expression));
    expression = new ExpressionBuilder("publicationDate > 2011-05-15").parseExpression();
    System.out.println("##" + toString(expression));
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
        String featureName = end == -1 ? text.substring(start) : text.substring(start, end);
        if ("true".equals(featureName) || "false".equals(featureName))
        {
          Literal literal = QueryFactory.eINSTANCE.createLiteral();
          literal.setLiteralValue(featureName);
          literal.setValue("true".equals(featureName) ? Boolean.TRUE : Boolean.FALSE);
          result = literal;
        }
        else
        {
          FeatureAccessor featureAccessor = QueryFactory.eINSTANCE.createFeatureAccessor();
          featureAccessor.setFeatureName(featureName);
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
            featureName = end == -1 ? text.substring(start) : text.substring(start, end);
            featureAccessor.setFeatureName(featureName);
            featureAccessor.setFeatureAccessor(baseFeatureAccessor);
          }
          result = featureAccessor;
        }
      }
      else if (codePoint >= '0' || codePoint <= '9')
      {
        int start = index;
        int end = index + 1;
        boolean longLiteral = false;
        boolean dateLiteral = false;
        LOOP:
        for (next(); hasNext(); next())
        {
          switch (peek())
          {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            {
              end = index + 1;
              break;
            }
            case 'L':
            {
              longLiteral = true;
              next();
              break LOOP;
            }
            case '-':
            case '+':
            case 'T':
            case ':':
            case '.':
            case 'Z':
            {
              end = index + 1;
              dateLiteral = true;
              break;
            }
            default:
            {
              break LOOP;
            }
          }
        }
        Literal literal = QueryFactory.eINSTANCE.createLiteral();
        literal.setLiteralValue(text.substring(start, end));
        if (dateLiteral)
        {
          literal.setValue(EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.EDATE, literal.getLiteralValue()));
        }
        else if (longLiteral)
        {
          literal.setValue(Long.valueOf(literal.getLiteralValue()));
        }
        else
        {
          literal.setValue(Integer.valueOf(literal.getLiteralValue()));
        }
        result = literal;
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
        Object value = object.getValue();
        String literalValue = object.getLiteralValue();
        return 
          value instanceof Integer  || value instanceof Date  || value instanceof Boolean ?
             literalValue :
             value instanceof Long ?
             literalValue + "L":
             "'" + literalValue + "'";
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
