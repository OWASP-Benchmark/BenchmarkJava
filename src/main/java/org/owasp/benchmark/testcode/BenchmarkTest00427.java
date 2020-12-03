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

@WebServlet(value="/trustbound-00/BenchmarkTest00427")
public class BenchmarkTest00427 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00427");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a70670 = param; //assign
		StringBuilder b70670 = new StringBuilder(a70670);  // stick in stringbuilder
		b70670.append(" SafeStuff"); // append some safe content
		b70670.replace(b70670.length()-"Chars".length(),b70670.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70670 = new java.util.HashMap<String,Object>();
		map70670.put("key70670", b70670.toString()); // put in a collection
		String c70670 = (String)map70670.get("key70670"); // get it back out
		String d70670 = c70670.substring(0,c70670.length()-1); // extract most of it
		String e70670 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d70670.getBytes() ) )); // B64 encode and decode it
		String f70670 = e70670.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70670); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "userid", bar);
				
		response.getWriter().println(
		"Item: 'userid' with value: '" + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
			+ "' saved in session."
);
	}
	
}
