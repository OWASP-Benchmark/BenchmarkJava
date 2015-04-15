package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06979")
public class BenchmarkTest06979 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a45186 = param; //assign
		StringBuilder b45186 = new StringBuilder(a45186);  // stick in stringbuilder
		b45186.append(" SafeStuff"); // append some safe content
		b45186.replace(b45186.length()-"Chars".length(),b45186.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45186 = new java.util.HashMap<String,Object>();
		map45186.put("key45186", b45186.toString()); // put in a collection
		String c45186 = (String)map45186.get("key45186"); // get it back out
		String d45186 = c45186.substring(0,c45186.length()-1); // extract most of it
		String e45186 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45186.getBytes() ) )); // B64 encode and decode it
		String f45186 = e45186.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45186 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45186); // reflection
		
		
		response.getWriter().write(bar);
	}
}
