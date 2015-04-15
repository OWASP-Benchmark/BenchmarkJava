package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18708")
public class BenchmarkTest18708 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89602 = param; //assign
		StringBuilder b89602 = new StringBuilder(a89602);  // stick in stringbuilder
		b89602.append(" SafeStuff"); // append some safe content
		b89602.replace(b89602.length()-"Chars".length(),b89602.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89602 = new java.util.HashMap<String,Object>();
		map89602.put("key89602", b89602.toString()); // put in a collection
		String c89602 = (String)map89602.get("key89602"); // get it back out
		String d89602 = c89602.substring(0,c89602.length()-1); // extract most of it
		String e89602 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89602.getBytes() ) )); // B64 encode and decode it
		String f89602 = e89602.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g89602 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89602); // reflection
	
		return bar;	
	}
}
