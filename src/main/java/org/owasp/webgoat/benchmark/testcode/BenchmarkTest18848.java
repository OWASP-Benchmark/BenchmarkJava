package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18848")
public class BenchmarkTest18848 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86762 = param; //assign
		StringBuilder b86762 = new StringBuilder(a86762);  // stick in stringbuilder
		b86762.append(" SafeStuff"); // append some safe content
		b86762.replace(b86762.length()-"Chars".length(),b86762.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86762 = new java.util.HashMap<String,Object>();
		map86762.put("key86762", b86762.toString()); // put in a collection
		String c86762 = (String)map86762.get("key86762"); // get it back out
		String d86762 = c86762.substring(0,c86762.length()-1); // extract most of it
		String e86762 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86762.getBytes() ) )); // B64 encode and decode it
		String f86762 = e86762.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86762); // reflection
	
		return bar;	
	}
}
