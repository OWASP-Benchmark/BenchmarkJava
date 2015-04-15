package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19836")
public class BenchmarkTest19836 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a49919 = param; //assign
		StringBuilder b49919 = new StringBuilder(a49919);  // stick in stringbuilder
		b49919.append(" SafeStuff"); // append some safe content
		b49919.replace(b49919.length()-"Chars".length(),b49919.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49919 = new java.util.HashMap<String,Object>();
		map49919.put("key49919", b49919.toString()); // put in a collection
		String c49919 = (String)map49919.get("key49919"); // get it back out
		String d49919 = c49919.substring(0,c49919.length()-1); // extract most of it
		String e49919 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49919.getBytes() ) )); // B64 encode and decode it
		String f49919 = e49919.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f49919); // reflection
	
		return bar;	
	}
}
