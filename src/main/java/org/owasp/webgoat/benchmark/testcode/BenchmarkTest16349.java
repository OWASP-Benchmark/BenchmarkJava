package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16349")
public class BenchmarkTest16349 extends HttpServlet {
	
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
		String a40469 = param; //assign
		StringBuilder b40469 = new StringBuilder(a40469);  // stick in stringbuilder
		b40469.append(" SafeStuff"); // append some safe content
		b40469.replace(b40469.length()-"Chars".length(),b40469.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40469 = new java.util.HashMap<String,Object>();
		map40469.put("key40469", b40469.toString()); // put in a collection
		String c40469 = (String)map40469.get("key40469"); // get it back out
		String d40469 = c40469.substring(0,c40469.length()-1); // extract most of it
		String e40469 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40469.getBytes() ) )); // B64 encode and decode it
		String f40469 = e40469.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g40469 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g40469); // reflection
	
		return bar;	
	}
}
