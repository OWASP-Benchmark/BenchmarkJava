package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02647")
public class BenchmarkTest02647 extends HttpServlet {
	
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
		String a31790 = param; //assign
		StringBuilder b31790 = new StringBuilder(a31790);  // stick in stringbuilder
		b31790.append(" SafeStuff"); // append some safe content
		b31790.replace(b31790.length()-"Chars".length(),b31790.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31790 = new java.util.HashMap<String,Object>();
		map31790.put("key31790", b31790.toString()); // put in a collection
		String c31790 = (String)map31790.get("key31790"); // get it back out
		String d31790 = c31790.substring(0,c31790.length()-1); // extract most of it
		String e31790 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31790.getBytes() ) )); // B64 encode and decode it
		String f31790 = e31790.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f31790); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
