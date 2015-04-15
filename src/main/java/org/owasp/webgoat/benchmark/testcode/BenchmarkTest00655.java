package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00655")
public class BenchmarkTest00655 extends HttpServlet {
	
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
		String a19924 = param; //assign
		StringBuilder b19924 = new StringBuilder(a19924);  // stick in stringbuilder
		b19924.append(" SafeStuff"); // append some safe content
		b19924.replace(b19924.length()-"Chars".length(),b19924.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19924 = new java.util.HashMap<String,Object>();
		map19924.put("key19924", b19924.toString()); // put in a collection
		String c19924 = (String)map19924.get("key19924"); // get it back out
		String d19924 = c19924.substring(0,c19924.length()-1); // extract most of it
		String e19924 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19924.getBytes() ) )); // B64 encode and decode it
		String f19924 = e19924.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f19924); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
