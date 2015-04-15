package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03063")
public class BenchmarkTest03063 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a27842 = param; //assign
		StringBuilder b27842 = new StringBuilder(a27842);  // stick in stringbuilder
		b27842.append(" SafeStuff"); // append some safe content
		b27842.replace(b27842.length()-"Chars".length(),b27842.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27842 = new java.util.HashMap<String,Object>();
		map27842.put("key27842", b27842.toString()); // put in a collection
		String c27842 = (String)map27842.get("key27842"); // get it back out
		String d27842 = c27842.substring(0,c27842.length()-1); // extract most of it
		String e27842 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27842.getBytes() ) )); // B64 encode and decode it
		String f27842 = e27842.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g27842 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g27842); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
