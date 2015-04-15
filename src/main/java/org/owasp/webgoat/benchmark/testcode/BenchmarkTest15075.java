package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15075")
public class BenchmarkTest15075 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52913 = param; //assign
		StringBuilder b52913 = new StringBuilder(a52913);  // stick in stringbuilder
		b52913.append(" SafeStuff"); // append some safe content
		b52913.replace(b52913.length()-"Chars".length(),b52913.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52913 = new java.util.HashMap<String,Object>();
		map52913.put("key52913", b52913.toString()); // put in a collection
		String c52913 = (String)map52913.get("key52913"); // get it back out
		String d52913 = c52913.substring(0,c52913.length()-1); // extract most of it
		String e52913 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52913.getBytes() ) )); // B64 encode and decode it
		String f52913 = e52913.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f52913); // reflection
	
		return bar;	
	}
}
