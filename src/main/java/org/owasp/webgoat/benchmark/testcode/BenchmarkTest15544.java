package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15544")
public class BenchmarkTest15544 extends HttpServlet {
	
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
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44939 = param; //assign
		StringBuilder b44939 = new StringBuilder(a44939);  // stick in stringbuilder
		b44939.append(" SafeStuff"); // append some safe content
		b44939.replace(b44939.length()-"Chars".length(),b44939.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44939 = new java.util.HashMap<String,Object>();
		map44939.put("key44939", b44939.toString()); // put in a collection
		String c44939 = (String)map44939.get("key44939"); // get it back out
		String d44939 = c44939.substring(0,c44939.length()-1); // extract most of it
		String e44939 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44939.getBytes() ) )); // B64 encode and decode it
		String f44939 = e44939.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44939); // reflection
	
		return bar;	
	}
}
