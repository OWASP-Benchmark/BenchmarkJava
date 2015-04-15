package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03201")
public class BenchmarkTest03201 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a62019 = param; //assign
		StringBuilder b62019 = new StringBuilder(a62019);  // stick in stringbuilder
		b62019.append(" SafeStuff"); // append some safe content
		b62019.replace(b62019.length()-"Chars".length(),b62019.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62019 = new java.util.HashMap<String,Object>();
		map62019.put("key62019", b62019.toString()); // put in a collection
		String c62019 = (String)map62019.get("key62019"); // get it back out
		String d62019 = c62019.substring(0,c62019.length()-1); // extract most of it
		String e62019 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62019.getBytes() ) )); // B64 encode and decode it
		String f62019 = e62019.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62019); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
