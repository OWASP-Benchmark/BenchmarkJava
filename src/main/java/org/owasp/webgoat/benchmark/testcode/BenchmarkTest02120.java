package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02120")
public class BenchmarkTest02120 extends HttpServlet {
	
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
		String a73596 = param; //assign
		StringBuilder b73596 = new StringBuilder(a73596);  // stick in stringbuilder
		b73596.append(" SafeStuff"); // append some safe content
		b73596.replace(b73596.length()-"Chars".length(),b73596.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73596 = new java.util.HashMap<String,Object>();
		map73596.put("key73596", b73596.toString()); // put in a collection
		String c73596 = (String)map73596.get("key73596"); // get it back out
		String d73596 = c73596.substring(0,c73596.length()-1); // extract most of it
		String e73596 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73596.getBytes() ) )); // B64 encode and decode it
		String f73596 = e73596.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73596); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
