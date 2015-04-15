package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06767")
public class BenchmarkTest06767 extends HttpServlet {
	
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
		String a91311 = param; //assign
		StringBuilder b91311 = new StringBuilder(a91311);  // stick in stringbuilder
		b91311.append(" SafeStuff"); // append some safe content
		b91311.replace(b91311.length()-"Chars".length(),b91311.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91311 = new java.util.HashMap<String,Object>();
		map91311.put("key91311", b91311.toString()); // put in a collection
		String c91311 = (String)map91311.get("key91311"); // get it back out
		String d91311 = c91311.substring(0,c91311.length()-1); // extract most of it
		String e91311 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91311.getBytes() ) )); // B64 encode and decode it
		String f91311 = e91311.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f91311); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}
