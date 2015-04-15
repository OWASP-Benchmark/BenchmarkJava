package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15477")
public class BenchmarkTest15477 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a99479 = param; //assign
		StringBuilder b99479 = new StringBuilder(a99479);  // stick in stringbuilder
		b99479.append(" SafeStuff"); // append some safe content
		b99479.replace(b99479.length()-"Chars".length(),b99479.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99479 = new java.util.HashMap<String,Object>();
		map99479.put("key99479", b99479.toString()); // put in a collection
		String c99479 = (String)map99479.get("key99479"); // get it back out
		String d99479 = c99479.substring(0,c99479.length()-1); // extract most of it
		String e99479 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99479.getBytes() ) )); // B64 encode and decode it
		String f99479 = e99479.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f99479); // reflection
	
		return bar;	
	}
}
