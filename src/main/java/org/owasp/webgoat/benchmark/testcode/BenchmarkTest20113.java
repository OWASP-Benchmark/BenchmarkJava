package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20113")
public class BenchmarkTest20113 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88098 = param; //assign
		StringBuilder b88098 = new StringBuilder(a88098);  // stick in stringbuilder
		b88098.append(" SafeStuff"); // append some safe content
		b88098.replace(b88098.length()-"Chars".length(),b88098.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88098 = new java.util.HashMap<String,Object>();
		map88098.put("key88098", b88098.toString()); // put in a collection
		String c88098 = (String)map88098.get("key88098"); // get it back out
		String d88098 = c88098.substring(0,c88098.length()-1); // extract most of it
		String e88098 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88098.getBytes() ) )); // B64 encode and decode it
		String f88098 = e88098.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g88098 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88098); // reflection
	
		return bar;	
	}
}
