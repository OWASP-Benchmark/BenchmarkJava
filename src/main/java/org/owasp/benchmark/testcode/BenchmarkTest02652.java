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

@WebServlet(value="/sqli-06/BenchmarkTest02652")
public class BenchmarkTest02652 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String queryString = request.getQueryString();
		String paramval = "BenchmarkTest02652"+"=";
		int paramLoc = -1;
		if (queryString != null) paramLoc = queryString.indexOf(paramval);
		if (paramLoc == -1) {
			response.getWriter().println("getQueryString() couldn't find expected parameter '" + "BenchmarkTest02652" + "' in query string.");
			return;
		}
		
		String param = queryString.substring(paramLoc + paramval.length()); // 1st assume "BenchmarkTest02652" param is last parameter in query string.
		// And then check to see if its in the middle of the query string and if so, trim off what comes after.
		int ampersandLoc = queryString.indexOf("&", paramLoc);
		if (ampersandLoc != -1) {
			param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
		}
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = doSomething(request, param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(statement, sql, response);
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
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a25323 = param; //assign
		StringBuilder b25323 = new StringBuilder(a25323);  // stick in stringbuilder
		b25323.append(" SafeStuff"); // append some safe content
		b25323.replace(b25323.length()-"Chars".length(),b25323.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25323 = new java.util.HashMap<String,Object>();
		map25323.put("key25323", b25323.toString()); // put in a collection
		String c25323 = (String)map25323.get("key25323"); // get it back out
		String d25323 = c25323.substring(0,c25323.length()-1); // extract most of it
		String e25323 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d25323.getBytes() ) )); // B64 encode and decode it
		String f25323 = e25323.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g25323 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g25323); // reflection
	
		return bar;	
	}
}
