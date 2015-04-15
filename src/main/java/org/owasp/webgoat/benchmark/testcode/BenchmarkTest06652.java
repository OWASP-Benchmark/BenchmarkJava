package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06652")
public class BenchmarkTest06652 extends HttpServlet {
	
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
		String a86164 = param; //assign
		StringBuilder b86164 = new StringBuilder(a86164);  // stick in stringbuilder
		b86164.append(" SafeStuff"); // append some safe content
		b86164.replace(b86164.length()-"Chars".length(),b86164.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86164 = new java.util.HashMap<String,Object>();
		map86164.put("key86164", b86164.toString()); // put in a collection
		String c86164 = (String)map86164.get("key86164"); // get it back out
		String d86164 = c86164.substring(0,c86164.length()-1); // extract most of it
		String e86164 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86164.getBytes() ) )); // B64 encode and decode it
		String f86164 = e86164.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86164); // reflection
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
