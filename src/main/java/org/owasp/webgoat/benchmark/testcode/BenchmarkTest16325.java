package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16325")
public class BenchmarkTest16325 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73136 = param; //assign
		StringBuilder b73136 = new StringBuilder(a73136);  // stick in stringbuilder
		b73136.append(" SafeStuff"); // append some safe content
		b73136.replace(b73136.length()-"Chars".length(),b73136.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73136 = new java.util.HashMap<String,Object>();
		map73136.put("key73136", b73136.toString()); // put in a collection
		String c73136 = (String)map73136.get("key73136"); // get it back out
		String d73136 = c73136.substring(0,c73136.length()-1); // extract most of it
		String e73136 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73136.getBytes() ) )); // B64 encode and decode it
		String f73136 = e73136.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g73136 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g73136); // reflection
	
		return bar;	
	}
}
