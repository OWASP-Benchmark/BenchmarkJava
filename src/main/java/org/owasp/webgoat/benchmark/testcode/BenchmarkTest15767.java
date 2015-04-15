package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15767")
public class BenchmarkTest15767 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3840 = param; //assign
		StringBuilder b3840 = new StringBuilder(a3840);  // stick in stringbuilder
		b3840.append(" SafeStuff"); // append some safe content
		b3840.replace(b3840.length()-"Chars".length(),b3840.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3840 = new java.util.HashMap<String,Object>();
		map3840.put("key3840", b3840.toString()); // put in a collection
		String c3840 = (String)map3840.get("key3840"); // get it back out
		String d3840 = c3840.substring(0,c3840.length()-1); // extract most of it
		String e3840 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3840.getBytes() ) )); // B64 encode and decode it
		String f3840 = e3840.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3840); // reflection
	
		return bar;	
	}
}
