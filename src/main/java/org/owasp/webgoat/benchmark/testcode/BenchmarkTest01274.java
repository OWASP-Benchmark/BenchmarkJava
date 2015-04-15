package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01274")
public class BenchmarkTest01274 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a39663 = param; //assign
		StringBuilder b39663 = new StringBuilder(a39663);  // stick in stringbuilder
		b39663.append(" SafeStuff"); // append some safe content
		b39663.replace(b39663.length()-"Chars".length(),b39663.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39663 = new java.util.HashMap<String,Object>();
		map39663.put("key39663", b39663.toString()); // put in a collection
		String c39663 = (String)map39663.get("key39663"); // get it back out
		String d39663 = c39663.substring(0,c39663.length()-1); // extract most of it
		String e39663 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39663.getBytes() ) )); // B64 encode and decode it
		String f39663 = e39663.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g39663 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g39663); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
