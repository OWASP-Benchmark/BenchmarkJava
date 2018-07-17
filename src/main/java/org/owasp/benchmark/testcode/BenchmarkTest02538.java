/**
* OWASP Benchmark Project v1.2
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

@WebServlet(value="/sqli-05/BenchmarkTest02538")
public class BenchmarkTest02538 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String[] values = request.getParameterValues("BenchmarkTest02538");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = doSomething(request, param);
		
		String sql = "SELECT TOP 1 USERNAME from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
		try {
	        Object results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForObject(sql,new Object[]{}, String.class);
			response.getWriter().println(
				"Your results are: "
			);

	//		System.out.println("Your results are");
			response.getWriter().println(
				org.owasp.esapi.ESAPI.encoder().encodeForHTML(results.toString())
			);
	//		System.out.println(results.toString());
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

		// Chain a bunch of propagators in sequence
		String a72634 = param; //assign
		StringBuilder b72634 = new StringBuilder(a72634);  // stick in stringbuilder
		b72634.append(" SafeStuff"); // append some safe content
		b72634.replace(b72634.length()-"Chars".length(),b72634.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72634 = new java.util.HashMap<String,Object>();
		map72634.put("key72634", b72634.toString()); // put in a collection
		String c72634 = (String)map72634.get("key72634"); // get it back out
		String d72634 = c72634.substring(0,c72634.length()-1); // extract most of it
		String e72634 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d72634.getBytes() ) )); // B64 encode and decode it
		String f72634 = e72634.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g72634 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72634); // reflection
	
		return bar;	
	}
}
