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

@WebServlet("/BenchmarkTest01744")
public class BenchmarkTest01744 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("vector");

		String bar = new Test().doSomething(param);
		
		java.io.File fileTarget = new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir, bar);
		response.getWriter().write("Access to file: '" + fileTarget + "' created." );
		if (fileTarget.exists()) {
			response.getWriter().write(" And file already exists.");
		} else { response.getWriter().write(" But file doesn't exist yet."); }
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87870 = param; //assign
		StringBuilder b87870 = new StringBuilder(a87870);  // stick in stringbuilder
		b87870.append(" SafeStuff"); // append some safe content
		b87870.replace(b87870.length()-"Chars".length(),b87870.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87870 = new java.util.HashMap<String,Object>();
		map87870.put("key87870", b87870.toString()); // put in a collection
		String c87870 = (String)map87870.get("key87870"); // get it back out
		String d87870 = c87870.substring(0,c87870.length()-1); // extract most of it
		String e87870 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87870.getBytes() ) )); // B64 encode and decode it
		String f87870 = e87870.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g87870 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87870); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
