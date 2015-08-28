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

@WebServlet("/BenchmarkTest01809")
public class BenchmarkTest01809 extends HttpServlet {
	
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
		
		try {
	        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"
	            + bar + "'";
	
			java.util.List list = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForList(sql);
			java.io.PrintWriter out = response.getWriter();
	        out.write("Your results are: <br>");
	//		System.out.println("Your results are");
			
			for(Object o:list){
				out.write(org.owasp.esapi.ESAPI.encoder().encodeForHTML(o.toString()) + "<br>");
	//			System.out.println(o.toString());
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
		String a1766 = param; //assign
		StringBuilder b1766 = new StringBuilder(a1766);  // stick in stringbuilder
		b1766.append(" SafeStuff"); // append some safe content
		b1766.replace(b1766.length()-"Chars".length(),b1766.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1766 = new java.util.HashMap<String,Object>();
		map1766.put("key1766", b1766.toString()); // put in a collection
		String c1766 = (String)map1766.get("key1766"); // get it back out
		String d1766 = c1766.substring(0,c1766.length()-1); // extract most of it
		String e1766 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1766.getBytes() ) )); // B64 encode and decode it
		String f1766 = e1766.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g1766 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1766); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
