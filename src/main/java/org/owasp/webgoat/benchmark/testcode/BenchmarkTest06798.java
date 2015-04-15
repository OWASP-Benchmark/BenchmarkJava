package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06798")
public class BenchmarkTest06798 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a91986 = param; //assign
		StringBuilder b91986 = new StringBuilder(a91986);  // stick in stringbuilder
		b91986.append(" SafeStuff"); // append some safe content
		b91986.replace(b91986.length()-"Chars".length(),b91986.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91986 = new java.util.HashMap<String,Object>();
		map91986.put("key91986", b91986.toString()); // put in a collection
		String c91986 = (String)map91986.get("key91986"); // get it back out
		String d91986 = c91986.substring(0,c91986.length()-1); // extract most of it
		String e91986 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91986.getBytes() ) )); // B64 encode and decode it
		String f91986 = e91986.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g91986 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91986); // reflection
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
