package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16984")
public class BenchmarkTest16984 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31695 = param; //assign
		StringBuilder b31695 = new StringBuilder(a31695);  // stick in stringbuilder
		b31695.append(" SafeStuff"); // append some safe content
		b31695.replace(b31695.length()-"Chars".length(),b31695.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31695 = new java.util.HashMap<String,Object>();
		map31695.put("key31695", b31695.toString()); // put in a collection
		String c31695 = (String)map31695.get("key31695"); // get it back out
		String d31695 = c31695.substring(0,c31695.length()-1); // extract most of it
		String e31695 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31695.getBytes() ) )); // B64 encode and decode it
		String f31695 = e31695.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g31695 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31695); // reflection
	
		return bar;	
	}
}
