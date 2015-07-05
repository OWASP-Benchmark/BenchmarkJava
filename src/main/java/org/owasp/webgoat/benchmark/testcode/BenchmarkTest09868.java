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

@WebServlet("/BenchmarkTest09868")
public class BenchmarkTest09868 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
            // TODO: Fix this, if possible.
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10289 = param; //assign
		StringBuilder b10289 = new StringBuilder(a10289);  // stick in stringbuilder
		b10289.append(" SafeStuff"); // append some safe content
		b10289.replace(b10289.length()-"Chars".length(),b10289.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10289 = new java.util.HashMap<String,Object>();
		map10289.put("key10289", b10289.toString()); // put in a collection
		String c10289 = (String)map10289.get("key10289"); // get it back out
		String d10289 = c10289.substring(0,c10289.length()-1); // extract most of it
		String e10289 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10289.getBytes() ) )); // B64 encode and decode it
		String f10289 = e10289.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g10289 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10289); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
