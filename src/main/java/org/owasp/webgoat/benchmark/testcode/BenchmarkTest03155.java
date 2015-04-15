package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03155")
public class BenchmarkTest03155 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a81574 = param; //assign
		StringBuilder b81574 = new StringBuilder(a81574);  // stick in stringbuilder
		b81574.append(" SafeStuff"); // append some safe content
		b81574.replace(b81574.length()-"Chars".length(),b81574.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81574 = new java.util.HashMap<String,Object>();
		map81574.put("key81574", b81574.toString()); // put in a collection
		String c81574 = (String)map81574.get("key81574"); // get it back out
		String d81574 = c81574.substring(0,c81574.length()-1); // extract most of it
		String e81574 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81574.getBytes() ) )); // B64 encode and decode it
		String f81574 = e81574.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f81574); // reflection
		
		
		response.getWriter().write(bar);
	}
}
