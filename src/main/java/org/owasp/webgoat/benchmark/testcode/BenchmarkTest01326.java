package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01326")
public class BenchmarkTest01326 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a25644 = param; //assign
		StringBuilder b25644 = new StringBuilder(a25644);  // stick in stringbuilder
		b25644.append(" SafeStuff"); // append some safe content
		b25644.replace(b25644.length()-"Chars".length(),b25644.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25644 = new java.util.HashMap<String,Object>();
		map25644.put("key25644", b25644.toString()); // put in a collection
		String c25644 = (String)map25644.get("key25644"); // get it back out
		String d25644 = c25644.substring(0,c25644.length()-1); // extract most of it
		String e25644 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25644.getBytes() ) )); // B64 encode and decode it
		String f25644 = e25644.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f25644); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
