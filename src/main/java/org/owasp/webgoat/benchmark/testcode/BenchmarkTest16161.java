package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16161")
public class BenchmarkTest16161 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
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
		String a12670 = param; //assign
		StringBuilder b12670 = new StringBuilder(a12670);  // stick in stringbuilder
		b12670.append(" SafeStuff"); // append some safe content
		b12670.replace(b12670.length()-"Chars".length(),b12670.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12670 = new java.util.HashMap<String,Object>();
		map12670.put("key12670", b12670.toString()); // put in a collection
		String c12670 = (String)map12670.get("key12670"); // get it back out
		String d12670 = c12670.substring(0,c12670.length()-1); // extract most of it
		String e12670 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12670.getBytes() ) )); // B64 encode and decode it
		String f12670 = e12670.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f12670); // reflection
	
		return bar;	
	}
}
