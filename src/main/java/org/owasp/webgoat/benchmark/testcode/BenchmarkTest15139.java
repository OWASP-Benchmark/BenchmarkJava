package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15139")
public class BenchmarkTest15139 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72818 = param; //assign
		StringBuilder b72818 = new StringBuilder(a72818);  // stick in stringbuilder
		b72818.append(" SafeStuff"); // append some safe content
		b72818.replace(b72818.length()-"Chars".length(),b72818.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72818 = new java.util.HashMap<String,Object>();
		map72818.put("key72818", b72818.toString()); // put in a collection
		String c72818 = (String)map72818.get("key72818"); // get it back out
		String d72818 = c72818.substring(0,c72818.length()-1); // extract most of it
		String e72818 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72818.getBytes() ) )); // B64 encode and decode it
		String f72818 = e72818.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72818); // reflection
	
		return bar;	
	}
}
