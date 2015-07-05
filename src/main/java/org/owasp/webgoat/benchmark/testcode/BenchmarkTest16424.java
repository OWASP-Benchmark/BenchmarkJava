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

@WebServlet("/BenchmarkTest16424")
public class BenchmarkTest16424 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		String cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
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
		String a72394 = param; //assign
		StringBuilder b72394 = new StringBuilder(a72394);  // stick in stringbuilder
		b72394.append(" SafeStuff"); // append some safe content
		b72394.replace(b72394.length()-"Chars".length(),b72394.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72394 = new java.util.HashMap<String,Object>();
		map72394.put("key72394", b72394.toString()); // put in a collection
		String c72394 = (String)map72394.get("key72394"); // get it back out
		String d72394 = c72394.substring(0,c72394.length()-1); // extract most of it
		String e72394 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72394.getBytes() ) )); // B64 encode and decode it
		String f72394 = e72394.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g72394 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72394); // reflection
	
		return bar;	
	}
}
