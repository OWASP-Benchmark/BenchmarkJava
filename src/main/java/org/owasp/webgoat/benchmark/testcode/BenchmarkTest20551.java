package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20551")
public class BenchmarkTest20551 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89737 = param; //assign
		StringBuilder b89737 = new StringBuilder(a89737);  // stick in stringbuilder
		b89737.append(" SafeStuff"); // append some safe content
		b89737.replace(b89737.length()-"Chars".length(),b89737.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89737 = new java.util.HashMap<String,Object>();
		map89737.put("key89737", b89737.toString()); // put in a collection
		String c89737 = (String)map89737.get("key89737"); // get it back out
		String d89737 = c89737.substring(0,c89737.length()-1); // extract most of it
		String e89737 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89737.getBytes() ) )); // B64 encode and decode it
		String f89737 = e89737.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f89737); // reflection
	
		return bar;	
	}
}
