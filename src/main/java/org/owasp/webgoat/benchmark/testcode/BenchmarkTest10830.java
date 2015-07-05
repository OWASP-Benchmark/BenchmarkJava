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

@WebServlet("/BenchmarkTest10830")
public class BenchmarkTest10830 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92081 = param; //assign
		StringBuilder b92081 = new StringBuilder(a92081);  // stick in stringbuilder
		b92081.append(" SafeStuff"); // append some safe content
		b92081.replace(b92081.length()-"Chars".length(),b92081.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92081 = new java.util.HashMap<String,Object>();
		map92081.put("key92081", b92081.toString()); // put in a collection
		String c92081 = (String)map92081.get("key92081"); // get it back out
		String d92081 = c92081.substring(0,c92081.length()-1); // extract most of it
		String e92081 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92081.getBytes() ) )); // B64 encode and decode it
		String f92081 = e92081.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g92081 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92081); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
