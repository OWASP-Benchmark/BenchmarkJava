package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06624")
public class BenchmarkTest06624 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a40660 = param; //assign
		StringBuilder b40660 = new StringBuilder(a40660);  // stick in stringbuilder
		b40660.append(" SafeStuff"); // append some safe content
		b40660.replace(b40660.length()-"Chars".length(),b40660.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40660 = new java.util.HashMap<String,Object>();
		map40660.put("key40660", b40660.toString()); // put in a collection
		String c40660 = (String)map40660.get("key40660"); // get it back out
		String d40660 = c40660.substring(0,c40660.length()-1); // extract most of it
		String e40660 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40660.getBytes() ) )); // B64 encode and decode it
		String f40660 = e40660.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g40660 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g40660); // reflection
		
		
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
	}
}
