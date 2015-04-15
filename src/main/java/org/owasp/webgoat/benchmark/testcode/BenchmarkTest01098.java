package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01098")
public class BenchmarkTest01098 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a22410 = param; //assign
		StringBuilder b22410 = new StringBuilder(a22410);  // stick in stringbuilder
		b22410.append(" SafeStuff"); // append some safe content
		b22410.replace(b22410.length()-"Chars".length(),b22410.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22410 = new java.util.HashMap<String,Object>();
		map22410.put("key22410", b22410.toString()); // put in a collection
		String c22410 = (String)map22410.get("key22410"); // get it back out
		String d22410 = c22410.substring(0,c22410.length()-1); // extract most of it
		String e22410 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22410.getBytes() ) )); // B64 encode and decode it
		String f22410 = e22410.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g22410 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g22410); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
