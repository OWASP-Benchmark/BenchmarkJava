package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01629")
public class BenchmarkTest01629 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a77529 = param; //assign
		StringBuilder b77529 = new StringBuilder(a77529);  // stick in stringbuilder
		b77529.append(" SafeStuff"); // append some safe content
		b77529.replace(b77529.length()-"Chars".length(),b77529.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77529 = new java.util.HashMap<String,Object>();
		map77529.put("key77529", b77529.toString()); // put in a collection
		String c77529 = (String)map77529.get("key77529"); // get it back out
		String d77529 = c77529.substring(0,c77529.length()-1); // extract most of it
		String e77529 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77529.getBytes() ) )); // B64 encode and decode it
		String f77529 = e77529.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g77529 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g77529); // reflection
		
		
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
