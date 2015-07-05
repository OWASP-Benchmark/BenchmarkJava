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

@WebServlet("/BenchmarkTest18509")
public class BenchmarkTest18509 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		try {
		    java.util.Properties Benchmarkprops = new java.util.Properties();
		    Benchmarkprops.load(this.getClass().getClassLoader().getResourceAsStream("Benchmark.properties"));
			String algorithm = Benchmarkprops.getProperty("cryptoAlg2", "AES/ECB/PKCS5Padding");
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance(algorithm);
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case");
			throw new ServletException(e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case");
			throw new ServletException(e);
		}
		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71012 = param; //assign
		StringBuilder b71012 = new StringBuilder(a71012);  // stick in stringbuilder
		b71012.append(" SafeStuff"); // append some safe content
		b71012.replace(b71012.length()-"Chars".length(),b71012.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71012 = new java.util.HashMap<String,Object>();
		map71012.put("key71012", b71012.toString()); // put in a collection
		String c71012 = (String)map71012.get("key71012"); // get it back out
		String d71012 = c71012.substring(0,c71012.length()-1); // extract most of it
		String e71012 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71012.getBytes() ) )); // B64 encode and decode it
		String f71012 = e71012.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71012); // reflection
	
		return bar;	
	}
}
