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

@WebServlet("/BenchmarkTest00511")
public class BenchmarkTest00511 extends HttpServlet {
	
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
		
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map34584 = new java.util.HashMap<String,Object>();
		map34584.put("keyA-34584", "a_Value"); // put some stuff in the collection
		map34584.put("keyB-34584", param); // put it in a collection
		map34584.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map34584.get("keyB-34584"); // get it back out
		bar = (String)map34584.get("keyA-34584"); // get safe value back out
		
		
		try {
	        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"
	            + bar + "'";
	
			org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.batchUpdate(sql);
			java.io.PrintWriter out = response.getWriter();
	//		System.out.println("no results for query: " + sql + " because the Spring batchUpdate method doesn't return results.");
			out.write("No results can be displayed for query: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql) + "<br>");
			out.write(" because the Spring batchUpdate method doesn't return results.");
		} catch (org.springframework.dao.DataAccessException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println("Error processing request.");
        		return;
        	}
			else throw new ServletException(e);
		}
	}
}
