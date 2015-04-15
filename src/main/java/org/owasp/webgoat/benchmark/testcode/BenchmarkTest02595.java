package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02595")
public class BenchmarkTest02595 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a86440 = param; //assign
		StringBuilder b86440 = new StringBuilder(a86440);  // stick in stringbuilder
		b86440.append(" SafeStuff"); // append some safe content
		b86440.replace(b86440.length()-"Chars".length(),b86440.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86440 = new java.util.HashMap<String,Object>();
		map86440.put("key86440", b86440.toString()); // put in a collection
		String c86440 = (String)map86440.get("key86440"); // get it back out
		String d86440 = c86440.substring(0,c86440.length()-1); // extract most of it
		String e86440 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86440.getBytes() ) )); // B64 encode and decode it
		String f86440 = e86440.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86440); // reflection
		
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}
}
