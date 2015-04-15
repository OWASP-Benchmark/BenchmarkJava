package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15082")
public class BenchmarkTest15082 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31273 = param; //assign
		StringBuilder b31273 = new StringBuilder(a31273);  // stick in stringbuilder
		b31273.append(" SafeStuff"); // append some safe content
		b31273.replace(b31273.length()-"Chars".length(),b31273.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31273 = new java.util.HashMap<String,Object>();
		map31273.put("key31273", b31273.toString()); // put in a collection
		String c31273 = (String)map31273.get("key31273"); // get it back out
		String d31273 = c31273.substring(0,c31273.length()-1); // extract most of it
		String e31273 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31273.getBytes() ) )); // B64 encode and decode it
		String f31273 = e31273.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g31273 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31273); // reflection
	
		return bar;	
	}
}
