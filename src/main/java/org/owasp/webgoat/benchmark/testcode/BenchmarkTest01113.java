package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01113")
public class BenchmarkTest01113 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a35393 = param; //assign
		StringBuilder b35393 = new StringBuilder(a35393);  // stick in stringbuilder
		b35393.append(" SafeStuff"); // append some safe content
		b35393.replace(b35393.length()-"Chars".length(),b35393.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35393 = new java.util.HashMap<String,Object>();
		map35393.put("key35393", b35393.toString()); // put in a collection
		String c35393 = (String)map35393.get("key35393"); // get it back out
		String d35393 = c35393.substring(0,c35393.length()-1); // extract most of it
		String e35393 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35393.getBytes() ) )); // B64 encode and decode it
		String f35393 = e35393.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35393 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35393); // reflection
		
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1", "Sun");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.lang.String) executed");
	}
}
