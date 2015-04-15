package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06207")
public class BenchmarkTest06207 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a69567 = param; //assign
		StringBuilder b69567 = new StringBuilder(a69567);  // stick in stringbuilder
		b69567.append(" SafeStuff"); // append some safe content
		b69567.replace(b69567.length()-"Chars".length(),b69567.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map69567 = new java.util.HashMap<String,Object>();
		map69567.put("key69567", b69567.toString()); // put in a collection
		String c69567 = (String)map69567.get("key69567"); // get it back out
		String d69567 = c69567.substring(0,c69567.length()-1); // extract most of it
		String e69567 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d69567.getBytes() ) )); // B64 encode and decode it
		String f69567 = e69567.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f69567); // reflection
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
