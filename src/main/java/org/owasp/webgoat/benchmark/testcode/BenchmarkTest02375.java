package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02375")
public class BenchmarkTest02375 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a45005 = param; //assign
		StringBuilder b45005 = new StringBuilder(a45005);  // stick in stringbuilder
		b45005.append(" SafeStuff"); // append some safe content
		b45005.replace(b45005.length()-"Chars".length(),b45005.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45005 = new java.util.HashMap<String,Object>();
		map45005.put("key45005", b45005.toString()); // put in a collection
		String c45005 = (String)map45005.get("key45005"); // get it back out
		String d45005 = c45005.substring(0,c45005.length()-1); // extract most of it
		String e45005 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45005.getBytes() ) )); // B64 encode and decode it
		String f45005 = e45005.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45005); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}
}
