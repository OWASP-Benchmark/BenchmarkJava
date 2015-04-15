package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19184")
public class BenchmarkTest19184 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95658 = param; //assign
		StringBuilder b95658 = new StringBuilder(a95658);  // stick in stringbuilder
		b95658.append(" SafeStuff"); // append some safe content
		b95658.replace(b95658.length()-"Chars".length(),b95658.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95658 = new java.util.HashMap<String,Object>();
		map95658.put("key95658", b95658.toString()); // put in a collection
		String c95658 = (String)map95658.get("key95658"); // get it back out
		String d95658 = c95658.substring(0,c95658.length()-1); // extract most of it
		String e95658 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95658.getBytes() ) )); // B64 encode and decode it
		String f95658 = e95658.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95658); // reflection
	
		return bar;	
	}
}
