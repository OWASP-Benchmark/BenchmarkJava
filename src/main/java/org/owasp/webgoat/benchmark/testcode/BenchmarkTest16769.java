package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16769")
public class BenchmarkTest16769 extends HttpServlet {
	
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
		String a85476 = param; //assign
		StringBuilder b85476 = new StringBuilder(a85476);  // stick in stringbuilder
		b85476.append(" SafeStuff"); // append some safe content
		b85476.replace(b85476.length()-"Chars".length(),b85476.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85476 = new java.util.HashMap<String,Object>();
		map85476.put("key85476", b85476.toString()); // put in a collection
		String c85476 = (String)map85476.get("key85476"); // get it back out
		String d85476 = c85476.substring(0,c85476.length()-1); // extract most of it
		String e85476 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85476.getBytes() ) )); // B64 encode and decode it
		String f85476 = e85476.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g85476 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g85476); // reflection
	
		return bar;	
	}
}
