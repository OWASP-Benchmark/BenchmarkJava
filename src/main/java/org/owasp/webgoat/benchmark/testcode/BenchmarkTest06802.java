package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06802")
public class BenchmarkTest06802 extends HttpServlet {
	
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
		String a70398 = param; //assign
		StringBuilder b70398 = new StringBuilder(a70398);  // stick in stringbuilder
		b70398.append(" SafeStuff"); // append some safe content
		b70398.replace(b70398.length()-"Chars".length(),b70398.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70398 = new java.util.HashMap<String,Object>();
		map70398.put("key70398", b70398.toString()); // put in a collection
		String c70398 = (String)map70398.get("key70398"); // get it back out
		String d70398 = c70398.substring(0,c70398.length()-1); // extract most of it
		String e70398 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70398.getBytes() ) )); // B64 encode and decode it
		String f70398 = e70398.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70398 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70398); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
