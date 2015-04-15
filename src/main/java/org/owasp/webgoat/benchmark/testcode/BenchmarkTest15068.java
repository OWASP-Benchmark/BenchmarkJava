package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15068")
public class BenchmarkTest15068 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73360 = param; //assign
		StringBuilder b73360 = new StringBuilder(a73360);  // stick in stringbuilder
		b73360.append(" SafeStuff"); // append some safe content
		b73360.replace(b73360.length()-"Chars".length(),b73360.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73360 = new java.util.HashMap<String,Object>();
		map73360.put("key73360", b73360.toString()); // put in a collection
		String c73360 = (String)map73360.get("key73360"); // get it back out
		String d73360 = c73360.substring(0,c73360.length()-1); // extract most of it
		String e73360 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73360.getBytes() ) )); // B64 encode and decode it
		String f73360 = e73360.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g73360 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g73360); // reflection
	
		return bar;	
	}
}
