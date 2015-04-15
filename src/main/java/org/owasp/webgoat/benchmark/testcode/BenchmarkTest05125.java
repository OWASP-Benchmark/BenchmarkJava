package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05125")
public class BenchmarkTest05125 extends HttpServlet {
	
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
		String a14101 = param; //assign
		StringBuilder b14101 = new StringBuilder(a14101);  // stick in stringbuilder
		b14101.append(" SafeStuff"); // append some safe content
		b14101.replace(b14101.length()-"Chars".length(),b14101.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14101 = new java.util.HashMap<String,Object>();
		map14101.put("key14101", b14101.toString()); // put in a collection
		String c14101 = (String)map14101.get("key14101"); // get it back out
		String d14101 = c14101.substring(0,c14101.length()-1); // extract most of it
		String e14101 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14101.getBytes() ) )); // B64 encode and decode it
		String f14101 = e14101.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g14101 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g14101); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
