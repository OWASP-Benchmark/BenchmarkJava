package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03518")
public class BenchmarkTest03518 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a1406 = param; //assign
		StringBuilder b1406 = new StringBuilder(a1406);  // stick in stringbuilder
		b1406.append(" SafeStuff"); // append some safe content
		b1406.replace(b1406.length()-"Chars".length(),b1406.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1406 = new java.util.HashMap<String,Object>();
		map1406.put("key1406", b1406.toString()); // put in a collection
		String c1406 = (String)map1406.get("key1406"); // get it back out
		String d1406 = c1406.substring(0,c1406.length()-1); // extract most of it
		String e1406 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1406.getBytes() ) )); // B64 encode and decode it
		String f1406 = e1406.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f1406); // reflection
		
		
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			// throw new ServletException(e); - for now, it's ok if this provider not on the platform
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		}

		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) executed");
	}
}
