package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20657")
public class BenchmarkTest20657 extends HttpServlet {
	
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
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21352 = param; //assign
		StringBuilder b21352 = new StringBuilder(a21352);  // stick in stringbuilder
		b21352.append(" SafeStuff"); // append some safe content
		b21352.replace(b21352.length()-"Chars".length(),b21352.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21352 = new java.util.HashMap<String,Object>();
		map21352.put("key21352", b21352.toString()); // put in a collection
		String c21352 = (String)map21352.get("key21352"); // get it back out
		String d21352 = c21352.substring(0,c21352.length()-1); // extract most of it
		String e21352 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21352.getBytes() ) )); // B64 encode and decode it
		String f21352 = e21352.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21352); // reflection
	
		return bar;	
	}
}
