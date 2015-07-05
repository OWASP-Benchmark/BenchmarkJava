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

@WebServlet("/BenchmarkTest09677")
public class BenchmarkTest09677 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27498 = param; //assign
		StringBuilder b27498 = new StringBuilder(a27498);  // stick in stringbuilder
		b27498.append(" SafeStuff"); // append some safe content
		b27498.replace(b27498.length()-"Chars".length(),b27498.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27498 = new java.util.HashMap<String,Object>();
		map27498.put("key27498", b27498.toString()); // put in a collection
		String c27498 = (String)map27498.get("key27498"); // get it back out
		String d27498 = c27498.substring(0,c27498.length()-1); // extract most of it
		String e27498 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27498.getBytes() ) )); // B64 encode and decode it
		String f27498 = e27498.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27498); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
