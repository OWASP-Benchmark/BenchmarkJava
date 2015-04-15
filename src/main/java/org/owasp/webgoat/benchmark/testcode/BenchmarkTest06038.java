package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06038")
public class BenchmarkTest06038 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a48735 = param; //assign
		StringBuilder b48735 = new StringBuilder(a48735);  // stick in stringbuilder
		b48735.append(" SafeStuff"); // append some safe content
		b48735.replace(b48735.length()-"Chars".length(),b48735.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48735 = new java.util.HashMap<String,Object>();
		map48735.put("key48735", b48735.toString()); // put in a collection
		String c48735 = (String)map48735.get("key48735"); // get it back out
		String d48735 = c48735.substring(0,c48735.length()-1); // extract most of it
		String e48735 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48735.getBytes() ) )); // B64 encode and decode it
		String f48735 = e48735.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48735); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
