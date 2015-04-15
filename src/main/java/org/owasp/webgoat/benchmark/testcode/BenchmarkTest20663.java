package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20663")
public class BenchmarkTest20663 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47847 = param; //assign
		StringBuilder b47847 = new StringBuilder(a47847);  // stick in stringbuilder
		b47847.append(" SafeStuff"); // append some safe content
		b47847.replace(b47847.length()-"Chars".length(),b47847.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47847 = new java.util.HashMap<String,Object>();
		map47847.put("key47847", b47847.toString()); // put in a collection
		String c47847 = (String)map47847.get("key47847"); // get it back out
		String d47847 = c47847.substring(0,c47847.length()-1); // extract most of it
		String e47847 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47847.getBytes() ) )); // B64 encode and decode it
		String f47847 = e47847.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47847); // reflection
	
		return bar;	
	}
}
