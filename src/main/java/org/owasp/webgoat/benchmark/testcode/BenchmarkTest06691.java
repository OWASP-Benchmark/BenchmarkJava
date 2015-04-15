package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06691")
public class BenchmarkTest06691 extends HttpServlet {
	
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
		String a43510 = param; //assign
		StringBuilder b43510 = new StringBuilder(a43510);  // stick in stringbuilder
		b43510.append(" SafeStuff"); // append some safe content
		b43510.replace(b43510.length()-"Chars".length(),b43510.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43510 = new java.util.HashMap<String,Object>();
		map43510.put("key43510", b43510.toString()); // put in a collection
		String c43510 = (String)map43510.get("key43510"); // get it back out
		String d43510 = c43510.substring(0,c43510.length()-1); // extract most of it
		String e43510 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43510.getBytes() ) )); // B64 encode and decode it
		String f43510 = e43510.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f43510); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
