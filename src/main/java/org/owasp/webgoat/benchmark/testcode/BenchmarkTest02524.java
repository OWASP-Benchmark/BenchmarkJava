package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02524")
public class BenchmarkTest02524 extends HttpServlet {
	
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
		String a87243 = param; //assign
		StringBuilder b87243 = new StringBuilder(a87243);  // stick in stringbuilder
		b87243.append(" SafeStuff"); // append some safe content
		b87243.replace(b87243.length()-"Chars".length(),b87243.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87243 = new java.util.HashMap<String,Object>();
		map87243.put("key87243", b87243.toString()); // put in a collection
		String c87243 = (String)map87243.get("key87243"); // get it back out
		String d87243 = c87243.substring(0,c87243.length()-1); // extract most of it
		String e87243 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87243.getBytes() ) )); // B64 encode and decode it
		String f87243 = e87243.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f87243); // reflection
		
		
		response.getWriter().write(bar);
	}
}
