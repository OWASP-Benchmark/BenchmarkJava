package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02099")
public class BenchmarkTest02099 extends HttpServlet {
	
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
		String a60715 = param; //assign
		StringBuilder b60715 = new StringBuilder(a60715);  // stick in stringbuilder
		b60715.append(" SafeStuff"); // append some safe content
		b60715.replace(b60715.length()-"Chars".length(),b60715.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60715 = new java.util.HashMap<String,Object>();
		map60715.put("key60715", b60715.toString()); // put in a collection
		String c60715 = (String)map60715.get("key60715"); // get it back out
		String d60715 = c60715.substring(0,c60715.length()-1); // extract most of it
		String e60715 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60715.getBytes() ) )); // B64 encode and decode it
		String f60715 = e60715.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g60715 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g60715); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
