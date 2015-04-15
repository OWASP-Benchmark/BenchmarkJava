package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02995")
public class BenchmarkTest02995 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a44407 = param; //assign
		StringBuilder b44407 = new StringBuilder(a44407);  // stick in stringbuilder
		b44407.append(" SafeStuff"); // append some safe content
		b44407.replace(b44407.length()-"Chars".length(),b44407.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44407 = new java.util.HashMap<String,Object>();
		map44407.put("key44407", b44407.toString()); // put in a collection
		String c44407 = (String)map44407.get("key44407"); // get it back out
		String d44407 = c44407.substring(0,c44407.length()-1); // extract most of it
		String e44407 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44407.getBytes() ) )); // B64 encode and decode it
		String f44407 = e44407.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44407); // reflection
		
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
