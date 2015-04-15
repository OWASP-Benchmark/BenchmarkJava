package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00425")
public class BenchmarkTest00425 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}
		
		
		// Chain a bunch of propagators in sequence
		String a97313 = param; //assign
		StringBuilder b97313 = new StringBuilder(a97313);  // stick in stringbuilder
		b97313.append(" SafeStuff"); // append some safe content
		b97313.replace(b97313.length()-"Chars".length(),b97313.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97313 = new java.util.HashMap<String,Object>();
		map97313.put("key97313", b97313.toString()); // put in a collection
		String c97313 = (String)map97313.get("key97313"); // get it back out
		String d97313 = c97313.substring(0,c97313.length()-1); // extract most of it
		String e97313 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97313.getBytes() ) )); // B64 encode and decode it
		String f97313 = e97313.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g97313 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g97313); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
