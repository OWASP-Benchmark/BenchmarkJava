package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01238")
public class BenchmarkTest01238 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a76977 = param; //assign
		StringBuilder b76977 = new StringBuilder(a76977);  // stick in stringbuilder
		b76977.append(" SafeStuff"); // append some safe content
		b76977.replace(b76977.length()-"Chars".length(),b76977.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76977 = new java.util.HashMap<String,Object>();
		map76977.put("key76977", b76977.toString()); // put in a collection
		String c76977 = (String)map76977.get("key76977"); // get it back out
		String d76977 = c76977.substring(0,c76977.length()-1); // extract most of it
		String e76977 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76977.getBytes() ) )); // B64 encode and decode it
		String f76977 = e76977.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76977 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76977); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
