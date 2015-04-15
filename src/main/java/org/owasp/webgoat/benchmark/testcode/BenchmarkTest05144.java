package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05144")
public class BenchmarkTest05144 extends HttpServlet {
	
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
		String a99345 = param; //assign
		StringBuilder b99345 = new StringBuilder(a99345);  // stick in stringbuilder
		b99345.append(" SafeStuff"); // append some safe content
		b99345.replace(b99345.length()-"Chars".length(),b99345.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99345 = new java.util.HashMap<String,Object>();
		map99345.put("key99345", b99345.toString()); // put in a collection
		String c99345 = (String)map99345.get("key99345"); // get it back out
		String d99345 = c99345.substring(0,c99345.length()-1); // extract most of it
		String e99345 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99345.getBytes() ) )); // B64 encode and decode it
		String f99345 = e99345.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g99345 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g99345); // reflection
		
		
		response.setHeader("SomeHeader", bar);
	}
}
