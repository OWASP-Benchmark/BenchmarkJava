package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18764")
public class BenchmarkTest18764 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a46449 = param; //assign
		StringBuilder b46449 = new StringBuilder(a46449);  // stick in stringbuilder
		b46449.append(" SafeStuff"); // append some safe content
		b46449.replace(b46449.length()-"Chars".length(),b46449.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46449 = new java.util.HashMap<String,Object>();
		map46449.put("key46449", b46449.toString()); // put in a collection
		String c46449 = (String)map46449.get("key46449"); // get it back out
		String d46449 = c46449.substring(0,c46449.length()-1); // extract most of it
		String e46449 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46449.getBytes() ) )); // B64 encode and decode it
		String f46449 = e46449.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g46449 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g46449); // reflection
	
		return bar;	
	}
}
