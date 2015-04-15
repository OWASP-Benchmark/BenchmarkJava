package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05234")
public class BenchmarkTest05234 extends HttpServlet {
	
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
		String a57565 = param; //assign
		StringBuilder b57565 = new StringBuilder(a57565);  // stick in stringbuilder
		b57565.append(" SafeStuff"); // append some safe content
		b57565.replace(b57565.length()-"Chars".length(),b57565.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57565 = new java.util.HashMap<String,Object>();
		map57565.put("key57565", b57565.toString()); // put in a collection
		String c57565 = (String)map57565.get("key57565"); // get it back out
		String d57565 = c57565.substring(0,c57565.length()-1); // extract most of it
		String e57565 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57565.getBytes() ) )); // B64 encode and decode it
		String f57565 = e57565.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57565); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}
}
