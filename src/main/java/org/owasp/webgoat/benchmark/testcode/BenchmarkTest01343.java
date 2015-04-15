package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01343")
public class BenchmarkTest01343 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a79447 = param; //assign
		StringBuilder b79447 = new StringBuilder(a79447);  // stick in stringbuilder
		b79447.append(" SafeStuff"); // append some safe content
		b79447.replace(b79447.length()-"Chars".length(),b79447.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79447 = new java.util.HashMap<String,Object>();
		map79447.put("key79447", b79447.toString()); // put in a collection
		String c79447 = (String)map79447.get("key79447"); // get it back out
		String d79447 = c79447.substring(0,c79447.length()-1); // extract most of it
		String e79447 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79447.getBytes() ) )); // B64 encode and decode it
		String f79447 = e79447.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f79447); // reflection
		
		
		response.addHeader(bar, "SomeValue");
	}
}
