package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16271")
public class BenchmarkTest16271 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95483 = param; //assign
		StringBuilder b95483 = new StringBuilder(a95483);  // stick in stringbuilder
		b95483.append(" SafeStuff"); // append some safe content
		b95483.replace(b95483.length()-"Chars".length(),b95483.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95483 = new java.util.HashMap<String,Object>();
		map95483.put("key95483", b95483.toString()); // put in a collection
		String c95483 = (String)map95483.get("key95483"); // get it back out
		String d95483 = c95483.substring(0,c95483.length()-1); // extract most of it
		String e95483 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95483.getBytes() ) )); // B64 encode and decode it
		String f95483 = e95483.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95483); // reflection
	
		return bar;	
	}
}
