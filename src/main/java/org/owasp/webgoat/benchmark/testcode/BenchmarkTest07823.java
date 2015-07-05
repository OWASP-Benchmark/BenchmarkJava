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

@WebServlet("/BenchmarkTest07823")
public class BenchmarkTest07823 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
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
		
		javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
		javax.xml.xpath.XPath xp = xpf.newXPath();
		try {
			xp.evaluate(bar, "SpecifiedContext");
		} catch (javax.xml.xpath.XPathExpressionException|java.lang.NullPointerException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94522 = param; //assign
		StringBuilder b94522 = new StringBuilder(a94522);  // stick in stringbuilder
		b94522.append(" SafeStuff"); // append some safe content
		b94522.replace(b94522.length()-"Chars".length(),b94522.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94522 = new java.util.HashMap<String,Object>();
		map94522.put("key94522", b94522.toString()); // put in a collection
		String c94522 = (String)map94522.get("key94522"); // get it back out
		String d94522 = c94522.substring(0,c94522.length()-1); // extract most of it
		String e94522 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94522.getBytes() ) )); // B64 encode and decode it
		String f94522 = e94522.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g94522 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g94522); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
