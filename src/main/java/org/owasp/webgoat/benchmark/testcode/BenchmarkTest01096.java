package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01096")
public class BenchmarkTest01096 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a13590 = param; //assign
		StringBuilder b13590 = new StringBuilder(a13590);  // stick in stringbuilder
		b13590.append(" SafeStuff"); // append some safe content
		b13590.replace(b13590.length()-"Chars".length(),b13590.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13590 = new java.util.HashMap<String,Object>();
		map13590.put("key13590", b13590.toString()); // put in a collection
		String c13590 = (String)map13590.get("key13590"); // get it back out
		String d13590 = c13590.substring(0,c13590.length()-1); // extract most of it
		String e13590 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13590.getBytes() ) )); // B64 encode and decode it
		String f13590 = e13590.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f13590); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
