package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05084")
public class BenchmarkTest05084 extends HttpServlet {
	
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
		String a53578 = param; //assign
		StringBuilder b53578 = new StringBuilder(a53578);  // stick in stringbuilder
		b53578.append(" SafeStuff"); // append some safe content
		b53578.replace(b53578.length()-"Chars".length(),b53578.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53578 = new java.util.HashMap<String,Object>();
		map53578.put("key53578", b53578.toString()); // put in a collection
		String c53578 = (String)map53578.get("key53578"); // get it back out
		String d53578 = c53578.substring(0,c53578.length()-1); // extract most of it
		String e53578 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53578.getBytes() ) )); // B64 encode and decode it
		String f53578 = e53578.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f53578); // reflection
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
