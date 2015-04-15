package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14906")
public class BenchmarkTest14906 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a66079 = param; //assign
		StringBuilder b66079 = new StringBuilder(a66079);  // stick in stringbuilder
		b66079.append(" SafeStuff"); // append some safe content
		b66079.replace(b66079.length()-"Chars".length(),b66079.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66079 = new java.util.HashMap<String,Object>();
		map66079.put("key66079", b66079.toString()); // put in a collection
		String c66079 = (String)map66079.get("key66079"); // get it back out
		String d66079 = c66079.substring(0,c66079.length()-1); // extract most of it
		String e66079 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66079.getBytes() ) )); // B64 encode and decode it
		String f66079 = e66079.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f66079); // reflection
	
		return bar;	
	}
}
