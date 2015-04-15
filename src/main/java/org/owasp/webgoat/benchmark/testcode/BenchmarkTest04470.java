package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04470")
public class BenchmarkTest04470 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a64395 = param; //assign
		StringBuilder b64395 = new StringBuilder(a64395);  // stick in stringbuilder
		b64395.append(" SafeStuff"); // append some safe content
		b64395.replace(b64395.length()-"Chars".length(),b64395.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64395 = new java.util.HashMap<String,Object>();
		map64395.put("key64395", b64395.toString()); // put in a collection
		String c64395 = (String)map64395.get("key64395"); // get it back out
		String d64395 = c64395.substring(0,c64395.length()-1); // extract most of it
		String e64395 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64395.getBytes() ) )); // B64 encode and decode it
		String f64395 = e64395.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64395); // reflection
		
		
		response.addHeader(bar, "SomeValue");
	}
}
