package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18251")
public class BenchmarkTest18251 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40487 = param; //assign
		StringBuilder b40487 = new StringBuilder(a40487);  // stick in stringbuilder
		b40487.append(" SafeStuff"); // append some safe content
		b40487.replace(b40487.length()-"Chars".length(),b40487.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40487 = new java.util.HashMap<String,Object>();
		map40487.put("key40487", b40487.toString()); // put in a collection
		String c40487 = (String)map40487.get("key40487"); // get it back out
		String d40487 = c40487.substring(0,c40487.length()-1); // extract most of it
		String e40487 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40487.getBytes() ) )); // B64 encode and decode it
		String f40487 = e40487.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g40487 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g40487); // reflection
	
		return bar;	
	}
}
