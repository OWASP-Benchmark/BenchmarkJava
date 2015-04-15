package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05067")
public class BenchmarkTest05067 extends HttpServlet {
	
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
		String a73742 = param; //assign
		StringBuilder b73742 = new StringBuilder(a73742);  // stick in stringbuilder
		b73742.append(" SafeStuff"); // append some safe content
		b73742.replace(b73742.length()-"Chars".length(),b73742.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73742 = new java.util.HashMap<String,Object>();
		map73742.put("key73742", b73742.toString()); // put in a collection
		String c73742 = (String)map73742.get("key73742"); // get it back out
		String d73742 = c73742.substring(0,c73742.length()-1); // extract most of it
		String e73742 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73742.getBytes() ) )); // B64 encode and decode it
		String f73742 = e73742.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73742); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
