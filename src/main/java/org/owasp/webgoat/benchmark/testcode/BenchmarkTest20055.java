package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20055")
public class BenchmarkTest20055 extends HttpServlet {
	
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
		String a5538 = param; //assign
		StringBuilder b5538 = new StringBuilder(a5538);  // stick in stringbuilder
		b5538.append(" SafeStuff"); // append some safe content
		b5538.replace(b5538.length()-"Chars".length(),b5538.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5538 = new java.util.HashMap<String,Object>();
		map5538.put("key5538", b5538.toString()); // put in a collection
		String c5538 = (String)map5538.get("key5538"); // get it back out
		String d5538 = c5538.substring(0,c5538.length()-1); // extract most of it
		String e5538 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5538.getBytes() ) )); // B64 encode and decode it
		String f5538 = e5538.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g5538 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5538); // reflection
	
		return bar;	
	}
}
