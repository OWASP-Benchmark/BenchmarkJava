package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20105")
public class BenchmarkTest20105 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95395 = param; //assign
		StringBuilder b95395 = new StringBuilder(a95395);  // stick in stringbuilder
		b95395.append(" SafeStuff"); // append some safe content
		b95395.replace(b95395.length()-"Chars".length(),b95395.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95395 = new java.util.HashMap<String,Object>();
		map95395.put("key95395", b95395.toString()); // put in a collection
		String c95395 = (String)map95395.get("key95395"); // get it back out
		String d95395 = c95395.substring(0,c95395.length()-1); // extract most of it
		String e95395 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95395.getBytes() ) )); // B64 encode and decode it
		String f95395 = e95395.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95395); // reflection
	
		return bar;	
	}
}
