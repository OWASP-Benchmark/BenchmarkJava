package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01007")
public class BenchmarkTest01007 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a38186 = param; //assign
		StringBuilder b38186 = new StringBuilder(a38186);  // stick in stringbuilder
		b38186.append(" SafeStuff"); // append some safe content
		b38186.replace(b38186.length()-"Chars".length(),b38186.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38186 = new java.util.HashMap<String,Object>();
		map38186.put("key38186", b38186.toString()); // put in a collection
		String c38186 = (String)map38186.get("key38186"); // get it back out
		String d38186 = c38186.substring(0,c38186.length()-1); // extract most of it
		String e38186 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38186.getBytes() ) )); // B64 encode and decode it
		String f38186 = e38186.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38186); // reflection
		
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}
}
