package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00600")
public class BenchmarkTest00600 extends HttpServlet {
	
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
		String a64394 = param; //assign
		StringBuilder b64394 = new StringBuilder(a64394);  // stick in stringbuilder
		b64394.append(" SafeStuff"); // append some safe content
		b64394.replace(b64394.length()-"Chars".length(),b64394.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64394 = new java.util.HashMap<String,Object>();
		map64394.put("key64394", b64394.toString()); // put in a collection
		String c64394 = (String)map64394.get("key64394"); // get it back out
		String d64394 = c64394.substring(0,c64394.length()-1); // extract most of it
		String e64394 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64394.getBytes() ) )); // B64 encode and decode it
		String f64394 = e64394.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64394); // reflection
		
		
		response.getWriter().println(bar);
	}
}
