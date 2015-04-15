package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04420")
public class BenchmarkTest04420 extends HttpServlet {
	
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
		String a31285 = param; //assign
		StringBuilder b31285 = new StringBuilder(a31285);  // stick in stringbuilder
		b31285.append(" SafeStuff"); // append some safe content
		b31285.replace(b31285.length()-"Chars".length(),b31285.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31285 = new java.util.HashMap<String,Object>();
		map31285.put("key31285", b31285.toString()); // put in a collection
		String c31285 = (String)map31285.get("key31285"); // get it back out
		String d31285 = c31285.substring(0,c31285.length()-1); // extract most of it
		String e31285 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31285.getBytes() ) )); // B64 encode and decode it
		String f31285 = e31285.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g31285 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31285); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
