package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02436")
public class BenchmarkTest02436 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a53852 = param; //assign
		StringBuilder b53852 = new StringBuilder(a53852);  // stick in stringbuilder
		b53852.append(" SafeStuff"); // append some safe content
		b53852.replace(b53852.length()-"Chars".length(),b53852.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53852 = new java.util.HashMap<String,Object>();
		map53852.put("key53852", b53852.toString()); // put in a collection
		String c53852 = (String)map53852.get("key53852"); // get it back out
		String d53852 = c53852.substring(0,c53852.length()-1); // extract most of it
		String e53852 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53852.getBytes() ) )); // B64 encode and decode it
		String f53852 = e53852.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f53852); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}
