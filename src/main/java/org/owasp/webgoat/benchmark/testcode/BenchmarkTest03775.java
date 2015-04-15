package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03775")
public class BenchmarkTest03775 extends HttpServlet {
	
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
		String a9798 = param; //assign
		StringBuilder b9798 = new StringBuilder(a9798);  // stick in stringbuilder
		b9798.append(" SafeStuff"); // append some safe content
		b9798.replace(b9798.length()-"Chars".length(),b9798.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9798 = new java.util.HashMap<String,Object>();
		map9798.put("key9798", b9798.toString()); // put in a collection
		String c9798 = (String)map9798.get("key9798"); // get it back out
		String d9798 = c9798.substring(0,c9798.length()-1); // extract most of it
		String e9798 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9798.getBytes() ) )); // B64 encode and decode it
		String f9798 = e9798.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9798); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
