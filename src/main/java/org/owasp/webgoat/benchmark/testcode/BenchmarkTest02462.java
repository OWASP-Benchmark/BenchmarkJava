package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02462")
public class BenchmarkTest02462 extends HttpServlet {
	
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
		String a7041 = param; //assign
		StringBuilder b7041 = new StringBuilder(a7041);  // stick in stringbuilder
		b7041.append(" SafeStuff"); // append some safe content
		b7041.replace(b7041.length()-"Chars".length(),b7041.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7041 = new java.util.HashMap<String,Object>();
		map7041.put("key7041", b7041.toString()); // put in a collection
		String c7041 = (String)map7041.get("key7041"); // get it back out
		String d7041 = c7041.substring(0,c7041.length()-1); // extract most of it
		String e7041 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7041.getBytes() ) )); // B64 encode and decode it
		String f7041 = e7041.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g7041 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g7041); // reflection
		
		
		response.getWriter().print(bar);
	}
}
