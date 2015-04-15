package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05070")
public class BenchmarkTest05070 extends HttpServlet {
	
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
		String a61689 = param; //assign
		StringBuilder b61689 = new StringBuilder(a61689);  // stick in stringbuilder
		b61689.append(" SafeStuff"); // append some safe content
		b61689.replace(b61689.length()-"Chars".length(),b61689.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61689 = new java.util.HashMap<String,Object>();
		map61689.put("key61689", b61689.toString()); // put in a collection
		String c61689 = (String)map61689.get("key61689"); // get it back out
		String d61689 = c61689.substring(0,c61689.length()-1); // extract most of it
		String e61689 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61689.getBytes() ) )); // B64 encode and decode it
		String f61689 = e61689.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61689 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61689); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
