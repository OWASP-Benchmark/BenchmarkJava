package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00595")
public class BenchmarkTest00595 extends HttpServlet {
	
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
		String a47183 = param; //assign
		StringBuilder b47183 = new StringBuilder(a47183);  // stick in stringbuilder
		b47183.append(" SafeStuff"); // append some safe content
		b47183.replace(b47183.length()-"Chars".length(),b47183.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47183 = new java.util.HashMap<String,Object>();
		map47183.put("key47183", b47183.toString()); // put in a collection
		String c47183 = (String)map47183.get("key47183"); // get it back out
		String d47183 = c47183.substring(0,c47183.length()-1); // extract most of it
		String e47183 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47183.getBytes() ) )); // B64 encode and decode it
		String f47183 = e47183.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g47183 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47183); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
