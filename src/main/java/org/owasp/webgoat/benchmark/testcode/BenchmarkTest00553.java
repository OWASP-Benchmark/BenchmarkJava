package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00553")
public class BenchmarkTest00553 extends HttpServlet {
	
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
		String a27771 = param; //assign
		StringBuilder b27771 = new StringBuilder(a27771);  // stick in stringbuilder
		b27771.append(" SafeStuff"); // append some safe content
		b27771.replace(b27771.length()-"Chars".length(),b27771.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27771 = new java.util.HashMap<String,Object>();
		map27771.put("key27771", b27771.toString()); // put in a collection
		String c27771 = (String)map27771.get("key27771"); // get it back out
		String d27771 = c27771.substring(0,c27771.length()-1); // extract most of it
		String e27771 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27771.getBytes() ) )); // B64 encode and decode it
		String f27771 = e27771.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g27771 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g27771); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
