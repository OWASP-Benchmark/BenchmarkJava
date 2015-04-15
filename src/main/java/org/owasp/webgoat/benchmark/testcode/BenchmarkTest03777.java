package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03777")
public class BenchmarkTest03777 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a18469 = param; //assign
		StringBuilder b18469 = new StringBuilder(a18469);  // stick in stringbuilder
		b18469.append(" SafeStuff"); // append some safe content
		b18469.replace(b18469.length()-"Chars".length(),b18469.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18469 = new java.util.HashMap<String,Object>();
		map18469.put("key18469", b18469.toString()); // put in a collection
		String c18469 = (String)map18469.get("key18469"); // get it back out
		String d18469 = c18469.substring(0,c18469.length()-1); // extract most of it
		String e18469 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18469.getBytes() ) )); // B64 encode and decode it
		String f18469 = e18469.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18469 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18469); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
