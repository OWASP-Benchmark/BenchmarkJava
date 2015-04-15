package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00621")
public class BenchmarkTest00621 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a73713 = param; //assign
		StringBuilder b73713 = new StringBuilder(a73713);  // stick in stringbuilder
		b73713.append(" SafeStuff"); // append some safe content
		b73713.replace(b73713.length()-"Chars".length(),b73713.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73713 = new java.util.HashMap<String,Object>();
		map73713.put("key73713", b73713.toString()); // put in a collection
		String c73713 = (String)map73713.get("key73713"); // get it back out
		String d73713 = c73713.substring(0,c73713.length()-1); // extract most of it
		String e73713 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73713.getBytes() ) )); // B64 encode and decode it
		String f73713 = e73713.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73713); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
