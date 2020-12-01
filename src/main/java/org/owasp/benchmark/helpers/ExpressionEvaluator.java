/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Juan Gama
* @created 2015
*/

package org.owasp.benchmark.helpers;

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
	public Object evaluate(String arg0, @SuppressWarnings("rawtypes") Class arg1, VariableResolver arg2, FunctionMapper arg3) throws ELException {
		return null;
	}

	@Override
	public Expression parseExpression(String arg0, @SuppressWarnings("rawtypes") Class arg1, FunctionMapper arg2) throws ELException {
		return null;
	}

}
