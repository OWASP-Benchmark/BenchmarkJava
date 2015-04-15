package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20517")
public class BenchmarkTest20517 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73967 = param; //assign
		StringBuilder b73967 = new StringBuilder(a73967);  // stick in stringbuilder
		b73967.append(" SafeStuff"); // append some safe content
		b73967.replace(b73967.length()-"Chars".length(),b73967.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73967 = new java.util.HashMap<String,Object>();
		map73967.put("key73967", b73967.toString()); // put in a collection
		String c73967 = (String)map73967.get("key73967"); // get it back out
		String d73967 = c73967.substring(0,c73967.length()-1); // extract most of it
		String e73967 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73967.getBytes() ) )); // B64 encode and decode it
		String f73967 = e73967.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73967); // reflection
	
		return bar;	
	}
}
