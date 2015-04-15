package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15648")
public class BenchmarkTest15648 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a5642 = param; //assign
		StringBuilder b5642 = new StringBuilder(a5642);  // stick in stringbuilder
		b5642.append(" SafeStuff"); // append some safe content
		b5642.replace(b5642.length()-"Chars".length(),b5642.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5642 = new java.util.HashMap<String,Object>();
		map5642.put("key5642", b5642.toString()); // put in a collection
		String c5642 = (String)map5642.get("key5642"); // get it back out
		String d5642 = c5642.substring(0,c5642.length()-1); // extract most of it
		String e5642 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5642.getBytes() ) )); // B64 encode and decode it
		String f5642 = e5642.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g5642 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5642); // reflection
	
		return bar;	
	}
}
