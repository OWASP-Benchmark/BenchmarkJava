package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19526")
public class BenchmarkTest19526 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23588 = param; //assign
		StringBuilder b23588 = new StringBuilder(a23588);  // stick in stringbuilder
		b23588.append(" SafeStuff"); // append some safe content
		b23588.replace(b23588.length()-"Chars".length(),b23588.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23588 = new java.util.HashMap<String,Object>();
		map23588.put("key23588", b23588.toString()); // put in a collection
		String c23588 = (String)map23588.get("key23588"); // get it back out
		String d23588 = c23588.substring(0,c23588.length()-1); // extract most of it
		String e23588 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23588.getBytes() ) )); // B64 encode and decode it
		String f23588 = e23588.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23588); // reflection
	
		return bar;	
	}
}
