package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04369")
public class BenchmarkTest04369 extends HttpServlet {
	
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
		String a79062 = param; //assign
		StringBuilder b79062 = new StringBuilder(a79062);  // stick in stringbuilder
		b79062.append(" SafeStuff"); // append some safe content
		b79062.replace(b79062.length()-"Chars".length(),b79062.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79062 = new java.util.HashMap<String,Object>();
		map79062.put("key79062", b79062.toString()); // put in a collection
		String c79062 = (String)map79062.get("key79062"); // get it back out
		String d79062 = c79062.substring(0,c79062.length()-1); // extract most of it
		String e79062 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79062.getBytes() ) )); // B64 encode and decode it
		String f79062 = e79062.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g79062 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g79062); // reflection
		
		
		response.getWriter().println(bar);
	}
}
