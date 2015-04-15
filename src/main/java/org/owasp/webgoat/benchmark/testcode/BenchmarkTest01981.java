package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01981")
public class BenchmarkTest01981 extends HttpServlet {
	
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
		String a68042 = param; //assign
		StringBuilder b68042 = new StringBuilder(a68042);  // stick in stringbuilder
		b68042.append(" SafeStuff"); // append some safe content
		b68042.replace(b68042.length()-"Chars".length(),b68042.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68042 = new java.util.HashMap<String,Object>();
		map68042.put("key68042", b68042.toString()); // put in a collection
		String c68042 = (String)map68042.get("key68042"); // get it back out
		String d68042 = c68042.substring(0,c68042.length()-1); // extract most of it
		String e68042 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68042.getBytes() ) )); // B64 encode and decode it
		String f68042 = e68042.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g68042 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g68042); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
