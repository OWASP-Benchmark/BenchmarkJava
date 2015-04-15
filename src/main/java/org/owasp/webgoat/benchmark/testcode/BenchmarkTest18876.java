package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18876")
public class BenchmarkTest18876 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67232 = param; //assign
		StringBuilder b67232 = new StringBuilder(a67232);  // stick in stringbuilder
		b67232.append(" SafeStuff"); // append some safe content
		b67232.replace(b67232.length()-"Chars".length(),b67232.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67232 = new java.util.HashMap<String,Object>();
		map67232.put("key67232", b67232.toString()); // put in a collection
		String c67232 = (String)map67232.get("key67232"); // get it back out
		String d67232 = c67232.substring(0,c67232.length()-1); // extract most of it
		String e67232 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67232.getBytes() ) )); // B64 encode and decode it
		String f67232 = e67232.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g67232 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g67232); // reflection
	
		return bar;	
	}
}
