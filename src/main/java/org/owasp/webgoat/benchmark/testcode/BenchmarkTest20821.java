package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20821")
public class BenchmarkTest20821 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3886 = param; //assign
		StringBuilder b3886 = new StringBuilder(a3886);  // stick in stringbuilder
		b3886.append(" SafeStuff"); // append some safe content
		b3886.replace(b3886.length()-"Chars".length(),b3886.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3886 = new java.util.HashMap<String,Object>();
		map3886.put("key3886", b3886.toString()); // put in a collection
		String c3886 = (String)map3886.get("key3886"); // get it back out
		String d3886 = c3886.substring(0,c3886.length()-1); // extract most of it
		String e3886 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3886.getBytes() ) )); // B64 encode and decode it
		String f3886 = e3886.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3886); // reflection
	
		return bar;	
	}
}
