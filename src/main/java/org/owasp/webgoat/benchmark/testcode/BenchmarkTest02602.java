package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02602")
public class BenchmarkTest02602 extends HttpServlet {
	
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
		String a79160 = param; //assign
		StringBuilder b79160 = new StringBuilder(a79160);  // stick in stringbuilder
		b79160.append(" SafeStuff"); // append some safe content
		b79160.replace(b79160.length()-"Chars".length(),b79160.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79160 = new java.util.HashMap<String,Object>();
		map79160.put("key79160", b79160.toString()); // put in a collection
		String c79160 = (String)map79160.get("key79160"); // get it back out
		String d79160 = c79160.substring(0,c79160.length()-1); // extract most of it
		String e79160 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79160.getBytes() ) )); // B64 encode and decode it
		String f79160 = e79160.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f79160); // reflection
		
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}
}
