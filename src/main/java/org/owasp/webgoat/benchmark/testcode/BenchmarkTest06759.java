package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06759")
public class BenchmarkTest06759 extends HttpServlet {
	
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
		String a48464 = param; //assign
		StringBuilder b48464 = new StringBuilder(a48464);  // stick in stringbuilder
		b48464.append(" SafeStuff"); // append some safe content
		b48464.replace(b48464.length()-"Chars".length(),b48464.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48464 = new java.util.HashMap<String,Object>();
		map48464.put("key48464", b48464.toString()); // put in a collection
		String c48464 = (String)map48464.get("key48464"); // get it back out
		String d48464 = c48464.substring(0,c48464.length()-1); // extract most of it
		String e48464 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48464.getBytes() ) )); // B64 encode and decode it
		String f48464 = e48464.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48464); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}
}
