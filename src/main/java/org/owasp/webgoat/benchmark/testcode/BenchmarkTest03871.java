package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03871")
public class BenchmarkTest03871 extends HttpServlet {
	
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
		String a46439 = param; //assign
		StringBuilder b46439 = new StringBuilder(a46439);  // stick in stringbuilder
		b46439.append(" SafeStuff"); // append some safe content
		b46439.replace(b46439.length()-"Chars".length(),b46439.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46439 = new java.util.HashMap<String,Object>();
		map46439.put("key46439", b46439.toString()); // put in a collection
		String c46439 = (String)map46439.get("key46439"); // get it back out
		String d46439 = c46439.substring(0,c46439.length()-1); // extract most of it
		String e46439 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46439.getBytes() ) )); // B64 encode and decode it
		String f46439 = e46439.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f46439); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
