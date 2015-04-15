package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05014")
public class BenchmarkTest05014 extends HttpServlet {
	
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
		String a44668 = param; //assign
		StringBuilder b44668 = new StringBuilder(a44668);  // stick in stringbuilder
		b44668.append(" SafeStuff"); // append some safe content
		b44668.replace(b44668.length()-"Chars".length(),b44668.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44668 = new java.util.HashMap<String,Object>();
		map44668.put("key44668", b44668.toString()); // put in a collection
		String c44668 = (String)map44668.get("key44668"); // get it back out
		String d44668 = c44668.substring(0,c44668.length()-1); // extract most of it
		String e44668 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44668.getBytes() ) )); // B64 encode and decode it
		String f44668 = e44668.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g44668 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44668); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
