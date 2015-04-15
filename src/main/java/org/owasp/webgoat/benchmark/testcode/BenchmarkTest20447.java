package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20447")
public class BenchmarkTest20447 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51707 = param; //assign
		StringBuilder b51707 = new StringBuilder(a51707);  // stick in stringbuilder
		b51707.append(" SafeStuff"); // append some safe content
		b51707.replace(b51707.length()-"Chars".length(),b51707.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51707 = new java.util.HashMap<String,Object>();
		map51707.put("key51707", b51707.toString()); // put in a collection
		String c51707 = (String)map51707.get("key51707"); // get it back out
		String d51707 = c51707.substring(0,c51707.length()-1); // extract most of it
		String e51707 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51707.getBytes() ) )); // B64 encode and decode it
		String f51707 = e51707.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51707); // reflection
	
		return bar;	
	}
}
