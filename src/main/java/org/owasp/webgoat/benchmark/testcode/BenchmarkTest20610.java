package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20610")
public class BenchmarkTest20610 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47243 = param; //assign
		StringBuilder b47243 = new StringBuilder(a47243);  // stick in stringbuilder
		b47243.append(" SafeStuff"); // append some safe content
		b47243.replace(b47243.length()-"Chars".length(),b47243.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47243 = new java.util.HashMap<String,Object>();
		map47243.put("key47243", b47243.toString()); // put in a collection
		String c47243 = (String)map47243.get("key47243"); // get it back out
		String d47243 = c47243.substring(0,c47243.length()-1); // extract most of it
		String e47243 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47243.getBytes() ) )); // B64 encode and decode it
		String f47243 = e47243.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g47243 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47243); // reflection
	
		return bar;	
	}
}
