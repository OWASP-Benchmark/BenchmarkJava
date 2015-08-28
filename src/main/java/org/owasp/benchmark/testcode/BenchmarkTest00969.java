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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00969")
public class BenchmarkTest00969 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = "";
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("vector")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					break;
				}
			}
		}

		String bar = new Test().doSomething(param);
		
		java.util.List<String> argList = new java.util.ArrayList<String>();
		
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	argList.add("cmd.exe");
        	argList.add("/c");
        } else {
        	argList.add("sh");
        	argList.add("-c");
        }
        argList.add("echo " + bar);

		ProcessBuilder pb = new ProcessBuilder(argList);

		try {
			Process p = pb.start();
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
            throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32829 = param; //assign
		StringBuilder b32829 = new StringBuilder(a32829);  // stick in stringbuilder
		b32829.append(" SafeStuff"); // append some safe content
		b32829.replace(b32829.length()-"Chars".length(),b32829.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32829 = new java.util.HashMap<String,Object>();
		map32829.put("key32829", b32829.toString()); // put in a collection
		String c32829 = (String)map32829.get("key32829"); // get it back out
		String d32829 = c32829.substring(0,c32829.length()-1); // extract most of it
		String e32829 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32829.getBytes() ) )); // B64 encode and decode it
		String f32829 = e32829.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g32829 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g32829); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
