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

@WebServlet("/BenchmarkTest01250")
public class BenchmarkTest01250 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a59702 = param; //assign
		StringBuilder b59702 = new StringBuilder(a59702);  // stick in stringbuilder
		b59702.append(" SafeStuff"); // append some safe content
		b59702.replace(b59702.length()-"Chars".length(),b59702.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59702 = new java.util.HashMap<String,Object>();
		map59702.put("key59702", b59702.toString()); // put in a collection
		String c59702 = (String)map59702.get("key59702"); // get it back out
		String d59702 = c59702.substring(0,c59702.length()-1); // extract most of it
		String e59702 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59702.getBytes() ) )); // B64 encode and decode it
		String f59702 = e59702.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g59702 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59702); // reflection
		
		
		String a1 = "";
		String a2 = "";
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        } else {
        	a1 = "sh";
        	a2 = "-c";
        }
        String[] args = {a1, a2, "echo", bar};

		ProcessBuilder pb = new ProcessBuilder();

		pb.command(args);
		
		try {
			Process p = pb.start();
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
            throw new ServletException(e);
		}
	}
}
