package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01799")
public class BenchmarkTest01799 extends HttpServlet {
	
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
		String a46233 = param; //assign
		StringBuilder b46233 = new StringBuilder(a46233);  // stick in stringbuilder
		b46233.append(" SafeStuff"); // append some safe content
		b46233.replace(b46233.length()-"Chars".length(),b46233.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46233 = new java.util.HashMap<String,Object>();
		map46233.put("key46233", b46233.toString()); // put in a collection
		String c46233 = (String)map46233.get("key46233"); // get it back out
		String d46233 = c46233.substring(0,c46233.length()-1); // extract most of it
		String e46233 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46233.getBytes() ) )); // B64 encode and decode it
		String f46233 = e46233.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g46233 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g46233); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
