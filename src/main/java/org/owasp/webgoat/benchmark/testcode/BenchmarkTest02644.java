package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02644")
public class BenchmarkTest02644 extends HttpServlet {
	
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
		String a72367 = param; //assign
		StringBuilder b72367 = new StringBuilder(a72367);  // stick in stringbuilder
		b72367.append(" SafeStuff"); // append some safe content
		b72367.replace(b72367.length()-"Chars".length(),b72367.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72367 = new java.util.HashMap<String,Object>();
		map72367.put("key72367", b72367.toString()); // put in a collection
		String c72367 = (String)map72367.get("key72367"); // get it back out
		String d72367 = c72367.substring(0,c72367.length()-1); // extract most of it
		String e72367 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72367.getBytes() ) )); // B64 encode and decode it
		String f72367 = e72367.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g72367 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72367); // reflection
		
		
		response.setHeader("SomeHeader", bar);
	}
}
