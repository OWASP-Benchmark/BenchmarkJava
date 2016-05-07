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

@WebServlet("/BenchmarkTest00275")
public class BenchmarkTest00275 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("referer");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
        param = java.net.URLDecoder.decode(param, "UTF-8");

		
		
		// Chain a bunch of propagators in sequence
		String a61008 = param; //assign
		StringBuilder b61008 = new StringBuilder(a61008);  // stick in stringbuilder
		b61008.append(" SafeStuff"); // append some safe content
		b61008.replace(b61008.length()-"Chars".length(),b61008.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61008 = new java.util.HashMap<String,Object>();
		map61008.put("key61008", b61008.toString()); // put in a collection
		String c61008 = (String)map61008.get("key61008"); // get it back out
		String d61008 = c61008.substring(0,c61008.length()-1); // extract most of it
		String e61008 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61008.getBytes() ) )); // B64 encode and decode it
		String f61008 = e61008.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g61008 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61008); // reflection
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
