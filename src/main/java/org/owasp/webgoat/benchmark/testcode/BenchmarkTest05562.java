package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05562")
public class BenchmarkTest05562 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a82534 = param; //assign
		StringBuilder b82534 = new StringBuilder(a82534);  // stick in stringbuilder
		b82534.append(" SafeStuff"); // append some safe content
		b82534.replace(b82534.length()-"Chars".length(),b82534.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82534 = new java.util.HashMap<String,Object>();
		map82534.put("key82534", b82534.toString()); // put in a collection
		String c82534 = (String)map82534.get("key82534"); // get it back out
		String d82534 = c82534.substring(0,c82534.length()-1); // extract most of it
		String e82534 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82534.getBytes() ) )); // B64 encode and decode it
		String f82534 = e82534.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82534); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
