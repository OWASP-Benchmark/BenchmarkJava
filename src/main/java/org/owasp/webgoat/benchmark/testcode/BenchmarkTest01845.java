package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01845")
public class BenchmarkTest01845 extends HttpServlet {
	
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
		String a18355 = param; //assign
		StringBuilder b18355 = new StringBuilder(a18355);  // stick in stringbuilder
		b18355.append(" SafeStuff"); // append some safe content
		b18355.replace(b18355.length()-"Chars".length(),b18355.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18355 = new java.util.HashMap<String,Object>();
		map18355.put("key18355", b18355.toString()); // put in a collection
		String c18355 = (String)map18355.get("key18355"); // get it back out
		String d18355 = c18355.substring(0,c18355.length()-1); // extract most of it
		String e18355 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18355.getBytes() ) )); // B64 encode and decode it
		String f18355 = e18355.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18355 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18355); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
