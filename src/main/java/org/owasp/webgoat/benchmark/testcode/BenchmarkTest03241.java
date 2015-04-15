package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03241")
public class BenchmarkTest03241 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a50309 = param; //assign
		StringBuilder b50309 = new StringBuilder(a50309);  // stick in stringbuilder
		b50309.append(" SafeStuff"); // append some safe content
		b50309.replace(b50309.length()-"Chars".length(),b50309.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50309 = new java.util.HashMap<String,Object>();
		map50309.put("key50309", b50309.toString()); // put in a collection
		String c50309 = (String)map50309.get("key50309"); // get it back out
		String d50309 = c50309.substring(0,c50309.length()-1); // extract most of it
		String e50309 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50309.getBytes() ) )); // B64 encode and decode it
		String f50309 = e50309.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50309); // reflection
		
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}
}
