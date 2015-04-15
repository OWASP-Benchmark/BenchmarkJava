package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14453")
public class BenchmarkTest14453 extends HttpServlet {
	
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
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92911 = param; //assign
		StringBuilder b92911 = new StringBuilder(a92911);  // stick in stringbuilder
		b92911.append(" SafeStuff"); // append some safe content
		b92911.replace(b92911.length()-"Chars".length(),b92911.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92911 = new java.util.HashMap<String,Object>();
		map92911.put("key92911", b92911.toString()); // put in a collection
		String c92911 = (String)map92911.get("key92911"); // get it back out
		String d92911 = c92911.substring(0,c92911.length()-1); // extract most of it
		String e92911 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92911.getBytes() ) )); // B64 encode and decode it
		String f92911 = e92911.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f92911); // reflection
	
		return bar;	
	}
}
