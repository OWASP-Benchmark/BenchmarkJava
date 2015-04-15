package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06182")
public class BenchmarkTest06182 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a65237 = param; //assign
		StringBuilder b65237 = new StringBuilder(a65237);  // stick in stringbuilder
		b65237.append(" SafeStuff"); // append some safe content
		b65237.replace(b65237.length()-"Chars".length(),b65237.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65237 = new java.util.HashMap<String,Object>();
		map65237.put("key65237", b65237.toString()); // put in a collection
		String c65237 = (String)map65237.get("key65237"); // get it back out
		String d65237 = c65237.substring(0,c65237.length()-1); // extract most of it
		String e65237 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65237.getBytes() ) )); // B64 encode and decode it
		String f65237 = e65237.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f65237); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
