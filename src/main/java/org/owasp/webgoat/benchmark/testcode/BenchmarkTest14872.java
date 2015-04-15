package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14872")
public class BenchmarkTest14872 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88603 = param; //assign
		StringBuilder b88603 = new StringBuilder(a88603);  // stick in stringbuilder
		b88603.append(" SafeStuff"); // append some safe content
		b88603.replace(b88603.length()-"Chars".length(),b88603.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88603 = new java.util.HashMap<String,Object>();
		map88603.put("key88603", b88603.toString()); // put in a collection
		String c88603 = (String)map88603.get("key88603"); // get it back out
		String d88603 = c88603.substring(0,c88603.length()-1); // extract most of it
		String e88603 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88603.getBytes() ) )); // B64 encode and decode it
		String f88603 = e88603.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88603); // reflection
	
		return bar;	
	}
}
