package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02653")
public class BenchmarkTest02653 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a57984 = param; //assign
		StringBuilder b57984 = new StringBuilder(a57984);  // stick in stringbuilder
		b57984.append(" SafeStuff"); // append some safe content
		b57984.replace(b57984.length()-"Chars".length(),b57984.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57984 = new java.util.HashMap<String,Object>();
		map57984.put("key57984", b57984.toString()); // put in a collection
		String c57984 = (String)map57984.get("key57984"); // get it back out
		String d57984 = c57984.substring(0,c57984.length()-1); // extract most of it
		String e57984 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57984.getBytes() ) )); // B64 encode and decode it
		String f57984 = e57984.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57984); // reflection
		
		
		response.getWriter().write(bar);
	}
}
