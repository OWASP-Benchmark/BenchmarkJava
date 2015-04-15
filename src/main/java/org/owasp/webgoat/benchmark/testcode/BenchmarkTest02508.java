package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02508")
public class BenchmarkTest02508 extends HttpServlet {
	
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
		String a64642 = param; //assign
		StringBuilder b64642 = new StringBuilder(a64642);  // stick in stringbuilder
		b64642.append(" SafeStuff"); // append some safe content
		b64642.replace(b64642.length()-"Chars".length(),b64642.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64642 = new java.util.HashMap<String,Object>();
		map64642.put("key64642", b64642.toString()); // put in a collection
		String c64642 = (String)map64642.get("key64642"); // get it back out
		String d64642 = c64642.substring(0,c64642.length()-1); // extract most of it
		String e64642 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64642.getBytes() ) )); // B64 encode and decode it
		String f64642 = e64642.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64642); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}
}
