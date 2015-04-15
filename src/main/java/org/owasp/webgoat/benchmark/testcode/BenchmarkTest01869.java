package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01869")
public class BenchmarkTest01869 extends HttpServlet {
	
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
		String a52587 = param; //assign
		StringBuilder b52587 = new StringBuilder(a52587);  // stick in stringbuilder
		b52587.append(" SafeStuff"); // append some safe content
		b52587.replace(b52587.length()-"Chars".length(),b52587.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52587 = new java.util.HashMap<String,Object>();
		map52587.put("key52587", b52587.toString()); // put in a collection
		String c52587 = (String)map52587.get("key52587"); // get it back out
		String d52587 = c52587.substring(0,c52587.length()-1); // extract most of it
		String e52587 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52587.getBytes() ) )); // B64 encode and decode it
		String f52587 = e52587.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52587 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52587); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
