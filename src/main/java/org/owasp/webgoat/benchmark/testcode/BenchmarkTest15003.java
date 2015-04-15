package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15003")
public class BenchmarkTest15003 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a2416 = param; //assign
		StringBuilder b2416 = new StringBuilder(a2416);  // stick in stringbuilder
		b2416.append(" SafeStuff"); // append some safe content
		b2416.replace(b2416.length()-"Chars".length(),b2416.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2416 = new java.util.HashMap<String,Object>();
		map2416.put("key2416", b2416.toString()); // put in a collection
		String c2416 = (String)map2416.get("key2416"); // get it back out
		String d2416 = c2416.substring(0,c2416.length()-1); // extract most of it
		String e2416 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2416.getBytes() ) )); // B64 encode and decode it
		String f2416 = e2416.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g2416 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g2416); // reflection
	
		return bar;	
	}
}
