package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01020")
public class BenchmarkTest01020 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a518 = param; //assign
		StringBuilder b518 = new StringBuilder(a518);  // stick in stringbuilder
		b518.append(" SafeStuff"); // append some safe content
		b518.replace(b518.length()-"Chars".length(),b518.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map518 = new java.util.HashMap<String,Object>();
		map518.put("key518", b518.toString()); // put in a collection
		String c518 = (String)map518.get("key518"); // get it back out
		String d518 = c518.substring(0,c518.length()-1); // extract most of it
		String e518 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d518.getBytes() ) )); // B64 encode and decode it
		String f518 = e518.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f518); // reflection
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
