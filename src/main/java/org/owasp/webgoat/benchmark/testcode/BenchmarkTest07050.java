package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07050")
public class BenchmarkTest07050 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a47277 = param; //assign
		StringBuilder b47277 = new StringBuilder(a47277);  // stick in stringbuilder
		b47277.append(" SafeStuff"); // append some safe content
		b47277.replace(b47277.length()-"Chars".length(),b47277.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47277 = new java.util.HashMap<String,Object>();
		map47277.put("key47277", b47277.toString()); // put in a collection
		String c47277 = (String)map47277.get("key47277"); // get it back out
		String d47277 = c47277.substring(0,c47277.length()-1); // extract most of it
		String e47277 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47277.getBytes() ) )); // B64 encode and decode it
		String f47277 = e47277.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g47277 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47277); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}
}
