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

@WebServlet("/BenchmarkTest12965")
public class BenchmarkTest12965 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
            // TODO: Fix this.
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75767 = param; //assign
		StringBuilder b75767 = new StringBuilder(a75767);  // stick in stringbuilder
		b75767.append(" SafeStuff"); // append some safe content
		b75767.replace(b75767.length()-"Chars".length(),b75767.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75767 = new java.util.HashMap<String,Object>();
		map75767.put("key75767", b75767.toString()); // put in a collection
		String c75767 = (String)map75767.get("key75767"); // get it back out
		String d75767 = c75767.substring(0,c75767.length()-1); // extract most of it
		String e75767 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75767.getBytes() ) )); // B64 encode and decode it
		String f75767 = e75767.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g75767 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75767); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
