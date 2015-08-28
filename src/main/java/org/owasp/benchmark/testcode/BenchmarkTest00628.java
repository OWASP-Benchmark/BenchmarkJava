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
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00628")
public class BenchmarkTest00628 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("vector");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a77708 = param; //assign
		StringBuilder b77708 = new StringBuilder(a77708);  // stick in stringbuilder
		b77708.append(" SafeStuff"); // append some safe content
		b77708.replace(b77708.length()-"Chars".length(),b77708.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77708 = new java.util.HashMap<String,Object>();
		map77708.put("key77708", b77708.toString()); // put in a collection
		String c77708 = (String)map77708.get("key77708"); // get it back out
		String d77708 = c77708.substring(0,c77708.length()-1); // extract most of it
		String e77708 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77708.getBytes() ) )); // B64 encode and decode it
		String f77708 = e77708.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g77708 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g77708); // reflection
		
		
		String fileName = null;
		java.io.FileOutputStream fos = null;

		try {
			fileName = org.owasp.benchmark.helpers.Utils.testfileDir + bar;
	
			fos = new java.io.FileOutputStream(fileName);
	        response.getWriter().write("Now ready to write to file: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName));
   		} catch (Exception e) {
			System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
//			System.out.println("File exception caught and swallowed: " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
                    fos = null;
				} catch (Exception e) {
					// we tried...
				}
			}
		}
	}
}
