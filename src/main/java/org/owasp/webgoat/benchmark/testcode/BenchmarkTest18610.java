package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18610")
public class BenchmarkTest18610 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27140 = param; //assign
		StringBuilder b27140 = new StringBuilder(a27140);  // stick in stringbuilder
		b27140.append(" SafeStuff"); // append some safe content
		b27140.replace(b27140.length()-"Chars".length(),b27140.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27140 = new java.util.HashMap<String,Object>();
		map27140.put("key27140", b27140.toString()); // put in a collection
		String c27140 = (String)map27140.get("key27140"); // get it back out
		String d27140 = c27140.substring(0,c27140.length()-1); // extract most of it
		String e27140 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27140.getBytes() ) )); // B64 encode and decode it
		String f27140 = e27140.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27140); // reflection
	
		return bar;	
	}
}
