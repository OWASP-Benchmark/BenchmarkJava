package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18558")
public class BenchmarkTest18558 extends HttpServlet {
	
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
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36011 = param; //assign
		StringBuilder b36011 = new StringBuilder(a36011);  // stick in stringbuilder
		b36011.append(" SafeStuff"); // append some safe content
		b36011.replace(b36011.length()-"Chars".length(),b36011.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36011 = new java.util.HashMap<String,Object>();
		map36011.put("key36011", b36011.toString()); // put in a collection
		String c36011 = (String)map36011.get("key36011"); // get it back out
		String d36011 = c36011.substring(0,c36011.length()-1); // extract most of it
		String e36011 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36011.getBytes() ) )); // B64 encode and decode it
		String f36011 = e36011.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f36011); // reflection
	
		return bar;	
	}
}
