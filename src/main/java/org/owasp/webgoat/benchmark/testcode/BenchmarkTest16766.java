package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16766")
public class BenchmarkTest16766 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a1389 = param; //assign
		StringBuilder b1389 = new StringBuilder(a1389);  // stick in stringbuilder
		b1389.append(" SafeStuff"); // append some safe content
		b1389.replace(b1389.length()-"Chars".length(),b1389.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1389 = new java.util.HashMap<String,Object>();
		map1389.put("key1389", b1389.toString()); // put in a collection
		String c1389 = (String)map1389.get("key1389"); // get it back out
		String d1389 = c1389.substring(0,c1389.length()-1); // extract most of it
		String e1389 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1389.getBytes() ) )); // B64 encode and decode it
		String f1389 = e1389.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f1389); // reflection
	
		return bar;	
	}
}
