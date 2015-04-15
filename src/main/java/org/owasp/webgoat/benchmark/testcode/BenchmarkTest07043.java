package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07043")
public class BenchmarkTest07043 extends HttpServlet {
	
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
		String a26378 = param; //assign
		StringBuilder b26378 = new StringBuilder(a26378);  // stick in stringbuilder
		b26378.append(" SafeStuff"); // append some safe content
		b26378.replace(b26378.length()-"Chars".length(),b26378.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26378 = new java.util.HashMap<String,Object>();
		map26378.put("key26378", b26378.toString()); // put in a collection
		String c26378 = (String)map26378.get("key26378"); // get it back out
		String d26378 = c26378.substring(0,c26378.length()-1); // extract most of it
		String e26378 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26378.getBytes() ) )); // B64 encode and decode it
		String f26378 = e26378.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f26378); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}
}
