package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01141")
public class BenchmarkTest01141 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a93417 = param; //assign
		StringBuilder b93417 = new StringBuilder(a93417);  // stick in stringbuilder
		b93417.append(" SafeStuff"); // append some safe content
		b93417.replace(b93417.length()-"Chars".length(),b93417.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93417 = new java.util.HashMap<String,Object>();
		map93417.put("key93417", b93417.toString()); // put in a collection
		String c93417 = (String)map93417.get("key93417"); // get it back out
		String d93417 = c93417.substring(0,c93417.length()-1); // extract most of it
		String e93417 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93417.getBytes() ) )); // B64 encode and decode it
		String f93417 = e93417.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93417); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}
