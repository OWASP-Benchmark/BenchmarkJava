package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20630")
public class BenchmarkTest20630 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6253 = param; //assign
		StringBuilder b6253 = new StringBuilder(a6253);  // stick in stringbuilder
		b6253.append(" SafeStuff"); // append some safe content
		b6253.replace(b6253.length()-"Chars".length(),b6253.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6253 = new java.util.HashMap<String,Object>();
		map6253.put("key6253", b6253.toString()); // put in a collection
		String c6253 = (String)map6253.get("key6253"); // get it back out
		String d6253 = c6253.substring(0,c6253.length()-1); // extract most of it
		String e6253 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6253.getBytes() ) )); // B64 encode and decode it
		String f6253 = e6253.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g6253 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6253); // reflection
	
		return bar;	
	}
}
