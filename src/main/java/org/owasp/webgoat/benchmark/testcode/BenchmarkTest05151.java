package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05151")
public class BenchmarkTest05151 extends HttpServlet {
	
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
		String a26870 = param; //assign
		StringBuilder b26870 = new StringBuilder(a26870);  // stick in stringbuilder
		b26870.append(" SafeStuff"); // append some safe content
		b26870.replace(b26870.length()-"Chars".length(),b26870.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26870 = new java.util.HashMap<String,Object>();
		map26870.put("key26870", b26870.toString()); // put in a collection
		String c26870 = (String)map26870.get("key26870"); // get it back out
		String d26870 = c26870.substring(0,c26870.length()-1); // extract most of it
		String e26870 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26870.getBytes() ) )); // B64 encode and decode it
		String f26870 = e26870.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f26870); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
