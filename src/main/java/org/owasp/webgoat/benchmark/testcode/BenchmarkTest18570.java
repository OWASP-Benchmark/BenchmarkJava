package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18570")
public class BenchmarkTest18570 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52101 = param; //assign
		StringBuilder b52101 = new StringBuilder(a52101);  // stick in stringbuilder
		b52101.append(" SafeStuff"); // append some safe content
		b52101.replace(b52101.length()-"Chars".length(),b52101.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52101 = new java.util.HashMap<String,Object>();
		map52101.put("key52101", b52101.toString()); // put in a collection
		String c52101 = (String)map52101.get("key52101"); // get it back out
		String d52101 = c52101.substring(0,c52101.length()-1); // extract most of it
		String e52101 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52101.getBytes() ) )); // B64 encode and decode it
		String f52101 = e52101.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52101 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52101); // reflection
	
		return bar;	
	}
}
