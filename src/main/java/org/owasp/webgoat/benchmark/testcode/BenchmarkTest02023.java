package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02023")
public class BenchmarkTest02023 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a87445 = param; //assign
		StringBuilder b87445 = new StringBuilder(a87445);  // stick in stringbuilder
		b87445.append(" SafeStuff"); // append some safe content
		b87445.replace(b87445.length()-"Chars".length(),b87445.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87445 = new java.util.HashMap<String,Object>();
		map87445.put("key87445", b87445.toString()); // put in a collection
		String c87445 = (String)map87445.get("key87445"); // get it back out
		String d87445 = c87445.substring(0,c87445.length()-1); // extract most of it
		String e87445 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87445.getBytes() ) )); // B64 encode and decode it
		String f87445 = e87445.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f87445); // reflection
		
		
		response.getWriter().write(bar);
	}
}
