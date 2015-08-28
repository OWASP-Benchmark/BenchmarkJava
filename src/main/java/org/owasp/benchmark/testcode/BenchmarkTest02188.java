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

@WebServlet("/BenchmarkTest02188")
public class BenchmarkTest02188 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String param = request.getParameter("vector");
		if (param == null) param = "";

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);
		} catch (java.sql.SQLException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println("Error processing request.");
        		return;
        	}
			else throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a46851 = param; //assign
		StringBuilder b46851 = new StringBuilder(a46851);  // stick in stringbuilder
		b46851.append(" SafeStuff"); // append some safe content
		b46851.replace(b46851.length()-"Chars".length(),b46851.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46851 = new java.util.HashMap<String,Object>();
		map46851.put("key46851", b46851.toString()); // put in a collection
		String c46851 = (String)map46851.get("key46851"); // get it back out
		String d46851 = c46851.substring(0,c46851.length()-1); // extract most of it
		String e46851 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46851.getBytes() ) )); // B64 encode and decode it
		String f46851 = e46851.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g46851 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g46851); // reflection
	
		return bar;	
	}
}
