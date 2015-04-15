package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03203")
public class BenchmarkTest03203 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a73608 = param; //assign
		StringBuilder b73608 = new StringBuilder(a73608);  // stick in stringbuilder
		b73608.append(" SafeStuff"); // append some safe content
		b73608.replace(b73608.length()-"Chars".length(),b73608.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73608 = new java.util.HashMap<String,Object>();
		map73608.put("key73608", b73608.toString()); // put in a collection
		String c73608 = (String)map73608.get("key73608"); // get it back out
		String d73608 = c73608.substring(0,c73608.length()-1); // extract most of it
		String e73608 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73608.getBytes() ) )); // B64 encode and decode it
		String f73608 = e73608.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g73608 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g73608); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
