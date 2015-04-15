package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03868")
public class BenchmarkTest03868 extends HttpServlet {
	
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
		String a1802 = param; //assign
		StringBuilder b1802 = new StringBuilder(a1802);  // stick in stringbuilder
		b1802.append(" SafeStuff"); // append some safe content
		b1802.replace(b1802.length()-"Chars".length(),b1802.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1802 = new java.util.HashMap<String,Object>();
		map1802.put("key1802", b1802.toString()); // put in a collection
		String c1802 = (String)map1802.get("key1802"); // get it back out
		String d1802 = c1802.substring(0,c1802.length()-1); // extract most of it
		String e1802 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1802.getBytes() ) )); // B64 encode and decode it
		String f1802 = e1802.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g1802 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1802); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
