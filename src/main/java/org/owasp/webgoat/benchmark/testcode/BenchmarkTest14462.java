package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14462")
public class BenchmarkTest14462 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a90296 = param; //assign
		StringBuilder b90296 = new StringBuilder(a90296);  // stick in stringbuilder
		b90296.append(" SafeStuff"); // append some safe content
		b90296.replace(b90296.length()-"Chars".length(),b90296.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90296 = new java.util.HashMap<String,Object>();
		map90296.put("key90296", b90296.toString()); // put in a collection
		String c90296 = (String)map90296.get("key90296"); // get it back out
		String d90296 = c90296.substring(0,c90296.length()-1); // extract most of it
		String e90296 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90296.getBytes() ) )); // B64 encode and decode it
		String f90296 = e90296.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f90296); // reflection
	
		return bar;	
	}
}
