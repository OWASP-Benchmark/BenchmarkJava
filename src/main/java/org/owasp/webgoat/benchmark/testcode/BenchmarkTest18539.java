package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18539")
public class BenchmarkTest18539 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

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
		String a77038 = param; //assign
		StringBuilder b77038 = new StringBuilder(a77038);  // stick in stringbuilder
		b77038.append(" SafeStuff"); // append some safe content
		b77038.replace(b77038.length()-"Chars".length(),b77038.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77038 = new java.util.HashMap<String,Object>();
		map77038.put("key77038", b77038.toString()); // put in a collection
		String c77038 = (String)map77038.get("key77038"); // get it back out
		String d77038 = c77038.substring(0,c77038.length()-1); // extract most of it
		String e77038 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77038.getBytes() ) )); // B64 encode and decode it
		String f77038 = e77038.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77038); // reflection
	
		return bar;	
	}
}
