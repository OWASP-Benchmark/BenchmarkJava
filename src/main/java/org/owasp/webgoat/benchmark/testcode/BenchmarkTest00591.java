package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00591")
public class BenchmarkTest00591 extends HttpServlet {
	
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
		String a50578 = param; //assign
		StringBuilder b50578 = new StringBuilder(a50578);  // stick in stringbuilder
		b50578.append(" SafeStuff"); // append some safe content
		b50578.replace(b50578.length()-"Chars".length(),b50578.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50578 = new java.util.HashMap<String,Object>();
		map50578.put("key50578", b50578.toString()); // put in a collection
		String c50578 = (String)map50578.get("key50578"); // get it back out
		String d50578 = c50578.substring(0,c50578.length()-1); // extract most of it
		String e50578 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50578.getBytes() ) )); // B64 encode and decode it
		String f50578 = e50578.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g50578 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g50578); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
