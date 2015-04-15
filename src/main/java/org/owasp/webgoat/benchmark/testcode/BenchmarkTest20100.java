package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20100")
public class BenchmarkTest20100 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93158 = param; //assign
		StringBuilder b93158 = new StringBuilder(a93158);  // stick in stringbuilder
		b93158.append(" SafeStuff"); // append some safe content
		b93158.replace(b93158.length()-"Chars".length(),b93158.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93158 = new java.util.HashMap<String,Object>();
		map93158.put("key93158", b93158.toString()); // put in a collection
		String c93158 = (String)map93158.get("key93158"); // get it back out
		String d93158 = c93158.substring(0,c93158.length()-1); // extract most of it
		String e93158 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93158.getBytes() ) )); // B64 encode and decode it
		String f93158 = e93158.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93158 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93158); // reflection
	
		return bar;	
	}
}
