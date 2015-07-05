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

@WebServlet("/BenchmarkTest12637")
public class BenchmarkTest12637 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		String cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        
		String[] argsEnv = { bar };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14754 = param; //assign
		StringBuilder b14754 = new StringBuilder(a14754);  // stick in stringbuilder
		b14754.append(" SafeStuff"); // append some safe content
		b14754.replace(b14754.length()-"Chars".length(),b14754.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14754 = new java.util.HashMap<String,Object>();
		map14754.put("key14754", b14754.toString()); // put in a collection
		String c14754 = (String)map14754.get("key14754"); // get it back out
		String d14754 = c14754.substring(0,c14754.length()-1); // extract most of it
		String e14754 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14754.getBytes() ) )); // B64 encode and decode it
		String f14754 = e14754.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14754); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
