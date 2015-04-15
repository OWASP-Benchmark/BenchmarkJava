package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02953")
public class BenchmarkTest02953 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a34351 = param; //assign
		StringBuilder b34351 = new StringBuilder(a34351);  // stick in stringbuilder
		b34351.append(" SafeStuff"); // append some safe content
		b34351.replace(b34351.length()-"Chars".length(),b34351.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34351 = new java.util.HashMap<String,Object>();
		map34351.put("key34351", b34351.toString()); // put in a collection
		String c34351 = (String)map34351.get("key34351"); // get it back out
		String d34351 = c34351.substring(0,c34351.length()-1); // extract most of it
		String e34351 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34351.getBytes() ) )); // B64 encode and decode it
		String f34351 = e34351.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34351); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
