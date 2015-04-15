package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01875")
public class BenchmarkTest01875 extends HttpServlet {
	
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
		String a24972 = param; //assign
		StringBuilder b24972 = new StringBuilder(a24972);  // stick in stringbuilder
		b24972.append(" SafeStuff"); // append some safe content
		b24972.replace(b24972.length()-"Chars".length(),b24972.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24972 = new java.util.HashMap<String,Object>();
		map24972.put("key24972", b24972.toString()); // put in a collection
		String c24972 = (String)map24972.get("key24972"); // get it back out
		String d24972 = c24972.substring(0,c24972.length()-1); // extract most of it
		String e24972 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24972.getBytes() ) )); // B64 encode and decode it
		String f24972 = e24972.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24972); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
