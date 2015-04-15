package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04207")
public class BenchmarkTest04207 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a13107 = param; //assign
		StringBuilder b13107 = new StringBuilder(a13107);  // stick in stringbuilder
		b13107.append(" SafeStuff"); // append some safe content
		b13107.replace(b13107.length()-"Chars".length(),b13107.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13107 = new java.util.HashMap<String,Object>();
		map13107.put("key13107", b13107.toString()); // put in a collection
		String c13107 = (String)map13107.get("key13107"); // get it back out
		String d13107 = c13107.substring(0,c13107.length()-1); // extract most of it
		String e13107 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13107.getBytes() ) )); // B64 encode and decode it
		String f13107 = e13107.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g13107 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g13107); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
