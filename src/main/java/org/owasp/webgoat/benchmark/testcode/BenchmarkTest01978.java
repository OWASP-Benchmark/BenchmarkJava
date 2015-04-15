package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01978")
public class BenchmarkTest01978 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a9215 = param; //assign
		StringBuilder b9215 = new StringBuilder(a9215);  // stick in stringbuilder
		b9215.append(" SafeStuff"); // append some safe content
		b9215.replace(b9215.length()-"Chars".length(),b9215.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9215 = new java.util.HashMap<String,Object>();
		map9215.put("key9215", b9215.toString()); // put in a collection
		String c9215 = (String)map9215.get("key9215"); // get it back out
		String d9215 = c9215.substring(0,c9215.length()-1); // extract most of it
		String e9215 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9215.getBytes() ) )); // B64 encode and decode it
		String f9215 = e9215.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9215); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
