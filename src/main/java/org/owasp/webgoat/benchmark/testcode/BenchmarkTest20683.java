package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20683")
public class BenchmarkTest20683 extends HttpServlet {
	
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
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a96143 = param; //assign
		StringBuilder b96143 = new StringBuilder(a96143);  // stick in stringbuilder
		b96143.append(" SafeStuff"); // append some safe content
		b96143.replace(b96143.length()-"Chars".length(),b96143.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96143 = new java.util.HashMap<String,Object>();
		map96143.put("key96143", b96143.toString()); // put in a collection
		String c96143 = (String)map96143.get("key96143"); // get it back out
		String d96143 = c96143.substring(0,c96143.length()-1); // extract most of it
		String e96143 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96143.getBytes() ) )); // B64 encode and decode it
		String f96143 = e96143.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f96143); // reflection
	
		return bar;	
	}
}
