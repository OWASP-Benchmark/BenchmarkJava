package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02650")
public class BenchmarkTest02650 extends HttpServlet {
	
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
		String a39457 = param; //assign
		StringBuilder b39457 = new StringBuilder(a39457);  // stick in stringbuilder
		b39457.append(" SafeStuff"); // append some safe content
		b39457.replace(b39457.length()-"Chars".length(),b39457.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39457 = new java.util.HashMap<String,Object>();
		map39457.put("key39457", b39457.toString()); // put in a collection
		String c39457 = (String)map39457.get("key39457"); // get it back out
		String d39457 = c39457.substring(0,c39457.length()-1); // extract most of it
		String e39457 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39457.getBytes() ) )); // B64 encode and decode it
		String f39457 = e39457.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g39457 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g39457); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
