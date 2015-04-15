package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19904")
public class BenchmarkTest19904 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a81571 = param; //assign
		StringBuilder b81571 = new StringBuilder(a81571);  // stick in stringbuilder
		b81571.append(" SafeStuff"); // append some safe content
		b81571.replace(b81571.length()-"Chars".length(),b81571.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81571 = new java.util.HashMap<String,Object>();
		map81571.put("key81571", b81571.toString()); // put in a collection
		String c81571 = (String)map81571.get("key81571"); // get it back out
		String d81571 = c81571.substring(0,c81571.length()-1); // extract most of it
		String e81571 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81571.getBytes() ) )); // B64 encode and decode it
		String f81571 = e81571.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f81571); // reflection
	
		return bar;	
	}
}
