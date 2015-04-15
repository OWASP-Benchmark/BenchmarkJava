package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16726")
public class BenchmarkTest16726 extends HttpServlet {
	
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
		String a49470 = param; //assign
		StringBuilder b49470 = new StringBuilder(a49470);  // stick in stringbuilder
		b49470.append(" SafeStuff"); // append some safe content
		b49470.replace(b49470.length()-"Chars".length(),b49470.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49470 = new java.util.HashMap<String,Object>();
		map49470.put("key49470", b49470.toString()); // put in a collection
		String c49470 = (String)map49470.get("key49470"); // get it back out
		String d49470 = c49470.substring(0,c49470.length()-1); // extract most of it
		String e49470 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49470.getBytes() ) )); // B64 encode and decode it
		String f49470 = e49470.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f49470); // reflection
	
		return bar;	
	}
}
