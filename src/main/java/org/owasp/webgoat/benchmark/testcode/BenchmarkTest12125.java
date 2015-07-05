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

@WebServlet("/BenchmarkTest12125")
public class BenchmarkTest12125 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20516 = param; //assign
		StringBuilder b20516 = new StringBuilder(a20516);  // stick in stringbuilder
		b20516.append(" SafeStuff"); // append some safe content
		b20516.replace(b20516.length()-"Chars".length(),b20516.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20516 = new java.util.HashMap<String,Object>();
		map20516.put("key20516", b20516.toString()); // put in a collection
		String c20516 = (String)map20516.get("key20516"); // get it back out
		String d20516 = c20516.substring(0,c20516.length()-1); // extract most of it
		String e20516 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20516.getBytes() ) )); // B64 encode and decode it
		String f20516 = e20516.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f20516); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
