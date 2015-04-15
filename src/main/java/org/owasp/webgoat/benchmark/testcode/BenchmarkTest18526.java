package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18526")
public class BenchmarkTest18526 extends HttpServlet {
	
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
		
		java.security.Provider[] provider = java.security.Security.getProviders();
		javax.crypto.Cipher c;

		try {
			if (provider.length > 1) {
				c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5PADDING", java.security.Security.getProvider("SunJCE"));
			} else {
				c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5PADDING", java.security.Security.getProvider("SunJCE"));
			}
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			// throw new ServletException(e);
		/*} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			// throw new ServletException(e); ok for now to swallow this */
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			// throw new ServletException(e);
		}
		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a78770 = param; //assign
		StringBuilder b78770 = new StringBuilder(a78770);  // stick in stringbuilder
		b78770.append(" SafeStuff"); // append some safe content
		b78770.replace(b78770.length()-"Chars".length(),b78770.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78770 = new java.util.HashMap<String,Object>();
		map78770.put("key78770", b78770.toString()); // put in a collection
		String c78770 = (String)map78770.get("key78770"); // get it back out
		String d78770 = c78770.substring(0,c78770.length()-1); // extract most of it
		String e78770 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78770.getBytes() ) )); // B64 encode and decode it
		String f78770 = e78770.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g78770 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78770); // reflection
	
		return bar;	
	}
}
