package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02113")
public class BenchmarkTest02113 extends HttpServlet {
	
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
		String a9282 = param; //assign
		StringBuilder b9282 = new StringBuilder(a9282);  // stick in stringbuilder
		b9282.append(" SafeStuff"); // append some safe content
		b9282.replace(b9282.length()-"Chars".length(),b9282.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9282 = new java.util.HashMap<String,Object>();
		map9282.put("key9282", b9282.toString()); // put in a collection
		String c9282 = (String)map9282.get("key9282"); // get it back out
		String d9282 = c9282.substring(0,c9282.length()-1); // extract most of it
		String e9282 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9282.getBytes() ) )); // B64 encode and decode it
		String f9282 = e9282.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g9282 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9282); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}
}
