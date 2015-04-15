package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20498")
public class BenchmarkTest20498 extends HttpServlet {
	
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
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1", "Sun");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.lang.String) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97149 = param; //assign
		StringBuilder b97149 = new StringBuilder(a97149);  // stick in stringbuilder
		b97149.append(" SafeStuff"); // append some safe content
		b97149.replace(b97149.length()-"Chars".length(),b97149.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97149 = new java.util.HashMap<String,Object>();
		map97149.put("key97149", b97149.toString()); // put in a collection
		String c97149 = (String)map97149.get("key97149"); // get it back out
		String d97149 = c97149.substring(0,c97149.length()-1); // extract most of it
		String e97149 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97149.getBytes() ) )); // B64 encode and decode it
		String f97149 = e97149.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f97149); // reflection
	
		return bar;	
	}
}
