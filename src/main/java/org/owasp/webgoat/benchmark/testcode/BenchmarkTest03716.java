package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03716")
public class BenchmarkTest03716 extends HttpServlet {
	
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
		String a41072 = param; //assign
		StringBuilder b41072 = new StringBuilder(a41072);  // stick in stringbuilder
		b41072.append(" SafeStuff"); // append some safe content
		b41072.replace(b41072.length()-"Chars".length(),b41072.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41072 = new java.util.HashMap<String,Object>();
		map41072.put("key41072", b41072.toString()); // put in a collection
		String c41072 = (String)map41072.get("key41072"); // get it back out
		String d41072 = c41072.substring(0,c41072.length()-1); // extract most of it
		String e41072 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41072.getBytes() ) )); // B64 encode and decode it
		String f41072 = e41072.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f41072); // reflection
		
		
		response.getWriter().print(bar);
	}
}
