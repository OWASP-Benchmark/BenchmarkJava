package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15743")
public class BenchmarkTest15743 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43785 = param; //assign
		StringBuilder b43785 = new StringBuilder(a43785);  // stick in stringbuilder
		b43785.append(" SafeStuff"); // append some safe content
		b43785.replace(b43785.length()-"Chars".length(),b43785.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43785 = new java.util.HashMap<String,Object>();
		map43785.put("key43785", b43785.toString()); // put in a collection
		String c43785 = (String)map43785.get("key43785"); // get it back out
		String d43785 = c43785.substring(0,c43785.length()-1); // extract most of it
		String e43785 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43785.getBytes() ) )); // B64 encode and decode it
		String f43785 = e43785.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f43785); // reflection
	
		return bar;	
	}
}
