/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/weakrand-00/BenchmarkTest00399")
public class BenchmarkTest00399 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00399");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a78565 = param; //assign
		StringBuilder b78565 = new StringBuilder(a78565);  // stick in stringbuilder
		b78565.append(" SafeStuff"); // append some safe content
		b78565.replace(b78565.length()-"Chars".length(),b78565.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78565 = new java.util.HashMap<String,Object>();
		map78565.put("key78565", b78565.toString()); // put in a collection
		String c78565 = (String)map78565.get("key78565"); // get it back out
		String d78565 = c78565.substring(0,c78565.length()-1); // extract most of it
		String e78565 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d78565.getBytes() ) )); // B64 encode and decode it
		String f78565 = e78565.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g78565 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78565); // reflection
		
		
		double value = new java.util.Random().nextDouble();
		String rememberMeKey = Double.toString(value).substring(2); // Trim off the 0. at the front.
		
		String user = "Donna";
		String fullClassName = this.getClass().getName();
		String testCaseNumber = fullClassName.substring(fullClassName.lastIndexOf('.')+1+"BenchmarkTest".length());
		user+= testCaseNumber;
		
		String cookieName = "rememberMe" + testCaseNumber;
		
		boolean foundUser = false;
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; !foundUser && i < cookies.length; i++) {
				javax.servlet.http.Cookie cookie = cookies[i];
				if (cookieName.equals(cookie.getName())) {
					if (cookie.getValue().equals(request.getSession().getAttribute(cookieName))) {
						foundUser = true;
					}
				}
			}
		}
		
		if (foundUser) {
			response.getWriter().println(
			"Welcome back: " + user + "<br/>"
			);
		} else {			
			javax.servlet.http.Cookie rememberMe = new javax.servlet.http.Cookie(cookieName, rememberMeKey);
			rememberMe.setSecure(true);
			rememberMe.setHttpOnly(true);
			rememberMe.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
			rememberMe.setPath(request.getRequestURI()); // i.e., set path to JUST this servlet 
														 // e.g., /benchmark/sql-01/BenchmarkTest01001
			request.getSession().setAttribute(cookieName, rememberMeKey);
			response.addCookie(rememberMe);
			response.getWriter().println(
				user + " has been remembered with cookie: " + rememberMe.getName() 
					+ " whose value is: " + rememberMe.getValue() + "<br/>"
			);
		}
		
		response.getWriter().println(
		"Weak Randomness Test java.util.Random.nextDouble() executed"
		);
	}
	
}
