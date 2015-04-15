package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01780")
public class BenchmarkTest01780 extends HttpServlet {
	
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
		String a34671 = param; //assign
		StringBuilder b34671 = new StringBuilder(a34671);  // stick in stringbuilder
		b34671.append(" SafeStuff"); // append some safe content
		b34671.replace(b34671.length()-"Chars".length(),b34671.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34671 = new java.util.HashMap<String,Object>();
		map34671.put("key34671", b34671.toString()); // put in a collection
		String c34671 = (String)map34671.get("key34671"); // get it back out
		String d34671 = c34671.substring(0,c34671.length()-1); // extract most of it
		String e34671 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34671.getBytes() ) )); // B64 encode and decode it
		String f34671 = e34671.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34671); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}
}
