package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16927")
public class BenchmarkTest16927 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75800 = param; //assign
		StringBuilder b75800 = new StringBuilder(a75800);  // stick in stringbuilder
		b75800.append(" SafeStuff"); // append some safe content
		b75800.replace(b75800.length()-"Chars".length(),b75800.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75800 = new java.util.HashMap<String,Object>();
		map75800.put("key75800", b75800.toString()); // put in a collection
		String c75800 = (String)map75800.get("key75800"); // get it back out
		String d75800 = c75800.substring(0,c75800.length()-1); // extract most of it
		String e75800 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75800.getBytes() ) )); // B64 encode and decode it
		String f75800 = e75800.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f75800); // reflection
	
		return bar;	
	}
}
