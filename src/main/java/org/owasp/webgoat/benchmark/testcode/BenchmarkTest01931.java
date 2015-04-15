package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01931")
public class BenchmarkTest01931 extends HttpServlet {
	
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
		String a14436 = param; //assign
		StringBuilder b14436 = new StringBuilder(a14436);  // stick in stringbuilder
		b14436.append(" SafeStuff"); // append some safe content
		b14436.replace(b14436.length()-"Chars".length(),b14436.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14436 = new java.util.HashMap<String,Object>();
		map14436.put("key14436", b14436.toString()); // put in a collection
		String c14436 = (String)map14436.get("key14436"); // get it back out
		String d14436 = c14436.substring(0,c14436.length()-1); // extract most of it
		String e14436 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14436.getBytes() ) )); // B64 encode and decode it
		String f14436 = e14436.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g14436 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g14436); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
