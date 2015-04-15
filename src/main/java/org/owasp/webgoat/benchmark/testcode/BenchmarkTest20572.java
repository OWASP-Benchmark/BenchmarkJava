package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20572")
public class BenchmarkTest20572 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52937 = param; //assign
		StringBuilder b52937 = new StringBuilder(a52937);  // stick in stringbuilder
		b52937.append(" SafeStuff"); // append some safe content
		b52937.replace(b52937.length()-"Chars".length(),b52937.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52937 = new java.util.HashMap<String,Object>();
		map52937.put("key52937", b52937.toString()); // put in a collection
		String c52937 = (String)map52937.get("key52937"); // get it back out
		String d52937 = c52937.substring(0,c52937.length()-1); // extract most of it
		String e52937 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52937.getBytes() ) )); // B64 encode and decode it
		String f52937 = e52937.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52937 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52937); // reflection
	
		return bar;	
	}
}
