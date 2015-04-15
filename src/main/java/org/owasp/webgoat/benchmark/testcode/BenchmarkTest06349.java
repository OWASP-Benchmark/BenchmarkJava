package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06349")
public class BenchmarkTest06349 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a83604 = param; //assign
		StringBuilder b83604 = new StringBuilder(a83604);  // stick in stringbuilder
		b83604.append(" SafeStuff"); // append some safe content
		b83604.replace(b83604.length()-"Chars".length(),b83604.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83604 = new java.util.HashMap<String,Object>();
		map83604.put("key83604", b83604.toString()); // put in a collection
		String c83604 = (String)map83604.get("key83604"); // get it back out
		String d83604 = c83604.substring(0,c83604.length()-1); // extract most of it
		String e83604 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83604.getBytes() ) )); // B64 encode and decode it
		String f83604 = e83604.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83604 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83604); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
