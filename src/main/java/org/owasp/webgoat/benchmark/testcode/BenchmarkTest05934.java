/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
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

@WebServlet("/BenchmarkTest05934")
public class BenchmarkTest05934 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a91594 = param; //assign
		StringBuilder b91594 = new StringBuilder(a91594);  // stick in stringbuilder
		b91594.append(" SafeStuff"); // append some safe content
		b91594.replace(b91594.length()-"Chars".length(),b91594.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91594 = new java.util.HashMap<String,Object>();
		map91594.put("key91594", b91594.toString()); // put in a collection
		String c91594 = (String)map91594.get("key91594"); // get it back out
		String d91594 = c91594.substring(0,c91594.length()-1); // extract most of it
		String e91594 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91594.getBytes() ) )); // B64 encode and decode it
		String f91594 = e91594.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g91594 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91594); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
