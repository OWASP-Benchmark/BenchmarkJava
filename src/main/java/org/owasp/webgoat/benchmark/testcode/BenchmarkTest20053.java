package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20053")
public class BenchmarkTest20053 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73406 = param; //assign
		StringBuilder b73406 = new StringBuilder(a73406);  // stick in stringbuilder
		b73406.append(" SafeStuff"); // append some safe content
		b73406.replace(b73406.length()-"Chars".length(),b73406.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73406 = new java.util.HashMap<String,Object>();
		map73406.put("key73406", b73406.toString()); // put in a collection
		String c73406 = (String)map73406.get("key73406"); // get it back out
		String d73406 = c73406.substring(0,c73406.length()-1); // extract most of it
		String e73406 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73406.getBytes() ) )); // B64 encode and decode it
		String f73406 = e73406.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73406); // reflection
	
		return bar;	
	}
}
