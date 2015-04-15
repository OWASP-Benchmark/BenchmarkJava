package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16661")
public class BenchmarkTest16661 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86112 = param; //assign
		StringBuilder b86112 = new StringBuilder(a86112);  // stick in stringbuilder
		b86112.append(" SafeStuff"); // append some safe content
		b86112.replace(b86112.length()-"Chars".length(),b86112.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86112 = new java.util.HashMap<String,Object>();
		map86112.put("key86112", b86112.toString()); // put in a collection
		String c86112 = (String)map86112.get("key86112"); // get it back out
		String d86112 = c86112.substring(0,c86112.length()-1); // extract most of it
		String e86112 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86112.getBytes() ) )); // B64 encode and decode it
		String f86112 = e86112.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g86112 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86112); // reflection
	
		return bar;	
	}
}
