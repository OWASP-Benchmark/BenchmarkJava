package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15107")
public class BenchmarkTest15107 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83003 = param; //assign
		StringBuilder b83003 = new StringBuilder(a83003);  // stick in stringbuilder
		b83003.append(" SafeStuff"); // append some safe content
		b83003.replace(b83003.length()-"Chars".length(),b83003.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83003 = new java.util.HashMap<String,Object>();
		map83003.put("key83003", b83003.toString()); // put in a collection
		String c83003 = (String)map83003.get("key83003"); // get it back out
		String d83003 = c83003.substring(0,c83003.length()-1); // extract most of it
		String e83003 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83003.getBytes() ) )); // B64 encode and decode it
		String f83003 = e83003.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83003 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83003); // reflection
	
		return bar;	
	}
}
