package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03157")
public class BenchmarkTest03157 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a94392 = param; //assign
		StringBuilder b94392 = new StringBuilder(a94392);  // stick in stringbuilder
		b94392.append(" SafeStuff"); // append some safe content
		b94392.replace(b94392.length()-"Chars".length(),b94392.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94392 = new java.util.HashMap<String,Object>();
		map94392.put("key94392", b94392.toString()); // put in a collection
		String c94392 = (String)map94392.get("key94392"); // get it back out
		String d94392 = c94392.substring(0,c94392.length()-1); // extract most of it
		String e94392 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94392.getBytes() ) )); // B64 encode and decode it
		String f94392 = e94392.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g94392 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g94392); // reflection
		
		
		response.getWriter().write(bar);
	}
}
