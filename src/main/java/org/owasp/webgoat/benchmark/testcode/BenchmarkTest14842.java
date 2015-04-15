package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14842")
public class BenchmarkTest14842 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19805 = param; //assign
		StringBuilder b19805 = new StringBuilder(a19805);  // stick in stringbuilder
		b19805.append(" SafeStuff"); // append some safe content
		b19805.replace(b19805.length()-"Chars".length(),b19805.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19805 = new java.util.HashMap<String,Object>();
		map19805.put("key19805", b19805.toString()); // put in a collection
		String c19805 = (String)map19805.get("key19805"); // get it back out
		String d19805 = c19805.substring(0,c19805.length()-1); // extract most of it
		String e19805 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19805.getBytes() ) )); // B64 encode and decode it
		String f19805 = e19805.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f19805); // reflection
	
		return bar;	
	}
}
