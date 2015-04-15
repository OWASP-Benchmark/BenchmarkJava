package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15646")
public class BenchmarkTest15646 extends HttpServlet {
	
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
		String a61146 = param; //assign
		StringBuilder b61146 = new StringBuilder(a61146);  // stick in stringbuilder
		b61146.append(" SafeStuff"); // append some safe content
		b61146.replace(b61146.length()-"Chars".length(),b61146.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61146 = new java.util.HashMap<String,Object>();
		map61146.put("key61146", b61146.toString()); // put in a collection
		String c61146 = (String)map61146.get("key61146"); // get it back out
		String d61146 = c61146.substring(0,c61146.length()-1); // extract most of it
		String e61146 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61146.getBytes() ) )); // B64 encode and decode it
		String f61146 = e61146.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f61146); // reflection
	
		return bar;	
	}
}
