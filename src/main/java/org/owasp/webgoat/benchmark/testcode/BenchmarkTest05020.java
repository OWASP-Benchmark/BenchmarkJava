package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05020")
public class BenchmarkTest05020 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a45787 = param; //assign
		StringBuilder b45787 = new StringBuilder(a45787);  // stick in stringbuilder
		b45787.append(" SafeStuff"); // append some safe content
		b45787.replace(b45787.length()-"Chars".length(),b45787.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45787 = new java.util.HashMap<String,Object>();
		map45787.put("key45787", b45787.toString()); // put in a collection
		String c45787 = (String)map45787.get("key45787"); // get it back out
		String d45787 = c45787.substring(0,c45787.length()-1); // extract most of it
		String e45787 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45787.getBytes() ) )); // B64 encode and decode it
		String f45787 = e45787.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45787 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45787); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
