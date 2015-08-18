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

@WebServlet("/BenchmarkTest02317")
public class BenchmarkTest02317 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		try {
			int r = java.security.SecureRandom.getInstance("SHA1PRNG").nextInt();
			String rememberMeKey = Integer.toString(r);
			
			String user = "SafeIngrid";
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
			System.out.println("Problem executing SecureRandom.nextInt() - TestCase");
			throw new ServletException(e);
	    }
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71128 = param; //assign
		StringBuilder b71128 = new StringBuilder(a71128);  // stick in stringbuilder
		b71128.append(" SafeStuff"); // append some safe content
		b71128.replace(b71128.length()-"Chars".length(),b71128.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71128 = new java.util.HashMap<String,Object>();
		map71128.put("key71128", b71128.toString()); // put in a collection
		String c71128 = (String)map71128.get("key71128"); // get it back out
		String d71128 = c71128.substring(0,c71128.length()-1); // extract most of it
		String e71128 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71128.getBytes() ) )); // B64 encode and decode it
		String f71128 = e71128.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71128); // reflection
	
		return bar;	
	}
}
