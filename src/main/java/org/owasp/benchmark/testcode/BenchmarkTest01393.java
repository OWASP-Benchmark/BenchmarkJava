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

@WebServlet("/BenchmarkTest01393")
public class BenchmarkTest01393 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("vector");
			if (values != null) param = values[0];
		}
		

		String bar = new Test().doSomething(param);
		
		String sql = "INSERT INTO users (username, password) VALUES ('foo','"+ bar + "')";
				
		try {
			java.sql.Statement statement = org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			int count = statement.executeUpdate( sql, new int[] {1,2} );
            org.owasp.benchmark.helpers.DatabaseHelper.outputUpdateComplete(sql, response);
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
		String a44572 = param; //assign
		StringBuilder b44572 = new StringBuilder(a44572);  // stick in stringbuilder
		b44572.append(" SafeStuff"); // append some safe content
		b44572.replace(b44572.length()-"Chars".length(),b44572.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44572 = new java.util.HashMap<String,Object>();
		map44572.put("key44572", b44572.toString()); // put in a collection
		String c44572 = (String)map44572.get("key44572"); // get it back out
		String d44572 = c44572.substring(0,c44572.length()-1); // extract most of it
		String e44572 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44572.getBytes() ) )); // B64 encode and decode it
		String f44572 = e44572.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g44572 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44572); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
