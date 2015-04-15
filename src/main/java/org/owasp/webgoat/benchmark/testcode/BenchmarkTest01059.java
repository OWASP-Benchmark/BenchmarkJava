package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01059")
public class BenchmarkTest01059 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a3609 = param; //assign
		StringBuilder b3609 = new StringBuilder(a3609);  // stick in stringbuilder
		b3609.append(" SafeStuff"); // append some safe content
		b3609.replace(b3609.length()-"Chars".length(),b3609.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3609 = new java.util.HashMap<String,Object>();
		map3609.put("key3609", b3609.toString()); // put in a collection
		String c3609 = (String)map3609.get("key3609"); // get it back out
		String d3609 = c3609.substring(0,c3609.length()-1); // extract most of it
		String e3609 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3609.getBytes() ) )); // B64 encode and decode it
		String f3609 = e3609.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3609); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
