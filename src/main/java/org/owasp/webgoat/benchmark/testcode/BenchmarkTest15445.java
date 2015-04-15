package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15445")
public class BenchmarkTest15445 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68615 = param; //assign
		StringBuilder b68615 = new StringBuilder(a68615);  // stick in stringbuilder
		b68615.append(" SafeStuff"); // append some safe content
		b68615.replace(b68615.length()-"Chars".length(),b68615.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68615 = new java.util.HashMap<String,Object>();
		map68615.put("key68615", b68615.toString()); // put in a collection
		String c68615 = (String)map68615.get("key68615"); // get it back out
		String d68615 = c68615.substring(0,c68615.length()-1); // extract most of it
		String e68615 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68615.getBytes() ) )); // B64 encode and decode it
		String f68615 = e68615.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68615); // reflection
	
		return bar;	
	}
}
