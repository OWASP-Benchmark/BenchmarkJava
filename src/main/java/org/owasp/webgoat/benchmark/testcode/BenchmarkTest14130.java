package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14130")
public class BenchmarkTest14130 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58521 = param; //assign
		StringBuilder b58521 = new StringBuilder(a58521);  // stick in stringbuilder
		b58521.append(" SafeStuff"); // append some safe content
		b58521.replace(b58521.length()-"Chars".length(),b58521.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58521 = new java.util.HashMap<String,Object>();
		map58521.put("key58521", b58521.toString()); // put in a collection
		String c58521 = (String)map58521.get("key58521"); // get it back out
		String d58521 = c58521.substring(0,c58521.length()-1); // extract most of it
		String e58521 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58521.getBytes() ) )); // B64 encode and decode it
		String f58521 = e58521.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58521); // reflection
	
		return bar;	
	}
}
