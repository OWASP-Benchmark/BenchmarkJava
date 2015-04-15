package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02568")
public class BenchmarkTest02568 extends HttpServlet {
	
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
		String a76258 = param; //assign
		StringBuilder b76258 = new StringBuilder(a76258);  // stick in stringbuilder
		b76258.append(" SafeStuff"); // append some safe content
		b76258.replace(b76258.length()-"Chars".length(),b76258.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76258 = new java.util.HashMap<String,Object>();
		map76258.put("key76258", b76258.toString()); // put in a collection
		String c76258 = (String)map76258.get("key76258"); // get it back out
		String d76258 = c76258.substring(0,c76258.length()-1); // extract most of it
		String e76258 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76258.getBytes() ) )); // B64 encode and decode it
		String f76258 = e76258.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76258 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76258); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
