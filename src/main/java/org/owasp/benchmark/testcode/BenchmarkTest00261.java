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

@WebServlet(value="/pathtraver-00/BenchmarkTest00261")
public class BenchmarkTest00261 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00261");
		
		if (headers != null && headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		// URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
		param = java.net.URLDecoder.decode(param, "UTF-8");
		
		
		// Chain a bunch of propagators in sequence
		String a3000 = param; //assign
		StringBuilder b3000 = new StringBuilder(a3000);  // stick in stringbuilder
		b3000.append(" SafeStuff"); // append some safe content
		b3000.replace(b3000.length()-"Chars".length(),b3000.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3000 = new java.util.HashMap<String,Object>();
		map3000.put("key3000", b3000.toString()); // put in a collection
		String c3000 = (String)map3000.get("key3000"); // get it back out
		String d3000 = c3000.substring(0,c3000.length()-1); // extract most of it
		String e3000 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d3000.getBytes() ) )); // B64 encode and decode it
		String f3000 = e3000.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g3000 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g3000); // reflection
		
		
		java.io.File fileTarget = new java.io.File(new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR),bar);
		response.getWriter().println(
"Access to file: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileTarget.toString()) + "' created." 
);
		if (fileTarget.exists()) {
			response.getWriter().println(
" And file already exists."
);
		} else { response.getWriter().println(
" But file doesn't exist yet."
); }
	}
	
}
