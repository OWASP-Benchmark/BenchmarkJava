package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15753")
public class BenchmarkTest15753 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71368 = param; //assign
		StringBuilder b71368 = new StringBuilder(a71368);  // stick in stringbuilder
		b71368.append(" SafeStuff"); // append some safe content
		b71368.replace(b71368.length()-"Chars".length(),b71368.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71368 = new java.util.HashMap<String,Object>();
		map71368.put("key71368", b71368.toString()); // put in a collection
		String c71368 = (String)map71368.get("key71368"); // get it back out
		String d71368 = c71368.substring(0,c71368.length()-1); // extract most of it
		String e71368 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71368.getBytes() ) )); // B64 encode and decode it
		String f71368 = e71368.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g71368 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71368); // reflection
	
		return bar;	
	}
}
