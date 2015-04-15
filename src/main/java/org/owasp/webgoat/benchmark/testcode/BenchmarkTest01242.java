package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01242")
public class BenchmarkTest01242 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a82789 = param; //assign
		StringBuilder b82789 = new StringBuilder(a82789);  // stick in stringbuilder
		b82789.append(" SafeStuff"); // append some safe content
		b82789.replace(b82789.length()-"Chars".length(),b82789.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82789 = new java.util.HashMap<String,Object>();
		map82789.put("key82789", b82789.toString()); // put in a collection
		String c82789 = (String)map82789.get("key82789"); // get it back out
		String d82789 = c82789.substring(0,c82789.length()-1); // extract most of it
		String e82789 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82789.getBytes() ) )); // B64 encode and decode it
		String f82789 = e82789.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82789); // reflection
		
		
		response.getWriter().write(bar);
	}
}
