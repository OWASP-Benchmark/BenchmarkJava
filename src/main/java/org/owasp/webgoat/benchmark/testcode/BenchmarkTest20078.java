package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20078")
public class BenchmarkTest20078 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51096 = param; //assign
		StringBuilder b51096 = new StringBuilder(a51096);  // stick in stringbuilder
		b51096.append(" SafeStuff"); // append some safe content
		b51096.replace(b51096.length()-"Chars".length(),b51096.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51096 = new java.util.HashMap<String,Object>();
		map51096.put("key51096", b51096.toString()); // put in a collection
		String c51096 = (String)map51096.get("key51096"); // get it back out
		String d51096 = c51096.substring(0,c51096.length()-1); // extract most of it
		String e51096 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51096.getBytes() ) )); // B64 encode and decode it
		String f51096 = e51096.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51096); // reflection
	
		return bar;	
	}
}
