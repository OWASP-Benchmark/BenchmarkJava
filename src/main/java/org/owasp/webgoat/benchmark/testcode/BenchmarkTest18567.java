package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18567")
public class BenchmarkTest18567 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30800 = param; //assign
		StringBuilder b30800 = new StringBuilder(a30800);  // stick in stringbuilder
		b30800.append(" SafeStuff"); // append some safe content
		b30800.replace(b30800.length()-"Chars".length(),b30800.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30800 = new java.util.HashMap<String,Object>();
		map30800.put("key30800", b30800.toString()); // put in a collection
		String c30800 = (String)map30800.get("key30800"); // get it back out
		String d30800 = c30800.substring(0,c30800.length()-1); // extract most of it
		String e30800 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30800.getBytes() ) )); // B64 encode and decode it
		String f30800 = e30800.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30800); // reflection
	
		return bar;	
	}
}
