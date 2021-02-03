/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/sqli-03/BenchmarkTest01809")
public class BenchmarkTest01809 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("BenchmarkTest01809");

		String bar = new Test().doSomething(request, param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
		try {
			java.util.List<java.util.Map<String, Object>> list = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForList(sql);
			response.getWriter().println(
				"Your results are: <br>"
			);

	//		System.out.println("Your results are");
			
			for (Object o:list) {
				response.getWriter().println(
					org.owasp.esapi.ESAPI.encoder().encodeForHTML(o.toString()) + "<br>"
				);
	//			System.out.println(o.toString());
			}
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			response.getWriter().println(
				"No results returned for query: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql)
			);
		} catch (org.springframework.dao.DataAccessException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println(
					"Error processing request."
				);
        		return;
        	}
			else throw new ServletException(e);
		}
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64594 = param; //assign
		StringBuilder b64594 = new StringBuilder(a64594);  // stick in stringbuilder
		b64594.append(" SafeStuff"); // append some safe content
		b64594.replace(b64594.length()-"Chars".length(),b64594.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64594 = new java.util.HashMap<String,Object>();
		map64594.put("key64594", b64594.toString()); // put in a collection
		String c64594 = (String)map64594.get("key64594"); // get it back out
		String d64594 = c64594.substring(0,c64594.length()-1); // extract most of it
		String e64594 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d64594.getBytes() ) )); // B64 encode and decode it
		String f64594 = e64594.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g64594 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64594); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
