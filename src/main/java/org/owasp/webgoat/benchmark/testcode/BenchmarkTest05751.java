package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05751")
public class BenchmarkTest05751 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a10453 = param; //assign
		StringBuilder b10453 = new StringBuilder(a10453);  // stick in stringbuilder
		b10453.append(" SafeStuff"); // append some safe content
		b10453.replace(b10453.length()-"Chars".length(),b10453.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10453 = new java.util.HashMap<String,Object>();
		map10453.put("key10453", b10453.toString()); // put in a collection
		String c10453 = (String)map10453.get("key10453"); // get it back out
		String d10453 = c10453.substring(0,c10453.length()-1); // extract most of it
		String e10453 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10453.getBytes() ) )); // B64 encode and decode it
		String f10453 = e10453.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10453); // reflection
		
		
		response.addHeader(bar, "SomeValue");
	}
}
