package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06257")
public class BenchmarkTest06257 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a12678 = param; //assign
		StringBuilder b12678 = new StringBuilder(a12678);  // stick in stringbuilder
		b12678.append(" SafeStuff"); // append some safe content
		b12678.replace(b12678.length()-"Chars".length(),b12678.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12678 = new java.util.HashMap<String,Object>();
		map12678.put("key12678", b12678.toString()); // put in a collection
		String c12678 = (String)map12678.get("key12678"); // get it back out
		String d12678 = c12678.substring(0,c12678.length()-1); // extract most of it
		String e12678 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12678.getBytes() ) )); // B64 encode and decode it
		String f12678 = e12678.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g12678 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g12678); // reflection
		
		
		response.getWriter().write(bar);
	}
}
