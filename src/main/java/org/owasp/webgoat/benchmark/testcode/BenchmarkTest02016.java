package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02016")
public class BenchmarkTest02016 extends HttpServlet {
	
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
		String a9180 = param; //assign
		StringBuilder b9180 = new StringBuilder(a9180);  // stick in stringbuilder
		b9180.append(" SafeStuff"); // append some safe content
		b9180.replace(b9180.length()-"Chars".length(),b9180.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9180 = new java.util.HashMap<String,Object>();
		map9180.put("key9180", b9180.toString()); // put in a collection
		String c9180 = (String)map9180.get("key9180"); // get it back out
		String d9180 = c9180.substring(0,c9180.length()-1); // extract most of it
		String e9180 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9180.getBytes() ) )); // B64 encode and decode it
		String f9180 = e9180.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9180); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
