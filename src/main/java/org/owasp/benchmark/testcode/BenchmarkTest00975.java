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

@WebServlet("/BenchmarkTest00975")
public class BenchmarkTest00975 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("vector")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
		String fileName = null;
		java.io.FileOutputStream fos = null;

		try {
			fileName = org.owasp.benchmark.helpers.Utils.testfileDir + bar;
	
			fos = new java.io.FileOutputStream(new java.io.File(fileName));
	        response.getWriter().write("Now ready to write to file: " + fileName);
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
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6442 = param; //assign
		StringBuilder b6442 = new StringBuilder(a6442);  // stick in stringbuilder
		b6442.append(" SafeStuff"); // append some safe content
		b6442.replace(b6442.length()-"Chars".length(),b6442.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6442 = new java.util.HashMap<String,Object>();
		map6442.put("key6442", b6442.toString()); // put in a collection
		String c6442 = (String)map6442.get("key6442"); // get it back out
		String d6442 = c6442.substring(0,c6442.length()-1); // extract most of it
		String e6442 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6442.getBytes() ) )); // B64 encode and decode it
		String f6442 = e6442.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g6442 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6442); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
