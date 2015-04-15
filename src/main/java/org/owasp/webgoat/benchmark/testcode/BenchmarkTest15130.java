package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15130")
public class BenchmarkTest15130 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a13055 = param; //assign
		StringBuilder b13055 = new StringBuilder(a13055);  // stick in stringbuilder
		b13055.append(" SafeStuff"); // append some safe content
		b13055.replace(b13055.length()-"Chars".length(),b13055.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13055 = new java.util.HashMap<String,Object>();
		map13055.put("key13055", b13055.toString()); // put in a collection
		String c13055 = (String)map13055.get("key13055"); // get it back out
		String d13055 = c13055.substring(0,c13055.length()-1); // extract most of it
		String e13055 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13055.getBytes() ) )); // B64 encode and decode it
		String f13055 = e13055.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f13055); // reflection
	
		return bar;	
	}
}
