package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16335")
public class BenchmarkTest16335 extends HttpServlet {
	
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
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a48368 = param; //assign
		StringBuilder b48368 = new StringBuilder(a48368);  // stick in stringbuilder
		b48368.append(" SafeStuff"); // append some safe content
		b48368.replace(b48368.length()-"Chars".length(),b48368.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48368 = new java.util.HashMap<String,Object>();
		map48368.put("key48368", b48368.toString()); // put in a collection
		String c48368 = (String)map48368.get("key48368"); // get it back out
		String d48368 = c48368.substring(0,c48368.length()-1); // extract most of it
		String e48368 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48368.getBytes() ) )); // B64 encode and decode it
		String f48368 = e48368.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g48368 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g48368); // reflection
	
		return bar;	
	}
}
