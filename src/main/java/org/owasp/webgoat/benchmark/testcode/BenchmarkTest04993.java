package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04993")
public class BenchmarkTest04993 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a62165 = param; //assign
		StringBuilder b62165 = new StringBuilder(a62165);  // stick in stringbuilder
		b62165.append(" SafeStuff"); // append some safe content
		b62165.replace(b62165.length()-"Chars".length(),b62165.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62165 = new java.util.HashMap<String,Object>();
		map62165.put("key62165", b62165.toString()); // put in a collection
		String c62165 = (String)map62165.get("key62165"); // get it back out
		String d62165 = c62165.substring(0,c62165.length()-1); // extract most of it
		String e62165 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62165.getBytes() ) )); // B64 encode and decode it
		String f62165 = e62165.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62165); // reflection
		
		
		response.getWriter().println(bar);
	}
}
