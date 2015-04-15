package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03083")
public class BenchmarkTest03083 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a5913 = param; //assign
		StringBuilder b5913 = new StringBuilder(a5913);  // stick in stringbuilder
		b5913.append(" SafeStuff"); // append some safe content
		b5913.replace(b5913.length()-"Chars".length(),b5913.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5913 = new java.util.HashMap<String,Object>();
		map5913.put("key5913", b5913.toString()); // put in a collection
		String c5913 = (String)map5913.get("key5913"); // get it back out
		String d5913 = c5913.substring(0,c5913.length()-1); // extract most of it
		String e5913 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5913.getBytes() ) )); // B64 encode and decode it
		String f5913 = e5913.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f5913); // reflection
		
		
		response.getWriter().print(bar);
	}
}
