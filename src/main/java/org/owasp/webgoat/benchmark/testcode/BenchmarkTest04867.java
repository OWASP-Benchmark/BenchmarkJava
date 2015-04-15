package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04867")
public class BenchmarkTest04867 extends HttpServlet {
	
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
		String a64430 = param; //assign
		StringBuilder b64430 = new StringBuilder(a64430);  // stick in stringbuilder
		b64430.append(" SafeStuff"); // append some safe content
		b64430.replace(b64430.length()-"Chars".length(),b64430.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64430 = new java.util.HashMap<String,Object>();
		map64430.put("key64430", b64430.toString()); // put in a collection
		String c64430 = (String)map64430.get("key64430"); // get it back out
		String d64430 = c64430.substring(0,c64430.length()-1); // extract most of it
		String e64430 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64430.getBytes() ) )); // B64 encode and decode it
		String f64430 = e64430.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64430 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64430); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
