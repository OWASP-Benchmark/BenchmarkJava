package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03281")
public class BenchmarkTest03281 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a83131 = param; //assign
		StringBuilder b83131 = new StringBuilder(a83131);  // stick in stringbuilder
		b83131.append(" SafeStuff"); // append some safe content
		b83131.replace(b83131.length()-"Chars".length(),b83131.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83131 = new java.util.HashMap<String,Object>();
		map83131.put("key83131", b83131.toString()); // put in a collection
		String c83131 = (String)map83131.get("key83131"); // get it back out
		String d83131 = c83131.substring(0,c83131.length()-1); // extract most of it
		String e83131 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83131.getBytes() ) )); // B64 encode and decode it
		String f83131 = e83131.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83131 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83131); // reflection
		
		
		response.setHeader("SomeHeader", bar);
	}
}
