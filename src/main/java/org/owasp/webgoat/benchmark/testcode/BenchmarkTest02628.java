package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02628")
public class BenchmarkTest02628 extends HttpServlet {
	
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
		String a40267 = param; //assign
		StringBuilder b40267 = new StringBuilder(a40267);  // stick in stringbuilder
		b40267.append(" SafeStuff"); // append some safe content
		b40267.replace(b40267.length()-"Chars".length(),b40267.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40267 = new java.util.HashMap<String,Object>();
		map40267.put("key40267", b40267.toString()); // put in a collection
		String c40267 = (String)map40267.get("key40267"); // get it back out
		String d40267 = c40267.substring(0,c40267.length()-1); // extract most of it
		String e40267 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40267.getBytes() ) )); // B64 encode and decode it
		String f40267 = e40267.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40267); // reflection
		
		
		response.addHeader("SomeHeader", bar);
	}
}
