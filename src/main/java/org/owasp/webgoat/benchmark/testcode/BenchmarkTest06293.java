package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06293")
public class BenchmarkTest06293 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a4260 = param; //assign
		StringBuilder b4260 = new StringBuilder(a4260);  // stick in stringbuilder
		b4260.append(" SafeStuff"); // append some safe content
		b4260.replace(b4260.length()-"Chars".length(),b4260.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4260 = new java.util.HashMap<String,Object>();
		map4260.put("key4260", b4260.toString()); // put in a collection
		String c4260 = (String)map4260.get("key4260"); // get it back out
		String d4260 = c4260.substring(0,c4260.length()-1); // extract most of it
		String e4260 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4260.getBytes() ) )); // B64 encode and decode it
		String f4260 = e4260.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4260); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
