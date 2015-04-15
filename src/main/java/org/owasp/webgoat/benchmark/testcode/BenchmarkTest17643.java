package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17643")
public class BenchmarkTest17643 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64140 = param; //assign
		StringBuilder b64140 = new StringBuilder(a64140);  // stick in stringbuilder
		b64140.append(" SafeStuff"); // append some safe content
		b64140.replace(b64140.length()-"Chars".length(),b64140.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64140 = new java.util.HashMap<String,Object>();
		map64140.put("key64140", b64140.toString()); // put in a collection
		String c64140 = (String)map64140.get("key64140"); // get it back out
		String d64140 = c64140.substring(0,c64140.length()-1); // extract most of it
		String e64140 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64140.getBytes() ) )); // B64 encode and decode it
		String f64140 = e64140.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64140); // reflection
	
		return bar;	
	}
}
