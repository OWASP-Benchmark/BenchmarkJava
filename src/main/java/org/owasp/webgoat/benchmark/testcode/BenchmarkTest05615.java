package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05615")
public class BenchmarkTest05615 extends HttpServlet {
	
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
		String a44922 = param; //assign
		StringBuilder b44922 = new StringBuilder(a44922);  // stick in stringbuilder
		b44922.append(" SafeStuff"); // append some safe content
		b44922.replace(b44922.length()-"Chars".length(),b44922.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44922 = new java.util.HashMap<String,Object>();
		map44922.put("key44922", b44922.toString()); // put in a collection
		String c44922 = (String)map44922.get("key44922"); // get it back out
		String d44922 = c44922.substring(0,c44922.length()-1); // extract most of it
		String e44922 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44922.getBytes() ) )); // B64 encode and decode it
		String f44922 = e44922.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44922); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}
}
