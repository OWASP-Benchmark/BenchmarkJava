package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06939")
public class BenchmarkTest06939 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a82203 = param; //assign
		StringBuilder b82203 = new StringBuilder(a82203);  // stick in stringbuilder
		b82203.append(" SafeStuff"); // append some safe content
		b82203.replace(b82203.length()-"Chars".length(),b82203.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82203 = new java.util.HashMap<String,Object>();
		map82203.put("key82203", b82203.toString()); // put in a collection
		String c82203 = (String)map82203.get("key82203"); // get it back out
		String d82203 = c82203.substring(0,c82203.length()-1); // extract most of it
		String e82203 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82203.getBytes() ) )); // B64 encode and decode it
		String f82203 = e82203.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82203); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
