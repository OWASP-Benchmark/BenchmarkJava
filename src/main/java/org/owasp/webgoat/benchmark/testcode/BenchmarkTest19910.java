package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19910")
public class BenchmarkTest19910 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72257 = param; //assign
		StringBuilder b72257 = new StringBuilder(a72257);  // stick in stringbuilder
		b72257.append(" SafeStuff"); // append some safe content
		b72257.replace(b72257.length()-"Chars".length(),b72257.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72257 = new java.util.HashMap<String,Object>();
		map72257.put("key72257", b72257.toString()); // put in a collection
		String c72257 = (String)map72257.get("key72257"); // get it back out
		String d72257 = c72257.substring(0,c72257.length()-1); // extract most of it
		String e72257 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72257.getBytes() ) )); // B64 encode and decode it
		String f72257 = e72257.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72257); // reflection
	
		return bar;	
	}
}
