package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04964")
public class BenchmarkTest04964 extends HttpServlet {
	
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
		String a94282 = param; //assign
		StringBuilder b94282 = new StringBuilder(a94282);  // stick in stringbuilder
		b94282.append(" SafeStuff"); // append some safe content
		b94282.replace(b94282.length()-"Chars".length(),b94282.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94282 = new java.util.HashMap<String,Object>();
		map94282.put("key94282", b94282.toString()); // put in a collection
		String c94282 = (String)map94282.get("key94282"); // get it back out
		String d94282 = c94282.substring(0,c94282.length()-1); // extract most of it
		String e94282 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94282.getBytes() ) )); // B64 encode and decode it
		String f94282 = e94282.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94282); // reflection
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
