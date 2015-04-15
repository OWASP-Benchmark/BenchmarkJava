package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02624")
public class BenchmarkTest02624 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a39887 = param; //assign
		StringBuilder b39887 = new StringBuilder(a39887);  // stick in stringbuilder
		b39887.append(" SafeStuff"); // append some safe content
		b39887.replace(b39887.length()-"Chars".length(),b39887.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39887 = new java.util.HashMap<String,Object>();
		map39887.put("key39887", b39887.toString()); // put in a collection
		String c39887 = (String)map39887.get("key39887"); // get it back out
		String d39887 = c39887.substring(0,c39887.length()-1); // extract most of it
		String e39887 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39887.getBytes() ) )); // B64 encode and decode it
		String f39887 = e39887.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f39887); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
