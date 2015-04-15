package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02345")
public class BenchmarkTest02345 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a81408 = param; //assign
		StringBuilder b81408 = new StringBuilder(a81408);  // stick in stringbuilder
		b81408.append(" SafeStuff"); // append some safe content
		b81408.replace(b81408.length()-"Chars".length(),b81408.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81408 = new java.util.HashMap<String,Object>();
		map81408.put("key81408", b81408.toString()); // put in a collection
		String c81408 = (String)map81408.get("key81408"); // get it back out
		String d81408 = c81408.substring(0,c81408.length()-1); // extract most of it
		String e81408 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81408.getBytes() ) )); // B64 encode and decode it
		String f81408 = e81408.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f81408); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
