package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19338")
public class BenchmarkTest19338 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33821 = param; //assign
		StringBuilder b33821 = new StringBuilder(a33821);  // stick in stringbuilder
		b33821.append(" SafeStuff"); // append some safe content
		b33821.replace(b33821.length()-"Chars".length(),b33821.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33821 = new java.util.HashMap<String,Object>();
		map33821.put("key33821", b33821.toString()); // put in a collection
		String c33821 = (String)map33821.get("key33821"); // get it back out
		String d33821 = c33821.substring(0,c33821.length()-1); // extract most of it
		String e33821 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33821.getBytes() ) )); // B64 encode and decode it
		String f33821 = e33821.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f33821); // reflection
	
		return bar;	
	}
}
