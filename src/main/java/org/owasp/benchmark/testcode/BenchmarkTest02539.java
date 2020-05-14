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

@WebServlet(value="/sqli-05/BenchmarkTest02539")
public class BenchmarkTest02539 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String[] values = request.getParameterValues("BenchmarkTest02539");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = doSomething(request, param);
		
		String sql = "SELECT  * from USERS where USERNAME='foo' and PASSWORD='"+ bar + "'";
		try {
	        org.springframework.jdbc.support.rowset.SqlRowSet results 
	        	= org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForRowSet(sql);
	        response.getWriter().println(
				"Your results are: "
			);

	//		System.out.println("Your results are");
			while (results.next()) {
				response.getWriter().println(
					org.owasp.esapi.ESAPI.encoder().encodeForHTML(results.getString("USERNAME")) + " "
				);
	//			System.out.println(results.getString("USERNAME"));
			}
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
		String a9290 = param; //assign
		StringBuilder b9290 = new StringBuilder(a9290);  // stick in stringbuilder
		b9290.append(" SafeStuff"); // append some safe content
		b9290.replace(b9290.length()-"Chars".length(),b9290.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9290 = new java.util.HashMap<String,Object>();
		map9290.put("key9290", b9290.toString()); // put in a collection
		String c9290 = (String)map9290.get("key9290"); // get it back out
		String d9290 = c9290.substring(0,c9290.length()-1); // extract most of it
		String e9290 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d9290.getBytes() ) )); // B64 encode and decode it
		String f9290 = e9290.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g9290 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9290); // reflection
	
		return bar;	
	}
}
