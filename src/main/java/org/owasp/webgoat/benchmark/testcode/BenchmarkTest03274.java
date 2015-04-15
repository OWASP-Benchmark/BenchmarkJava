package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03274")
public class BenchmarkTest03274 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a55542 = param; //assign
		StringBuilder b55542 = new StringBuilder(a55542);  // stick in stringbuilder
		b55542.append(" SafeStuff"); // append some safe content
		b55542.replace(b55542.length()-"Chars".length(),b55542.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55542 = new java.util.HashMap<String,Object>();
		map55542.put("key55542", b55542.toString()); // put in a collection
		String c55542 = (String)map55542.get("key55542"); // get it back out
		String d55542 = c55542.substring(0,c55542.length()-1); // extract most of it
		String e55542 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55542.getBytes() ) )); // B64 encode and decode it
		String f55542 = e55542.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f55542); // reflection
		
		
		response.addHeader(bar, "SomeValue");
	}
}
