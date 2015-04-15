package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01153")
public class BenchmarkTest01153 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a55202 = param; //assign
		StringBuilder b55202 = new StringBuilder(a55202);  // stick in stringbuilder
		b55202.append(" SafeStuff"); // append some safe content
		b55202.replace(b55202.length()-"Chars".length(),b55202.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55202 = new java.util.HashMap<String,Object>();
		map55202.put("key55202", b55202.toString()); // put in a collection
		String c55202 = (String)map55202.get("key55202"); // get it back out
		String d55202 = c55202.substring(0,c55202.length()-1); // extract most of it
		String e55202 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55202.getBytes() ) )); // B64 encode and decode it
		String f55202 = e55202.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55202 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55202); // reflection
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
