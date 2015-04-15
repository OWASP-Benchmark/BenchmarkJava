package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15455")
public class BenchmarkTest15455 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53417 = param; //assign
		StringBuilder b53417 = new StringBuilder(a53417);  // stick in stringbuilder
		b53417.append(" SafeStuff"); // append some safe content
		b53417.replace(b53417.length()-"Chars".length(),b53417.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53417 = new java.util.HashMap<String,Object>();
		map53417.put("key53417", b53417.toString()); // put in a collection
		String c53417 = (String)map53417.get("key53417"); // get it back out
		String d53417 = c53417.substring(0,c53417.length()-1); // extract most of it
		String e53417 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53417.getBytes() ) )); // B64 encode and decode it
		String f53417 = e53417.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g53417 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53417); // reflection
	
		return bar;	
	}
}
