package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20614")
public class BenchmarkTest20614 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a50123 = param; //assign
		StringBuilder b50123 = new StringBuilder(a50123);  // stick in stringbuilder
		b50123.append(" SafeStuff"); // append some safe content
		b50123.replace(b50123.length()-"Chars".length(),b50123.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50123 = new java.util.HashMap<String,Object>();
		map50123.put("key50123", b50123.toString()); // put in a collection
		String c50123 = (String)map50123.get("key50123"); // get it back out
		String d50123 = c50123.substring(0,c50123.length()-1); // extract most of it
		String e50123 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50123.getBytes() ) )); // B64 encode and decode it
		String f50123 = e50123.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50123); // reflection
	
		return bar;	
	}
}
