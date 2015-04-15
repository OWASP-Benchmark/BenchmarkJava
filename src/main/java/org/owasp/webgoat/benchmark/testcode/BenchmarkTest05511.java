package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05511")
public class BenchmarkTest05511 extends HttpServlet {
	
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
		String a52905 = param; //assign
		StringBuilder b52905 = new StringBuilder(a52905);  // stick in stringbuilder
		b52905.append(" SafeStuff"); // append some safe content
		b52905.replace(b52905.length()-"Chars".length(),b52905.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52905 = new java.util.HashMap<String,Object>();
		map52905.put("key52905", b52905.toString()); // put in a collection
		String c52905 = (String)map52905.get("key52905"); // get it back out
		String d52905 = c52905.substring(0,c52905.length()-1); // extract most of it
		String e52905 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52905.getBytes() ) )); // B64 encode and decode it
		String f52905 = e52905.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52905 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52905); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
