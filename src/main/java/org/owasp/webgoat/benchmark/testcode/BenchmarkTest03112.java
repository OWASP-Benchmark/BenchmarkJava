package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03112")
public class BenchmarkTest03112 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a26612 = param; //assign
		StringBuilder b26612 = new StringBuilder(a26612);  // stick in stringbuilder
		b26612.append(" SafeStuff"); // append some safe content
		b26612.replace(b26612.length()-"Chars".length(),b26612.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26612 = new java.util.HashMap<String,Object>();
		map26612.put("key26612", b26612.toString()); // put in a collection
		String c26612 = (String)map26612.get("key26612"); // get it back out
		String d26612 = c26612.substring(0,c26612.length()-1); // extract most of it
		String e26612 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26612.getBytes() ) )); // B64 encode and decode it
		String f26612 = e26612.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g26612 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26612); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
