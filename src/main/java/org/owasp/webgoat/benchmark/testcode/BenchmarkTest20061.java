package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20061")
public class BenchmarkTest20061 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a78367 = param; //assign
		StringBuilder b78367 = new StringBuilder(a78367);  // stick in stringbuilder
		b78367.append(" SafeStuff"); // append some safe content
		b78367.replace(b78367.length()-"Chars".length(),b78367.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78367 = new java.util.HashMap<String,Object>();
		map78367.put("key78367", b78367.toString()); // put in a collection
		String c78367 = (String)map78367.get("key78367"); // get it back out
		String d78367 = c78367.substring(0,c78367.length()-1); // extract most of it
		String e78367 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78367.getBytes() ) )); // B64 encode and decode it
		String f78367 = e78367.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g78367 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78367); // reflection
	
		return bar;	
	}
}
