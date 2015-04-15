package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06971")
public class BenchmarkTest06971 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a6613 = param; //assign
		StringBuilder b6613 = new StringBuilder(a6613);  // stick in stringbuilder
		b6613.append(" SafeStuff"); // append some safe content
		b6613.replace(b6613.length()-"Chars".length(),b6613.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6613 = new java.util.HashMap<String,Object>();
		map6613.put("key6613", b6613.toString()); // put in a collection
		String c6613 = (String)map6613.get("key6613"); // get it back out
		String d6613 = c6613.substring(0,c6613.length()-1); // extract most of it
		String e6613 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6613.getBytes() ) )); // B64 encode and decode it
		String f6613 = e6613.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6613); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
