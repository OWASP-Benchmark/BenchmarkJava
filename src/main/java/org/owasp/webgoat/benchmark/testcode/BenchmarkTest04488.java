package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04488")
public class BenchmarkTest04488 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a37067 = param; //assign
		StringBuilder b37067 = new StringBuilder(a37067);  // stick in stringbuilder
		b37067.append(" SafeStuff"); // append some safe content
		b37067.replace(b37067.length()-"Chars".length(),b37067.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37067 = new java.util.HashMap<String,Object>();
		map37067.put("key37067", b37067.toString()); // put in a collection
		String c37067 = (String)map37067.get("key37067"); // get it back out
		String d37067 = c37067.substring(0,c37067.length()-1); // extract most of it
		String e37067 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37067.getBytes() ) )); // B64 encode and decode it
		String f37067 = e37067.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f37067); // reflection
		
		
		response.getWriter().write(bar);
	}
}
