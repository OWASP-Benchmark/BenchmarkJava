package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18896")
public class BenchmarkTest18896 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62584 = param; //assign
		StringBuilder b62584 = new StringBuilder(a62584);  // stick in stringbuilder
		b62584.append(" SafeStuff"); // append some safe content
		b62584.replace(b62584.length()-"Chars".length(),b62584.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62584 = new java.util.HashMap<String,Object>();
		map62584.put("key62584", b62584.toString()); // put in a collection
		String c62584 = (String)map62584.get("key62584"); // get it back out
		String d62584 = c62584.substring(0,c62584.length()-1); // extract most of it
		String e62584 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62584.getBytes() ) )); // B64 encode and decode it
		String f62584 = e62584.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62584); // reflection
	
		return bar;	
	}
}
