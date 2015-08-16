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

@WebServlet("/BenchmarkTest01584")
public class BenchmarkTest01584 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("vector");
		if (param == null) param = "";

		String bar = new Test().doSomething(param);
		
		try {
			String sql = "SELECT  * from USERS where USERNAME='foo' and PASSWORD='"+ bar + "'" ;
	
	        org.springframework.jdbc.support.rowset.SqlRowSet results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForRowSet(sql);
	        java.io.PrintWriter out = response.getWriter();
			out.write("Your results are: ");
	//		System.out.println("Your results are");
			while(results.next()) {
	            out.write(org.owasp.esapi.ESAPI.encoder().encodeForHTML(results.getString("USERNAME")) + " ");
	//			System.out.println(results.getString("USERNAME"));
			}
		} catch (org.springframework.dao.DataAccessException e) {
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
		String a49844 = param; //assign
		StringBuilder b49844 = new StringBuilder(a49844);  // stick in stringbuilder
		b49844.append(" SafeStuff"); // append some safe content
		b49844.replace(b49844.length()-"Chars".length(),b49844.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49844 = new java.util.HashMap<String,Object>();
		map49844.put("key49844", b49844.toString()); // put in a collection
		String c49844 = (String)map49844.get("key49844"); // get it back out
		String d49844 = c49844.substring(0,c49844.length()-1); // extract most of it
		String e49844 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49844.getBytes() ) )); // B64 encode and decode it
		String f49844 = e49844.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g49844 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49844); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
