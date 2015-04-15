package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03744")
public class BenchmarkTest03744 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a25560 = param; //assign
		StringBuilder b25560 = new StringBuilder(a25560);  // stick in stringbuilder
		b25560.append(" SafeStuff"); // append some safe content
		b25560.replace(b25560.length()-"Chars".length(),b25560.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25560 = new java.util.HashMap<String,Object>();
		map25560.put("key25560", b25560.toString()); // put in a collection
		String c25560 = (String)map25560.get("key25560"); // get it back out
		String d25560 = c25560.substring(0,c25560.length()-1); // extract most of it
		String e25560 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25560.getBytes() ) )); // B64 encode and decode it
		String f25560 = e25560.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f25560); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
