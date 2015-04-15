package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06063")
public class BenchmarkTest06063 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a83601 = param; //assign
		StringBuilder b83601 = new StringBuilder(a83601);  // stick in stringbuilder
		b83601.append(" SafeStuff"); // append some safe content
		b83601.replace(b83601.length()-"Chars".length(),b83601.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83601 = new java.util.HashMap<String,Object>();
		map83601.put("key83601", b83601.toString()); // put in a collection
		String c83601 = (String)map83601.get("key83601"); // get it back out
		String d83601 = c83601.substring(0,c83601.length()-1); // extract most of it
		String e83601 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83601.getBytes() ) )); // B64 encode and decode it
		String f83601 = e83601.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83601); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
