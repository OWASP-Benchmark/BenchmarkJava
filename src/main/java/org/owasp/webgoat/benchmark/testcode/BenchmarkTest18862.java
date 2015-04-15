package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18862")
public class BenchmarkTest18862 extends HttpServlet {
	
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
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1914 = param; //assign
		StringBuilder b1914 = new StringBuilder(a1914);  // stick in stringbuilder
		b1914.append(" SafeStuff"); // append some safe content
		b1914.replace(b1914.length()-"Chars".length(),b1914.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1914 = new java.util.HashMap<String,Object>();
		map1914.put("key1914", b1914.toString()); // put in a collection
		String c1914 = (String)map1914.get("key1914"); // get it back out
		String d1914 = c1914.substring(0,c1914.length()-1); // extract most of it
		String e1914 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1914.getBytes() ) )); // B64 encode and decode it
		String f1914 = e1914.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f1914); // reflection
	
		return bar;	
	}
}
