package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03737")
public class BenchmarkTest03737 extends HttpServlet {
	
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
		String a37939 = param; //assign
		StringBuilder b37939 = new StringBuilder(a37939);  // stick in stringbuilder
		b37939.append(" SafeStuff"); // append some safe content
		b37939.replace(b37939.length()-"Chars".length(),b37939.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37939 = new java.util.HashMap<String,Object>();
		map37939.put("key37939", b37939.toString()); // put in a collection
		String c37939 = (String)map37939.get("key37939"); // get it back out
		String d37939 = c37939.substring(0,c37939.length()-1); // extract most of it
		String e37939 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37939.getBytes() ) )); // B64 encode and decode it
		String f37939 = e37939.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f37939); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
