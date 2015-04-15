package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15701")
public class BenchmarkTest15701 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37570 = param; //assign
		StringBuilder b37570 = new StringBuilder(a37570);  // stick in stringbuilder
		b37570.append(" SafeStuff"); // append some safe content
		b37570.replace(b37570.length()-"Chars".length(),b37570.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37570 = new java.util.HashMap<String,Object>();
		map37570.put("key37570", b37570.toString()); // put in a collection
		String c37570 = (String)map37570.get("key37570"); // get it back out
		String d37570 = c37570.substring(0,c37570.length()-1); // extract most of it
		String e37570 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37570.getBytes() ) )); // B64 encode and decode it
		String f37570 = e37570.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g37570 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g37570); // reflection
	
		return bar;	
	}
}
