package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06175")
public class BenchmarkTest06175 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a29192 = param; //assign
		StringBuilder b29192 = new StringBuilder(a29192);  // stick in stringbuilder
		b29192.append(" SafeStuff"); // append some safe content
		b29192.replace(b29192.length()-"Chars".length(),b29192.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29192 = new java.util.HashMap<String,Object>();
		map29192.put("key29192", b29192.toString()); // put in a collection
		String c29192 = (String)map29192.get("key29192"); // get it back out
		String d29192 = c29192.substring(0,c29192.length()-1); // extract most of it
		String e29192 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29192.getBytes() ) )); // B64 encode and decode it
		String f29192 = e29192.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29192); // reflection
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
