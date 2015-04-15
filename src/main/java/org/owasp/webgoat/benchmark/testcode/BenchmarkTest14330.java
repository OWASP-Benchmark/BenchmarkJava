package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14330")
public class BenchmarkTest14330 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40555 = param; //assign
		StringBuilder b40555 = new StringBuilder(a40555);  // stick in stringbuilder
		b40555.append(" SafeStuff"); // append some safe content
		b40555.replace(b40555.length()-"Chars".length(),b40555.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40555 = new java.util.HashMap<String,Object>();
		map40555.put("key40555", b40555.toString()); // put in a collection
		String c40555 = (String)map40555.get("key40555"); // get it back out
		String d40555 = c40555.substring(0,c40555.length()-1); // extract most of it
		String e40555 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40555.getBytes() ) )); // B64 encode and decode it
		String f40555 = e40555.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40555); // reflection
	
		return bar;	
	}
}
