package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02934")
public class BenchmarkTest02934 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a62306 = param; //assign
		StringBuilder b62306 = new StringBuilder(a62306);  // stick in stringbuilder
		b62306.append(" SafeStuff"); // append some safe content
		b62306.replace(b62306.length()-"Chars".length(),b62306.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62306 = new java.util.HashMap<String,Object>();
		map62306.put("key62306", b62306.toString()); // put in a collection
		String c62306 = (String)map62306.get("key62306"); // get it back out
		String d62306 = c62306.substring(0,c62306.length()-1); // extract most of it
		String e62306 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62306.getBytes() ) )); // B64 encode and decode it
		String f62306 = e62306.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62306); // reflection
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
