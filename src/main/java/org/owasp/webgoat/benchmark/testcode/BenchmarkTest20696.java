package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20696")
public class BenchmarkTest20696 extends HttpServlet {
	
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
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83803 = param; //assign
		StringBuilder b83803 = new StringBuilder(a83803);  // stick in stringbuilder
		b83803.append(" SafeStuff"); // append some safe content
		b83803.replace(b83803.length()-"Chars".length(),b83803.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83803 = new java.util.HashMap<String,Object>();
		map83803.put("key83803", b83803.toString()); // put in a collection
		String c83803 = (String)map83803.get("key83803"); // get it back out
		String d83803 = c83803.substring(0,c83803.length()-1); // extract most of it
		String e83803 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83803.getBytes() ) )); // B64 encode and decode it
		String f83803 = e83803.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83803 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83803); // reflection
	
		return bar;	
	}
}
