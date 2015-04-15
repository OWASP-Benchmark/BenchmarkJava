package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14980")
public class BenchmarkTest14980 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52275 = param; //assign
		StringBuilder b52275 = new StringBuilder(a52275);  // stick in stringbuilder
		b52275.append(" SafeStuff"); // append some safe content
		b52275.replace(b52275.length()-"Chars".length(),b52275.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52275 = new java.util.HashMap<String,Object>();
		map52275.put("key52275", b52275.toString()); // put in a collection
		String c52275 = (String)map52275.get("key52275"); // get it back out
		String d52275 = c52275.substring(0,c52275.length()-1); // extract most of it
		String e52275 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52275.getBytes() ) )); // B64 encode and decode it
		String f52275 = e52275.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52275 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52275); // reflection
	
		return bar;	
	}
}
