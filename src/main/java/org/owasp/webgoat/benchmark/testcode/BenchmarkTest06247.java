package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06247")
public class BenchmarkTest06247 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a48474 = param; //assign
		StringBuilder b48474 = new StringBuilder(a48474);  // stick in stringbuilder
		b48474.append(" SafeStuff"); // append some safe content
		b48474.replace(b48474.length()-"Chars".length(),b48474.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48474 = new java.util.HashMap<String,Object>();
		map48474.put("key48474", b48474.toString()); // put in a collection
		String c48474 = (String)map48474.get("key48474"); // get it back out
		String d48474 = c48474.substring(0,c48474.length()-1); // extract most of it
		String e48474 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48474.getBytes() ) )); // B64 encode and decode it
		String f48474 = e48474.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48474); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
