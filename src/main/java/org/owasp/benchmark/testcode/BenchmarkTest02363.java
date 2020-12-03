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
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/sqli-05/BenchmarkTest02363")
public class BenchmarkTest02363 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();		    	
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for(int i=0;i<values.length && flag; i++){
					String value = values[i];
					if (value.equals("BenchmarkTest02363")) {
						param = name;
					    flag = false;
					}
				}
			}
		}

		String bar = doSomething(request, param);
		
		try {
	        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
	
			org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.batchUpdate(sql);
			response.getWriter().println(
				"No results can be displayed for query: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql) + "<br>"
				+ " because the Spring batchUpdate method doesn't return results."
			);
		} catch (org.springframework.dao.DataAccessException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println(
					"Error processing request."
				);
        	}
			else throw new ServletException(e);
		}
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21456 = param; //assign
		StringBuilder b21456 = new StringBuilder(a21456);  // stick in stringbuilder
		b21456.append(" SafeStuff"); // append some safe content
		b21456.replace(b21456.length()-"Chars".length(),b21456.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21456 = new java.util.HashMap<String,Object>();
		map21456.put("key21456", b21456.toString()); // put in a collection
		String c21456 = (String)map21456.get("key21456"); // get it back out
		String d21456 = c21456.substring(0,c21456.length()-1); // extract most of it
		String e21456 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d21456.getBytes() ) )); // B64 encode and decode it
		String f21456 = e21456.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g21456 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21456); // reflection
	
		return bar;	
	}
}
