package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14138")
public class BenchmarkTest14138 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a69495 = param; //assign
		StringBuilder b69495 = new StringBuilder(a69495);  // stick in stringbuilder
		b69495.append(" SafeStuff"); // append some safe content
		b69495.replace(b69495.length()-"Chars".length(),b69495.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map69495 = new java.util.HashMap<String,Object>();
		map69495.put("key69495", b69495.toString()); // put in a collection
		String c69495 = (String)map69495.get("key69495"); // get it back out
		String d69495 = c69495.substring(0,c69495.length()-1); // extract most of it
		String e69495 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d69495.getBytes() ) )); // B64 encode and decode it
		String f69495 = e69495.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f69495); // reflection
	
		return bar;	
	}
}
