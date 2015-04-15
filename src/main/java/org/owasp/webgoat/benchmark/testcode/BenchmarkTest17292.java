package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17292")
public class BenchmarkTest17292 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		// FILE URIs are tricky because they are different between Mac and Windows because of lack of standardization.
		// Mac requires an extra slash for some reason.
		String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        	startURIslashes = "/";
	        else startURIslashes = "//";

		try {
			java.net.URI fileURI = new java.net.URI("file", null, startURIslashes 
				+ org.owasp.webgoat.benchmark.helpers.Utils.testfileDir.replace('\\', java.io.File.separatorChar).replace(' ', '_') + bar, null, null);
			new java.io.File(fileURI);
		} catch (java.net.URISyntaxException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23156 = param; //assign
		StringBuilder b23156 = new StringBuilder(a23156);  // stick in stringbuilder
		b23156.append(" SafeStuff"); // append some safe content
		b23156.replace(b23156.length()-"Chars".length(),b23156.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23156 = new java.util.HashMap<String,Object>();
		map23156.put("key23156", b23156.toString()); // put in a collection
		String c23156 = (String)map23156.get("key23156"); // get it back out
		String d23156 = c23156.substring(0,c23156.length()-1); // extract most of it
		String e23156 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23156.getBytes() ) )); // B64 encode and decode it
		String f23156 = e23156.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23156); // reflection
	
		return bar;	
	}
}
