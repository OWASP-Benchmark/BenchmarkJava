package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06326")
public class BenchmarkTest06326 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a60269 = param; //assign
		StringBuilder b60269 = new StringBuilder(a60269);  // stick in stringbuilder
		b60269.append(" SafeStuff"); // append some safe content
		b60269.replace(b60269.length()-"Chars".length(),b60269.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60269 = new java.util.HashMap<String,Object>();
		map60269.put("key60269", b60269.toString()); // put in a collection
		String c60269 = (String)map60269.get("key60269"); // get it back out
		String d60269 = c60269.substring(0,c60269.length()-1); // extract most of it
		String e60269 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60269.getBytes() ) )); // B64 encode and decode it
		String f60269 = e60269.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g60269 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g60269); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
