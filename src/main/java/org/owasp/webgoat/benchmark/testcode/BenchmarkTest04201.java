package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04201")
public class BenchmarkTest04201 extends HttpServlet {
	
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
		String a40553 = param; //assign
		StringBuilder b40553 = new StringBuilder(a40553);  // stick in stringbuilder
		b40553.append(" SafeStuff"); // append some safe content
		b40553.replace(b40553.length()-"Chars".length(),b40553.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40553 = new java.util.HashMap<String,Object>();
		map40553.put("key40553", b40553.toString()); // put in a collection
		String c40553 = (String)map40553.get("key40553"); // get it back out
		String d40553 = c40553.substring(0,c40553.length()-1); // extract most of it
		String e40553 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40553.getBytes() ) )); // B64 encode and decode it
		String f40553 = e40553.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40553); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
