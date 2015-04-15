package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05061")
public class BenchmarkTest05061 extends HttpServlet {
	
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
		String a98388 = param; //assign
		StringBuilder b98388 = new StringBuilder(a98388);  // stick in stringbuilder
		b98388.append(" SafeStuff"); // append some safe content
		b98388.replace(b98388.length()-"Chars".length(),b98388.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98388 = new java.util.HashMap<String,Object>();
		map98388.put("key98388", b98388.toString()); // put in a collection
		String c98388 = (String)map98388.get("key98388"); // get it back out
		String d98388 = c98388.substring(0,c98388.length()-1); // extract most of it
		String e98388 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98388.getBytes() ) )); // B64 encode and decode it
		String f98388 = e98388.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f98388); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
