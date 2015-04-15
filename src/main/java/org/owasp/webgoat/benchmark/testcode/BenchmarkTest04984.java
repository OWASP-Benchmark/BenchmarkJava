package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04984")
public class BenchmarkTest04984 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a73031 = param; //assign
		StringBuilder b73031 = new StringBuilder(a73031);  // stick in stringbuilder
		b73031.append(" SafeStuff"); // append some safe content
		b73031.replace(b73031.length()-"Chars".length(),b73031.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73031 = new java.util.HashMap<String,Object>();
		map73031.put("key73031", b73031.toString()); // put in a collection
		String c73031 = (String)map73031.get("key73031"); // get it back out
		String d73031 = c73031.substring(0,c73031.length()-1); // extract most of it
		String e73031 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73031.getBytes() ) )); // B64 encode and decode it
		String f73031 = e73031.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73031); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
