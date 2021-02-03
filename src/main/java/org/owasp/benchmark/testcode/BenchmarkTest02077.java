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

@WebServlet(value="/weakrand-04/BenchmarkTest02077")
public class BenchmarkTest02077 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest02077");
		
		if (headers != null && headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		// URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = doSomething(request, param);
		
	    try {
		    java.security.SecureRandom secureRandomGenerator = java.security.SecureRandom.getInstance("SHA1PRNG");
		
		    // Get 40 random bytes
		    byte[] randomBytes = new byte[40];
		    secureRandomGenerator.nextBytes(randomBytes);
		    
	        String rememberMeKey = org.owasp.esapi.ESAPI.encoder().encodeForBase64(randomBytes, true);
	
			String user = "SafeByron";
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
				rememberMe.setPath(request.getRequestURI()); // i.e., set path to JUST this servlet 
															 // e.g., /benchmark/sql-01/BenchmarkTest01001
				request.getSession().setAttribute(cookieName, rememberMeKey);
				response.addCookie(rememberMe);
				response.getWriter().println(
user + " has been remembered with cookie: " + rememberMe.getName() 
						+ " whose value is: " + rememberMe.getValue() + "<br/>"
);
			}  
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextBytes() - TestCase");
			throw new ServletException(e);
	    } finally {
			response.getWriter().println(
"Randomness Test java.security.SecureRandom.nextBytes(byte[]) executed"
);
	    }
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a78258 = param; //assign
		StringBuilder b78258 = new StringBuilder(a78258);  // stick in stringbuilder
		b78258.append(" SafeStuff"); // append some safe content
		b78258.replace(b78258.length()-"Chars".length(),b78258.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78258 = new java.util.HashMap<String,Object>();
		map78258.put("key78258", b78258.toString()); // put in a collection
		String c78258 = (String)map78258.get("key78258"); // get it back out
		String d78258 = c78258.substring(0,c78258.length()-1); // extract most of it
		String e78258 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d78258.getBytes() ) )); // B64 encode and decode it
		String f78258 = e78258.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g78258 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78258); // reflection
	
		return bar;	
	}
}
