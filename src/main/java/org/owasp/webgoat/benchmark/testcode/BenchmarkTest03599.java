package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03599")
public class BenchmarkTest03599 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a82403 = param; //assign
		StringBuilder b82403 = new StringBuilder(a82403);  // stick in stringbuilder
		b82403.append(" SafeStuff"); // append some safe content
		b82403.replace(b82403.length()-"Chars".length(),b82403.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82403 = new java.util.HashMap<String,Object>();
		map82403.put("key82403", b82403.toString()); // put in a collection
		String c82403 = (String)map82403.get("key82403"); // get it back out
		String d82403 = c82403.substring(0,c82403.length()-1); // extract most of it
		String e82403 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82403.getBytes() ) )); // B64 encode and decode it
		String f82403 = e82403.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82403); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
