package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04432")
public class BenchmarkTest04432 extends HttpServlet {
	
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
		String a71812 = param; //assign
		StringBuilder b71812 = new StringBuilder(a71812);  // stick in stringbuilder
		b71812.append(" SafeStuff"); // append some safe content
		b71812.replace(b71812.length()-"Chars".length(),b71812.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71812 = new java.util.HashMap<String,Object>();
		map71812.put("key71812", b71812.toString()); // put in a collection
		String c71812 = (String)map71812.get("key71812"); // get it back out
		String d71812 = c71812.substring(0,c71812.length()-1); // extract most of it
		String e71812 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71812.getBytes() ) )); // B64 encode and decode it
		String f71812 = e71812.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g71812 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71812); // reflection
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
