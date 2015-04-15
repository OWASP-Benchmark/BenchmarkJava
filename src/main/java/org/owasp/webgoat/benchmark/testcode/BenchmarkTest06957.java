package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06957")
public class BenchmarkTest06957 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a83087 = param; //assign
		StringBuilder b83087 = new StringBuilder(a83087);  // stick in stringbuilder
		b83087.append(" SafeStuff"); // append some safe content
		b83087.replace(b83087.length()-"Chars".length(),b83087.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83087 = new java.util.HashMap<String,Object>();
		map83087.put("key83087", b83087.toString()); // put in a collection
		String c83087 = (String)map83087.get("key83087"); // get it back out
		String d83087 = c83087.substring(0,c83087.length()-1); // extract most of it
		String e83087 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83087.getBytes() ) )); // B64 encode and decode it
		String f83087 = e83087.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83087); // reflection
		
		
		response.addHeader(bar, "SomeValue");
	}
}
