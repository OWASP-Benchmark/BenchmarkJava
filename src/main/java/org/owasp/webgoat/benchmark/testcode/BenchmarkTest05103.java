package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05103")
public class BenchmarkTest05103 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a78106 = param; //assign
		StringBuilder b78106 = new StringBuilder(a78106);  // stick in stringbuilder
		b78106.append(" SafeStuff"); // append some safe content
		b78106.replace(b78106.length()-"Chars".length(),b78106.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78106 = new java.util.HashMap<String,Object>();
		map78106.put("key78106", b78106.toString()); // put in a collection
		String c78106 = (String)map78106.get("key78106"); // get it back out
		String d78106 = c78106.substring(0,c78106.length()-1); // extract most of it
		String e78106 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78106.getBytes() ) )); // B64 encode and decode it
		String f78106 = e78106.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f78106); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
