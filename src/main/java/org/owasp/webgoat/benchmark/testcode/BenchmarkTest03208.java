package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03208")
public class BenchmarkTest03208 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a29794 = param; //assign
		StringBuilder b29794 = new StringBuilder(a29794);  // stick in stringbuilder
		b29794.append(" SafeStuff"); // append some safe content
		b29794.replace(b29794.length()-"Chars".length(),b29794.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29794 = new java.util.HashMap<String,Object>();
		map29794.put("key29794", b29794.toString()); // put in a collection
		String c29794 = (String)map29794.get("key29794"); // get it back out
		String d29794 = c29794.substring(0,c29794.length()-1); // extract most of it
		String e29794 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29794.getBytes() ) )); // B64 encode and decode it
		String f29794 = e29794.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29794); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
