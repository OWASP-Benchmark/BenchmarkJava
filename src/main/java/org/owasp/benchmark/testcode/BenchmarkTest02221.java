/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02221")
public class BenchmarkTest02221 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("vector");
			if (values != null) param = values[0];
		}
		

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		java.io.PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>\n<html>\n<body>\n<p>");
		out.format(java.util.Locale.US,"Formatted like: %1$s and %2$s.",obj);
	    out.write("\n</p>\n</body>\n</html>");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = param;
		if (param != null && param.length() > 1) {
		    StringBuilder sbxyz54556 = new StringBuilder(param);
		    bar = sbxyz54556.replace(param.length()-"Z".length(), param.length(),"Z").toString();
		}
	
		return bar;	
	}
}
