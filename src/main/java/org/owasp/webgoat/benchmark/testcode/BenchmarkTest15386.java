package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15386")
public class BenchmarkTest15386 extends HttpServlet {
	
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
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case");
			//throw new ServletException(e); - default provider (SUN) does not have any cipher instances
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case");
			//throw new ServletException(e); - default provider (SUN) does not have any cipher instances
		}
		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27367 = param; //assign
		StringBuilder b27367 = new StringBuilder(a27367);  // stick in stringbuilder
		b27367.append(" SafeStuff"); // append some safe content
		b27367.replace(b27367.length()-"Chars".length(),b27367.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27367 = new java.util.HashMap<String,Object>();
		map27367.put("key27367", b27367.toString()); // put in a collection
		String c27367 = (String)map27367.get("key27367"); // get it back out
		String d27367 = c27367.substring(0,c27367.length()-1); // extract most of it
		String e27367 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27367.getBytes() ) )); // B64 encode and decode it
		String f27367 = e27367.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27367); // reflection
	
		return bar;	
	}
}
