package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18230")
public class BenchmarkTest18230 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a16369 = param; //assign
		StringBuilder b16369 = new StringBuilder(a16369);  // stick in stringbuilder
		b16369.append(" SafeStuff"); // append some safe content
		b16369.replace(b16369.length()-"Chars".length(),b16369.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map16369 = new java.util.HashMap<String,Object>();
		map16369.put("key16369", b16369.toString()); // put in a collection
		String c16369 = (String)map16369.get("key16369"); // get it back out
		String d16369 = c16369.substring(0,c16369.length()-1); // extract most of it
		String e16369 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d16369.getBytes() ) )); // B64 encode and decode it
		String f16369 = e16369.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f16369); // reflection
	
		return bar;	
	}
}
