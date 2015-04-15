package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04950")
public class BenchmarkTest04950 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a95023 = param; //assign
		StringBuilder b95023 = new StringBuilder(a95023);  // stick in stringbuilder
		b95023.append(" SafeStuff"); // append some safe content
		b95023.replace(b95023.length()-"Chars".length(),b95023.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95023 = new java.util.HashMap<String,Object>();
		map95023.put("key95023", b95023.toString()); // put in a collection
		String c95023 = (String)map95023.get("key95023"); // get it back out
		String d95023 = c95023.substring(0,c95023.length()-1); // extract most of it
		String e95023 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95023.getBytes() ) )); // B64 encode and decode it
		String f95023 = e95023.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95023); // reflection
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
