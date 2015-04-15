package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06050")
public class BenchmarkTest06050 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a18551 = param; //assign
		StringBuilder b18551 = new StringBuilder(a18551);  // stick in stringbuilder
		b18551.append(" SafeStuff"); // append some safe content
		b18551.replace(b18551.length()-"Chars".length(),b18551.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18551 = new java.util.HashMap<String,Object>();
		map18551.put("key18551", b18551.toString()); // put in a collection
		String c18551 = (String)map18551.get("key18551"); // get it back out
		String d18551 = c18551.substring(0,c18551.length()-1); // extract most of it
		String e18551 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18551.getBytes() ) )); // B64 encode and decode it
		String f18551 = e18551.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f18551); // reflection
		
		
		// FILE URIs are tricky because they are different between Mac and Windows because of lack of standardization.
		// Mac requires an extra slash for some reason.
		String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        	startURIslashes = "/";
	        else startURIslashes = "//";

		try {
			java.net.URI fileURI = new java.net.URI("file:" + startURIslashes 
				+ org.owasp.webgoat.benchmark.helpers.Utils.testfileDir.replace('\\', '/').replace(' ', '_') + bar);
			new java.io.File(fileURI);
		} catch (java.net.URISyntaxException e) {
			throw new ServletException(e);
		}
	}
}
