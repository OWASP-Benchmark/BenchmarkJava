package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05127")
public class BenchmarkTest05127 extends HttpServlet {
	
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
		String a72579 = param; //assign
		StringBuilder b72579 = new StringBuilder(a72579);  // stick in stringbuilder
		b72579.append(" SafeStuff"); // append some safe content
		b72579.replace(b72579.length()-"Chars".length(),b72579.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72579 = new java.util.HashMap<String,Object>();
		map72579.put("key72579", b72579.toString()); // put in a collection
		String c72579 = (String)map72579.get("key72579"); // get it back out
		String d72579 = c72579.substring(0,c72579.length()-1); // extract most of it
		String e72579 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72579.getBytes() ) )); // B64 encode and decode it
		String f72579 = e72579.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72579); // reflection
		
		
		response.addHeader("SomeHeader", bar);
	}
}
