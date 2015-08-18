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

@WebServlet("/BenchmarkTest00973")
public class BenchmarkTest00973 extends HttpServlet {
	
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
	
			fos = new java.io.FileOutputStream(new java.io.File(fileName),false);
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
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a46245 = param; //assign
		StringBuilder b46245 = new StringBuilder(a46245);  // stick in stringbuilder
		b46245.append(" SafeStuff"); // append some safe content
		b46245.replace(b46245.length()-"Chars".length(),b46245.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46245 = new java.util.HashMap<String,Object>();
		map46245.put("key46245", b46245.toString()); // put in a collection
		String c46245 = (String)map46245.get("key46245"); // get it back out
		String d46245 = c46245.substring(0,c46245.length()-1); // extract most of it
		String e46245 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46245.getBytes() ) )); // B64 encode and decode it
		String f46245 = e46245.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g46245 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g46245); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
