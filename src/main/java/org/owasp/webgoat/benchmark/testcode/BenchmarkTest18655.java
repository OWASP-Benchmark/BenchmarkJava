package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18655")
public class BenchmarkTest18655 extends HttpServlet {
	
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
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3733 = param; //assign
		StringBuilder b3733 = new StringBuilder(a3733);  // stick in stringbuilder
		b3733.append(" SafeStuff"); // append some safe content
		b3733.replace(b3733.length()-"Chars".length(),b3733.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3733 = new java.util.HashMap<String,Object>();
		map3733.put("key3733", b3733.toString()); // put in a collection
		String c3733 = (String)map3733.get("key3733"); // get it back out
		String d3733 = c3733.substring(0,c3733.length()-1); // extract most of it
		String e3733 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3733.getBytes() ) )); // B64 encode and decode it
		String f3733 = e3733.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3733); // reflection
	
		return bar;	
	}
}
