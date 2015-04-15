package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20677")
public class BenchmarkTest20677 extends HttpServlet {
	
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
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70762 = param; //assign
		StringBuilder b70762 = new StringBuilder(a70762);  // stick in stringbuilder
		b70762.append(" SafeStuff"); // append some safe content
		b70762.replace(b70762.length()-"Chars".length(),b70762.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70762 = new java.util.HashMap<String,Object>();
		map70762.put("key70762", b70762.toString()); // put in a collection
		String c70762 = (String)map70762.get("key70762"); // get it back out
		String d70762 = c70762.substring(0,c70762.length()-1); // extract most of it
		String e70762 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70762.getBytes() ) )); // B64 encode and decode it
		String f70762 = e70762.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70762); // reflection
	
		return bar;	
	}
}
