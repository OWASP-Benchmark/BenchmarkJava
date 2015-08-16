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

@WebServlet("/BenchmarkTest01847")
public class BenchmarkTest01847 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("vector");

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString(1, "foo");
			statement.execute();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(statement, sql, response);
		} catch (java.sql.SQLException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println("Error processing request.");
        		return;
        	}
			else throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a16871 = param; //assign
		StringBuilder b16871 = new StringBuilder(a16871);  // stick in stringbuilder
		b16871.append(" SafeStuff"); // append some safe content
		b16871.replace(b16871.length()-"Chars".length(),b16871.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map16871 = new java.util.HashMap<String,Object>();
		map16871.put("key16871", b16871.toString()); // put in a collection
		String c16871 = (String)map16871.get("key16871"); // get it back out
		String d16871 = c16871.substring(0,c16871.length()-1); // extract most of it
		String e16871 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d16871.getBytes() ) )); // B64 encode and decode it
		String f16871 = e16871.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g16871 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g16871); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
