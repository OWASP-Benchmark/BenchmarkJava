package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17375")
public class BenchmarkTest17375 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a5677 = param; //assign
		StringBuilder b5677 = new StringBuilder(a5677);  // stick in stringbuilder
		b5677.append(" SafeStuff"); // append some safe content
		b5677.replace(b5677.length()-"Chars".length(),b5677.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5677 = new java.util.HashMap<String,Object>();
		map5677.put("key5677", b5677.toString()); // put in a collection
		String c5677 = (String)map5677.get("key5677"); // get it back out
		String d5677 = c5677.substring(0,c5677.length()-1); // extract most of it
		String e5677 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5677.getBytes() ) )); // B64 encode and decode it
		String f5677 = e5677.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f5677); // reflection
	
		return bar;	
	}
}
