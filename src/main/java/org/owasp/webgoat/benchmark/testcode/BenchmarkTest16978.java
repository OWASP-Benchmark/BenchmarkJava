package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16978")
public class BenchmarkTest16978 extends HttpServlet {
	
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
		String a93922 = param; //assign
		StringBuilder b93922 = new StringBuilder(a93922);  // stick in stringbuilder
		b93922.append(" SafeStuff"); // append some safe content
		b93922.replace(b93922.length()-"Chars".length(),b93922.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93922 = new java.util.HashMap<String,Object>();
		map93922.put("key93922", b93922.toString()); // put in a collection
		String c93922 = (String)map93922.get("key93922"); // get it back out
		String d93922 = c93922.substring(0,c93922.length()-1); // extract most of it
		String e93922 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93922.getBytes() ) )); // B64 encode and decode it
		String f93922 = e93922.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93922); // reflection
	
		return bar;	
	}
}
