package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01043")
public class BenchmarkTest01043 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a87084 = param; //assign
		StringBuilder b87084 = new StringBuilder(a87084);  // stick in stringbuilder
		b87084.append(" SafeStuff"); // append some safe content
		b87084.replace(b87084.length()-"Chars".length(),b87084.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87084 = new java.util.HashMap<String,Object>();
		map87084.put("key87084", b87084.toString()); // put in a collection
		String c87084 = (String)map87084.get("key87084"); // get it back out
		String d87084 = c87084.substring(0,c87084.length()-1); // extract most of it
		String e87084 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87084.getBytes() ) )); // B64 encode and decode it
		String f87084 = e87084.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87084 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87084); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
