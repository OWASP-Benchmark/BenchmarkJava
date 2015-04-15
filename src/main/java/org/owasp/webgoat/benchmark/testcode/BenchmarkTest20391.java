package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20391")
public class BenchmarkTest20391 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9099 = param; //assign
		StringBuilder b9099 = new StringBuilder(a9099);  // stick in stringbuilder
		b9099.append(" SafeStuff"); // append some safe content
		b9099.replace(b9099.length()-"Chars".length(),b9099.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9099 = new java.util.HashMap<String,Object>();
		map9099.put("key9099", b9099.toString()); // put in a collection
		String c9099 = (String)map9099.get("key9099"); // get it back out
		String d9099 = c9099.substring(0,c9099.length()-1); // extract most of it
		String e9099 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9099.getBytes() ) )); // B64 encode and decode it
		String f9099 = e9099.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g9099 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9099); // reflection
	
		return bar;	
	}
}
