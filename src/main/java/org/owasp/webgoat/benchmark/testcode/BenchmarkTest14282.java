package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14282")
public class BenchmarkTest14282 extends HttpServlet {
	
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
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72834 = param; //assign
		StringBuilder b72834 = new StringBuilder(a72834);  // stick in stringbuilder
		b72834.append(" SafeStuff"); // append some safe content
		b72834.replace(b72834.length()-"Chars".length(),b72834.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72834 = new java.util.HashMap<String,Object>();
		map72834.put("key72834", b72834.toString()); // put in a collection
		String c72834 = (String)map72834.get("key72834"); // get it back out
		String d72834 = c72834.substring(0,c72834.length()-1); // extract most of it
		String e72834 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72834.getBytes() ) )); // B64 encode and decode it
		String f72834 = e72834.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72834); // reflection
	
		return bar;	
	}
}
