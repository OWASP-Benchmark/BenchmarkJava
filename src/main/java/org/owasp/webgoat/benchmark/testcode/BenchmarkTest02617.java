package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02617")
public class BenchmarkTest02617 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a57090 = param; //assign
		StringBuilder b57090 = new StringBuilder(a57090);  // stick in stringbuilder
		b57090.append(" SafeStuff"); // append some safe content
		b57090.replace(b57090.length()-"Chars".length(),b57090.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57090 = new java.util.HashMap<String,Object>();
		map57090.put("key57090", b57090.toString()); // put in a collection
		String c57090 = (String)map57090.get("key57090"); // get it back out
		String d57090 = c57090.substring(0,c57090.length()-1); // extract most of it
		String e57090 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57090.getBytes() ) )); // B64 encode and decode it
		String f57090 = e57090.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g57090 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g57090); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
