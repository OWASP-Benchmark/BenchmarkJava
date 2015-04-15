package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05703")
public class BenchmarkTest05703 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a27696 = param; //assign
		StringBuilder b27696 = new StringBuilder(a27696);  // stick in stringbuilder
		b27696.append(" SafeStuff"); // append some safe content
		b27696.replace(b27696.length()-"Chars".length(),b27696.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27696 = new java.util.HashMap<String,Object>();
		map27696.put("key27696", b27696.toString()); // put in a collection
		String c27696 = (String)map27696.get("key27696"); // get it back out
		String d27696 = c27696.substring(0,c27696.length()-1); // extract most of it
		String e27696 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27696.getBytes() ) )); // B64 encode and decode it
		String f27696 = e27696.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g27696 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g27696); // reflection
		
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}
}
