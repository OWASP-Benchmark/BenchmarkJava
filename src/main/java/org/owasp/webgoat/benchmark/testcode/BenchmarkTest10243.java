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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10243")
public class BenchmarkTest10243 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, 
			    java.sql.Statement.RETURN_GENERATED_KEYS );
			    statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a79548 = param; //assign
		StringBuilder b79548 = new StringBuilder(a79548);  // stick in stringbuilder
		b79548.append(" SafeStuff"); // append some safe content
		b79548.replace(b79548.length()-"Chars".length(),b79548.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79548 = new java.util.HashMap<String,Object>();
		map79548.put("key79548", b79548.toString()); // put in a collection
		String c79548 = (String)map79548.get("key79548"); // get it back out
		String d79548 = c79548.substring(0,c79548.length()-1); // extract most of it
		String e79548 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79548.getBytes() ) )); // B64 encode and decode it
		String f79548 = e79548.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g79548 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g79548); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
