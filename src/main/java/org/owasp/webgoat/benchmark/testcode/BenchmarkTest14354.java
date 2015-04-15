package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14354")
public class BenchmarkTest14354 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a63606 = param; //assign
		StringBuilder b63606 = new StringBuilder(a63606);  // stick in stringbuilder
		b63606.append(" SafeStuff"); // append some safe content
		b63606.replace(b63606.length()-"Chars".length(),b63606.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63606 = new java.util.HashMap<String,Object>();
		map63606.put("key63606", b63606.toString()); // put in a collection
		String c63606 = (String)map63606.get("key63606"); // get it back out
		String d63606 = c63606.substring(0,c63606.length()-1); // extract most of it
		String e63606 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63606.getBytes() ) )); // B64 encode and decode it
		String f63606 = e63606.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63606); // reflection
	
		return bar;	
	}
}
