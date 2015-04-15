package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01345")
public class BenchmarkTest01345 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a88627 = param; //assign
		StringBuilder b88627 = new StringBuilder(a88627);  // stick in stringbuilder
		b88627.append(" SafeStuff"); // append some safe content
		b88627.replace(b88627.length()-"Chars".length(),b88627.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88627 = new java.util.HashMap<String,Object>();
		map88627.put("key88627", b88627.toString()); // put in a collection
		String c88627 = (String)map88627.get("key88627"); // get it back out
		String d88627 = c88627.substring(0,c88627.length()-1); // extract most of it
		String e88627 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88627.getBytes() ) )); // B64 encode and decode it
		String f88627 = e88627.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g88627 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88627); // reflection
		
		
		response.addHeader(bar, "SomeValue");
	}
}
