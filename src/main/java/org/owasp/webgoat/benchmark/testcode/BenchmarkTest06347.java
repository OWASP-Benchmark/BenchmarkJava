package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06347")
public class BenchmarkTest06347 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a4568 = param; //assign
		StringBuilder b4568 = new StringBuilder(a4568);  // stick in stringbuilder
		b4568.append(" SafeStuff"); // append some safe content
		b4568.replace(b4568.length()-"Chars".length(),b4568.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4568 = new java.util.HashMap<String,Object>();
		map4568.put("key4568", b4568.toString()); // put in a collection
		String c4568 = (String)map4568.get("key4568"); // get it back out
		String d4568 = c4568.substring(0,c4568.length()-1); // extract most of it
		String e4568 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4568.getBytes() ) )); // B64 encode and decode it
		String f4568 = e4568.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4568); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
