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

@WebServlet("/BenchmarkTest00677")
public class BenchmarkTest00677 extends HttpServlet {
	
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
		String a96792 = param; //assign
		StringBuilder b96792 = new StringBuilder(a96792);  // stick in stringbuilder
		b96792.append(" SafeStuff"); // append some safe content
		b96792.replace(b96792.length()-"Chars".length(),b96792.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96792 = new java.util.HashMap<String,Object>();
		map96792.put("key96792", b96792.toString()); // put in a collection
		String c96792 = (String)map96792.get("key96792"); // get it back out
		String d96792 = c96792.substring(0,c96792.length()-1); // extract most of it
		String e96792 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96792.getBytes() ) )); // B64 encode and decode it
		String f96792 = e96792.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f96792); // reflection
		
		
		try {
			double rand = java.security.SecureRandom.getInstance("SHA1PRNG").nextDouble();
			
			String rememberMeKey = Double.toString(rand).substring(2); // Trim off the 0. at the front.
			
			String user = "SafeDonna";
			String fullClassName = this.getClass().getName();
			String testCaseNumber = fullClassName.substring(fullClassName.lastIndexOf('.')+1+"BenchmarkTest".length());
			user+= testCaseNumber;
			
			String cookieName = "rememberMe" + testCaseNumber;
			
			boolean foundUser = false;
			javax.servlet.http.Cookie[] cookies = request.getCookies();
			for (int i = 0; cookies != null && ++i < cookies.length && !foundUser;) {
				javax.servlet.http.Cookie cookie = cookies[i];
				if (cookieName.equals(cookie.getName())) {
					if (cookie.getValue().equals(request.getSession().getAttribute(cookieName))) {
						foundUser = true;
					}
				}
			}
			
			if (foundUser) {
				response.getWriter().println("Welcome back: " + user + "<br/>");			
			} else {			
				javax.servlet.http.Cookie rememberMe = new javax.servlet.http.Cookie(cookieName, rememberMeKey);
				rememberMe.setSecure(true);
				request.getSession().setAttribute(cookieName, rememberMeKey);
				response.addCookie(rememberMe);
				response.getWriter().println(user + " has been remembered with cookie: " + rememberMe.getName() 
						+ " whose value is: " + rememberMe.getValue() + "<br/>");
			}

	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextDouble() - TestCase");
			throw new ServletException(e);
	    }
		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextDouble() executed");
	}
}
