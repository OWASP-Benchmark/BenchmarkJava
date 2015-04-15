package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02642")
public class BenchmarkTest02642 extends HttpServlet {
	
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
		String a58959 = param; //assign
		StringBuilder b58959 = new StringBuilder(a58959);  // stick in stringbuilder
		b58959.append(" SafeStuff"); // append some safe content
		b58959.replace(b58959.length()-"Chars".length(),b58959.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58959 = new java.util.HashMap<String,Object>();
		map58959.put("key58959", b58959.toString()); // put in a collection
		String c58959 = (String)map58959.get("key58959"); // get it back out
		String d58959 = c58959.substring(0,c58959.length()-1); // extract most of it
		String e58959 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58959.getBytes() ) )); // B64 encode and decode it
		String f58959 = e58959.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58959); // reflection
		
		
		response.setHeader("SomeHeader", bar);
	}
}
