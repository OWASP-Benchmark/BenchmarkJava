package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05529")
public class BenchmarkTest05529 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a19201 = param; //assign
		StringBuilder b19201 = new StringBuilder(a19201);  // stick in stringbuilder
		b19201.append(" SafeStuff"); // append some safe content
		b19201.replace(b19201.length()-"Chars".length(),b19201.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19201 = new java.util.HashMap<String,Object>();
		map19201.put("key19201", b19201.toString()); // put in a collection
		String c19201 = (String)map19201.get("key19201"); // get it back out
		String d19201 = c19201.substring(0,c19201.length()-1); // extract most of it
		String e19201 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19201.getBytes() ) )); // B64 encode and decode it
		String f19201 = e19201.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19201 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19201); // reflection
		
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}
}
