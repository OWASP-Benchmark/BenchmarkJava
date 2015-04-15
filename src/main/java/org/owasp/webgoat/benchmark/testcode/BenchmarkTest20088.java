package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20088")
public class BenchmarkTest20088 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68722 = param; //assign
		StringBuilder b68722 = new StringBuilder(a68722);  // stick in stringbuilder
		b68722.append(" SafeStuff"); // append some safe content
		b68722.replace(b68722.length()-"Chars".length(),b68722.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68722 = new java.util.HashMap<String,Object>();
		map68722.put("key68722", b68722.toString()); // put in a collection
		String c68722 = (String)map68722.get("key68722"); // get it back out
		String d68722 = c68722.substring(0,c68722.length()-1); // extract most of it
		String e68722 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68722.getBytes() ) )); // B64 encode and decode it
		String f68722 = e68722.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68722); // reflection
	
		return bar;	
	}
}
