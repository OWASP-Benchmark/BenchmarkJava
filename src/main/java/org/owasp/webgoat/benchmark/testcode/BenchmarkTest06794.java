package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06794")
public class BenchmarkTest06794 extends HttpServlet {
	
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
		String a88489 = param; //assign
		StringBuilder b88489 = new StringBuilder(a88489);  // stick in stringbuilder
		b88489.append(" SafeStuff"); // append some safe content
		b88489.replace(b88489.length()-"Chars".length(),b88489.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88489 = new java.util.HashMap<String,Object>();
		map88489.put("key88489", b88489.toString()); // put in a collection
		String c88489 = (String)map88489.get("key88489"); // get it back out
		String d88489 = c88489.substring(0,c88489.length()-1); // extract most of it
		String e88489 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88489.getBytes() ) )); // B64 encode and decode it
		String f88489 = e88489.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88489); // reflection
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
