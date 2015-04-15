package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00689")
public class BenchmarkTest00689 extends HttpServlet {
	
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
		String a88456 = param; //assign
		StringBuilder b88456 = new StringBuilder(a88456);  // stick in stringbuilder
		b88456.append(" SafeStuff"); // append some safe content
		b88456.replace(b88456.length()-"Chars".length(),b88456.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88456 = new java.util.HashMap<String,Object>();
		map88456.put("key88456", b88456.toString()); // put in a collection
		String c88456 = (String)map88456.get("key88456"); // get it back out
		String d88456 = c88456.substring(0,c88456.length()-1); // extract most of it
		String e88456 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88456.getBytes() ) )); // B64 encode and decode it
		String f88456 = e88456.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88456); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
