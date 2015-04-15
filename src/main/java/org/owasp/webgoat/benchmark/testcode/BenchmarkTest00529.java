package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00529")
public class BenchmarkTest00529 extends HttpServlet {
	
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
		String a32454 = param; //assign
		StringBuilder b32454 = new StringBuilder(a32454);  // stick in stringbuilder
		b32454.append(" SafeStuff"); // append some safe content
		b32454.replace(b32454.length()-"Chars".length(),b32454.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32454 = new java.util.HashMap<String,Object>();
		map32454.put("key32454", b32454.toString()); // put in a collection
		String c32454 = (String)map32454.get("key32454"); // get it back out
		String d32454 = c32454.substring(0,c32454.length()-1); // extract most of it
		String e32454 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32454.getBytes() ) )); // B64 encode and decode it
		String f32454 = e32454.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32454); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}
}
