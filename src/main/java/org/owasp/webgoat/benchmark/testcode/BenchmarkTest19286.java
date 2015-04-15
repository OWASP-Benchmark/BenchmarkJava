package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19286")
public class BenchmarkTest19286 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

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
		String a32094 = param; //assign
		StringBuilder b32094 = new StringBuilder(a32094);  // stick in stringbuilder
		b32094.append(" SafeStuff"); // append some safe content
		b32094.replace(b32094.length()-"Chars".length(),b32094.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32094 = new java.util.HashMap<String,Object>();
		map32094.put("key32094", b32094.toString()); // put in a collection
		String c32094 = (String)map32094.get("key32094"); // get it back out
		String d32094 = c32094.substring(0,c32094.length()-1); // extract most of it
		String e32094 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32094.getBytes() ) )); // B64 encode and decode it
		String f32094 = e32094.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32094); // reflection
	
		return bar;	
	}
}
