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

@WebServlet("/BenchmarkTest02539")
public class BenchmarkTest02539 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String[] values = request.getParameterValues("vector");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = doSomething(param);
		
		try {
			String sql = "SELECT  * from USERS where USERNAME='foo' and PASSWORD='"+ bar + "'" ;
	
	        org.springframework.jdbc.support.rowset.SqlRowSet results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForRowSet(sql);
	        java.io.PrintWriter out = response.getWriter();
			out.write("Your results are: ");
	//		System.out.println("Your results are");
			while(results.next()) {
	            out.write(org.owasp.esapi.ESAPI.encoder().encodeForHTML(results.getString("USERNAME")) + " ");
	//			System.out.println(results.getString("USERNAME"));
			}
		} catch (org.springframework.dao.DataAccessException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println("Error processing request.");
        		return;
        	}
			else throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14444 = param; //assign
		StringBuilder b14444 = new StringBuilder(a14444);  // stick in stringbuilder
		b14444.append(" SafeStuff"); // append some safe content
		b14444.replace(b14444.length()-"Chars".length(),b14444.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14444 = new java.util.HashMap<String,Object>();
		map14444.put("key14444", b14444.toString()); // put in a collection
		String c14444 = (String)map14444.get("key14444"); // get it back out
		String d14444 = c14444.substring(0,c14444.length()-1); // extract most of it
		String e14444 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14444.getBytes() ) )); // B64 encode and decode it
		String f14444 = e14444.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g14444 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g14444); // reflection
	
		return bar;	
	}
}
