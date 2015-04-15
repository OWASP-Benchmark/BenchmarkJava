package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01842")
public class BenchmarkTest01842 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a9083 = param; //assign
		StringBuilder b9083 = new StringBuilder(a9083);  // stick in stringbuilder
		b9083.append(" SafeStuff"); // append some safe content
		b9083.replace(b9083.length()-"Chars".length(),b9083.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9083 = new java.util.HashMap<String,Object>();
		map9083.put("key9083", b9083.toString()); // put in a collection
		String c9083 = (String)map9083.get("key9083"); // get it back out
		String d9083 = c9083.substring(0,c9083.length()-1); // extract most of it
		String e9083 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9083.getBytes() ) )); // B64 encode and decode it
		String f9083 = e9083.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9083); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
