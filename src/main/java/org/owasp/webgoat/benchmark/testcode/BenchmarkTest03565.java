package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03565")
public class BenchmarkTest03565 extends HttpServlet {
	
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
		String a10930 = param; //assign
		StringBuilder b10930 = new StringBuilder(a10930);  // stick in stringbuilder
		b10930.append(" SafeStuff"); // append some safe content
		b10930.replace(b10930.length()-"Chars".length(),b10930.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10930 = new java.util.HashMap<String,Object>();
		map10930.put("key10930", b10930.toString()); // put in a collection
		String c10930 = (String)map10930.get("key10930"); // get it back out
		String d10930 = c10930.substring(0,c10930.length()-1); // extract most of it
		String e10930 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10930.getBytes() ) )); // B64 encode and decode it
		String f10930 = e10930.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g10930 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10930); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
