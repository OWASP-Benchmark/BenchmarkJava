package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03877")
public class BenchmarkTest03877 extends HttpServlet {
	
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
		String a47870 = param; //assign
		StringBuilder b47870 = new StringBuilder(a47870);  // stick in stringbuilder
		b47870.append(" SafeStuff"); // append some safe content
		b47870.replace(b47870.length()-"Chars".length(),b47870.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47870 = new java.util.HashMap<String,Object>();
		map47870.put("key47870", b47870.toString()); // put in a collection
		String c47870 = (String)map47870.get("key47870"); // get it back out
		String d47870 = c47870.substring(0,c47870.length()-1); // extract most of it
		String e47870 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47870.getBytes() ) )); // B64 encode and decode it
		String f47870 = e47870.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47870); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
