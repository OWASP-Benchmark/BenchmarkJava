package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16353")
public class BenchmarkTest16353 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a80991 = param; //assign
		StringBuilder b80991 = new StringBuilder(a80991);  // stick in stringbuilder
		b80991.append(" SafeStuff"); // append some safe content
		b80991.replace(b80991.length()-"Chars".length(),b80991.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80991 = new java.util.HashMap<String,Object>();
		map80991.put("key80991", b80991.toString()); // put in a collection
		String c80991 = (String)map80991.get("key80991"); // get it back out
		String d80991 = c80991.substring(0,c80991.length()-1); // extract most of it
		String e80991 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80991.getBytes() ) )); // B64 encode and decode it
		String f80991 = e80991.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f80991); // reflection
	
		return bar;	
	}
}
