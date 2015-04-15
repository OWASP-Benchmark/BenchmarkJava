package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03195")
public class BenchmarkTest03195 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a48052 = param; //assign
		StringBuilder b48052 = new StringBuilder(a48052);  // stick in stringbuilder
		b48052.append(" SafeStuff"); // append some safe content
		b48052.replace(b48052.length()-"Chars".length(),b48052.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48052 = new java.util.HashMap<String,Object>();
		map48052.put("key48052", b48052.toString()); // put in a collection
		String c48052 = (String)map48052.get("key48052"); // get it back out
		String d48052 = c48052.substring(0,c48052.length()-1); // extract most of it
		String e48052 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48052.getBytes() ) )); // B64 encode and decode it
		String f48052 = e48052.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48052); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
