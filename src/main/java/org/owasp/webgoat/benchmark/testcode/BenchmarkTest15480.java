package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15480")
public class BenchmarkTest15480 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52811 = param; //assign
		StringBuilder b52811 = new StringBuilder(a52811);  // stick in stringbuilder
		b52811.append(" SafeStuff"); // append some safe content
		b52811.replace(b52811.length()-"Chars".length(),b52811.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52811 = new java.util.HashMap<String,Object>();
		map52811.put("key52811", b52811.toString()); // put in a collection
		String c52811 = (String)map52811.get("key52811"); // get it back out
		String d52811 = c52811.substring(0,c52811.length()-1); // extract most of it
		String e52811 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52811.getBytes() ) )); // B64 encode and decode it
		String f52811 = e52811.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52811 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52811); // reflection
	
		return bar;	
	}
}
