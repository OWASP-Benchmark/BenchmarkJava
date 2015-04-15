package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18761")
public class BenchmarkTest18761 extends HttpServlet {
	
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
		String a57886 = param; //assign
		StringBuilder b57886 = new StringBuilder(a57886);  // stick in stringbuilder
		b57886.append(" SafeStuff"); // append some safe content
		b57886.replace(b57886.length()-"Chars".length(),b57886.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57886 = new java.util.HashMap<String,Object>();
		map57886.put("key57886", b57886.toString()); // put in a collection
		String c57886 = (String)map57886.get("key57886"); // get it back out
		String d57886 = c57886.substring(0,c57886.length()-1); // extract most of it
		String e57886 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57886.getBytes() ) )); // B64 encode and decode it
		String f57886 = e57886.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57886); // reflection
	
		return bar;	
	}
}
