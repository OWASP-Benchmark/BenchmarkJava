package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16686")
public class BenchmarkTest16686 extends HttpServlet {
	
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
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a80302 = param; //assign
		StringBuilder b80302 = new StringBuilder(a80302);  // stick in stringbuilder
		b80302.append(" SafeStuff"); // append some safe content
		b80302.replace(b80302.length()-"Chars".length(),b80302.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80302 = new java.util.HashMap<String,Object>();
		map80302.put("key80302", b80302.toString()); // put in a collection
		String c80302 = (String)map80302.get("key80302"); // get it back out
		String d80302 = c80302.substring(0,c80302.length()-1); // extract most of it
		String e80302 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80302.getBytes() ) )); // B64 encode and decode it
		String f80302 = e80302.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g80302 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g80302); // reflection
	
		return bar;	
	}
}
