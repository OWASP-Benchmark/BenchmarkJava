package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01945")
public class BenchmarkTest01945 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a60716 = param; //assign
		StringBuilder b60716 = new StringBuilder(a60716);  // stick in stringbuilder
		b60716.append(" SafeStuff"); // append some safe content
		b60716.replace(b60716.length()-"Chars".length(),b60716.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60716 = new java.util.HashMap<String,Object>();
		map60716.put("key60716", b60716.toString()); // put in a collection
		String c60716 = (String)map60716.get("key60716"); // get it back out
		String d60716 = c60716.substring(0,c60716.length()-1); // extract most of it
		String e60716 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60716.getBytes() ) )); // B64 encode and decode it
		String f60716 = e60716.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g60716 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g60716); // reflection
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
