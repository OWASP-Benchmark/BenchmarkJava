package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05838")
public class BenchmarkTest05838 extends HttpServlet {
	
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
		String a37591 = param; //assign
		StringBuilder b37591 = new StringBuilder(a37591);  // stick in stringbuilder
		b37591.append(" SafeStuff"); // append some safe content
		b37591.replace(b37591.length()-"Chars".length(),b37591.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37591 = new java.util.HashMap<String,Object>();
		map37591.put("key37591", b37591.toString()); // put in a collection
		String c37591 = (String)map37591.get("key37591"); // get it back out
		String d37591 = c37591.substring(0,c37591.length()-1); // extract most of it
		String e37591 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37591.getBytes() ) )); // B64 encode and decode it
		String f37591 = e37591.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g37591 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g37591); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
