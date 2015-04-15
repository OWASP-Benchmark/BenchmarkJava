package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06638")
public class BenchmarkTest06638 extends HttpServlet {
	
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
		String a82449 = param; //assign
		StringBuilder b82449 = new StringBuilder(a82449);  // stick in stringbuilder
		b82449.append(" SafeStuff"); // append some safe content
		b82449.replace(b82449.length()-"Chars".length(),b82449.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82449 = new java.util.HashMap<String,Object>();
		map82449.put("key82449", b82449.toString()); // put in a collection
		String c82449 = (String)map82449.get("key82449"); // get it back out
		String d82449 = c82449.substring(0,c82449.length()-1); // extract most of it
		String e82449 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82449.getBytes() ) )); // B64 encode and decode it
		String f82449 = e82449.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g82449 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82449); // reflection
		
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}
}
