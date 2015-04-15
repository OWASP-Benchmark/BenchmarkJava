package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01335")
public class BenchmarkTest01335 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a86383 = param; //assign
		StringBuilder b86383 = new StringBuilder(a86383);  // stick in stringbuilder
		b86383.append(" SafeStuff"); // append some safe content
		b86383.replace(b86383.length()-"Chars".length(),b86383.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86383 = new java.util.HashMap<String,Object>();
		map86383.put("key86383", b86383.toString()); // put in a collection
		String c86383 = (String)map86383.get("key86383"); // get it back out
		String d86383 = c86383.substring(0,c86383.length()-1); // extract most of it
		String e86383 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86383.getBytes() ) )); // B64 encode and decode it
		String f86383 = e86383.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86383); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
