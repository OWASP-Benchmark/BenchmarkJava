package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03037")
public class BenchmarkTest03037 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a9571 = param; //assign
		StringBuilder b9571 = new StringBuilder(a9571);  // stick in stringbuilder
		b9571.append(" SafeStuff"); // append some safe content
		b9571.replace(b9571.length()-"Chars".length(),b9571.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9571 = new java.util.HashMap<String,Object>();
		map9571.put("key9571", b9571.toString()); // put in a collection
		String c9571 = (String)map9571.get("key9571"); // get it back out
		String d9571 = c9571.substring(0,c9571.length()-1); // extract most of it
		String e9571 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9571.getBytes() ) )); // B64 encode and decode it
		String f9571 = e9571.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9571); // reflection
		
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}
}
