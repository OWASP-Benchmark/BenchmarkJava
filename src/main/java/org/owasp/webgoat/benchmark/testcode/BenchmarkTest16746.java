package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16746")
public class BenchmarkTest16746 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3905 = param; //assign
		StringBuilder b3905 = new StringBuilder(a3905);  // stick in stringbuilder
		b3905.append(" SafeStuff"); // append some safe content
		b3905.replace(b3905.length()-"Chars".length(),b3905.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3905 = new java.util.HashMap<String,Object>();
		map3905.put("key3905", b3905.toString()); // put in a collection
		String c3905 = (String)map3905.get("key3905"); // get it back out
		String d3905 = c3905.substring(0,c3905.length()-1); // extract most of it
		String e3905 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3905.getBytes() ) )); // B64 encode and decode it
		String f3905 = e3905.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3905); // reflection
	
		return bar;	
	}
}
