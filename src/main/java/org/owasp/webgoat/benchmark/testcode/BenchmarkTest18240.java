package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18240")
public class BenchmarkTest18240 extends HttpServlet {
	
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
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4904 = param; //assign
		StringBuilder b4904 = new StringBuilder(a4904);  // stick in stringbuilder
		b4904.append(" SafeStuff"); // append some safe content
		b4904.replace(b4904.length()-"Chars".length(),b4904.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4904 = new java.util.HashMap<String,Object>();
		map4904.put("key4904", b4904.toString()); // put in a collection
		String c4904 = (String)map4904.get("key4904"); // get it back out
		String d4904 = c4904.substring(0,c4904.length()-1); // extract most of it
		String e4904 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4904.getBytes() ) )); // B64 encode and decode it
		String f4904 = e4904.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4904); // reflection
	
		return bar;	
	}
}
