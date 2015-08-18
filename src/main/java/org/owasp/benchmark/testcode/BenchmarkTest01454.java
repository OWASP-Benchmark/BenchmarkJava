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

@WebServlet("/BenchmarkTest01454")
public class BenchmarkTest01454 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();		    	
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for(int i=0;i<values.length && flag; i++){
					String value = values[i];
					if (value.equals("vector")) {
						param = name;
					    flag = false;
					}
				}
			}
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a69778 = param; //assign
		StringBuilder b69778 = new StringBuilder(a69778);  // stick in stringbuilder
		b69778.append(" SafeStuff"); // append some safe content
		b69778.replace(b69778.length()-"Chars".length(),b69778.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map69778 = new java.util.HashMap<String,Object>();
		map69778.put("key69778", b69778.toString()); // put in a collection
		String c69778 = (String)map69778.get("key69778"); // get it back out
		String d69778 = c69778.substring(0,c69778.length()-1); // extract most of it
		String e69778 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d69778.getBytes() ) )); // B64 encode and decode it
		String f69778 = e69778.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g69778 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g69778); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
