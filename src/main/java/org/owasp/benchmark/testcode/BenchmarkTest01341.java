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

@WebServlet("/BenchmarkTest01341")
public class BenchmarkTest01341 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("vector");
			if (values != null) param = values[0];
		}
		

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().printf(java.util.Locale.US,"Formatted like: %1$s and %2$s.",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a41904 = param; //assign
		StringBuilder b41904 = new StringBuilder(a41904);  // stick in stringbuilder
		b41904.append(" SafeStuff"); // append some safe content
		b41904.replace(b41904.length()-"Chars".length(),b41904.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41904 = new java.util.HashMap<String,Object>();
		map41904.put("key41904", b41904.toString()); // put in a collection
		String c41904 = (String)map41904.get("key41904"); // get it back out
		String d41904 = c41904.substring(0,c41904.length()-1); // extract most of it
		String e41904 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41904.getBytes() ) )); // B64 encode and decode it
		String f41904 = e41904.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g41904 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g41904); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
