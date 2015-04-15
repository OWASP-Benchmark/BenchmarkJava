package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06356")
public class BenchmarkTest06356 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a1751 = param; //assign
		StringBuilder b1751 = new StringBuilder(a1751);  // stick in stringbuilder
		b1751.append(" SafeStuff"); // append some safe content
		b1751.replace(b1751.length()-"Chars".length(),b1751.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1751 = new java.util.HashMap<String,Object>();
		map1751.put("key1751", b1751.toString()); // put in a collection
		String c1751 = (String)map1751.get("key1751"); // get it back out
		String d1751 = c1751.substring(0,c1751.length()-1); // extract most of it
		String e1751 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1751.getBytes() ) )); // B64 encode and decode it
		String f1751 = e1751.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g1751 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1751); // reflection
		
		
		response.addHeader("SomeHeader", bar);
	}
}
