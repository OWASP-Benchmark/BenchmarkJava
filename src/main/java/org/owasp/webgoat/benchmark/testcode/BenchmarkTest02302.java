package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02302")
public class BenchmarkTest02302 extends HttpServlet {
	
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
		String a25561 = param; //assign
		StringBuilder b25561 = new StringBuilder(a25561);  // stick in stringbuilder
		b25561.append(" SafeStuff"); // append some safe content
		b25561.replace(b25561.length()-"Chars".length(),b25561.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25561 = new java.util.HashMap<String,Object>();
		map25561.put("key25561", b25561.toString()); // put in a collection
		String c25561 = (String)map25561.get("key25561"); // get it back out
		String d25561 = c25561.substring(0,c25561.length()-1); // extract most of it
		String e25561 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25561.getBytes() ) )); // B64 encode and decode it
		String f25561 = e25561.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f25561); // reflection
		
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}
}
