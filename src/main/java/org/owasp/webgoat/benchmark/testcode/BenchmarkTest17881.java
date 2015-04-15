package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17881")
public class BenchmarkTest17881 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

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
		String a94694 = param; //assign
		StringBuilder b94694 = new StringBuilder(a94694);  // stick in stringbuilder
		b94694.append(" SafeStuff"); // append some safe content
		b94694.replace(b94694.length()-"Chars".length(),b94694.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94694 = new java.util.HashMap<String,Object>();
		map94694.put("key94694", b94694.toString()); // put in a collection
		String c94694 = (String)map94694.get("key94694"); // get it back out
		String d94694 = c94694.substring(0,c94694.length()-1); // extract most of it
		String e94694 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94694.getBytes() ) )); // B64 encode and decode it
		String f94694 = e94694.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94694); // reflection
	
		return bar;	
	}
}
