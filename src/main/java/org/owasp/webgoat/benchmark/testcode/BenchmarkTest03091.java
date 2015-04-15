package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03091")
public class BenchmarkTest03091 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a20419 = param; //assign
		StringBuilder b20419 = new StringBuilder(a20419);  // stick in stringbuilder
		b20419.append(" SafeStuff"); // append some safe content
		b20419.replace(b20419.length()-"Chars".length(),b20419.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20419 = new java.util.HashMap<String,Object>();
		map20419.put("key20419", b20419.toString()); // put in a collection
		String c20419 = (String)map20419.get("key20419"); // get it back out
		String d20419 = c20419.substring(0,c20419.length()-1); // extract most of it
		String e20419 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20419.getBytes() ) )); // B64 encode and decode it
		String f20419 = e20419.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f20419); // reflection
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
