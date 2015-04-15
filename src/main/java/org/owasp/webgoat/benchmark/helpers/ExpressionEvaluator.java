package org.owasp.webgoat.benchmark.helpers;

import java.util.Map;

import javax.servlet.jsp.el.ELException;
import javax.servlet.jsp.el.Expression;
import javax.servlet.jsp.el.FunctionMapper;
import javax.servlet.jsp.el.VariableResolver;

@SuppressWarnings("deprecation")
public class ExpressionEvaluator extends javax.servlet.jsp.el.ExpressionEvaluator 
{
    public static String evaluateEL(String expression, Map<String, Object> properties)
    {
    	return null;
    }

	@Override
	public Object evaluate(String arg0, Class arg1, VariableResolver arg2, FunctionMapper arg3) throws ELException {
		return null;
	}

	@Override
	public Expression parseExpression(String arg0, Class arg1, FunctionMapper arg2) throws ELException {
		return null;
	}

}
