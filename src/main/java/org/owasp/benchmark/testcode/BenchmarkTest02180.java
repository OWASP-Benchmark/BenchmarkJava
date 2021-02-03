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
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/sqli-04/BenchmarkTest02180")
public class BenchmarkTest02180 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = request.getParameter("BenchmarkTest02180");
		if (param == null) param = "";

		String bar = doSomething(request, param);
		
		String sql = "SELECT TOP 1 userid from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
		try {
			//Long results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForLong(sql);
			Long results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForObject(sql, Long.class);
			response.getWriter().println(
				"Your results are: "
			);

	//		System.out.println("your results are");
			response.getWriter().println(
				results.toString()
			);
	//		System.out.println(results);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			response.getWriter().println(
				"No results returned for query: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql) 
			);
		} catch (org.springframework.dao.DataAccessException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
			response.getWriter().println(
				"Error processing request."
			);
		}
			else throw new ServletException(e);
		}
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map32515 = new java.util.HashMap<String,Object>();
		map32515.put("keyA-32515", "a_Value"); // put some stuff in the collection
		map32515.put("keyB-32515", param); // put it in a collection
		map32515.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map32515.get("keyB-32515"); // get it back out
		bar = (String)map32515.get("keyA-32515"); // get safe value back out
	
		return bar;	
	}
}
