package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06091")
public class BenchmarkTest06091 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a2727 = param; //assign
		StringBuilder b2727 = new StringBuilder(a2727);  // stick in stringbuilder
		b2727.append(" SafeStuff"); // append some safe content
		b2727.replace(b2727.length()-"Chars".length(),b2727.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2727 = new java.util.HashMap<String,Object>();
		map2727.put("key2727", b2727.toString()); // put in a collection
		String c2727 = (String)map2727.get("key2727"); // get it back out
		String d2727 = c2727.substring(0,c2727.length()-1); // extract most of it
		String e2727 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2727.getBytes() ) )); // B64 encode and decode it
		String f2727 = e2727.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f2727); // reflection
		
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
