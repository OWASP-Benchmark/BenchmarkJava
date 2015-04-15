package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05106")
public class BenchmarkTest05106 extends HttpServlet {
	
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
		String a81594 = param; //assign
		StringBuilder b81594 = new StringBuilder(a81594);  // stick in stringbuilder
		b81594.append(" SafeStuff"); // append some safe content
		b81594.replace(b81594.length()-"Chars".length(),b81594.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81594 = new java.util.HashMap<String,Object>();
		map81594.put("key81594", b81594.toString()); // put in a collection
		String c81594 = (String)map81594.get("key81594"); // get it back out
		String d81594 = c81594.substring(0,c81594.length()-1); // extract most of it
		String e81594 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81594.getBytes() ) )); // B64 encode and decode it
		String f81594 = e81594.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g81594 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g81594); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
