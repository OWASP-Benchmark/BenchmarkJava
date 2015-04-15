package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14912")
public class BenchmarkTest14912 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47449 = param; //assign
		StringBuilder b47449 = new StringBuilder(a47449);  // stick in stringbuilder
		b47449.append(" SafeStuff"); // append some safe content
		b47449.replace(b47449.length()-"Chars".length(),b47449.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47449 = new java.util.HashMap<String,Object>();
		map47449.put("key47449", b47449.toString()); // put in a collection
		String c47449 = (String)map47449.get("key47449"); // get it back out
		String d47449 = c47449.substring(0,c47449.length()-1); // extract most of it
		String e47449 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47449.getBytes() ) )); // B64 encode and decode it
		String f47449 = e47449.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47449); // reflection
	
		return bar;	
	}
}
