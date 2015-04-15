package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02002")
public class BenchmarkTest02002 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a62843 = param; //assign
		StringBuilder b62843 = new StringBuilder(a62843);  // stick in stringbuilder
		b62843.append(" SafeStuff"); // append some safe content
		b62843.replace(b62843.length()-"Chars".length(),b62843.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62843 = new java.util.HashMap<String,Object>();
		map62843.put("key62843", b62843.toString()); // put in a collection
		String c62843 = (String)map62843.get("key62843"); // get it back out
		String d62843 = c62843.substring(0,c62843.length()-1); // extract most of it
		String e62843 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62843.getBytes() ) )); // B64 encode and decode it
		String f62843 = e62843.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g62843 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g62843); // reflection
		
		
		response.addHeader(bar, "SomeValue");
	}
}
