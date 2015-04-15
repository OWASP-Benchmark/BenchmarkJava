package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16728")
public class BenchmarkTest16728 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a83029 = param; //assign
		StringBuilder b83029 = new StringBuilder(a83029);  // stick in stringbuilder
		b83029.append(" SafeStuff"); // append some safe content
		b83029.replace(b83029.length()-"Chars".length(),b83029.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83029 = new java.util.HashMap<String,Object>();
		map83029.put("key83029", b83029.toString()); // put in a collection
		String c83029 = (String)map83029.get("key83029"); // get it back out
		String d83029 = c83029.substring(0,c83029.length()-1); // extract most of it
		String e83029 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83029.getBytes() ) )); // B64 encode and decode it
		String f83029 = e83029.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83029 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83029); // reflection
	
		return bar;	
	}
}
