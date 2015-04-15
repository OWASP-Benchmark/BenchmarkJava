package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02553")
public class BenchmarkTest02553 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a89359 = param; //assign
		StringBuilder b89359 = new StringBuilder(a89359);  // stick in stringbuilder
		b89359.append(" SafeStuff"); // append some safe content
		b89359.replace(b89359.length()-"Chars".length(),b89359.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89359 = new java.util.HashMap<String,Object>();
		map89359.put("key89359", b89359.toString()); // put in a collection
		String c89359 = (String)map89359.get("key89359"); // get it back out
		String d89359 = c89359.substring(0,c89359.length()-1); // extract most of it
		String e89359 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89359.getBytes() ) )); // B64 encode and decode it
		String f89359 = e89359.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g89359 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89359); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
