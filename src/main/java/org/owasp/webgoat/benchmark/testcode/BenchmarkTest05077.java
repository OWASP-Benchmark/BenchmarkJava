package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05077")
public class BenchmarkTest05077 extends HttpServlet {
	
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
		String a44875 = param; //assign
		StringBuilder b44875 = new StringBuilder(a44875);  // stick in stringbuilder
		b44875.append(" SafeStuff"); // append some safe content
		b44875.replace(b44875.length()-"Chars".length(),b44875.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44875 = new java.util.HashMap<String,Object>();
		map44875.put("key44875", b44875.toString()); // put in a collection
		String c44875 = (String)map44875.get("key44875"); // get it back out
		String d44875 = c44875.substring(0,c44875.length()-1); // extract most of it
		String e44875 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44875.getBytes() ) )); // B64 encode and decode it
		String f44875 = e44875.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44875); // reflection
		
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}
}
