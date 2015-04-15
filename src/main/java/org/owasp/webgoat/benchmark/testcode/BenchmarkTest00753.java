package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00753")
public class BenchmarkTest00753 extends HttpServlet {
	
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
		String a2249 = param; //assign
		StringBuilder b2249 = new StringBuilder(a2249);  // stick in stringbuilder
		b2249.append(" SafeStuff"); // append some safe content
		b2249.replace(b2249.length()-"Chars".length(),b2249.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2249 = new java.util.HashMap<String,Object>();
		map2249.put("key2249", b2249.toString()); // put in a collection
		String c2249 = (String)map2249.get("key2249"); // get it back out
		String d2249 = c2249.substring(0,c2249.length()-1); // extract most of it
		String e2249 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2249.getBytes() ) )); // B64 encode and decode it
		String f2249 = e2249.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g2249 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g2249); // reflection
		
		
		response.getWriter().write(bar);
	}
}
