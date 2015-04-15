package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02589")
public class BenchmarkTest02589 extends HttpServlet {
	
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
		String a8196 = param; //assign
		StringBuilder b8196 = new StringBuilder(a8196);  // stick in stringbuilder
		b8196.append(" SafeStuff"); // append some safe content
		b8196.replace(b8196.length()-"Chars".length(),b8196.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8196 = new java.util.HashMap<String,Object>();
		map8196.put("key8196", b8196.toString()); // put in a collection
		String c8196 = (String)map8196.get("key8196"); // get it back out
		String d8196 = c8196.substring(0,c8196.length()-1); // extract most of it
		String e8196 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8196.getBytes() ) )); // B64 encode and decode it
		String f8196 = e8196.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g8196 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g8196); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
