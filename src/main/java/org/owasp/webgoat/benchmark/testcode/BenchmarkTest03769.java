package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03769")
public class BenchmarkTest03769 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a60903 = param; //assign
		StringBuilder b60903 = new StringBuilder(a60903);  // stick in stringbuilder
		b60903.append(" SafeStuff"); // append some safe content
		b60903.replace(b60903.length()-"Chars".length(),b60903.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60903 = new java.util.HashMap<String,Object>();
		map60903.put("key60903", b60903.toString()); // put in a collection
		String c60903 = (String)map60903.get("key60903"); // get it back out
		String d60903 = c60903.substring(0,c60903.length()-1); // extract most of it
		String e60903 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60903.getBytes() ) )); // B64 encode and decode it
		String f60903 = e60903.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f60903); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
