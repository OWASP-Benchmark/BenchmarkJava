package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15121")
public class BenchmarkTest15121 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a39774 = param; //assign
		StringBuilder b39774 = new StringBuilder(a39774);  // stick in stringbuilder
		b39774.append(" SafeStuff"); // append some safe content
		b39774.replace(b39774.length()-"Chars".length(),b39774.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39774 = new java.util.HashMap<String,Object>();
		map39774.put("key39774", b39774.toString()); // put in a collection
		String c39774 = (String)map39774.get("key39774"); // get it back out
		String d39774 = c39774.substring(0,c39774.length()-1); // extract most of it
		String e39774 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39774.getBytes() ) )); // B64 encode and decode it
		String f39774 = e39774.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f39774); // reflection
	
		return bar;	
	}
}
