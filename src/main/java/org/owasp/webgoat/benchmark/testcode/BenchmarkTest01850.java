package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01850")
public class BenchmarkTest01850 extends HttpServlet {
	
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
		String a63728 = param; //assign
		StringBuilder b63728 = new StringBuilder(a63728);  // stick in stringbuilder
		b63728.append(" SafeStuff"); // append some safe content
		b63728.replace(b63728.length()-"Chars".length(),b63728.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63728 = new java.util.HashMap<String,Object>();
		map63728.put("key63728", b63728.toString()); // put in a collection
		String c63728 = (String)map63728.get("key63728"); // get it back out
		String d63728 = c63728.substring(0,c63728.length()-1); // extract most of it
		String e63728 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63728.getBytes() ) )); // B64 encode and decode it
		String f63728 = e63728.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63728); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
