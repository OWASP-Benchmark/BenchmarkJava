package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05052")
public class BenchmarkTest05052 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a35716 = param; //assign
		StringBuilder b35716 = new StringBuilder(a35716);  // stick in stringbuilder
		b35716.append(" SafeStuff"); // append some safe content
		b35716.replace(b35716.length()-"Chars".length(),b35716.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35716 = new java.util.HashMap<String,Object>();
		map35716.put("key35716", b35716.toString()); // put in a collection
		String c35716 = (String)map35716.get("key35716"); // get it back out
		String d35716 = c35716.substring(0,c35716.length()-1); // extract most of it
		String e35716 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35716.getBytes() ) )); // B64 encode and decode it
		String f35716 = e35716.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f35716); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
