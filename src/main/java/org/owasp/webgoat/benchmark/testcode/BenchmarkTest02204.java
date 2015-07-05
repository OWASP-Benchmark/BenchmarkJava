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

@WebServlet("/BenchmarkTest02204")
public class BenchmarkTest02204 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a53941 = param; //assign
		StringBuilder b53941 = new StringBuilder(a53941);  // stick in stringbuilder
		b53941.append(" SafeStuff"); // append some safe content
		b53941.replace(b53941.length()-"Chars".length(),b53941.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53941 = new java.util.HashMap<String,Object>();
		map53941.put("key53941", b53941.toString()); // put in a collection
		String c53941 = (String)map53941.get("key53941"); // get it back out
		String d53941 = c53941.substring(0,c53941.length()-1); // extract most of it
		String e53941 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53941.getBytes() ) )); // B64 encode and decode it
		String f53941 = e53941.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g53941 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53941); // reflection
		
		
		String sql = "UPDATE USERS SET PASSWORD='" + bar + "' WHERE USERNAME='foo'";
				
		try {
			java.sql.Statement statement = org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
