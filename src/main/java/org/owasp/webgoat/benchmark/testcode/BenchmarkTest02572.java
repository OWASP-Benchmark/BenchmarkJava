package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02572")
public class BenchmarkTest02572 extends HttpServlet {
	
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
		String a96077 = param; //assign
		StringBuilder b96077 = new StringBuilder(a96077);  // stick in stringbuilder
		b96077.append(" SafeStuff"); // append some safe content
		b96077.replace(b96077.length()-"Chars".length(),b96077.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96077 = new java.util.HashMap<String,Object>();
		map96077.put("key96077", b96077.toString()); // put in a collection
		String c96077 = (String)map96077.get("key96077"); // get it back out
		String d96077 = c96077.substring(0,c96077.length()-1); // extract most of it
		String e96077 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96077.getBytes() ) )); // B64 encode and decode it
		String f96077 = e96077.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f96077); // reflection
		
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}
}
