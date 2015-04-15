package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20423")
public class BenchmarkTest20423 extends HttpServlet {
	
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
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15688 = param; //assign
		StringBuilder b15688 = new StringBuilder(a15688);  // stick in stringbuilder
		b15688.append(" SafeStuff"); // append some safe content
		b15688.replace(b15688.length()-"Chars".length(),b15688.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15688 = new java.util.HashMap<String,Object>();
		map15688.put("key15688", b15688.toString()); // put in a collection
		String c15688 = (String)map15688.get("key15688"); // get it back out
		String d15688 = c15688.substring(0,c15688.length()-1); // extract most of it
		String e15688 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15688.getBytes() ) )); // B64 encode and decode it
		String f15688 = e15688.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f15688); // reflection
	
		return bar;	
	}
}
