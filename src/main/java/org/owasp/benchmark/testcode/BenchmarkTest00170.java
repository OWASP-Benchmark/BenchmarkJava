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

@WebServlet(value="/securecookie-00/BenchmarkTest00170")
public class BenchmarkTest00170 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		if (request.getHeader("BenchmarkTest00170") != null) {
			param = request.getHeader("BenchmarkTest00170");
		}
		
		// URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
		param = java.net.URLDecoder.decode(param, "UTF-8");
		
		
		// Chain a bunch of propagators in sequence
		String a9823 = param; //assign
		StringBuilder b9823 = new StringBuilder(a9823);  // stick in stringbuilder
		b9823.append(" SafeStuff"); // append some safe content
		b9823.replace(b9823.length()-"Chars".length(),b9823.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9823 = new java.util.HashMap<String,Object>();
		map9823.put("key9823", b9823.toString()); // put in a collection
		String c9823 = (String)map9823.get("key9823"); // get it back out
		String d9823 = c9823.substring(0,c9823.length()-1); // extract most of it
		String e9823 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d9823.getBytes() ) )); // B64 encode and decode it
		String f9823 = e9823.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g9823 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9823); // reflection
		
		
		byte[] input = new byte[1000];
		String str = "?";
		Object inputParam = param;
		if (inputParam instanceof String) str = ((String) inputParam);
		if (inputParam instanceof java.io.InputStream) {
			int i = ((java.io.InputStream) inputParam).read(input);
			if (i == -1) {
				response.getWriter().println(
"This input source requires a POST, not a GET. Incompatible UI for the InputStream source."
);
				return;
			}			
			str = new String(input, 0, i);
		}
		if ("".equals(str)) str="No cookie value supplied";
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie", str);
		
		cookie.setSecure(false);
		cookie.setHttpOnly(true);
		cookie.setPath(request.getRequestURI()); // i.e., set path to JUST this servlet
												 // e.g., /benchmark/sql-01/BenchmarkTest01001
		response.addCookie(cookie);

        response.getWriter().println(
			"Created cookie: 'SomeCookie': with value: '"
			+ org.owasp.esapi.ESAPI.encoder().encodeForHTML(str) + "' and secure flag set to: false"
		);
	}
	
}
