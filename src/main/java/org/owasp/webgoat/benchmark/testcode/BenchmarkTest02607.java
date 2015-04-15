package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02607")
public class BenchmarkTest02607 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a59746 = param; //assign
		StringBuilder b59746 = new StringBuilder(a59746);  // stick in stringbuilder
		b59746.append(" SafeStuff"); // append some safe content
		b59746.replace(b59746.length()-"Chars".length(),b59746.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59746 = new java.util.HashMap<String,Object>();
		map59746.put("key59746", b59746.toString()); // put in a collection
		String c59746 = (String)map59746.get("key59746"); // get it back out
		String d59746 = c59746.substring(0,c59746.length()-1); // extract most of it
		String e59746 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59746.getBytes() ) )); // B64 encode and decode it
		String f59746 = e59746.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g59746 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59746); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
