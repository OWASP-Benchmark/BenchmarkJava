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

@WebServlet("/BenchmarkTest10212")
public class BenchmarkTest10212 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql, java.sql.ResultSet.TYPE_FORWARD_ONLY, 
							java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT );
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55371 = param; //assign
		StringBuilder b55371 = new StringBuilder(a55371);  // stick in stringbuilder
		b55371.append(" SafeStuff"); // append some safe content
		b55371.replace(b55371.length()-"Chars".length(),b55371.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55371 = new java.util.HashMap<String,Object>();
		map55371.put("key55371", b55371.toString()); // put in a collection
		String c55371 = (String)map55371.get("key55371"); // get it back out
		String d55371 = c55371.substring(0,c55371.length()-1); // extract most of it
		String e55371 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55371.getBytes() ) )); // B64 encode and decode it
		String f55371 = e55371.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g55371 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55371); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
