package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04803")
public class BenchmarkTest04803 extends HttpServlet {
	
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
		String a54287 = param; //assign
		StringBuilder b54287 = new StringBuilder(a54287);  // stick in stringbuilder
		b54287.append(" SafeStuff"); // append some safe content
		b54287.replace(b54287.length()-"Chars".length(),b54287.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54287 = new java.util.HashMap<String,Object>();
		map54287.put("key54287", b54287.toString()); // put in a collection
		String c54287 = (String)map54287.get("key54287"); // get it back out
		String d54287 = c54287.substring(0,c54287.length()-1); // extract most of it
		String e54287 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54287.getBytes() ) )); // B64 encode and decode it
		String f54287 = e54287.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f54287); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
