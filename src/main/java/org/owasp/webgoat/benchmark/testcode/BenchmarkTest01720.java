package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01720")
public class BenchmarkTest01720 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a40928 = param; //assign
		StringBuilder b40928 = new StringBuilder(a40928);  // stick in stringbuilder
		b40928.append(" SafeStuff"); // append some safe content
		b40928.replace(b40928.length()-"Chars".length(),b40928.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40928 = new java.util.HashMap<String,Object>();
		map40928.put("key40928", b40928.toString()); // put in a collection
		String c40928 = (String)map40928.get("key40928"); // get it back out
		String d40928 = c40928.substring(0,c40928.length()-1); // extract most of it
		String e40928 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40928.getBytes() ) )); // B64 encode and decode it
		String f40928 = e40928.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40928); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}
}
