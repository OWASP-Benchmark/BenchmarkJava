package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16381")
public class BenchmarkTest16381 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53316 = param; //assign
		StringBuilder b53316 = new StringBuilder(a53316);  // stick in stringbuilder
		b53316.append(" SafeStuff"); // append some safe content
		b53316.replace(b53316.length()-"Chars".length(),b53316.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53316 = new java.util.HashMap<String,Object>();
		map53316.put("key53316", b53316.toString()); // put in a collection
		String c53316 = (String)map53316.get("key53316"); // get it back out
		String d53316 = c53316.substring(0,c53316.length()-1); // extract most of it
		String e53316 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53316.getBytes() ) )); // B64 encode and decode it
		String f53316 = e53316.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f53316); // reflection
	
		return bar;	
	}
}
