package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01878")
public class BenchmarkTest01878 extends HttpServlet {
	
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
		String a70200 = param; //assign
		StringBuilder b70200 = new StringBuilder(a70200);  // stick in stringbuilder
		b70200.append(" SafeStuff"); // append some safe content
		b70200.replace(b70200.length()-"Chars".length(),b70200.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70200 = new java.util.HashMap<String,Object>();
		map70200.put("key70200", b70200.toString()); // put in a collection
		String c70200 = (String)map70200.get("key70200"); // get it back out
		String d70200 = c70200.substring(0,c70200.length()-1); // extract most of it
		String e70200 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70200.getBytes() ) )); // B64 encode and decode it
		String f70200 = e70200.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70200 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70200); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
