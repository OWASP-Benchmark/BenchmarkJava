package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05581")
public class BenchmarkTest05581 extends HttpServlet {
	
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
		String a70639 = param; //assign
		StringBuilder b70639 = new StringBuilder(a70639);  // stick in stringbuilder
		b70639.append(" SafeStuff"); // append some safe content
		b70639.replace(b70639.length()-"Chars".length(),b70639.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70639 = new java.util.HashMap<String,Object>();
		map70639.put("key70639", b70639.toString()); // put in a collection
		String c70639 = (String)map70639.get("key70639"); // get it back out
		String d70639 = c70639.substring(0,c70639.length()-1); // extract most of it
		String e70639 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70639.getBytes() ) )); // B64 encode and decode it
		String f70639 = e70639.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70639); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
