package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00603")
public class BenchmarkTest00603 extends HttpServlet {
	
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
		String a32613 = param; //assign
		StringBuilder b32613 = new StringBuilder(a32613);  // stick in stringbuilder
		b32613.append(" SafeStuff"); // append some safe content
		b32613.replace(b32613.length()-"Chars".length(),b32613.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32613 = new java.util.HashMap<String,Object>();
		map32613.put("key32613", b32613.toString()); // put in a collection
		String c32613 = (String)map32613.get("key32613"); // get it back out
		String d32613 = c32613.substring(0,c32613.length()-1); // extract most of it
		String e32613 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32613.getBytes() ) )); // B64 encode and decode it
		String f32613 = e32613.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g32613 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g32613); // reflection
		
		
		response.getWriter().println(bar);
	}
}
