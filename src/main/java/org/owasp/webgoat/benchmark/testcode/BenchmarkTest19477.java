package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19477")
public class BenchmarkTest19477 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95338 = param; //assign
		StringBuilder b95338 = new StringBuilder(a95338);  // stick in stringbuilder
		b95338.append(" SafeStuff"); // append some safe content
		b95338.replace(b95338.length()-"Chars".length(),b95338.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95338 = new java.util.HashMap<String,Object>();
		map95338.put("key95338", b95338.toString()); // put in a collection
		String c95338 = (String)map95338.get("key95338"); // get it back out
		String d95338 = c95338.substring(0,c95338.length()-1); // extract most of it
		String e95338 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95338.getBytes() ) )); // B64 encode and decode it
		String f95338 = e95338.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95338); // reflection
	
		return bar;	
	}
}
