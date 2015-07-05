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

@WebServlet("/BenchmarkTest10405")
public class BenchmarkTest10405 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76073 = param; //assign
		StringBuilder b76073 = new StringBuilder(a76073);  // stick in stringbuilder
		b76073.append(" SafeStuff"); // append some safe content
		b76073.replace(b76073.length()-"Chars".length(),b76073.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76073 = new java.util.HashMap<String,Object>();
		map76073.put("key76073", b76073.toString()); // put in a collection
		String c76073 = (String)map76073.get("key76073"); // get it back out
		String d76073 = c76073.substring(0,c76073.length()-1); // extract most of it
		String e76073 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76073.getBytes() ) )); // B64 encode and decode it
		String f76073 = e76073.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g76073 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76073); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
