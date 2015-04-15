package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05510")
public class BenchmarkTest05510 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a89733 = param; //assign
		StringBuilder b89733 = new StringBuilder(a89733);  // stick in stringbuilder
		b89733.append(" SafeStuff"); // append some safe content
		b89733.replace(b89733.length()-"Chars".length(),b89733.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89733 = new java.util.HashMap<String,Object>();
		map89733.put("key89733", b89733.toString()); // put in a collection
		String c89733 = (String)map89733.get("key89733"); // get it back out
		String d89733 = c89733.substring(0,c89733.length()-1); // extract most of it
		String e89733 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89733.getBytes() ) )); // B64 encode and decode it
		String f89733 = e89733.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f89733); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
