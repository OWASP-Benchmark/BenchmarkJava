package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03885")
public class BenchmarkTest03885 extends HttpServlet {
	
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
		String a69113 = param; //assign
		StringBuilder b69113 = new StringBuilder(a69113);  // stick in stringbuilder
		b69113.append(" SafeStuff"); // append some safe content
		b69113.replace(b69113.length()-"Chars".length(),b69113.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map69113 = new java.util.HashMap<String,Object>();
		map69113.put("key69113", b69113.toString()); // put in a collection
		String c69113 = (String)map69113.get("key69113"); // get it back out
		String d69113 = c69113.substring(0,c69113.length()-1); // extract most of it
		String e69113 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d69113.getBytes() ) )); // B64 encode and decode it
		String f69113 = e69113.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g69113 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g69113); // reflection
		
		
		response.addHeader("SomeHeader", bar);
	}
}
