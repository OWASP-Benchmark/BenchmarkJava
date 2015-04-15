package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05837")
public class BenchmarkTest05837 extends HttpServlet {
	
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
		String a97223 = param; //assign
		StringBuilder b97223 = new StringBuilder(a97223);  // stick in stringbuilder
		b97223.append(" SafeStuff"); // append some safe content
		b97223.replace(b97223.length()-"Chars".length(),b97223.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97223 = new java.util.HashMap<String,Object>();
		map97223.put("key97223", b97223.toString()); // put in a collection
		String c97223 = (String)map97223.get("key97223"); // get it back out
		String d97223 = c97223.substring(0,c97223.length()-1); // extract most of it
		String e97223 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97223.getBytes() ) )); // B64 encode and decode it
		String f97223 = e97223.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f97223); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
