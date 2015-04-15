package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06461")
public class BenchmarkTest06461 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a7928 = param; //assign
		StringBuilder b7928 = new StringBuilder(a7928);  // stick in stringbuilder
		b7928.append(" SafeStuff"); // append some safe content
		b7928.replace(b7928.length()-"Chars".length(),b7928.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7928 = new java.util.HashMap<String,Object>();
		map7928.put("key7928", b7928.toString()); // put in a collection
		String c7928 = (String)map7928.get("key7928"); // get it back out
		String d7928 = c7928.substring(0,c7928.length()-1); // extract most of it
		String e7928 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7928.getBytes() ) )); // B64 encode and decode it
		String f7928 = e7928.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g7928 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g7928); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}
}
