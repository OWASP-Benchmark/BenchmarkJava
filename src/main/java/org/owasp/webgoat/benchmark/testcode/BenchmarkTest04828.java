package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04828")
public class BenchmarkTest04828 extends HttpServlet {
	
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
		String a34460 = param; //assign
		StringBuilder b34460 = new StringBuilder(a34460);  // stick in stringbuilder
		b34460.append(" SafeStuff"); // append some safe content
		b34460.replace(b34460.length()-"Chars".length(),b34460.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34460 = new java.util.HashMap<String,Object>();
		map34460.put("key34460", b34460.toString()); // put in a collection
		String c34460 = (String)map34460.get("key34460"); // get it back out
		String d34460 = c34460.substring(0,c34460.length()-1); // extract most of it
		String e34460 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34460.getBytes() ) )); // B64 encode and decode it
		String f34460 = e34460.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34460); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}
}
