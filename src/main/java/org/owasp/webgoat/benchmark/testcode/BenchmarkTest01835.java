package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01835")
public class BenchmarkTest01835 extends HttpServlet {
	
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
		String a9956 = param; //assign
		StringBuilder b9956 = new StringBuilder(a9956);  // stick in stringbuilder
		b9956.append(" SafeStuff"); // append some safe content
		b9956.replace(b9956.length()-"Chars".length(),b9956.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9956 = new java.util.HashMap<String,Object>();
		map9956.put("key9956", b9956.toString()); // put in a collection
		String c9956 = (String)map9956.get("key9956"); // get it back out
		String d9956 = c9956.substring(0,c9956.length()-1); // extract most of it
		String e9956 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9956.getBytes() ) )); // B64 encode and decode it
		String f9956 = e9956.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g9956 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9956); // reflection
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
