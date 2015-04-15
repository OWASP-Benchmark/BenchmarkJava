package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19505")
public class BenchmarkTest19505 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a12315 = param; //assign
		StringBuilder b12315 = new StringBuilder(a12315);  // stick in stringbuilder
		b12315.append(" SafeStuff"); // append some safe content
		b12315.replace(b12315.length()-"Chars".length(),b12315.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12315 = new java.util.HashMap<String,Object>();
		map12315.put("key12315", b12315.toString()); // put in a collection
		String c12315 = (String)map12315.get("key12315"); // get it back out
		String d12315 = c12315.substring(0,c12315.length()-1); // extract most of it
		String e12315 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12315.getBytes() ) )); // B64 encode and decode it
		String f12315 = e12315.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f12315); // reflection
	
		return bar;	
	}
}
