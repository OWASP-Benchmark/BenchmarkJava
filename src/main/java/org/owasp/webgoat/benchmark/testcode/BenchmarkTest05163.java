/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
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

@WebServlet("/BenchmarkTest05163")
public class BenchmarkTest05163 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a1138 = param; //assign
		StringBuilder b1138 = new StringBuilder(a1138);  // stick in stringbuilder
		b1138.append(" SafeStuff"); // append some safe content
		b1138.replace(b1138.length()-"Chars".length(),b1138.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1138 = new java.util.HashMap<String,Object>();
		map1138.put("key1138", b1138.toString()); // put in a collection
		String c1138 = (String)map1138.get("key1138"); // get it back out
		String d1138 = c1138.substring(0,c1138.length()-1); // extract most of it
		String e1138 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1138.getBytes() ) )); // B64 encode and decode it
		String f1138 = e1138.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g1138 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1138); // reflection
		
		
		String cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}
}
