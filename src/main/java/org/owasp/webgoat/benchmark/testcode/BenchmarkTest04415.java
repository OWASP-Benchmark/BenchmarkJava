package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04415")
public class BenchmarkTest04415 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a9794 = param; //assign
		StringBuilder b9794 = new StringBuilder(a9794);  // stick in stringbuilder
		b9794.append(" SafeStuff"); // append some safe content
		b9794.replace(b9794.length()-"Chars".length(),b9794.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9794 = new java.util.HashMap<String,Object>();
		map9794.put("key9794", b9794.toString()); // put in a collection
		String c9794 = (String)map9794.get("key9794"); // get it back out
		String d9794 = c9794.substring(0,c9794.length()-1); // extract most of it
		String e9794 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9794.getBytes() ) )); // B64 encode and decode it
		String f9794 = e9794.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9794); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
