package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03864")
public class BenchmarkTest03864 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a25683 = param; //assign
		StringBuilder b25683 = new StringBuilder(a25683);  // stick in stringbuilder
		b25683.append(" SafeStuff"); // append some safe content
		b25683.replace(b25683.length()-"Chars".length(),b25683.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25683 = new java.util.HashMap<String,Object>();
		map25683.put("key25683", b25683.toString()); // put in a collection
		String c25683 = (String)map25683.get("key25683"); // get it back out
		String d25683 = c25683.substring(0,c25683.length()-1); // extract most of it
		String e25683 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25683.getBytes() ) )); // B64 encode and decode it
		String f25683 = e25683.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f25683); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
