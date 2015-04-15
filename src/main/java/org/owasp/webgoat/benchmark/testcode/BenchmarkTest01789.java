package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01789")
public class BenchmarkTest01789 extends HttpServlet {
	
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
		String a56705 = param; //assign
		StringBuilder b56705 = new StringBuilder(a56705);  // stick in stringbuilder
		b56705.append(" SafeStuff"); // append some safe content
		b56705.replace(b56705.length()-"Chars".length(),b56705.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56705 = new java.util.HashMap<String,Object>();
		map56705.put("key56705", b56705.toString()); // put in a collection
		String c56705 = (String)map56705.get("key56705"); // get it back out
		String d56705 = c56705.substring(0,c56705.length()-1); // extract most of it
		String e56705 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56705.getBytes() ) )); // B64 encode and decode it
		String f56705 = e56705.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f56705); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}
