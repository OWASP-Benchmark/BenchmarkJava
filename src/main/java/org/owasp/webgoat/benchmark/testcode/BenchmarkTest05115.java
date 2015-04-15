package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05115")
public class BenchmarkTest05115 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a57164 = param; //assign
		StringBuilder b57164 = new StringBuilder(a57164);  // stick in stringbuilder
		b57164.append(" SafeStuff"); // append some safe content
		b57164.replace(b57164.length()-"Chars".length(),b57164.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57164 = new java.util.HashMap<String,Object>();
		map57164.put("key57164", b57164.toString()); // put in a collection
		String c57164 = (String)map57164.get("key57164"); // get it back out
		String d57164 = c57164.substring(0,c57164.length()-1); // extract most of it
		String e57164 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57164.getBytes() ) )); // B64 encode and decode it
		String f57164 = e57164.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57164); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
