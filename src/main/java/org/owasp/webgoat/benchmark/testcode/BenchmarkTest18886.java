package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18886")
public class BenchmarkTest18886 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31426 = param; //assign
		StringBuilder b31426 = new StringBuilder(a31426);  // stick in stringbuilder
		b31426.append(" SafeStuff"); // append some safe content
		b31426.replace(b31426.length()-"Chars".length(),b31426.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31426 = new java.util.HashMap<String,Object>();
		map31426.put("key31426", b31426.toString()); // put in a collection
		String c31426 = (String)map31426.get("key31426"); // get it back out
		String d31426 = c31426.substring(0,c31426.length()-1); // extract most of it
		String e31426 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31426.getBytes() ) )); // B64 encode and decode it
		String f31426 = e31426.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f31426); // reflection
	
		return bar;	
	}
}
