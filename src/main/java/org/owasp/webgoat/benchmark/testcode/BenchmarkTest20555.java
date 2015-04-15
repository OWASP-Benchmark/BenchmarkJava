package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20555")
public class BenchmarkTest20555 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a65978 = param; //assign
		StringBuilder b65978 = new StringBuilder(a65978);  // stick in stringbuilder
		b65978.append(" SafeStuff"); // append some safe content
		b65978.replace(b65978.length()-"Chars".length(),b65978.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65978 = new java.util.HashMap<String,Object>();
		map65978.put("key65978", b65978.toString()); // put in a collection
		String c65978 = (String)map65978.get("key65978"); // get it back out
		String d65978 = c65978.substring(0,c65978.length()-1); // extract most of it
		String e65978 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65978.getBytes() ) )); // B64 encode and decode it
		String f65978 = e65978.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g65978 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g65978); // reflection
	
		return bar;	
	}
}
