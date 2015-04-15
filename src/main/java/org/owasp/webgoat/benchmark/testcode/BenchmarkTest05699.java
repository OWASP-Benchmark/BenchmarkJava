package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05699")
public class BenchmarkTest05699 extends HttpServlet {
	
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
		String a60137 = param; //assign
		StringBuilder b60137 = new StringBuilder(a60137);  // stick in stringbuilder
		b60137.append(" SafeStuff"); // append some safe content
		b60137.replace(b60137.length()-"Chars".length(),b60137.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60137 = new java.util.HashMap<String,Object>();
		map60137.put("key60137", b60137.toString()); // put in a collection
		String c60137 = (String)map60137.get("key60137"); // get it back out
		String d60137 = c60137.substring(0,c60137.length()-1); // extract most of it
		String e60137 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60137.getBytes() ) )); // B64 encode and decode it
		String f60137 = e60137.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g60137 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g60137); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
