package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20602")
public class BenchmarkTest20602 extends HttpServlet {
	
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
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19447 = param; //assign
		StringBuilder b19447 = new StringBuilder(a19447);  // stick in stringbuilder
		b19447.append(" SafeStuff"); // append some safe content
		b19447.replace(b19447.length()-"Chars".length(),b19447.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19447 = new java.util.HashMap<String,Object>();
		map19447.put("key19447", b19447.toString()); // put in a collection
		String c19447 = (String)map19447.get("key19447"); // get it back out
		String d19447 = c19447.substring(0,c19447.length()-1); // extract most of it
		String e19447 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19447.getBytes() ) )); // B64 encode and decode it
		String f19447 = e19447.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19447 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19447); // reflection
	
		return bar;	
	}
}
