package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16357")
public class BenchmarkTest16357 extends HttpServlet {
	
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
		String a53955 = param; //assign
		StringBuilder b53955 = new StringBuilder(a53955);  // stick in stringbuilder
		b53955.append(" SafeStuff"); // append some safe content
		b53955.replace(b53955.length()-"Chars".length(),b53955.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53955 = new java.util.HashMap<String,Object>();
		map53955.put("key53955", b53955.toString()); // put in a collection
		String c53955 = (String)map53955.get("key53955"); // get it back out
		String d53955 = c53955.substring(0,c53955.length()-1); // extract most of it
		String e53955 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53955.getBytes() ) )); // B64 encode and decode it
		String f53955 = e53955.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g53955 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53955); // reflection
	
		return bar;	
	}
}
