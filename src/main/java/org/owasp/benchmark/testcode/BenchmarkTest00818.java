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

@WebServlet("/BenchmarkTest00818")
public class BenchmarkTest00818 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String queryString = request.getQueryString();
		String paramval = "vector"+"=";
		int paramLoc = -1;
		if (queryString != null) paramLoc = queryString.indexOf(paramval);
		if (paramLoc == -1) {
			response.getWriter().println("getQueryString() couldn't find expected parameter '" + "vector" + "' in query string.");
			return;
		}
		
		String param = queryString.substring(paramLoc + paramval.length()); // 1st assume "vector" param is last parameter in query string.
		// And then check to see if its in the middle of the query string and if so, trim off what comes after.
		int ampersandLoc = queryString.indexOf("&", paramLoc);
		if (ampersandLoc != -1) {
			param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
		}
		param = java.net.URLDecoder.decode(param, "UTF-8");
		
		
		// Chain a bunch of propagators in sequence
		String a35438 = param; //assign
		StringBuilder b35438 = new StringBuilder(a35438);  // stick in stringbuilder
		b35438.append(" SafeStuff"); // append some safe content
		b35438.replace(b35438.length()-"Chars".length(),b35438.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35438 = new java.util.HashMap<String,Object>();
		map35438.put("key35438", b35438.toString()); // put in a collection
		String c35438 = (String)map35438.get("key35438"); // get it back out
		String d35438 = c35438.substring(0,c35438.length()-1); // extract most of it
		String e35438 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35438.getBytes() ) )); // B64 encode and decode it
		String f35438 = e35438.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g35438 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35438); // reflection
		
		
		Object[] obj = { "a", "b" };
		response.getWriter().format(bar,obj);
	}
}
