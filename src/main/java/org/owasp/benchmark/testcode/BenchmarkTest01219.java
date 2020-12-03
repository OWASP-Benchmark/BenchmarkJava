/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/sqli-02/BenchmarkTest01219")
public class BenchmarkTest01219 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest01219");
		
		if (headers != null && headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		// URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = new Test().doSomething(request, param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);
		} catch (java.sql.SQLException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println(
"Error processing request."
);
        		return;
        	}
			else throw new ServletException(e);
		}
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map23263 = new java.util.HashMap<String,Object>();
		map23263.put("keyA-23263", "a_Value"); // put some stuff in the collection
		map23263.put("keyB-23263", param); // put it in a collection
		map23263.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map23263.get("keyB-23263"); // get it back out
		bar = (String)map23263.get("keyA-23263"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
