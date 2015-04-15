package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16960")
public class BenchmarkTest16960 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71943 = param; //assign
		StringBuilder b71943 = new StringBuilder(a71943);  // stick in stringbuilder
		b71943.append(" SafeStuff"); // append some safe content
		b71943.replace(b71943.length()-"Chars".length(),b71943.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71943 = new java.util.HashMap<String,Object>();
		map71943.put("key71943", b71943.toString()); // put in a collection
		String c71943 = (String)map71943.get("key71943"); // get it back out
		String d71943 = c71943.substring(0,c71943.length()-1); // extract most of it
		String e71943 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71943.getBytes() ) )); // B64 encode and decode it
		String f71943 = e71943.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71943); // reflection
	
		return bar;	
	}
}
