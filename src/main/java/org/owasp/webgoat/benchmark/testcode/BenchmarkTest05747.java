package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05747")
public class BenchmarkTest05747 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a18082 = param; //assign
		StringBuilder b18082 = new StringBuilder(a18082);  // stick in stringbuilder
		b18082.append(" SafeStuff"); // append some safe content
		b18082.replace(b18082.length()-"Chars".length(),b18082.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18082 = new java.util.HashMap<String,Object>();
		map18082.put("key18082", b18082.toString()); // put in a collection
		String c18082 = (String)map18082.get("key18082"); // get it back out
		String d18082 = c18082.substring(0,c18082.length()-1); // extract most of it
		String e18082 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18082.getBytes() ) )); // B64 encode and decode it
		String f18082 = e18082.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18082 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18082); // reflection
		
		
		response.addHeader("SomeHeader", bar);
	}
}
