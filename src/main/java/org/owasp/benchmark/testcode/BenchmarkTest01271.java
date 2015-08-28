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

@WebServlet("/BenchmarkTest01271")
public class BenchmarkTest01271 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getParameter("vector");
		if (param == null) param = "";

		String bar = new Test().doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		String rememberMeKey = Float.toString(rand).substring(2); // Trim off the 0. at the front.
		
		String user = "Floyd";
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
			response.getWriter().println("Welcome back: " + user + "<br/>");			
		} else {			
			javax.servlet.http.Cookie rememberMe = new javax.servlet.http.Cookie(cookieName, rememberMeKey);
			rememberMe.setSecure(true);
            rememberMe.setPath("/benchmark/" + this.getClass().getSimpleName());
			request.getSession().setAttribute(cookieName, rememberMeKey);
			response.addCookie(rememberMe);
			response.getWriter().println(user + " has been remembered with cookie: " + rememberMe.getName() 
					+ " whose value is: " + rememberMe.getValue() + "<br/>");
		}
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33059 = param; //assign
		StringBuilder b33059 = new StringBuilder(a33059);  // stick in stringbuilder
		b33059.append(" SafeStuff"); // append some safe content
		b33059.replace(b33059.length()-"Chars".length(),b33059.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33059 = new java.util.HashMap<String,Object>();
		map33059.put("key33059", b33059.toString()); // put in a collection
		String c33059 = (String)map33059.get("key33059"); // get it back out
		String d33059 = c33059.substring(0,c33059.length()-1); // extract most of it
		String e33059 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33059.getBytes() ) )); // B64 encode and decode it
		String f33059 = e33059.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g33059 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g33059); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
