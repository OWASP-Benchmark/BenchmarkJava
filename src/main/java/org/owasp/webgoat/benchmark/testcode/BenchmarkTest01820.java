package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01820")
public class BenchmarkTest01820 extends HttpServlet {
	
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
		String a62412 = param; //assign
		StringBuilder b62412 = new StringBuilder(a62412);  // stick in stringbuilder
		b62412.append(" SafeStuff"); // append some safe content
		b62412.replace(b62412.length()-"Chars".length(),b62412.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62412 = new java.util.HashMap<String,Object>();
		map62412.put("key62412", b62412.toString()); // put in a collection
		String c62412 = (String)map62412.get("key62412"); // get it back out
		String d62412 = c62412.substring(0,c62412.length()-1); // extract most of it
		String e62412 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62412.getBytes() ) )); // B64 encode and decode it
		String f62412 = e62412.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g62412 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g62412); // reflection
		
		
		response.getWriter().print(bar);
	}
}
