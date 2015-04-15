package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03676")
public class BenchmarkTest03676 extends HttpServlet {
	
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
		String a13684 = param; //assign
		StringBuilder b13684 = new StringBuilder(a13684);  // stick in stringbuilder
		b13684.append(" SafeStuff"); // append some safe content
		b13684.replace(b13684.length()-"Chars".length(),b13684.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13684 = new java.util.HashMap<String,Object>();
		map13684.put("key13684", b13684.toString()); // put in a collection
		String c13684 = (String)map13684.get("key13684"); // get it back out
		String d13684 = c13684.substring(0,c13684.length()-1); // extract most of it
		String e13684 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13684.getBytes() ) )); // B64 encode and decode it
		String f13684 = e13684.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g13684 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g13684); // reflection
		
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1", "Sun");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.lang.String) executed");
	}
}
