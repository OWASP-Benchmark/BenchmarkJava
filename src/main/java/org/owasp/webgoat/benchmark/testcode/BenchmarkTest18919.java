package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18919")
public class BenchmarkTest18919 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a79439 = param; //assign
		StringBuilder b79439 = new StringBuilder(a79439);  // stick in stringbuilder
		b79439.append(" SafeStuff"); // append some safe content
		b79439.replace(b79439.length()-"Chars".length(),b79439.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79439 = new java.util.HashMap<String,Object>();
		map79439.put("key79439", b79439.toString()); // put in a collection
		String c79439 = (String)map79439.get("key79439"); // get it back out
		String d79439 = c79439.substring(0,c79439.length()-1); // extract most of it
		String e79439 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79439.getBytes() ) )); // B64 encode and decode it
		String f79439 = e79439.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g79439 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g79439); // reflection
	
		return bar;	
	}
}
