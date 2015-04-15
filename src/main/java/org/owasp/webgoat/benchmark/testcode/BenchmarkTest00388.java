package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00388")
public class BenchmarkTest00388 extends HttpServlet {
	
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
		String a41194 = param; //assign
		StringBuilder b41194 = new StringBuilder(a41194);  // stick in stringbuilder
		b41194.append(" SafeStuff"); // append some safe content
		b41194.replace(b41194.length()-"Chars".length(),b41194.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41194 = new java.util.HashMap<String,Object>();
		map41194.put("key41194", b41194.toString()); // put in a collection
		String c41194 = (String)map41194.get("key41194"); // get it back out
		String d41194 = c41194.substring(0,c41194.length()-1); // extract most of it
		String e41194 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41194.getBytes() ) )); // B64 encode and decode it
		String f41194 = e41194.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f41194); // reflection
		
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}
}
