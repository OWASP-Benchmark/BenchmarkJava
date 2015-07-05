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

@WebServlet("/BenchmarkTest17178")
public class BenchmarkTest17178 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql, java.sql.ResultSet.TYPE_FORWARD_ONLY, 
							java.sql.ResultSet.CONCUR_READ_ONLY );
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70543 = param; //assign
		StringBuilder b70543 = new StringBuilder(a70543);  // stick in stringbuilder
		b70543.append(" SafeStuff"); // append some safe content
		b70543.replace(b70543.length()-"Chars".length(),b70543.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70543 = new java.util.HashMap<String,Object>();
		map70543.put("key70543", b70543.toString()); // put in a collection
		String c70543 = (String)map70543.get("key70543"); // get it back out
		String d70543 = c70543.substring(0,c70543.length()-1); // extract most of it
		String e70543 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70543.getBytes() ) )); // B64 encode and decode it
		String f70543 = e70543.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g70543 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70543); // reflection
	
		return bar;	
	}
}
