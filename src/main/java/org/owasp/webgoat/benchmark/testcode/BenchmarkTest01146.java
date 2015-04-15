package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01146")
public class BenchmarkTest01146 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a64518 = param; //assign
		StringBuilder b64518 = new StringBuilder(a64518);  // stick in stringbuilder
		b64518.append(" SafeStuff"); // append some safe content
		b64518.replace(b64518.length()-"Chars".length(),b64518.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64518 = new java.util.HashMap<String,Object>();
		map64518.put("key64518", b64518.toString()); // put in a collection
		String c64518 = (String)map64518.get("key64518"); // get it back out
		String d64518 = c64518.substring(0,c64518.length()-1); // extract most of it
		String e64518 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64518.getBytes() ) )); // B64 encode and decode it
		String f64518 = e64518.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64518 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64518); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
