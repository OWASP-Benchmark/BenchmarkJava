package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04909")
public class BenchmarkTest04909 extends HttpServlet {
	
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
		String a78859 = param; //assign
		StringBuilder b78859 = new StringBuilder(a78859);  // stick in stringbuilder
		b78859.append(" SafeStuff"); // append some safe content
		b78859.replace(b78859.length()-"Chars".length(),b78859.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78859 = new java.util.HashMap<String,Object>();
		map78859.put("key78859", b78859.toString()); // put in a collection
		String c78859 = (String)map78859.get("key78859"); // get it back out
		String d78859 = c78859.substring(0,c78859.length()-1); // extract most of it
		String e78859 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78859.getBytes() ) )); // B64 encode and decode it
		String f78859 = e78859.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f78859); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}
