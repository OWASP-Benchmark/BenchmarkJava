package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06121")
public class BenchmarkTest06121 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a14562 = param; //assign
		StringBuilder b14562 = new StringBuilder(a14562);  // stick in stringbuilder
		b14562.append(" SafeStuff"); // append some safe content
		b14562.replace(b14562.length()-"Chars".length(),b14562.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14562 = new java.util.HashMap<String,Object>();
		map14562.put("key14562", b14562.toString()); // put in a collection
		String c14562 = (String)map14562.get("key14562"); // get it back out
		String d14562 = c14562.substring(0,c14562.length()-1); // extract most of it
		String e14562 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14562.getBytes() ) )); // B64 encode and decode it
		String f14562 = e14562.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14562); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
