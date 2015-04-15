package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19508")
public class BenchmarkTest19508 extends HttpServlet {
	
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
		String a69590 = param; //assign
		StringBuilder b69590 = new StringBuilder(a69590);  // stick in stringbuilder
		b69590.append(" SafeStuff"); // append some safe content
		b69590.replace(b69590.length()-"Chars".length(),b69590.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map69590 = new java.util.HashMap<String,Object>();
		map69590.put("key69590", b69590.toString()); // put in a collection
		String c69590 = (String)map69590.get("key69590"); // get it back out
		String d69590 = c69590.substring(0,c69590.length()-1); // extract most of it
		String e69590 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d69590.getBytes() ) )); // B64 encode and decode it
		String f69590 = e69590.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g69590 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g69590); // reflection
	
		return bar;	
	}
}
