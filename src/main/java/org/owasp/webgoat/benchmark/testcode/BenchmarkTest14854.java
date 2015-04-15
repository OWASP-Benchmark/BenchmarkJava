package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14854")
public class BenchmarkTest14854 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88457 = param; //assign
		StringBuilder b88457 = new StringBuilder(a88457);  // stick in stringbuilder
		b88457.append(" SafeStuff"); // append some safe content
		b88457.replace(b88457.length()-"Chars".length(),b88457.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88457 = new java.util.HashMap<String,Object>();
		map88457.put("key88457", b88457.toString()); // put in a collection
		String c88457 = (String)map88457.get("key88457"); // get it back out
		String d88457 = c88457.substring(0,c88457.length()-1); // extract most of it
		String e88457 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88457.getBytes() ) )); // B64 encode and decode it
		String f88457 = e88457.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g88457 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88457); // reflection
	
		return bar;	
	}
}
