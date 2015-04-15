package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05121")
public class BenchmarkTest05121 extends HttpServlet {
	
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
		String a39184 = param; //assign
		StringBuilder b39184 = new StringBuilder(a39184);  // stick in stringbuilder
		b39184.append(" SafeStuff"); // append some safe content
		b39184.replace(b39184.length()-"Chars".length(),b39184.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39184 = new java.util.HashMap<String,Object>();
		map39184.put("key39184", b39184.toString()); // put in a collection
		String c39184 = (String)map39184.get("key39184"); // get it back out
		String d39184 = c39184.substring(0,c39184.length()-1); // extract most of it
		String e39184 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39184.getBytes() ) )); // B64 encode and decode it
		String f39184 = e39184.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f39184); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
