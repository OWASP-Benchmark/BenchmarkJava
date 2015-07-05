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

@WebServlet("/BenchmarkTest15136")
public class BenchmarkTest15136 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		String cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        
		String[] argsEnv = { bar };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a78233 = param; //assign
		StringBuilder b78233 = new StringBuilder(a78233);  // stick in stringbuilder
		b78233.append(" SafeStuff"); // append some safe content
		b78233.replace(b78233.length()-"Chars".length(),b78233.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78233 = new java.util.HashMap<String,Object>();
		map78233.put("key78233", b78233.toString()); // put in a collection
		String c78233 = (String)map78233.get("key78233"); // get it back out
		String d78233 = c78233.substring(0,c78233.length()-1); // extract most of it
		String e78233 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78233.getBytes() ) )); // B64 encode and decode it
		String f78233 = e78233.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g78233 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78233); // reflection
	
		return bar;	
	}
}
