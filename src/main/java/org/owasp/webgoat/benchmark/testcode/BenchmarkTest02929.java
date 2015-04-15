package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02929")
public class BenchmarkTest02929 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a72475 = param; //assign
		StringBuilder b72475 = new StringBuilder(a72475);  // stick in stringbuilder
		b72475.append(" SafeStuff"); // append some safe content
		b72475.replace(b72475.length()-"Chars".length(),b72475.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72475 = new java.util.HashMap<String,Object>();
		map72475.put("key72475", b72475.toString()); // put in a collection
		String c72475 = (String)map72475.get("key72475"); // get it back out
		String d72475 = c72475.substring(0,c72475.length()-1); // extract most of it
		String e72475 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72475.getBytes() ) )); // B64 encode and decode it
		String f72475 = e72475.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72475); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
