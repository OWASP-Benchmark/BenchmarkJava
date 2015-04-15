package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16345")
public class BenchmarkTest16345 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68636 = param; //assign
		StringBuilder b68636 = new StringBuilder(a68636);  // stick in stringbuilder
		b68636.append(" SafeStuff"); // append some safe content
		b68636.replace(b68636.length()-"Chars".length(),b68636.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68636 = new java.util.HashMap<String,Object>();
		map68636.put("key68636", b68636.toString()); // put in a collection
		String c68636 = (String)map68636.get("key68636"); // get it back out
		String d68636 = c68636.substring(0,c68636.length()-1); // extract most of it
		String e68636 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68636.getBytes() ) )); // B64 encode and decode it
		String f68636 = e68636.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68636); // reflection
	
		return bar;	
	}
}
