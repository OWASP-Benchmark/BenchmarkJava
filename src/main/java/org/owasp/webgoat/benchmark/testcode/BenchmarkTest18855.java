package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18855")
public class BenchmarkTest18855 extends HttpServlet {
	
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
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15166 = param; //assign
		StringBuilder b15166 = new StringBuilder(a15166);  // stick in stringbuilder
		b15166.append(" SafeStuff"); // append some safe content
		b15166.replace(b15166.length()-"Chars".length(),b15166.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15166 = new java.util.HashMap<String,Object>();
		map15166.put("key15166", b15166.toString()); // put in a collection
		String c15166 = (String)map15166.get("key15166"); // get it back out
		String d15166 = c15166.substring(0,c15166.length()-1); // extract most of it
		String e15166 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15166.getBytes() ) )); // B64 encode and decode it
		String f15166 = e15166.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g15166 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g15166); // reflection
	
		return bar;	
	}
}
