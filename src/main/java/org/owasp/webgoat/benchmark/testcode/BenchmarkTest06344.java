package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06344")
public class BenchmarkTest06344 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a82973 = param; //assign
		StringBuilder b82973 = new StringBuilder(a82973);  // stick in stringbuilder
		b82973.append(" SafeStuff"); // append some safe content
		b82973.replace(b82973.length()-"Chars".length(),b82973.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82973 = new java.util.HashMap<String,Object>();
		map82973.put("key82973", b82973.toString()); // put in a collection
		String c82973 = (String)map82973.get("key82973"); // get it back out
		String d82973 = c82973.substring(0,c82973.length()-1); // extract most of it
		String e82973 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82973.getBytes() ) )); // B64 encode and decode it
		String f82973 = e82973.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g82973 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82973); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
