package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02556")
public class BenchmarkTest02556 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a83062 = param; //assign
		StringBuilder b83062 = new StringBuilder(a83062);  // stick in stringbuilder
		b83062.append(" SafeStuff"); // append some safe content
		b83062.replace(b83062.length()-"Chars".length(),b83062.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83062 = new java.util.HashMap<String,Object>();
		map83062.put("key83062", b83062.toString()); // put in a collection
		String c83062 = (String)map83062.get("key83062"); // get it back out
		String d83062 = c83062.substring(0,c83062.length()-1); // extract most of it
		String e83062 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83062.getBytes() ) )); // B64 encode and decode it
		String f83062 = e83062.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83062); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
