package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15002")
public class BenchmarkTest15002 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62392 = param; //assign
		StringBuilder b62392 = new StringBuilder(a62392);  // stick in stringbuilder
		b62392.append(" SafeStuff"); // append some safe content
		b62392.replace(b62392.length()-"Chars".length(),b62392.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62392 = new java.util.HashMap<String,Object>();
		map62392.put("key62392", b62392.toString()); // put in a collection
		String c62392 = (String)map62392.get("key62392"); // get it back out
		String d62392 = c62392.substring(0,c62392.length()-1); // extract most of it
		String e62392 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62392.getBytes() ) )); // B64 encode and decode it
		String f62392 = e62392.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62392); // reflection
	
		return bar;	
	}
}
