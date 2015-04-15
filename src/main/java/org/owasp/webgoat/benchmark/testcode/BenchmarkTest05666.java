package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05666")
public class BenchmarkTest05666 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a40494 = param; //assign
		StringBuilder b40494 = new StringBuilder(a40494);  // stick in stringbuilder
		b40494.append(" SafeStuff"); // append some safe content
		b40494.replace(b40494.length()-"Chars".length(),b40494.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40494 = new java.util.HashMap<String,Object>();
		map40494.put("key40494", b40494.toString()); // put in a collection
		String c40494 = (String)map40494.get("key40494"); // get it back out
		String d40494 = c40494.substring(0,c40494.length()-1); // extract most of it
		String e40494 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40494.getBytes() ) )); // B64 encode and decode it
		String f40494 = e40494.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40494); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
