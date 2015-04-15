package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15407")
public class BenchmarkTest15407 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44237 = param; //assign
		StringBuilder b44237 = new StringBuilder(a44237);  // stick in stringbuilder
		b44237.append(" SafeStuff"); // append some safe content
		b44237.replace(b44237.length()-"Chars".length(),b44237.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44237 = new java.util.HashMap<String,Object>();
		map44237.put("key44237", b44237.toString()); // put in a collection
		String c44237 = (String)map44237.get("key44237"); // get it back out
		String d44237 = c44237.substring(0,c44237.length()-1); // extract most of it
		String e44237 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44237.getBytes() ) )); // B64 encode and decode it
		String f44237 = e44237.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g44237 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44237); // reflection
	
		return bar;	
	}
}
