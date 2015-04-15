package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02308")
public class BenchmarkTest02308 extends HttpServlet {
	
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
		String a37090 = param; //assign
		StringBuilder b37090 = new StringBuilder(a37090);  // stick in stringbuilder
		b37090.append(" SafeStuff"); // append some safe content
		b37090.replace(b37090.length()-"Chars".length(),b37090.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37090 = new java.util.HashMap<String,Object>();
		map37090.put("key37090", b37090.toString()); // put in a collection
		String c37090 = (String)map37090.get("key37090"); // get it back out
		String d37090 = c37090.substring(0,c37090.length()-1); // extract most of it
		String e37090 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37090.getBytes() ) )); // B64 encode and decode it
		String f37090 = e37090.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f37090); // reflection
		
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}
}
