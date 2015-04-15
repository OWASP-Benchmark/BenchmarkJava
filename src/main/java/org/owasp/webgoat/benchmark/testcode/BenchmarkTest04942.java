package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04942")
public class BenchmarkTest04942 extends HttpServlet {
	
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
		String a96936 = param; //assign
		StringBuilder b96936 = new StringBuilder(a96936);  // stick in stringbuilder
		b96936.append(" SafeStuff"); // append some safe content
		b96936.replace(b96936.length()-"Chars".length(),b96936.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96936 = new java.util.HashMap<String,Object>();
		map96936.put("key96936", b96936.toString()); // put in a collection
		String c96936 = (String)map96936.get("key96936"); // get it back out
		String d96936 = c96936.substring(0,c96936.length()-1); // extract most of it
		String e96936 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96936.getBytes() ) )); // B64 encode and decode it
		String f96936 = e96936.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f96936); // reflection
		
		
		response.getWriter().print(bar);
	}
}
