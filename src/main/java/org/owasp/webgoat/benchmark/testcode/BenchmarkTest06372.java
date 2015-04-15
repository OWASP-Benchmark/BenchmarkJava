package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06372")
public class BenchmarkTest06372 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a30547 = param; //assign
		StringBuilder b30547 = new StringBuilder(a30547);  // stick in stringbuilder
		b30547.append(" SafeStuff"); // append some safe content
		b30547.replace(b30547.length()-"Chars".length(),b30547.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30547 = new java.util.HashMap<String,Object>();
		map30547.put("key30547", b30547.toString()); // put in a collection
		String c30547 = (String)map30547.get("key30547"); // get it back out
		String d30547 = c30547.substring(0,c30547.length()-1); // extract most of it
		String e30547 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30547.getBytes() ) )); // B64 encode and decode it
		String f30547 = e30547.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30547); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
