package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01920")
public class BenchmarkTest01920 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a49867 = param; //assign
		StringBuilder b49867 = new StringBuilder(a49867);  // stick in stringbuilder
		b49867.append(" SafeStuff"); // append some safe content
		b49867.replace(b49867.length()-"Chars".length(),b49867.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49867 = new java.util.HashMap<String,Object>();
		map49867.put("key49867", b49867.toString()); // put in a collection
		String c49867 = (String)map49867.get("key49867"); // get it back out
		String d49867 = c49867.substring(0,c49867.length()-1); // extract most of it
		String e49867 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49867.getBytes() ) )); // B64 encode and decode it
		String f49867 = e49867.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g49867 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49867); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
